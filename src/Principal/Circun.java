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
public class Circun {

    int r;
    Ponto pC;
    Color cor;
    boolean isAliasing;

    public Circun() {

    }

    public Circun(int r, Ponto pC, Color cor, boolean a) {
        this.r = r;
        this.pC = pC;
        this.cor = cor;
        this.isAliasing = a;
    }

    public void desenhaCirculo(int xc, int yc, int x, int y, Graphics area) {
        new Ponto(xc + x, yc + y).draw(area, cor);
        new Ponto(xc - x, yc + y).draw(area, cor);
        new Ponto(xc + x, yc - y).draw(area, cor);
        new Ponto(xc - x, yc - y).draw(area, cor);
        new Ponto(xc + y, yc + x).draw(area, cor);
        new Ponto(xc - y, yc + x).draw(area, cor);
        new Ponto(xc + y, yc - x).draw(area, cor);
        new Ponto(xc - y, yc - x).draw(area, cor);
    }

    public void draw(Graphics area) {

        int x = 0, y = r;
        int p = 3 - 2 * r;

        desenhaCirculo(x, y, pC.x, pC.y, area);

        while (x < y) {
            if (p < 0) {
                p = p + 4 * x + 6;
            } else {
                p = p + 4 * (x - y) + 10;
                y--;
            }
            x++;
            desenhaCirculo(pC.x, pC.y, x, y, area);
        }
    }

    public void drawCircunAli(JPanel area) {
        
    }
}
