package com.printapp.util;

import com.printapp.dialog.MainPanel;
import javax.swing.*;
import java.awt.*;

public class Utils {

    public static boolean isNull(String value){
        return value == null || value.trim().equalsIgnoreCase("null");
    }

    public static boolean isNull(Object value){
        return value == null;
    }

    public static void constrain(Container c, Component p, int x, int y, int width, int height, int fill, int anchor, double weightx, double weighty, int insetTop, int insetLeft, int insetRight, int insetBottom){
        GridBagConstraints gc = new GridBagConstraints(x, y, width, height, weightx, weighty, anchor, fill, new Insets(insetTop, insetLeft, insetRight, insetBottom), 0, 0);
        c.add(p, gc);
    }

    public static void forwardState(MainPanel mainPanel){
        try{
            int state = Integer.parseInt(mainPanel.getCurrentState());
            switch(state){
                case States.Step1:mainPanel.setCurrentState(""+States.Step2); break;
                case States.Step2:mainPanel.setCurrentState(""+States.Step3); break;
                case States.Step3:break;
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }

    public static MainPanel getMainPanel(){
        Window []wnd = Window.getWindows();
        for(Window w:wnd)
            if(w instanceof MainPanel)
                return (MainPanel )w;
        return null;
    }

    public static void centerOnScreen(Component cmp){
        Dimension size = cmp.getSize();
        Dimension displaySize = getDisplayDimensions();
        Point pt = new Point(displaySize.width / 2 - size.width / 2, displaySize.height / 2 - size.height / 2);
        cmp.setLocation(pt);
    }

    public static Dimension getDisplayDimensions(){
        Dimension screenSize = null;
        GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice[] devices = env.getScreenDevices();
        if(devices[0] != null)
            screenSize = new Dimension(devices[0].getDisplayMode().getWidth(), devices[0].getDisplayMode().getHeight());
        else
            screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        return screenSize;
    }

    public static JMenu getMenu(final String key){
        return new JMenu(){
            public String getText() {
                return i18n.getString(key);
            }
        };
    }

    public static JMenuItem getMenuItem(final String key){
        return new JMenuItem(){
            public String getText() {
                return i18n.getString(key);
            }
        };
    }

    public static JButton getButton(final String key){
        return new JButton(){
            public String getText() {
                return i18n.getString(key);
            }
        };
    }

    public static JLabel getLabel(final String key){
        return new JLabel(){
            public String getText() {
                return i18n.getString(key);
            }
        };
    }
}
