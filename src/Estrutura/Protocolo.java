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
public class Protocolo {

    private Bloco bloco;
    private char b;
    private String endereco;

    public Protocolo(Bloco bloco, char b, String endereco) {
        this.bloco = bloco;
        this.b = b;
        this.endereco = endereco;
    }

    public Bloco getBloco() {
        return bloco;
    }

    public void setBloco(Bloco bloco) {
        this.bloco = bloco;
    }

    public char getB() {
        return b;
    }

    public void setB(char b) {
        this.b = b;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

}
