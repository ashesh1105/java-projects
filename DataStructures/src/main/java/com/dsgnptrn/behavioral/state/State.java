package com.dsgnptrn.behavioral.state;

public interface State {

    void insertCoin() throws MachineWarning;

    void pressButton() throws MachineWarning;

    void dispense() throws MachineWarning;

}
