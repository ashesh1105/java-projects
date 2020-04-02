package com.dsgnptrn.behavioral.state;

// When vending machine is in Dispensing State, only operation you can do is to dispense an item

public class DispensingState implements State {
	
    VendingMachine machine ;

    DispensingState(VendingMachine machine) {
        this.machine = machine;
    }

    // You can't insert coin when machine is already in the process of dispensing an item!
    public void insertCoin() throws MachineWarning {
        throw new MachineWarning("wait, don't insert coin ... previous order is processing");
    }

    // You can't press a button when machine is already in the process of dispensing an item!
    public void pressButton() throws MachineWarning {
        throw new MachineWarning("wait, don't press button ... previous order is processing");
    }

    // This is the only operation allowed when vending machine is in Dispensing state
    public void dispense() throws MachineWarning {
    	System.out.println("Dispensing item..");

    	// Now that machine has done dispensing item, move the state of the machine back to NoCoinInsertedState
        machine.setMachineState(machine.getNoCoinInsertedState());
    }

}
