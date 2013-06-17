package com.printapp.edit;

import com.printapp.edit.misc.GridItem;
import com.printapp.edit.misc.InfoLabel;
import com.printapp.util.ImageResource;
import com.printapp.util.Utils;
import com.printapp.util.i18n;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;

public class Step2 extends JPanel {

    private InfoLabel labelInfo;

    private JPanel panelGrid;

    private JSplitPane mainSplit;

    private JButton acceptButton;

    public Step2(){

        super();
        init();
    }

    public void init(){

        setLayout(new GridBagLayout());

        labelInfo = new InfoLabel();

        acceptButton = Utils.getButton("Continue");
        acceptButton.setAction(new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                Utils.forwardState(Utils.getMainPanel());
            }
        });

        acceptButton.setIcon(new ImageIcon(ImageResource.getImageIcon("steps.jpg").getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH)));

        panelGrid = new JPanel();
        panelGrid.setLayout(new GridLayout(6, 4));

        String gridTextFmt = i18n.getString("Catalog") + " %d";
        for (int i = 0; i < 4; i++)
            for(int j = 0; j < 6; j++){
                final int n = i * 4 + j;
                final GridItem item = new GridItem(){
                    public String getText() {
                        return String.format(i18n.getString("Catalog") + " %d", n);
                    }

                    public void mouseClicked(MouseEvent e) {
                        super.mouseClicked(e);
                        labelInfo.setText(i18n.getString("Clicked") + " " + getText());
                    }
                };
                panelGrid.add(item);
            }

        JPanel rightPanel = new JPanel(new BorderLayout());
        rightPanel.add(labelInfo, BorderLayout.CENTER);
        rightPanel.add(acceptButton, BorderLayout.SOUTH);

        mainSplit = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
        mainSplit.setLeftComponent(new JScrollPane(panelGrid));
        mainSplit.setRightComponent(rightPanel);
        mainSplit.setDividerLocation(0.8);
        mainSplit.setResizeWeight(0.8);

        Utils.constrain(this, mainSplit, 0, 0, 1, 1, GridBagConstraints.BOTH, GridBagConstraints.NORTHWEST, 1, 1, 0, 0, 0, 0);


    }


}
