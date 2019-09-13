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
public class MemoriaPrincipal {

    private Bloco[] bloco;

    public MemoriaPrincipal() {
        this.bloco = new Bloco[32];
        for (int i = 0; i < 32; i++) {
            this.bloco[i] = new Bloco();

            //// TESTE INUTii ///
            // getBloco(i).setCelula('A',0);
        }
    }

    public Bloco[] getBloco() {
        return bloco;
    }

    public void setBloco(Bloco[] bloco) {
        this.bloco = bloco;
    }

    public Bloco getBloco(int i) {
        return bloco[i];
    }

    public void setBloco(Bloco bloco, int i) {
        this.bloco[i] = bloco;
    }
}
