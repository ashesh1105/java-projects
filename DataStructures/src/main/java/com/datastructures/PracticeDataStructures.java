package com.datastructures;

import java.util.*;

public class PracticeDataStructures {

	public static void main(String[] args) {

		List<String> animals = new ArrayList<String>();
		Set<String> birds = new HashSet<String>();

		// Populate the list
		animals.add("cat");
		animals.add("tiger");
		animals.add("swan");
		animals.add("elephant");
		animals.add("monkey");
		animals.add("dog");

//		Collections.sort(animals, Comparator.comparing(e -> e.length()));
		
		// Java8 Lambda - sort() is part of List interface itself
		animals.sort(Comparator.comparing(e -> e.length()));

		// Print the list by length of their names
		System.out.println("Printing animals sorted by their length of name:");
		animals.forEach(System.out::println);

		// Now sort it in reverse order of their lengths. Just add a minus on e.length()
		animals.sort(Comparator.comparing(e -> -e.length()));

		// Print the list by reverse order of length of their names
		System.out.println("\nPrinting animals sorted by length of their names in descending order:");
		animals.forEach(System.out::println);

		// Sort the list by reverse alphabetical order by inner class implementing comparator
//		animals.sort((animal1, animal2) -> (-1) * animal1.compareTo(animal2));	// -1 x since reverse alphabetical needed
		animals.sort(Comparator.reverseOrder());


		// Print the list by reverse alphabetical order
		System.out.println("\nPrinting animals in the list compared by reverse alphabetical order:");
		animals.forEach(System.out::println);

		// Sort the list by reverse alphabetical order by outer class
		// implementing comparator
		// This way you can use them multiple times
		Collections.sort(animals, new CompareAnimalsReverseAlphabatical());

		// Print the list by reverse alphabetical order
		System.out
				.println("\n"
						+ "Animals in the list compared by reverse alphabetical order using class that implements Comparator:");
		animals.forEach(System.out::println);

		// Populate the Set (HashSet)
		birds.add("Peacock");
		birds.add("Hen");
		birds.add("Parrot");
		birds.add("Eagle");
		birds.add("Chicken");

		// Print the Set
		System.out.println("\nPrinting the Set before sorting (HashSet):");
		System.out.println(birds);

		// Sort the Set (HashSet)
		Set<String> sortedBirds = new TreeSet<String>(birds);

		// Print the sorted set:
		System.out.println("\nPrinting the sorted set of birds using TreeSet:");
		System.out.println(sortedBirds);

		// Add objects to list and set (sorted one, like TreeSet)
		// Define the List and Set (in this case, sorted one on natural order)
		List<Person> peopleList = new ArrayList();
		Set<Person> peopleSet = new TreeSet();

		// Add people to List
		addPeople(peopleList);

		// Print the people List
		System.out.println("\nPrinting the list of people:");
		peopleList.forEach(System.out::println);

		// Sort the list
		Collections.sort(peopleList, Comparator.comparing(e -> e.getName().length()));

		// Print the sorted list of people
		System.out
				.println("\nPrinting the sorted list of people by length of names using Comparable:");
		
		peopleList.forEach(people -> System.out.println(people));

		// Add people to set (TreeSet). Remember, the class Person must implement Comparable interface
		addPeople(peopleSet);

		// Print the people set:
		System.out
				.println("\nPrinting the set of people from TreeSet with Person class implementing "
						+ "Comparable:");
		peopleSet.forEach(System.out::println);

	}

	private static void addPeople(Collection<Person> people) {
		people.add(new Person("Ashesh", 1));
		people.add(new Person("Ram", 2));
		people.add(new Person("Ghanshyam", 3));
		people.add(new Person("Tom", 4));
		people.add(new Person("Dick", 5));
		people.add(new Person("Harry", 6));
		people.add(new Person("David", 7));
	}

}

class CompareAnimalsReverseAlphabatical implements Comparator<String> {

	@Override
	public int compare(String animal1, String animal2) {
		return -(animal1.compareTo(animal2));
	}

}

class Person implements Comparable<Person> {
	private String name;
	private int id;

	public Person(String name, int id) {
		super();
		this.name = name;
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Name: " + name + " | ID: " + id;
	}

	@Override
	public int compareTo(Person person) {
		// Below would enable sorting in natural alphabetic order by names but
		// commenting it out
		// return (name.compareTo(person.getName()));
		// going by sorting by length of names

		if (!(person instanceof Person)) {
			System.out.println("Comparing wrong object types!");
		}

		int len1 = name.length();
		int len2 = person.getName().length();
		if (len1 > len2) {
			return 1;
		} else if (len1 < len2) {
			return -1;
		}
		return name.compareTo(person.getName());	// lexicographical order for people with same name lengths
	}

}
