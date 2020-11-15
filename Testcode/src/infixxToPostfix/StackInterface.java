package infixxToPostfix;

//
//   Name: Tommy Phong
//   Project: #2
//   Due: 3/9/202
//   Course: cs-2400-02
//
//   Description:
//               This interface define methods that must be implemented by the Stack
//               implementation. 
//
public interface StackInterface<T> {
   /** Pushes an element onto the top of the stack
	   @param newEntry the object that is being added. */
   public void push(T newEntry);
   
   /** Removes the element at the top of the stack.
       @return return the element that was popped from the stack. */
   public T pop();
   
   /** Checks the element that is currently at the top of the stack.
       @return return the element that is on the top. */ 
   public T peek();

   /** Determine whether stack is currently empty or not.
       @return return true if the stack is empty, and false otherwise. */
   public boolean isEmpty();
   
   /** Clear all element from the stack. */
   public void clear();
} 
