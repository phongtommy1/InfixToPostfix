package infixxToPostfix;
import java.lang.Math;
//
//   Name: Tommy Phong
//   Project: #2
//   Due: 3/9/202
//   Course: cs-2400-02
//
//   Description:
//               This class is the implementation of the method that is used by 
//               ExpressionCheck.
//
public class Expression {
    
	public static String[] convertToPostFix (String[] infixExpression) {
    	StackInterface<String> operatorStack = new ArrayStack<>();
    	String[] postfix = new String[infixExpression.length - parenthese(infixExpression) * 2];
    	String nextCharacter;
    	String topOperator;
    	int counter = 0;
    	int index = 0;
    	
    	if(!checkBalance(infixExpression)) {
    		throw new RuntimeException("unbalance parenthese");
    	}
    	
    	while (counter< infixExpression.length) {
    		 nextCharacter = infixExpression[counter];
    	     switch (nextCharacter) {  	 
    	         case "^":
    	        	 operatorStack.push(nextCharacter);
    	    	     break;
    	    	     
    	         case "+": case "-": case "*": case "/":
    	        	 while(!operatorStack.isEmpty() && (precedence(nextCharacter) <= precedence(operatorStack.peek())) 
    	        			 && precedence(operatorStack.peek()) != 4) {
    	        		 postfix[index] = operatorStack.pop();
    	        		 index++;
    	        	 }
    	        	 operatorStack.push(nextCharacter);
    	        	 break;
    	         case "(": 
    	        	 operatorStack.push(nextCharacter);
    	        	 break;
    	         case ")":
    	  	        topOperator = operatorStack.pop();   	  	         
    	        	while(!topOperator.equals("(")) {
    	        		postfix[index] = topOperator;
    	        		 topOperator = operatorStack.pop();
    	        		 index++;
    	        	 }
    	             break;
    	        	 
    	        default:
    	        	postfix[index] = nextCharacter;
    	        	index++;
    	        	break; 	 
    	     } 
    	     counter++;
    	}
    	while(!operatorStack.isEmpty()) {
    		topOperator = operatorStack.pop();
    		postfix[index] = topOperator;
    		index++;
    	}
    	return postfix;
	}
    
    public static int evaluatePostfix(String[] postfixExpression, BagInterface<Name> nameBag){
        StackInterface<Integer> valueStack = new ArrayStack<>();
        String nextCharacter;
        String topOperator;
    	int counter = 0;
    	int operandOne;
    	int operandTwo;
    	int result = 0;
    	int variable;
    	
    	while(counter < postfixExpression.length) {
    		nextCharacter = postfixExpression[counter];
  
    		switch (nextCharacter) {   	
    		    case "+": case "-": case "*": case "/": case "^":
    		    	    try {
    		    	    topOperator = nextCharacter;
    		    	    operandTwo = valueStack.pop();
        		    	operandOne = valueStack.pop();
    		    	    }
    		    		catch (Exception e) {
    		    			throw new RuntimeException("Illegal expression");
    		    		}
        		    	
        		    	if(topOperator.equals("+")) {
        		    		result = operandTwo + operandOne;
        		    	}
        		    	else if(topOperator.equals("-")) {
        		    		result = operandOne - operandTwo;
        		    	}
        		    	else if(topOperator.equals("*")) {
        		    		result = operandTwo * operandOne;
        		    	}
        		    	else if(topOperator.equals("/")) {
        		    		
        		    		result = operandOne / operandTwo; 
        		    	}
        		    	else if(topOperator.equals("^")) {
        		    		double result1 = (Math.pow(operandOne, operandTwo));
        		    		result = (int) result1;
        		    	}
        		    	valueStack.push(result);  
    		            break;
    		    
    		    default:
                    try {
                    	variable = Integer.parseInt(nextCharacter);
                    }
                    catch (NumberFormatException e) {
                    	variable = lookUp(nextCharacter, nameBag);
                    }
                    
                    valueStack.push(variable);
                    break;
    		}
    		counter++;
         } 		
    	return valueStack.peek();
    }
    
    private static boolean isValidOperrand(String[] infixExpression) {
    	int numOperator = 0;
    	int numOperand = 0;
    	int index = 0;
    	boolean valid = false;
    	
    	while(index < infixExpression.length) {
    	    if(infixExpression[index].equals("*")){
    	    	numOperator++;
    	    	index++;
    	    }
    	    else if (infixExpression[index].equals("/")) {
    	    	numOperator++;
    	    	index++;
    	    }
    	    else if (infixExpression[index].equals("+")) {
    	    	numOperator++;
    	    	index++;
    	    }
    	    else if(infixExpression[index].equals("^")) {
    	    	numOperator++;
    	    	index++;
    	    }
    	    else if (infixExpression[index].equals("-")) {
    	    	numOperator++;
    	    	index++;
    	    }
    	    else if (infixExpression[index].equals("(")){
    	    	numOperand++;
    	    	index++;
    	    }
    	    else if (infixExpression[index].equals(")")) {
    	    	numOperand++;
    	    	index++;
    	    }
    	}
    	System.out.println(numOperator);
    	System.out.println(numOperand);
    	if(numOperand == (numOperator + 1)) {
    	    valid = true;	
    	}
       	return valid;
    }
    
    private static boolean checkBalance(String[] expression) {
    	StackInterface<String> openDelimiterStack = new ArrayStack<>();
    	
    	int characterCount = expression.length;
    	boolean isBalanced = true;
    	int index = 0;
    	String nextCharacter = " ";
    	
    	while (isBalanced && (index < characterCount)) {
    		nextCharacter = expression[index];
    		switch (nextCharacter){
    		case "(":
    			openDelimiterStack.push(nextCharacter);
    			break;
    		case ")":
    			if (openDelimiterStack.isEmpty()) {
    				isBalanced = false;
    			}
    			else {
    				String openDelimiter = openDelimiterStack.pop();
    				isBalanced = isPaired(openDelimiter, nextCharacter);
    			}
    			break;
    			
    	   default:
    		   break;
    		}
    		index++;
    	}
    	if (!openDelimiterStack.isEmpty()) {
    		isBalanced = false;
    	}
    	return isBalanced;
    }
    
    private static boolean isPaired(String open, String close) {
    	return (open.equals("(") && close.equals(")"));
    }
    
	private static int precedence(String newEntry) {
    	switch (newEntry) {
    	    
    	    case "+": case "-":
    		    return 1;
    	
    	    case "*": case "/":
    		    return 2;
    		    
    	    case "^":
    		    return 3;
    		  
    	    case "(": case ")":
    	    	return 4;
    	    	
    	    default:
    	    	return -1;
    	}

	}
	
	private static int parenthese(String [] infixExpression) {
    	int loopcounter = 0;
    	int numParenthese = 0;
    	
		while (loopcounter < infixExpression.length) {
    		if(infixExpression[loopcounter].equals( "(")) {
    			numParenthese++;
    			loopcounter++;
    		}
    		else {
    			loopcounter++;
    		}
    	}
		return numParenthese;
		}
	
	private static int lookUp(String currentString, BagInterface<Name> nameBag) {
		Object [] a = (Object[]) nameBag.toArray();
		boolean found = false;
		int index = 0;
		
		while(index < a.length && !found) {
			if(((Name)a[index]).getName().equals(currentString)) {
				return ((Name)a[index]).getValue();
			}
			else {
				index++;
			}
		}
		throw new RuntimeException("Name not found");
		
	}
}
