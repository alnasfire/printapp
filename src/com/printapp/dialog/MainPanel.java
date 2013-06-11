package com.printapp.dialog;

import javax.swing.*;

public interface MainPanel {

    JPanel getMainPanel();

    void setCurrentState(String state);

    String getCurrentState();
}
