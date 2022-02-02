package edu.kis.vh.nursery.list;

//kombinacja klawiszy alt + strzalka lewo/prawo na Windowsie
//pozwala przeskakiwac pomiedzy otwartymi edytorami w IDE wg kolejnosci ich odwiedzenia
//na macOS ekwiwalent to option + command + strzalka lewo/prawo

public class Node {

	private int value;
	private Node prev;
	private Node next;

	public Node(int i) {
		value = i;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
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
