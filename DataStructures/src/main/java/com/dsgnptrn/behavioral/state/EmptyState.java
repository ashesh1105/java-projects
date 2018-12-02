package com.dsgnptrn.behavioral.state;

public class EmptyState implements State {
	
    VendingMachine machine;

    public EmptyState(VendingMachine machine) {

        this.machine =  machine;

    }

    public void insertCoin() throws MachineWarning{

        throw new MachineWarning("Can not process the request, machine empty");

    }

    public void pressButton() throws MachineWarning{

        throw new MachineWarning("Invalid Action as in empty state");

    }

    public void dispense() throws MachineWarning{

        throw new MachineWarning("Invalid Action, machine empty");

    }

}
