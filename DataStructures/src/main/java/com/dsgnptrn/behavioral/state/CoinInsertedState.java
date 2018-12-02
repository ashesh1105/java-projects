package com.dsgnptrn.behavioral.state;

public class CoinInsertedState implements State {
	
    VendingMachine machine =null;

    public CoinInsertedState(VendingMachine machine) {

        this.machine =  machine;

    }

    public void insertCoin() throws MachineWarning {

        throw new MachineWarning("Coin is already inserted, wait till current order finished.");

    }

    public void dispense() throws MachineWarning {

        throw new MachineWarning("Can't dispense, button is not pressed.");

    }
    
    public void pressButton() throws MachineWarning {
    	
    	System.out.println("Button Pressed..");

        machine.setMachineState(machine.getDispensingState());

    }
    
    

}
