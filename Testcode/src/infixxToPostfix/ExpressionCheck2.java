package infixxToPostfix;
//
//    Name: Tommy Phong
//    Project: #2
//    Due: 3/9/202
//    Course: cs-2400-02
//    
//    Description:
//               This class runs test trials on whether my conversion
//               from infix to postfix is performed correctly, and
//               also check whether the evaluation of it is correct.
//
public class ExpressionCheck2 {

	public static void main(String[] args) {
		String[] infix = "1 + 4 / 5".split("\\s+");	    
		String[] postfix;
		
		postfix = Expression.convertToPostFix(infix);
		
		BagInterface<Name> names = new ArrayBag<>();
		
		names.add(new Name("a", 10));
		
		names.add(new Name("b", 1));
        
		int result = Expression.evaluatePostfix(postfix, names);
		
		System.out.println(display(postfix));
		System.out.println(result);
	}

	private static String display(String[] newArray) {
		String postfix = new String();
		
		for(int index = 0; index < newArray.length; index++) {
			postfix += newArray[index];
		}
		return postfix;
	}
}
