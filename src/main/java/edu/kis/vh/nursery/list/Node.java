package edu.kis.vh.nursery.list;

//kombinacja klawiszy alt + strzalka lewo/prawo na Windowsie
//pozwala przeskakiwac pomiedzy otwartymi edytorami w IDE wg kolejnosci ich odwiedzenia
//na macOS ekwiwalent to option + command + strzalka lewo/prawo

public class Node {

	public int value;
	public Node prev, next;

	public Node(int i) {
		value = i;
	}

}
