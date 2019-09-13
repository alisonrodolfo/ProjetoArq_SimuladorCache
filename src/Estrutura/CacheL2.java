/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estrutura;

import Estrutura.Conjunto;
import Estrutura.Quadro;

/**
 *
 * @author aliso
 */
public class CacheL2 {

    private Conjunto[] conjunto;
    private Quadro[] quadro;

    public CacheL2() {
        this.conjunto = new Conjunto[4];
        for (int i = 0; i < 4; i++) {
            this.conjunto[i] = new Conjunto();
        }

        this.quadro = new Quadro[8];
        for (int i = 0; i < 8; i++) {
            this.quadro[i] = new Quadro();
        }

    }

    public Conjunto getConjunto(int i) {
        return conjunto[i];
    }

    public void setConjunto1(Conjunto conjunto, int i) {
        this.conjunto[i] = conjunto;
    }

    public Conjunto[] getConjunto() {
        return conjunto;
    }

    public void setConjunto(Conjunto[] conjunto) {
        this.conjunto = conjunto;
    }

    public Quadro getQuadro(int i) {
        return quadro[i];
    }

    public void setQuadro(Quadro quadro, int i) {
        this.quadro[i] = quadro;
    }

    public Quadro[] getQuadro() {
        return quadro;
    }

    public void setQuadro(Quadro[] quadro) {
        this.quadro = quadro;
    }


}
