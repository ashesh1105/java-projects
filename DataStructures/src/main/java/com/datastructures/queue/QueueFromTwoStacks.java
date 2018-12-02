package com.datastructures.queue;

public class QueueFromTwoStacks {
	
	/**
	 * Implement Queue behaviour using to stacks, not arrays at all!
	 * Methods needed will be add, peek and pop
	 * TODO: Implement this when you get time.
	 * Approach:
	 * a) Use two stacks, stackA and stackB
	 * b) Always peek or poll from stackB (you can make it do from stackA if you want), stackA will be in Empty state
	 * Once write operation is done. Need to synchronize the method to maintain the state!!
	 * c) Depending on situation, ready heavy or write heavy, you can make read faster or write faster
	 * (why make both operations heavy? As generally the case,let's say its ready heavy, reads 10 times of write operation)
	 * Add Operation (queue.add(data)):
	 * d) Say we want to add Integer 1 and add operation starts.
	 * e) Pop elements from stackB (1 by 1) and add to stackA till stackB is empty
	 * f) Push the new element (1) to stackA
	 * g) Pop from stackA (1 by 1) and keep adding to stackB till stackA is empty, and once done, you're done!
	 * Note, your stackA is in Empty state again. You're all set to allow another threads to do queue operations again!
	 * Peek Operation (will be super fast O(1), makes sense since it is read heavy!):
	 * h) Peek from stackB and return that element. You're done!
	 * Pop Operation (super fast, O(1), like peek!):
	 * i) Simply pop from stackB and return the element, you're done.
	 * That's it! :)
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
