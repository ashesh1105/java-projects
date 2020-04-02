package com.dsgnptrn.behavioral.state;

// No operation will be possible when vending machine is in Empty state!

public class EmptyState implements State {
	
    private VendingMachine machine;

    public EmptyState(VendingMachine machine) {
        this.machine =  machine;
    }

    // Throw error since machine is in Empty state!
    public void insertCoin() throws MachineWarning{
        throw new MachineWarning("Can not process the request, machine empty");
    }

    // Throw error since machine is in Empty state!
    public void pressButton() throws MachineWarning{
        throw new MachineWarning("Invalid Action as in empty state");
    }

    // Throw error since machine is in Empty state!
    public void dispense() throws MachineWarning{
        throw new MachineWarning("Invalid Action, machine empty");
    }

}
