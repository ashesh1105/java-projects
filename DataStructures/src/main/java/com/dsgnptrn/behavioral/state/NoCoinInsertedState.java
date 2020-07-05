package com.dsgnptrn.behavioral.state;

// When vending machine is in this state, you can only insert a coin, any other operation prior to that will be an error!

public class NoCoinInsertedState implements State {
	
    private VendingMachine machine;

    public NoCoinInsertedState(VendingMachine machine) {
        this.machine =  machine;
    }

    // This is the only operation allowed when machine is in NoCoinInsertedState!
    public void insertCoin() throws MachineWarning {

        // Machine should have items available for it to start accepting coins
        if (!machine.isEmpty()) {
        	System.out.println("Inserting coin..");
            machine.setMachineState(machine.getCoinInsertedState());
        }
        else {
            throw new MachineWarning("Can not process request .. Machine is out of stock");
        }
    }

    // Can't press a button since no coin is inserted yet!
    public void pressButton() throws MachineWarning{
        throw new MachineWarning("Button pressed with no coin inserted ..");
    }

    // Can't dispense an item since no coin is inserted yet!
    public void dispense() throws MachineWarning{
        throw new MachineWarning("Can't dispense, no coin inserted");
    }

}
