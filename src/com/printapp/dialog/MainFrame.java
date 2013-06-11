package com.printapp.dialog;

import com.printapp.edit.Step1;
import com.printapp.edit.Step2;
import com.printapp.edit.Step3;
import com.printapp.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class MainFrame extends JFrame implements MainPanel {

    protected JMenuBar menuBar;
    protected JMenu menu;
    protected JTabbedPane tabbedPane;
    protected JPanel bottomPanel;
    protected JPanel bannerPanel;
    protected JButton i18nSwitchBtn;
    Image bannerImg;
    private static String[] langList = {"ru", "en"};
    private String state = ""+States.Step1;

    private JPanel mainPanel;

    public JPanel getMainPanel(){
        return mainPanel;
    }

    public void setCurrentState(String state){
        this.state = state;
        ((CardLayout ) getMainPanel().getLayout()).show(getMainPanel(), state);
    }

    public String getCurrentState() {
        return state;
    }

    public MainFrame(){
        bannerImg = new ImageIcon("src/img/logo1.jpg").getImage();
        menuBar = new JMenuBar(){
            public void paint(Graphics g) {
                super.paint(g);
//                g.drawImage(bannerImg, 70, 0, getWidth() - 200, getHeight(), this);
            }
        };
        menu = Utils.getMenu("File");
        menu.add(Utils.getMenuItem("New"));
        menu.add(Utils.getMenuItem("Save"));
        menu.add(Utils.getMenuItem("Save_as"));
        menu.add(new JSeparator());
        menu.add(Utils.getMenuItem("Close"));
        menu.add(new JSeparator());
        menu.add(Utils.getMenuItem("Exit"));

        //menuBar.setLayout(new BorderLayout());
        menuBar.add(menu);

        i18nSwitchBtn = new JButton(){
            public String getText() {
                String txt = Configuration.getLanguage();
                if(Utils.isNull(txt))
                    txt = Configuration.default_language;
                return txt;
            }
        };
        i18nSwitchBtn.setAction(new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                String lang = "" + Configuration.getLanguage();
                int index = -1;
                for(int j = 0; j < langList.length; j++)
                    if(lang.equals(langList[j])){
                        index = j;
                        break;
                    }
                index++;
                if(index >= langList.length)
                    index = 0;
                Configuration.setLanguage(langList[index]);
                setCurrentState(getCurrentState());
                repaint();
            }
        });
        i18nSwitchBtn.setBackground(ColorScheme.dataBkgColor);
        i18nSwitchBtn.setContentAreaFilled(false);

        bottomPanel = new JPanel();
        bannerPanel = new JPanel(new BorderLayout());
//        bannerPanel.add(bannerBtn, BorderLayout.CENTER);
        bannerPanel.add(i18nSwitchBtn, BorderLayout.EAST);

        tabbedPane = new JTabbedPane(JTabbedPane.BOTTOM);

        mainPanel = new JPanel(new CardLayout());

        mainPanel.add(new Step1(), ""+States.Step1);
        mainPanel.add(new Step2(), ""+States.Step2);
        mainPanel.add(new Step3(), ""+States.Step3);

        getContentPane().add(mainPanel, BorderLayout.CENTER);
        menuBar.add(bannerPanel, BorderLayout.EAST);

        setJMenuBar(menuBar);
        setCurrentState("" + States.Step1);
    }

    public static void main(String [] args){

        MainFrame frame = new MainFrame();
        frame.setSize(800,600);
        Utils.centerOnScreen(frame);
        frame.setTitle(i18n.getString("MainTitle"));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
