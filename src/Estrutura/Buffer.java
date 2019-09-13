/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estrutura;

import Estrutura.Bloco;

/**
 *
 * @author aliso
 */
public class Buffer {

    private Bloco[] bloco;
    private int[] destino;
    private boolean[] ocupado;

    public Buffer() {
        this.bloco = new Bloco[2];
        this.destino = new int[2];
        this.ocupado = new boolean[2];
        for (int i = 0; i < 2; i++) {
            this.bloco[i] = new Bloco();
            this.destino[i] = 0;
            this.ocupado[i] = false;
        }
    }

    public Bloco getBloco(int i) {
        return bloco[i];
    }

    public void setBloco(Bloco bloco, int i) {
        this.bloco[i] = bloco;
    }

    public Bloco[] getBloco() {
        return bloco;
    }

    public void setBloco(Bloco[] bloco) {
        this.bloco = bloco;
    }

    public int getDestino(int i) {
        return destino[i];
    }

    public void setDestino(int destino, int i) {
        this.destino[i] = destino;
    }

    public int[] getDestino() {
        return destino;
    }

    public void setDestino(int[] destino) {
        this.destino = destino;
    }

    public boolean getOcupado(int i) {
        return ocupado[i];
    }

    public void setOcupado(boolean ocupado, int i) {
        this.ocupado[i] = ocupado;
    }

    public boolean[] getOcupado() {
        return ocupado;
    }

    public void setOcupado(boolean[] ocupado) {
        this.ocupado = ocupado;
    }

    public boolean cheio() {
        if (this.getOcupado(0) && this.getOcupado(1)) {
            return true;
        } else {
            return false;
        }
    }

}
