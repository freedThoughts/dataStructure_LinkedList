package singleLinkedList;

public class ListNode<T> {
	
	private T data;
	private ListNode<T> next;
	
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	public ListNode<T> getNext() {
		return next;
	}
	public void setNext(ListNode<T> next) {
		this.next = next;
	}

	public ListNode(){}
	public ListNode(T data){
		this.data = data;
	}
	
	public ListNode(T data, ListNode<T> listNode){
		this.data = data;
		this.next = listNode;
	}

}
