package com.dsgnptrn.behavioral.state;

public interface State {

    public void insertCoin() throws MachineWarning;

    public void pressButton() throws MachineWarning;

    public void dispense() throws MachineWarning;

}
