package infixxToPostfix;
//
//   Name: Tommy Phong
//   Project: #2
//   Due: 3/9/202
//   Course: cs-2400-02
//
//   Description:
//              This class is the implementation of the methods from StackInterface.
//
import java.util.Arrays;
import java.util.EmptyStackException;

public class ArrayStack<T> implements StackInterface<T> {
    
	private T[] stack;
	private int topIndex;
	private static final int DEFAULT_CAPACITY = 25;
	
	public ArrayStack() {
       this(DEFAULT_CAPACITY);	
    }
	
	public ArrayStack(int initialCapacity) {
        
		@SuppressWarnings("unchecked")
		T[] tempStack = (T[])new Object[initialCapacity];
        stack = tempStack;
        topIndex = -1;
	}
	
	@Override
	/** Pushes an element onto the top of the stack
	   @param newEntry the object that is being added. */
	public void push(T newEntry) {
		
		ensureCapacity();
		stack[topIndex + 1] = newEntry;
		topIndex++;
	}

	@Override
	/** Removes the element at the top of the stack.
    @return return the element that was popped from the stack. */
	public T pop() {
		T removed;
		
		if(isEmpty()) {
			throw new EmptyStackException();
		}
		else {
		    removed = stack[topIndex];
		    stack[topIndex] = null;
		    topIndex--;
		}
		return removed;
	}

	@Override
	/** Checks the element that is currently at the top of the stack.
    @return return the element that is on the top. */ 
	public T peek() {
		
		if(isEmpty()) {
			throw new EmptyStackException();
		}
		else {
			return stack[topIndex];
		}
	}

	@Override
	/** Determine whether stack is currently empty or not.
    @return return true if the stack is empty, and false otherwise. */
	public boolean isEmpty() {
		
		return topIndex == -1;
	}

	@Override
	/** Clear all element from the stack. */
	public void clear() {
		
		while(!isEmpty()) {
			pop();
		}
		
	}
	
   private void ensureCapacity() {
       
	   if(topIndex == stack.length-1) {
		   int newSize = 2 * stack.length;
		   stack = Arrays.copyOf(stack, newSize);
	   }
   }
}
