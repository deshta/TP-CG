/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;

/**
 *
 * @author 720333
 */
public class Pontos {
    public Ponto p1;
    public Ponto p2;
    public int r;
    
    
    public Pontos(Ponto p1, Ponto p2){
        this.p1 = p1;
        this.p2 = p2;    
    }
    
    public Pontos(Ponto p1, int r){
        this.p1 = p1;
        this.r = r;
        p2 = null;
    }  
}
