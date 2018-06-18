/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;

import java.awt.Color;
import java.awt.Graphics;
import static java.lang.Math.floor;
import static java.lang.Math.round;

/**
 *
 * @author guimn
 */
public class Reta extends javax.swing.JPanel {

    Ponto p1;
    Ponto p2;
    Color cor;
    boolean aliasing;

    /**
        * O construtor vazio do metodo da reta.
    */
    public Reta() {
    }

    /**
     * O método Reta recebe os pontos inicial, final e a cor da reta.
     * @param Ponto p1, ponto inicial recebido.
     * @param Ponto p2, ponto final recebido.
     * @param Color cor,cor desejada para a linha.
     * @return retorna as coordenadas de dois pontos e a cor desejada pelo usuario.
    */
    public Reta(Ponto p1, Ponto p2, Color cor, boolean a) {
        this.p1 = p1;
        this.p2 = p2;
        this.cor = cor;
        this.aliasing = a;
    }

    /**
     * O método pontos recebe os pontos inicial e final.
     * @param Graphics area, tela onde será plotada a reta.
     * @return null
    */
    public void draw(Graphics area) {
        int dx, dy, xIncr, yIncr, p;
        int c1, c2;
        int x, y;

        dx = p2.x - p1.x;
        dy = p2.y - p1.y;

        if (dx < 0) {
            xIncr = -1;
            dx = -dx;
        } else {
            xIncr = 1;
        }

        if (dy < 0) {
            yIncr = -1;
            dy = -dy;
        } else {
            yIncr = 1;
        }

        x = p1.x;
        y = p1.y;
        new Ponto(x, y).draw(area, cor);

        if (dx > dy) {
            p = 2 * (dy - dx);
            c1 = 2 * dy;
            c2 = 2 * (dy - dx);

            for (int i = 0; i < dx; i++) {
                x += xIncr;
                if (p < 0) {
                    p += c1;
                } else {
                    p += c2;
                    y += yIncr;
                }
                new Ponto(x, y).draw(area, cor);
            }
        } else {
            p = 2 * (dx - dy);
            c1 = 2 * dx;
            c2 = 2 * (dx - dy);

            for (int i = 0; i < dy; i++) {
                y += yIncr;
                if (p < 0) {
                    p += c1;
                } else {
                    p += c2;
                    x += xIncr;
                }
                new Ponto(x, y).draw(area, cor);
            }
        }
    }


    /**
     * O método rotacionar recebe a área e em quantos graus a reta será rotacionada
     * @param Graphics area, area onde será plotada a reta a ser rotacionada.
     * @param Double grau, angulo em graus em que a reta será rotacionada.
     * @return null.
    */
    public void rotacionar(Graphics area, double grau) {
        double rad = ((Math.PI / 180) * grau);
        float auxX2 = p2.x - p1.x;
        float auxY2 = p2.y - p1.y;
        p2.x = (int) (auxX2 * Math.cos(rad) - auxY2 * Math.sin(rad)) + p1.x;
        p2.y = (int) (auxX2 * Math.sin(rad) + auxY2 * Math.cos(rad)) + p1.y;
        if (aliasing) {
            drawAli(area);
        } else {
            draw(area);
        }
    }

    /**
     * O método plot recebe duas variáveis que representam um ponto e o coeficiente de cor que será colocado para
     * realizar o anti-aliasing.
     * @param Double x, variavel x recebida pelo metodo plot para representar uma coordenada do ponto.
     * @param Double y, variavel y recebida pelo metodo plot para representar uma coordenada do ponto.
     * @param Double c, variavel c recebida pelo metodo plot para representar o coeficiente da cor solicitada.
     * @return null.
    */
    void plot(Graphics g, double x, double y, double c) {
        g.setColor(new Color(cor.getRed() / 255, cor.getGreen() / 255, cor.getBlue() / 255, (float) c));
        g.fillOval((int) x, (int) y, 2, 2);
    }

    int ipart(double x) {
        return (int) x;
    }

    double fpart(double x) {
        return x - floor(x);
    }

    double rfpart(double x) {
        return 1.0 - fpart(x);
    }

    void drawAli(Graphics p) {
        boolean steep = Math.abs(p2.y - p1.y) > Math.abs(p2.x - p1.x);

        if (steep) {
            int aux = p1.x;
            p1.x = p1.y;
            p1.y = aux;

            aux = p2.x;
            p2.x = p2.y;
            p2.y = aux;
        }

        if (p1.x > p2.x) {
            int aux = p1.x;
            p1.x = p2.x;
            p2.x = aux;

            aux = p1.y;
            p1.y = p2.y;
            p2.y = aux;
        }

        double dx = p2.x - p1.x;
        double dy = p2.y - p1.y;
        double gradient = dy / dx;
        if (dx == 0.0) {
            gradient = 1.0;
        }
        
        double xend = round(p1.x);
        double yend = p1.y + gradient * (xend - p1.x);
        double xgap = rfpart(p1.x + 0.5);
        double xpxl1 = xend;
        double ypxl1 = ipart(yend);

        if (steep) {
            plot(p, ypxl1, xpxl1, rfpart(yend) * xgap);
            plot(p, ypxl1 + 1, xpxl1, fpart(yend) * xgap);
        } else {
            plot(p, xpxl1, ypxl1, rfpart(yend) * xgap);
            plot(p, xpxl1, ypxl1 + 1, fpart(yend) * xgap);
        }

        
        double intery = yend + gradient;

        
        xend = round(p2.x);
        yend = p2.y + gradient * (xend - p2.x);
        xgap = fpart(p2.x + 0.5);
        double xpxl2 = xend;
        double ypxl2 = ipart(yend);

        if (steep) {
            plot(p, ypxl2, xpxl2, rfpart(yend) * xgap);
            plot(p, ypxl2 + 1, xpxl2, fpart(yend) * xgap);
        } else {
            plot(p, xpxl2, ypxl2, rfpart(yend) * xgap);
            plot(p, xpxl2, ypxl2 + 1, fpart(yend) * xgap);
        }

        
        for (double x = xpxl1 + 1; x <= xpxl2 - 1; x++) {
            if (steep) {
                plot(p, ipart(intery), x, rfpart(intery));
                plot(p, ipart(intery) + 1, x, fpart(intery));
                intery = intery + gradient;
            } else {
                plot(p, x, ipart(intery), rfpart(intery));
                plot(p, x, ipart(intery) + 1, fpart(intery));
                intery = intery + gradient;
            }
        }
    }
}
