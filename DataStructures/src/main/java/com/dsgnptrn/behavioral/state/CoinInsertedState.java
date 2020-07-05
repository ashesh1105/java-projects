package com.dsgnptrn.behavioral.state;

// Only operation you can do when vending machine is in this state is to press a button!

public class CoinInsertedState implements State {
	
    VendingMachine machine =null;

    public CoinInsertedState(VendingMachine machine) {
        this.machine =  machine;
    }

    // Coin is already inserted since we're in CoinInsertedState, so this will cause an error
    public void insertCoin() throws MachineWarning {
        throw new MachineWarning("Coin is already inserted, wait till current order finished.");
    }

    // This is the only operation allowed when vending machine is in CoinInsertedState
    public void pressButton() throws MachineWarning {
        System.out.println("Button Pressed..");

        // Now that button is pressed, machine gets to dispensing state
        machine.setMachineState(machine.getDispensingState());
    }

    // You can't dispense until button is pressed!
    public void dispense() throws MachineWarning {
        throw new MachineWarning("Can't dispense, button is not pressed.");
    }
}
