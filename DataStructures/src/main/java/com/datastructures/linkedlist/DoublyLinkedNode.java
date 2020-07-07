package com.datastructures.linkedlist;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString(of={"data"})
public class DoublyLinkedNode {

	@Getter
	private Integer data;
	@Getter
	@Setter
	private DoublyLinkedNode nextNode;
	@Getter
	@Setter
	private DoublyLinkedNode previousNode;

	public DoublyLinkedNode(Integer data) {
		this.data = data;
	}

}
