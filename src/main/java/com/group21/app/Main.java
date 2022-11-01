package com.group21.app;

import javax.swing.*;

import com.group21.app.Screen.MenuPanel;
import com.group21.app.Screen.ScreenPanel;
import com.group21.app.Screen.TitlePanel;
import com.group21.app.Screen.UI;

import java.awt.*;

public class Main {

    public static void main(String[] args) {
        UI ui = UI.getInstance();
        ui.makeTitleWindow();
    }
}

// COMPILE THE CODE: mvn package
// RUNNING THE CODE: java -cp target/Phase-2-1.0.jar com.group21.app.Main