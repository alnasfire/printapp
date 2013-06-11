package com.printapp.edit;

import com.printapp.util.ColorScheme;
import com.printapp.util.Utils;
import com.printapp.util.i18n;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class Step3 extends JPanel{

    private JTabbedPane projectArea;
    private JButton addImageBtn;
    private JButton addTextBtn;
    private JButton addEffectBtn;
    private JButton setBkgBtn;

    private JPanel topArea;
    private JPanel tmpArea;

    private JButton acceptBtn;

    public Step3(){

        super();
        init();
    }


    public void init(){

        projectArea = new JTabbedPane(JTabbedPane.BOTTOM);
        addImageBtn = Utils.getButton("addImageBtnText");
        addTextBtn = Utils.getButton("addTextBtnText");
        addEffectBtn = Utils.getButton("addEffectBtnText");
        setBkgBtn = Utils.getButton("setBkgBtnText");
        acceptBtn = Utils.getButton("Print");
        tmpArea = new JPanel(new BorderLayout());
        JTextPane jt =  new JTextPane(){
            public String getText() {
                return i18n.getString("Panel_stub");
            }
        };
        jt.setEditable(false);
        tmpArea.add(jt, BorderLayout.CENTER);
        tmpArea.add(acceptBtn, BorderLayout.SOUTH);
        tmpArea.setBorder(new LineBorder(ColorScheme.panelBorderColor));
        topArea = new JPanel();
        topArea.setLayout(new GridLayout(1, 4));
        topArea.add(addImageBtn);
        topArea.add(addTextBtn);
        topArea.add(addEffectBtn);
        topArea.add(setBkgBtn);

        setLayout(new GridBagLayout());

        Utils.constrain(this, topArea, 0, 0, 5, 1, GridBagConstraints.HORIZONTAL, GridBagConstraints.NORTHWEST, 1, 0, 0, 0, 0, 0);
        Utils.constrain(this, Box.createHorizontalBox(), 5, 0, 1, 1, GridBagConstraints.HORIZONTAL, GridBagConstraints.NORTHWEST, 1, 0, 0, 0, 0, 0);
        Utils.constrain(this, projectArea, 0, 1, 5, 6, GridBagConstraints.BOTH, GridBagConstraints.NORTHWEST, 1, 1, 0, 0, 0, 0);
        Utils.constrain(this, tmpArea, 5, 1, 1, 6, GridBagConstraints.BOTH, GridBagConstraints.NORTHWEST, 1, 1, 0, 0, 0, 0);

    }

}
