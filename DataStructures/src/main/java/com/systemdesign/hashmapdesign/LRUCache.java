package com.systemdesign.hashmapdesign;

import java.util.HashMap;
import java.util.Map;

/*
 LRU Cache implementation.
 1. Use HashMap to store Key Node -> Values pairs.
 2. Use Doubly Ended LinkedList to maintain the order of usage of these key nodes in the HashMap.
 3. Whenever a Key is read or written, put it at the tail of the LinkedList.
 4. Whenever you need space in cache, remove from head of the LinkedList and remove these nodes from HashMap as well.
 */
public class LRUCache {

	private int cacheSize;
	private int currentCacheSize;
	private Map<Integer, CacheNode> cache;
	private CacheNode cacheStart;
	private CacheNode cacheEnd;

	public LRUCache(int cacheSize) {
		this.cacheSize = cacheSize;
		currentCacheSize = 0;
		cache = new HashMap<>();
		cacheStart = null;
		cacheEnd = null;
	}

	public CacheNode get(int key) {

		if (cache.containsKey(key)) {
			System.out.println("Data is available in cache. Returning it.");

			// Make this data current in linked list part of cache)
			CacheNode node = cache.get(key);
			if (node != cacheEnd) {
				removeFromCacheRegister(node);
			}
			addToCacheRegister(node);
			return node;
		} else {
			System.out.println("Data is not currently present in cache. Adding it to cache before returning it.");
			CacheNode node = new CacheNode(key);
			cache.put(key, node);
			addToCacheRegister(node);
			return node;
		}
	}

	private void addToCacheRegister(CacheNode node) {

		if (currentCacheSize == 0) {
			currentCacheSize++;
			cacheStart = node;
			cacheEnd = node;
		} else if (currentCacheSize < cacheSize) {
			currentCacheSize++;
			cacheEnd.setNext(node);
			node.setPrev(cacheEnd);
			cacheEnd = node;
		} else {
			// Log the message that cache is currently full. Removing the last accessed node before adding new node to cache.
			System.out.println("Cache is already full, removing the last accessed data before adding new.");
			removeFromCacheRegister(cacheStart);
			
			// Node add the node to the tail
			currentCacheSize++;
			cacheEnd.setNext(node);
			node.setPrev(cacheEnd);
			cacheEnd = node;
		}

	}

	private void removeFromCacheRegister(CacheNode node) {

		if (currentCacheSize == 0) {
			System.out.println("Cache is already empty, can't remove anything from it.");
			return;
		} else if (node == cacheStart) {
			currentCacheSize--;
			cacheStart = node.getNext();
			cacheStart.setPrev(null);
			node.setNext(null);
		} else if (node == cacheEnd) {
			currentCacheSize--;
			cacheEnd = node.getPrev();
			cacheEnd.setNext(null);
		} else {
			currentCacheSize--;
			CacheNode prevNode = node.getPrev();
			CacheNode nextNode = node.getNext();
			prevNode.setNext(nextNode);
			nextNode.setPrev(prevNode);
			node.setNext(null);
			node.setPrev(null);
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
