package com.printapp.edit.misc;

import com.printapp.util.ColorScheme;
import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class GridItem extends JLabel implements MouseListener{

    public GridItem(){
        super();

        setBorder(new CompoundBorder(new LineBorder(ColorScheme.gridBorderColor), new EmptyBorder(4, 2, 4, 2)));
        setIconTextGap(4);

        addMouseListener(this);
    }

    public void mouseClicked(MouseEvent e) {

    }

    public void mousePressed(MouseEvent e) {

    }

    public void mouseReleased(MouseEvent e) {

    }

    public void mouseEntered(MouseEvent e) {

    }

    public void mouseExited(MouseEvent e) {

    }
}
