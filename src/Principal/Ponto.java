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
    
    /*
     * Construtor vazio do método Ponto.
    */
    public Ponto(){   
    }
    
    /**
     * O método ponto que recebe coordenada de ponto.
     * @param int x, coordenada de um ponto  recebido pelo metodo Ponto.
     * @param int y, coordenada de um ponto recebido pelo metodo Ponto.
     * @return retorna as coordenadas do ponto
     */
    public Ponto(int x, int y){
        this.x = x;
        this.y = y;
    }
    

    /**
     * O método draw recebe a área a ser desenhada e a cor do ponto.
     * @param Graphics p, área a ser desenhada o ponto.
     * @param Color cor, cor do ponto.
     * @return null
     */
    public void draw(Graphics p, Color cor){
        p.setColor(cor);
        p.drawLine(x, y, x, y);
    }
}
