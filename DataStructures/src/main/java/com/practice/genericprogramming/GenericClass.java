package com.practice.genericprogramming;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class GenericClass<T1, T2> implements GenericInterface<T1, T2> {

	Map<T1, T2> genericMap;

	public GenericClass(DataType mapType) {
		switch (mapType) {
		case HashMap:
			genericMap = new HashMap<T1, T2>();
			break;
		case TreeMap:
			genericMap = new TreeMap<T1, T2>();
			break;
		case LinkedHashMap:
			genericMap = new TreeMap<T1, T2>();
			break;
		}
	}

	@Override
	public void add(T1 key, T2 value) {
		genericMap.put(key, value);
	}

	@Override
	public GenericInterface<T1, T2> delete(T1 key) {
		genericMap.remove(key);
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public GenericInterface<T1, T2> get(T1 key) {
		return (GenericInterface<T1, T2>) genericMap.get(key);
	}

	@Override
	public GenericInterface<T1, T2> update(T1 key, T2 value) {
		// TODO Auto-generated method stub
		genericMap.remove(key);
		genericMap.put(key, value);
		return (GenericInterface<T1, T2>) genericMap;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (Map.Entry<T1, T2> entry : genericMap.entrySet()) {
			T1 key = entry.getKey();
			T2 value = entry.getValue();
			sb.append("Key: ").append(key).append(" ; Value: ").append(value)
					.append("\n");
		}

		return sb.toString();
	}

}
