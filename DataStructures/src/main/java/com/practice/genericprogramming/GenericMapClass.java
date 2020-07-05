package com.practice.genericprogramming;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class GenericMapClass<T1, T2> implements GenericMapInterface<T1, T2> {

	Map<T1, T2> genericMap;

	public GenericMapClass(DataType mapType) {
		switch (mapType) {
		case HashMap:
			genericMap = new HashMap<T1, T2>();
			break;
		case TreeMap:
			genericMap = new TreeMap<T1, T2>();
			break;
		case LinkedHashMap:
			genericMap = new LinkedHashMap<>();
			break;
		}
	}

	@Override
	public void add(T1 key, T2 value) {
		genericMap.put(key, value);
	}

	@Override
	public GenericMapInterface<T1, T2> delete(T1 key) {
		genericMap.remove(key);
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T2 get(T1 key) {
		return genericMap.get(key);
	}

	@Override
	public GenericMapInterface<T1, T2> update(T1 key, T2 value) {
		// TODO Auto-generated method stub
		genericMap.put(key, value);
		return (GenericMapInterface<T1, T2>) genericMap;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();

		genericMap.forEach((k, v) -> {
			sb.append("Key: ").append(k).append(" ; Value: ").append(v)
					.append("\n");
		});

		return sb.toString();
	}

}
