package com.printapp.dialog;

import com.printapp.util.Utils;
import com.printapp.util.i18n;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.font.TextAttribute;
import java.util.Map;

public class AlphaButton extends JButton{
    
    private float alpha = 1f;
    private boolean hover = false;
    
    Font normalFont = null;
    
    public AlphaButton(){
        super();
        init();
    }
    
    public AlphaButton(String txt){
        super(txt);
        init();
    }

    public void setHover(boolean hh){
        this.hover = hh;
    }
    
    public boolean isHover(){
        return hover;
    }
    
    public void init(){
        addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                AlphaButton.this.setAlpha(1f);
                AlphaButton.this.setHover(true);
                Utils.componentEntered(AlphaButton.this);
            }

            public void mouseExited(MouseEvent e) {
                AlphaButton.this.setAlpha(1f);
                AlphaButton.this.setHover(false);                
                Utils.componentExited(AlphaButton.this);
            }
        });
        setContentAreaFilled(false);
        setBorderPainted(false);
        setFocusPainted(false);
        normalFont = getFont();
    }
    
    public String getText(){
        String txt = super.getText();
        if(txt != null)
            return i18n.getString(txt);
        return txt;
    }
    
    public void setAlpha(float a){
        this.alpha = a;
    }

    public float getAlpha(){
        return alpha;
    }

    public Color getForeground() {
        return super.getForeground();
    }

    public void paintComponent(java.awt.Graphics g) {
        java.awt.Graphics2D g2 = (java.awt.Graphics2D) g;
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha));
        if(isHover()){
            setForeground(Color.blue);
            Font ff = g2.getFont();
            Map attributes = ff.getAttributes();
            attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
            setFont(ff.deriveFont(attributes));
        }else{
            setForeground(Color.black);
            Font ff = g2.getFont();
            Map attributes = ff.getAttributes();
            attributes.remove(TextAttribute.UNDERLINE);
            setFont(normalFont);
        }
        super.paintComponent(g2);
    }    
    
}
