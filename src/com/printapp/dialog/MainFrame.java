package com.printapp.dialog;

import com.printapp.edit.Step1;
import com.printapp.edit.Step2;
import com.printapp.edit.Step3;
import com.printapp.util.*;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.*;

public class MainFrame extends JFrame implements MainPanel {

    protected JPanel bottomPanel;
    protected JButton exitBtn;
    protected JLabel versionLabel;
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
//        try {
//            UIManager.setLookAndFeel(new TinyLookAndFeel());
//        } catch (UnsupportedLookAndFeelException e) {
//            e.printStackTrace();
//        }
        bottomPanel = new JPanel();
        
        versionLabel = Utils.getLabel("Version");
        versionLabel.setBorder(new EmptyBorder(0, 25, 0 ,0));
        
        exitBtn = new AlphaButton();
        exitBtn.setAction(new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        exitBtn.setIcon(ImageResource.getImageIcon("Delete24.gif"));

        bottomPanel.setLayout(new GridBagLayout());
        Utils.constrain(bottomPanel, versionLabel, 0, 0, 1, 1, GridBagConstraints.BOTH, GridBagConstraints.NORTHWEST, 1, 1, 0, 10, 0, 0);
        Utils.constrain(bottomPanel, Box.createHorizontalBox(), 1, 0, 3, 1, GridBagConstraints.BOTH, GridBagConstraints.NORTHWEST, 1, 1, 0, 0, 0, 0);
        Utils.constrain(bottomPanel, exitBtn, 4, 0, 1, 1, GridBagConstraints.BOTH, GridBagConstraints.NORTHWEST, 0.1, 1, 0, 0, 10, 0);
        bottomPanel.setBorder(new CompoundBorder(new EmptyBorder(10, 0, 10, 0), new LineBorder(Color.black){
            public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
                Graphics2D g2D = (Graphics2D ) g;
                g2D.setPaint(new GradientPaint(1, 0, Color.gray.brighter(), width /2, 0, Color.black));
                g2D.drawLine(1, 0, width / 2, 0);
                g2D.setPaint(new GradientPaint(width / 2, 0, Color.black, width - 2, 0, Color.gray.brighter()));
                g2D.drawLine(width / 2, 0, width - 2, 0);
            }
        }));
        
        mainPanel = new JPanel(new CardLayout()){
            protected void paintComponent(Graphics g) {
//                super.paintComponent(g);
            }
        };

        mainPanel.add(new Step1(), ""+States.Step1);
        mainPanel.add(new Step2(), "" + States.Step2);
        mainPanel.add(new Step3(), "" + States.Step3);


        Container cp = getContentPane();
        cp.add(mainPanel, BorderLayout.CENTER);
        bottomPanel.setPreferredSize(new Dimension(840, 50));
        cp.add(bottomPanel, BorderLayout.SOUTH);

        setCurrentState("" + States.Step1);
    }

    public static void main(String [] args){

        MainFrame frame = new MainFrame();
        frame.setSize(840,600);
        Utils.centerOnScreen(frame);
        frame.setTitle(i18n.getString("MainTitle"));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setResizable(false);
    }
}
