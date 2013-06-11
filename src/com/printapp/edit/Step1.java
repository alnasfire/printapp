package com.printapp.edit;

import com.printapp.dialog.MainPanel;
import com.printapp.util.Utils;
import com.printapp.util.i18n;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.geom.Ellipse2D;

public class Step1 extends JPanel{

    private JButton startButton;
    private Action startAction;
    private Image img;

    public Step1(){

        super();
        init();
    }

    public void init(){

        startAction = new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                MainPanel mainPanel = Utils.getMainPanel();
                if(mainPanel == null)
                    return;
                Utils.forwardState(mainPanel);
            }
        };

        setLayout(new GridBagLayout());
        this.img = new ImageIcon("src/img/catalogue.jpg").getImage();
        this.startButton = new JButton(){

//            private Shape shape;
//
//            private void initShape(){
//                Dimension dd = getPreferredSize();
//                if(shape == null)
//                    shape = new Ellipse2D.Float(0, 0, dd.width - 1, dd.height - 1);
//            }

            public String getText() {
                return i18n.getString("Start");
            }

//            public boolean contains(int x, int y) {
//                initShape();
//                return shape.contains(x, y);
//            }
        };
        startButton.setAction(startAction);
        startButton.setContentAreaFilled(false);
        startButton.setFocusPainted(false);
        startButton.setPreferredSize(new Dimension(120, 60));

        startButton.setIcon(new ImageIcon(new ImageIcon("src/img/steps.jpg").getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH)));

        setLayout(new BorderLayout());
        JPanel tmp = new JPanel(new BorderLayout());
        tmp.add(startButton, BorderLayout.EAST);
        add(tmp, BorderLayout.SOUTH);
//        Utils.constrain(this, Box.createHorizontalBox(), 0, 0, 2, 4, GridBagConstraints.BOTH, GridBagConstraints.NORTHWEST, 1, 1, 0, 0, 0, 0);
//        Utils.constrain(this, Box.createGlue(), 0, 4, 2, 1, GridBagConstraints.BOTH, GridBagConstraints.NORTHWEST, 1, 1, 0, 0, 0, 0);
//        Utils.constrain(this, startButton, 1, 6, 1, 1, GridBagConstraints.BOTH, GridBagConstraints.NORTHWEST, 0.1, 0.1, 0, 0, 0, 0);

    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(img, 0, 0, getWidth(), getHeight() - 80, this);
    }
}
