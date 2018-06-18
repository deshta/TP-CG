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

    /**
        * Construtor vazio do método Circun.
    */
    public Circun() {

    }

    /** 
     * O metodo Circun recebe as coordenadas do raio,ponto central da circunferencia e a cor desejada.
     * @param int r, o ponto do raio 
     * @param Ponto pC, o ponto central da circunferencia
     * @param Color cor, a cor do tracejado da circunferencia
     * @return uma circunferencia a partir dos dados obtidos.
    */   
    public Circun(int r, Ponto pC, Color cor, boolean a) {
        this.r = r;
        this.pC = pC;
        this.cor = cor;
        this.isAliasing = a;
    }

    /** 
        * O metodo desenhaCirculo recebe os pontos centrais e plota um circulo na tela com a cor desejada.
        * @param int xc,o ponto x central
        * @param int yc,o ponto y central
        * @param int x, o ponto inicial
        * @param int y, o ponto final
        * @param Graphics area em que será desenhada a circunferência
        * @return null.
    */
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

    /** 
        * O metodo draw recebe a área onde será desenhada a circunferência.
        * @param Graphics area em que será desenhada a circunferência
        * @return null.
    */
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
