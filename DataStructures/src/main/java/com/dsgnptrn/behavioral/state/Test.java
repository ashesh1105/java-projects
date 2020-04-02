package com.dsgnptrn.behavioral.state;

/*
  Design a vending machine with these operations:
  a) Insert a coin,
  b) Press button
  c) Dispense an item
  When behavior is associated with a specific state, we create an interface (State in this case) and have various implementations
  which represent a behavior for a specific state.
 */

public class Test {

	public Test() {

	}

	public static void main(String[] args) {

		VendingMachine machine = new VendingMachine();	// Machine boots up with EmptyState
		machine.reFill(2);	// Brings vending machine to NoCoinInsertedState

		// First dispense
		try {
			machine.insertCoin();	// Brings machine to CoinInsertedState
			machine.pressButton();	// Brings machine to DispensingState
		} catch (MachineWarning e) {
			System.out.println("Error - Test 1:" + e.getMessage());
		}

		// Second Test
		try {
			machine.insertCoin();
			machine.insertCoin();	// Should cause an error since machine is already in CoinInsertedState
			machine.pressButton();	// Should dispense an item since we have the last one of 2 available
		} catch (MachineWarning e) {
			System.out.println("Test 2:" + e.getMessage());
		}

		// Test Three
		try {
			machine.pressButton(); // Should cause an error since machine is in NoCoinInsertedState
		} catch (MachineWarning e) {
			System.out.println("Test 3:" + e.getMessage());
		}

		// Test Four
		try {
			machine.insertCoin();	// Will cause error since machine is in EmptyState now!
		} catch (MachineWarning e) {
			System.out.println("Test 4:" + e.getMessage());
		}
	}
}
