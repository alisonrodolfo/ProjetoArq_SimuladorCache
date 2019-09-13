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
public class Bloco {

    private char celula[];

    public Bloco() {
        this.celula = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G'};
    }

    public char getCelula(int i) {
        return celula[i];
    }

    public void setCelula(char info, int i) {
        this.celula[i] = info;
    }

    public char[] getCelula() {
        return celula;
    }

    public void setCelula(char[] celula) {
        this.celula = celula;
    }

}
