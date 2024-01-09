
public class ResizingArrayQueue<T> {
	private int size = 0;
	private T[] queue;
	
	public ResizingArrayQueue() {
		queue = (T[]) new Object[1];
	}
	
	public void enqueue(T newItem) {
		if(newItem == null) throw new IllegalArgumentException();
		if(size+1 >= queue.length) {
			T[] queueCopy = (T[]) new Object[queue.length*2];
			for(int i = 0; i < queue.length; i++) {
				queueCopy[i] = queue[i];
			}
			queue = queueCopy;
		}
		
		queue[size] = newItem;
		size++;
		
	}
	
	public T dequeue() {
		if(isEmpty()) throw new IllegalStateException();
		if(size-1 < queue.length/4) {
			T[] queueCopy = (T[]) new Object[queue.length/2];
			for(int i = 0; i <queueCopy.length; i++) {
				queueCopy[i] = queue[i];
			}
			queue = queueCopy;
		}
		T deleteVal = queue[0];
		for(int i = 1; i <=size; i++) {
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
		return size() == 0;
	}
	
	public int size() {
		return size;
	}
}
