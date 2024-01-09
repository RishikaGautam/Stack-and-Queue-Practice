
public class LinkedListStack<T> {
	
	private static class Node<T>{
		T data;
		Node<T> next;
		
		Node() {
			data = null;
			next = null;
		}
		
		Node(T add) {
			data = add;
			next = null;
		}
	}
	private int size = 0;
	private Node<T> head;
	
	public LinkedListStack() {
		head = null;
	}
	
	public void push(T newItem) {
		if(newItem == null) {
			throw new IllegalArgumentException();
		}
		Node<T> temp = new Node<T>(newItem);
		temp.next = head;
		head = temp;
		size++;
	}
	
	public T pop() {
		if(isEmpty()) {
			throw new IllegalStateException();
		}
		T deleteVal = head.data;
		head = head.next;
		size--;
		return deleteVal;
	}
	
	public T peek() {
		if(isEmpty()) {
			throw new IllegalStateException();
		}
		return head.data;
	}
	
	public boolean isEmpty() {
		return size()==0;
	}
	
	public int size() {
		return size;
	}
}
