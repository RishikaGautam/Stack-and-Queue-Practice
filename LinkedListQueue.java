
public class LinkedListQueue<T> {
	private static class Node<T>{
		T data;
		Node<T> next;
		
		Node(){
			data = null;
			next = null;
		}
		
		Node(T value){
			data = value;
			next = null;
		}
	}
	
	private Node<T> head;
	private Node<T> tail;
	private int size;
	
	public LinkedListQueue() {
		head = null;
		tail = null;
		size = 0;
	}
	
	public void enqueue(T newItem) {
		if(newItem == null) throw new IllegalArgumentException();
        Node<T> temp = tail;
        tail = new Node<T>(newItem);
		if(isEmpty()) {
			head = tail;
		}else {
			temp.next = tail;
		}
		size++;
	}
	
	public T dequeue() {
		if(isEmpty()) throw new IllegalStateException();
		T deleteVal = head.data;
		head = head.next;
		size--;
		if(isEmpty()) tail = null;
		return deleteVal;
	}
	
	public T peek() {
		if(isEmpty()) throw new IllegalStateException();
		return head.data;
	}
	
	public boolean isEmpty() {
		return size()==0;
	}
	
	public int size() {
		return size;
	}
}
