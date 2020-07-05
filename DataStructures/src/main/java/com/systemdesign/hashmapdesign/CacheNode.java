package com.systemdesign.hashmapdesign;

public class CacheNode {
	
	private int id;
	private CacheNode prev;
	private CacheNode next;
	
	public CacheNode(int id) {
		this.id = id;
		prev = null;
		next = null;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public CacheNode getPrev() {
		return prev;
	}

	public void setPrev(CacheNode prev) {
		this.prev = prev;
	}

	public CacheNode getNext() {
		return next;
	}

	public void setNext(CacheNode next) {
		this.next = next;
	}
	
	

}
