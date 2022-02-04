package edu.kis.vh.nursery.list;

public class IntLinkedList {

	private Node lastNode;
	// TODO: this variable is not used at all, it can be removed
	private int i;

	public void push(int i) {
		if (lastNode == null)
			lastNode = new Node(i);
		else {
			lastNode.setNext(new Node(i));
			lastNode.getNext().setPrev(lastNode);
			lastNode = lastNode.getNext();
		}
	}

	public boolean isEmpty() {
		return lastNode == null;
	}

	// TODO: this method does not make sense in this implementation (it is not used, IntLinkedList does not 
	// implement any interface or anything that makes it obligatory to implement this isFull method with no use)
	public boolean isFull() {
		return false;
	}

	public int top() {
		if (isEmpty())
			return -1;
		return lastNode.getValue();
	}

	public int pop() {
		if (isEmpty())
			return -1;
		int ret = lastNode.getValue();
		lastNode = lastNode.getPrev();
		return ret;
	}

}


//kombinacja klawiszy alt + strzalka lewo/prawo na Windowsie
//pozwala przeskakiwac pomiedzy otwartymi edytorami w IDE wg kolejnosci ich odwiedzenia
//na macOS ekwiwalent to option + command + strzalka lewo/prawo

class Node {

	private int value;
	private Node prev;
	private Node next;

	public Node(int i) {
		value = i;
	}

	public int getValue() {
		return value;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}

	public Node getPrev() {
		return prev;
	}

	public void setPrev(Node prev) {
		this.prev = prev;
	}

}
