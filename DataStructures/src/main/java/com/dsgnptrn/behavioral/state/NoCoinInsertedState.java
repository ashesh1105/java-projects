package com.dsgnptrn.behavioral.state;

public class NoCoinInsertedState implements State {
	
    VendingMachine machine;

    public NoCoinInsertedState(VendingMachine machine) {

        this.machine =  machine;

    }

    public void insertCoin() throws MachineWarning {

        if (!machine.isEmpty()) {
        	
        	System.out.println("Inserting coin..");

            machine.setMachineState(machine.getConinInsertedState());

        }

        else {

            throw new MachineWarning("Can not process request .. Machine is out of stock");

        }

    }

    public void pressButton() throws MachineWarning{

        throw new MachineWarning("Button pressed with no coin inserted ..");

    }

    public void dispense() throws MachineWarning{

        throw new MachineWarning("Can't dispense, no coin inserted");

    }

}
