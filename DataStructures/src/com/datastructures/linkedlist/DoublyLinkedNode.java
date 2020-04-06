package com.datastructures.linkedlist;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class DoublyLinkedNode {

	@Getter
	private Integer data;
	@Getter
	@Setter
	@ToString.Exclude
	private DoublyLinkedNode nextNode;
	@Getter
	@Setter
	@ToString.Exclude
	private DoublyLinkedNode previousNode;

	public DoublyLinkedNode(Integer data) {
		this.data = data;
	}

}
