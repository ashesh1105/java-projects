package com.dsgnptrn.behavioral.state;

import lombok.Getter;
import lombok.Setter;

public class VendingMachine {

    @Getter
    @Setter
    private State emptyState = new EmptyState(this);
    @Getter
    @Setter
    private State noCoinInsertedState = new NoCoinInsertedState(this);
    @Getter
    @Setter
    private State coninInsertedState = new CoinInsertedState(this);
    @Getter
    @Setter
    private State dispensingState = new DispensingState(this);
    @Getter
    @Setter
    private State machineState = null;

    private int capacity = 0;

    // Instantiate Vending Machine with Empty state
    public VendingMachine() {
        machineState = emptyState;
    }

    public boolean isEmpty() {
        return capacity <= 0;
    }

    // When you fill the machine, it gets out of empty state and gets to noCoinInsertedState
    public void reFill(int count) {
        if (count > 0) {
            capacity += count;
            machineState = noCoinInsertedState;
        }
    }

    // Two Actions can be performed by Machine after it is refilled
    public void insertCoin() throws MachineWarning {

        // Machine is in NoCoinInsertedState, so you can insert a coin now, to get to CoinInsertedState
        machineState.insertCoin();
    }
    
    public void pressButton() throws MachineWarning {

        // Pressing a button brings machine to Dispensing State, you can then dispense the item you're looking for
        machineState.pressButton();
        machineState.dispense();

        // Decrement the capacity by 1 since we dispensed an item
        capacity--;
    }
}
