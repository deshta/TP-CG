/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author guimn
 */
public class Ponto extends JPanel{
    int x;
    int y;
    
    public Ponto(){
        
    }
    
    public Ponto(int x, int y){
        this.x = x;
        this.y = y;
    }
    
    public void draw(JPanel p, Color cor){
        Graphics g = p.getGraphics();
        g.setColor(cor);
        g.drawLine(x, y, x, y);
    }
}
