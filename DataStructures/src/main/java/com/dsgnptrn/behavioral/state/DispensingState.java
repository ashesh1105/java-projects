package com.dsgnptrn.behavioral.state;

public class DispensingState implements State {
	
    VendingMachine machine ;

    DispensingState(VendingMachine machine) {

        this.machine = machine;

    }

    public void insertCoin() throws MachineWarning {

        throw new MachineWarning("wait, don't insert coin ... previous order is processing");

    }

    public void pressButton() throws MachineWarning {

        throw new MachineWarning("wait, don't press button ... previous order is processing");

    }

    public void dispense() throws MachineWarning {
    	
    	System.out.println("Dispencing item..");

        machine.setMachineState(machine.getNoCoinInsertedState());

    }

}
