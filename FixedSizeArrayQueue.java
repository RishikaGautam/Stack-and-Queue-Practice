
public class FixedSizeArrayQueue<T> {
	private int size;
	private T[] queue;
	
	public FixedSizeArrayQueue(int maxsize){
		queue = (T[]) new Object[maxsize];
		size = 0;
	}
	
	public void enqueue(T newItem) {
		if(newItem == null) throw new IllegalArgumentException();
		if(size+1 > queue.length) throw new IllegalStateException();
		
		queue[size] = newItem;
		size++;
	}
	
	public T dequeue() {
		if(isEmpty()) throw new IllegalStateException();
		T deleteVal = queue[0];
		for(int i = 1; i <= size; i++) {
			queue[i-1] = queue[i];
		}
		size--;
		return deleteVal;
	}
	
	public T peek() {
		if(isEmpty()) throw new IllegalStateException();
		return queue[0];
	}
	
	public boolean isEmpty() {
		return size()==0;
	}
	
	public int size() {
		return size;
	}
	
	
}
