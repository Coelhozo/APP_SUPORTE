package Interfaces.Components;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Cursor;
//import java.awt.Graphics;

public class Butao extends JButton{
    
    public Butao(String str){
        super(str);
        setContentAreaFilled(false);
        setCursor(new Cursor(Cursor.HAND_CURSOR));
        setFocusable(false);
        setForeground(new Color(0,0,0,180));
    }
}