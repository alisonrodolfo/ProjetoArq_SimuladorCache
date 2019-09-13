/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estrutura;

/**
 *
 * @author aliso
 */
public class Quadro {

    private Bloco bloco;
    private boolean bit_sujo;
    private boolean bit_validade;
    private int rotulo;
    private int ind;
    private int mapemaneto;

    public Quadro() {
        this.bloco = new Bloco();
        this.bit_sujo = false;
        this.mapemaneto = 0;
        this.bit_validade = false;
        this.rotulo = 0;
        this.ind = 0;
    }

    public void incMapa() {
        this.mapemaneto++;
    }

    public void zeraMapa() {
        this.mapemaneto = 0;
    }

    public Bloco getBloco() {
        return bloco;
    }

    public void setBloco(Bloco bloco) {
        this.bloco = bloco;
    }

    public int getLru() {
        return mapemaneto;
    }

    public void setLru(int mapemaneto) {
        this.mapemaneto = mapemaneto;
    }

    public int getRotulo() {
        return rotulo;
    }

    public void setRotulo(int rotulo) {
        this.rotulo = rotulo;
    }

    public boolean getBit_sujo() {
        return bit_sujo;
    }

    public void setBit_sujo(boolean bit_sujo) {
        this.bit_sujo = bit_sujo;
    }

    public boolean getBit_validade() {
        return bit_validade;
    }

    public void setBit_validade(boolean bit_validade) {
        this.bit_validade = bit_validade;
    }

    /* //// VOID ////
    
    public void escrever(int rotulo, int desl, char info) {
        char[] aux = this.bloco.getCelula();
        aux[desl] = info;
    }
     */
    public int getInd() {
        return ind;
    }

    public void setInd(int ind) {
        this.ind = ind;
    }

    public int getMapemaneto() {
        return mapemaneto;
    }

    public void setMapemaneto(int mapemaneto) {
        this.mapemaneto = mapemaneto;
    }
}
