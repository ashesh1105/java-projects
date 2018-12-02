package com.practice.genericprogramming;

public interface GenericInterface<T1, T2> {
	// adds the pair
	public void add(T1 key, T2 value);

	// deletes the pair and returns the deleted pair
	public GenericInterface<T1, T2> delete(T1 key);

	// returns the pair matching the key
	public GenericInterface<T1, T2> get(T1 key);

	// updates the record and returns the updated key value pair
	public GenericInterface<T1, T2> update(T1 key, T2 value);

}
