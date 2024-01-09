
public class ResizingArrayStack<T> {
	private int size = 0;
	private T[] stack;
	
	public ResizingArrayStack() {
		stack = (T[]) new Object[1];
	}
	
	public void push(T newItem) {
		if(newItem == null) {
			throw new IllegalArgumentException();
			
		}
		if(size+1 > stack.length) {
			T[] stackCopy = (T[]) new Object[stack.length*2];
			for(int i = 0; i <stack.length; i++) {
				stackCopy[i] = stack[i];
			}
			stack = stackCopy;
		}
		stack[size] = newItem;
		size++;
	}
	
	public T pop() {
		if(isEmpty()) {
			throw new IllegalStateException();
		}
		if(stack.length/4 > size-1) {
			T[] stackCopy = (T[]) new Object[stack.length/2];
			for(int i = 0; i < stack.length; i++) {
				stackCopy[i] = stack[i];
			}
			stack = stackCopy;
		}
		T deleteVal = stack[size-1];
		stack[size-1] = null;
		size--;
		return deleteVal;
	}
	
	public T peek() {
		if(isEmpty()) {
			throw new IllegalStateException();
		}
		return stack[size-1];
	}
	
	public boolean isEmpty() {
		return size()==0;
	}
	
	public int size() {
		return size;
	}
	
}
