/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estrutura;

import Estrutura.Quadro;

/**
 *
 * @author aliso
 */
public class Conjunto {

    private Quadro[] quadro;

    public Conjunto() {
        this.quadro = new Quadro[2];
        for (int i = 0; i < 2; i++) {
            this.quadro[i] = new Quadro();
        }
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

    public int getRotulo(int iquadro) {
        return this.quadro[iquadro].getRotulo();
    }

    public void setRotulo(int iquadro, int rot) {
        this.quadro[iquadro].setRotulo(rot);
    }
    public int getIndice(int iquadro) {
        return this.quadro[iquadro].getInd();
    }

    public void setIndice(int iquadro, int ind) {
        this.quadro[iquadro].setInd(ind);
    }
}
