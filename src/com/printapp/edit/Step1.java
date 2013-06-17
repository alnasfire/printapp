package com.printapp.edit;

import com.printapp.dialog.MainPanel;
import com.printapp.util.*;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Step1 extends JPanel{


    protected JButton i18nSwitchBtn;
    private static String[] langList = {"ru", "en"};
    protected JPanel bannerPanel;
    protected Image bannerImg;
    protected JPanel centerPanel;
    protected JPanel centerLeftPanel;
    protected JPanel centerRightPanel;
    protected JButton newBtn;
    protected JButton openBtn;
    protected JButton binBtn;
    private JLabel helloLabel;
    
    private Image img;

    public Step1(){

        super();
        init();
    }

    public void init(){

        bannerImg = ImageResource.getImageIcon("logo1.jpg").getImage();

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
                Utils.getMainPanel().setCurrentState(Utils.getMainPanel().getCurrentState());
                repaint();
            }
        });
        i18nSwitchBtn.setBackground(ColorScheme.dataBkgColor);
        i18nSwitchBtn.setContentAreaFilled(false);
        i18nSwitchBtn.setPreferredSize(new Dimension(60, 20));
        
        setLayout(new GridBagLayout());
        this.img = ImageResource.getImageIcon("catalogue.jpg").getImage();
        bannerPanel = new JPanel(){
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(bannerImg, 1, 1, getWidth() - 2, getHeight() - 2, this);
            }
        };

        bannerPanel.setPreferredSize(new Dimension(50, 40));

        JPanel tmpPanel = new JPanel(new GridBagLayout());
        Utils.constrain(tmpPanel, bannerPanel, 0, 0, 3, 1, GridBagConstraints.BOTH, GridBagConstraints.NORTHWEST, 1, 1, 1, 1, 1, 1);
        Utils.constrain(tmpPanel, i18nSwitchBtn, 3, 0, 1, 1, GridBagConstraints.BOTH, GridBagConstraints.NORTHWEST, 0.3, 1, 1, 1, 1, 1);

        tmpPanel.setBorder(new CompoundBorder(new EmptyBorder(1, 0, 1, 0), new LineBorder(Color.black) {
            public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
                Graphics2D g2D = (Graphics2D) g;
                g2D.setPaint(new GradientPaint(0, height - 1, Color.black, width / 2, height - 1, Color.gray.brighter()));
                g2D.drawLine(0, height - 1, width / 2, height - 1);
                g2D.setPaint(new GradientPaint(width / 2, height - 1, Color.gray.brighter(), width, height - 1, Color.black));
                g2D.drawLine(width / 2, height - 1, width, height - 1);
            }
        }));

        centerLeftPanel = new JPanel(){
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(img, 2, 2, getWidth()-4, getHeight() - 4, this);
            }
        };

        centerLeftPanel.setBorder(new CompoundBorder(new EmptyBorder(1, 1, 1, 1), new LineBorder(Color.black){
            public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
                Graphics2D g2D = (Graphics2D ) g;
                g2D.setPaint(new GradientPaint(width - 1, 0, Color.black, width - 1, height / 2, Color.gray.brighter()));
                g2D.drawLine(width - 1, 0, width - 1, height / 2);
                g2D.setPaint(new GradientPaint(width - 1, height / 2, Color.gray.brighter(), width - 1, height, Color.black));
                g2D.drawLine(width - 1, height / 2, width - 1, height);
            }
        }));
        
        centerRightPanel = new JPanel(new BorderLayout());
        centerRightPanel.add(tmpPanel, BorderLayout.NORTH);
        
        helloLabel = Utils.getLabel("helloLabel");
        helloLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        
        newBtn = Utils.getButton("New");
        openBtn = Utils.getButton("Open");
        binBtn = Utils.getButton("Bin");

        JPanel tmpPanel2 = new JPanel();
        tmpPanel2.setLayout(new BoxLayout(tmpPanel2, BoxLayout.Y_AXIS));
        tmpPanel2.add(Box.createVerticalStrut(50));
        tmpPanel2.add(makeBtnPanel(helloLabel));
        tmpPanel2.add(Box.createVerticalStrut(50));
        tmpPanel2.add(makeBtnPanel(newBtn));
        tmpPanel2.add(makeBtnPanel(openBtn));
        tmpPanel2.add(makeBtnPanel(binBtn));
        tmpPanel2.add(Box.createVerticalStrut(50));

        centerRightPanel.add(tmpPanel2, BorderLayout.CENTER);
        
        centerPanel = new JPanel(new GridBagLayout());
        
        Utils.constrain(centerPanel, centerLeftPanel, 0, 0, 1, 1, GridBagConstraints.BOTH, GridBagConstraints.NORTHWEST, 1, 1, 0, 0, 0, 0);
        Utils.constrain(centerPanel, centerRightPanel, 1, 0, 1, 1, GridBagConstraints.BOTH, GridBagConstraints.NORTHWEST, 1, 1, 0, 0, 0, 0);

        setLayout(new GridBagLayout());
        
        Utils.constrain(this, centerPanel, 0, 0, 1, 1, GridBagConstraints.BOTH, GridBagConstraints.NORTHWEST, 1, 1, 0, 0, 0, 0);
        
    }

    private JPanel makeBtnPanel(JComponent btn){
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(btn, BorderLayout.CENTER);
        panel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        return panel;
    }
    
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(img, 0, 0, getWidth(), getHeight() - 80, this);
    }
}
