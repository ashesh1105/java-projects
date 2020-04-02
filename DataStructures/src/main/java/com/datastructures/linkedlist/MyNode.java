package com.datastructures.linkedlist;

import lombok.Getter;
import lombok.Setter;

public class MyNode {

	@Getter
	@Setter
	private int data;

	@Getter
	@Setter
	private MyNode nextNode;

	public MyNode(int data) {
		this.data = data;
	}

	public MyNode() {

	}

}
