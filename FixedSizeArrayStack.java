
public class FixedSizeArrayStack<T>{
	private int size;
	private T[] stack;
	
	public FixedSizeArrayStack(int maxSize) {
		stack = (T[]) new Object[maxSize];
		size = 0;
		
	}
	
	public void push(T newItem){
		if(newItem == null) {
			throw new IllegalArgumentException();
		}
		if(size+1 > stack.length) {
			throw new IllegalStateException();
		}
		stack[size] = newItem;
		size++;
	}
	
	public T pop() {
		if(isEmpty()) {
			throw new IllegalStateException();
		}
		T deleteVal = stack[size];
		stack[size-1] = null;
		return deleteVal;
	}
	
	public T peek() {
		if(isEmpty()) {
			throw new IllegalStateException();
		}
		return stack[size-1];
	}
	
	public boolean isEmpty() {
		return (size()<=0);
	}
	
	public int size() {
		return size;
	}
	
}
