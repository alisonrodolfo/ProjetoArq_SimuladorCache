/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetoarq_simuladorcache;

import Estrutura.MemoriaPrincipal;
import Estrutura.Buffer;
import Estrutura.Bloco;
import Estrutura.CacheL1;
import Estrutura.CacheL2;
import Estrutura.Protocolo;

/**
 *
 * @author aliso
 */
public class Simulador {

    private MemoriaPrincipal mp;
    private CacheL1 cacheL1;
    private CacheL1 cacheL1_2;
    private CacheL2 cacheL2;
    private Buffer buffer;
    private int n_leiturasL1;
    private int n_escritasL1;
    private int miss_leituraL1;
    private int miss_escritaL1;
    
    
    private int n_leiturasL1_2;
    private int n_escritasL1_2;
    private int miss_leituraL1_2;
    private int miss_escritaL1_2;
    
    private int n_leiturasL2;
    private int n_escritasL2;
    private int miss_leituraL2;
    private int miss_escritaL2;
    private String fila;
    
    private int instClock;

    public Simulador(String fila) {
        this.mp = new MemoriaPrincipal();

        this.cacheL1 = new CacheL1();
        this.cacheL1_2 = new CacheL1();
        this.cacheL2 = new CacheL2();

        this.buffer = new Buffer();
        this.n_escritasL1 = 0;
        this.miss_escritaL1 = 0;
        this.n_leiturasL1 = 0;
        this.miss_leituraL1 = 0;
        
         this.n_escritasL1_2 = 0;
        this.miss_escritaL1_2 = 0;
        this.n_leiturasL1_2 = 0;
        this.miss_leituraL1_2 = 0;
        
        this.n_escritasL2 = 0;
        this.miss_escritaL2 = 0;
        this.n_leiturasL2 = 0;
        this.miss_leituraL2 = 0;
        this.fila = fila;
        this.instClock = 0;
        
        
        
        
    }

    public void upLRUL2(int tag, int conj) {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 2; j++) {
                if (cacheL2.getConjunto(i).getQuadro(j).getBit_validade()) {
                    cacheL2.getConjunto(i).getQuadro(j).incMapa();
                }
            }
        }

        for (int i = 0; i < 2; i++) {
            if (cacheL2.getConjunto(conj).getRotulo(i) == tag) {
                cacheL2.getConjunto(conj).getQuadro(i).zeraMapa();
            }
        }
    }

    public void upFIFOL2(int tag) {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 2; j++) {
                if (cacheL2.getConjunto(i).getQuadro(j).getBit_validade()) {
                    cacheL2.getConjunto(i).getQuadro(j).incMapa();
                }
            }
        }

    }

    public void upLRUL1(int tag, int indice) {

        for (int j = 0; j < 2; j++) {
            if (cacheL1.getConjunto(0).getQuadro(j).getBit_validade()) {
                cacheL1.getConjunto(0).getQuadro(j).incMapa();
            }

        }

        for (int i = 0; i < 2; i++) {
            if ((cacheL1.getConjunto(0).getRotulo(i) == tag) && (cacheL1.getConjunto(0).getIndice(i) == indice)) {
                cacheL1.getConjunto(0).getQuadro(i).zeraMapa();
            }
        }
    }

    public void upFIFOL1(int tag) {

        for (int j = 0; j < 2; j++) {
            if (cacheL1.getConjunto(0).getQuadro(j).getBit_validade()) {
                cacheL1.getConjunto(0).getQuadro(j).incMapa();
            }
        }

    }

    public char getCacheL1(int tag, int indice, int deslocamento) {
        for (int i = 0; i < 2; i++) {
            if (cacheL1.getConjunto(0).getQuadro(i).getBit_validade()) {
                if ((cacheL1.getConjunto(0).getQuadro(i).getRotulo() == tag) && (cacheL1.getConjunto(0).getQuadro(i).getInd() == indice)) {
                    return cacheL1.getConjunto(0).getQuadro(i).getBloco().getCelula(deslocamento);
                }
            }
        }
        return '\0';
    }
    
    public void upLRUL1_2(int tag, int indice) {

        for (int j = 0; j < 2; j++) {
            if (cacheL1_2.getConjunto(0).getQuadro(j).getBit_validade()) {
                cacheL1_2.getConjunto(0).getQuadro(j).incMapa();
            }

        }

        for (int i = 0; i < 2; i++) {
            if ((cacheL1_2.getConjunto(0).getRotulo(i) == tag) && (cacheL1_2.getConjunto(0).getIndice(i) == indice)) {
                cacheL1_2.getConjunto(0).getQuadro(i).zeraMapa();
            }
        }
    }

    public void upFIFOL1_2(int tag) {

        for (int j = 0; j < 2; j++) {
            if (cacheL1_2.getConjunto(0).getQuadro(j).getBit_validade()) {
                cacheL1_2.getConjunto(0).getQuadro(j).incMapa();
            }
        }

    }

    public char getCacheL1_2(int tag, int indice, int deslocamento) {
        for (int i = 0; i < 2; i++) {
            if (cacheL1_2.getConjunto(0).getQuadro(i).getBit_validade()) {
                if ((cacheL1_2.getConjunto(0).getQuadro(i).getRotulo() == tag) && (cacheL1_2.getConjunto(0).getQuadro(i).getInd() == indice)) {
                    return cacheL1_2.getConjunto(0).getQuadro(i).getBloco().getCelula(deslocamento);
                }
            }
        }
        return '\0';
    }

    public Protocolo getCacheL2(int tag, int indice, int deslocamento) {
        Protocolo prot = new Protocolo(null, '\0', "");
        for (int i = 0; i < 2; i++) {
            if (cacheL2.getConjunto(indice).getQuadro(i).getBit_validade()) {
                if (cacheL2.getConjunto(indice).getQuadro(i).getRotulo() == tag) {
                    return new Protocolo(cacheL2.getConjunto(indice).getQuadro(i).getBloco(),
                            cacheL2.getConjunto(indice).getQuadro(i).getBloco().getCelula(deslocamento), "");
                }
            }
        }
        return prot;
    }

    public synchronized char LOADCacheL2(String endereco) {
        int tag, indice, deslocamento;
 
        
        char dado = '\0';
        tag = binario_para_decimal(endereco.substring(0, 3));
        indice = binario_para_decimal(endereco.substring(3, 5));
        deslocamento = binario_para_decimal(endereco.substring(5, 7));

        dado = busca_na_cacheL2(endereco,0);

        return dado;
    }

    public char LOADCacheL1L2(String endereco) {
        int tag, indice, deslocamento;
        
        
        this.n_leiturasL1++;
        instClock += 3;
        char dado = '\0';
        tag = binario_para_decimal(endereco.substring(0, 3));
        indice = binario_para_decimal(endereco.substring(3, 5));
        deslocamento = binario_para_decimal(endereco.substring(5, 7));

        while ((dado = getCacheL1(tag,indice, deslocamento)) == '\0') {
            this.miss_leituraL1++;
            instClock += 3;
            busca_na_cacheL2(endereco,1);
        }

        if (fila.equalsIgnoreCase("LRU")) {
            this.upLRUL1(tag, indice);
        }else if (fila.equalsIgnoreCase("FIFO")) {
            this.upFIFOL1(tag);
        } else {
            System.out.println("1ERRO: " + fila);
        }

        return dado;
    }
    
    public char LOADCacheL1L2_2(String endereco) {
        int tag, indice, deslocamento;

        this.n_leiturasL1_2++;
        instClock += 3;
        char dado = '\0';
        tag = binario_para_decimal(endereco.substring(0, 3));
        indice = binario_para_decimal(endereco.substring(3, 5));
        deslocamento = binario_para_decimal(endereco.substring(5, 7));

        while ((dado = getCacheL1_2(tag,indice, deslocamento)) == '\0') {
            this.miss_leituraL1_2++;
            instClock += 3;
            busca_na_cacheL2(endereco,2);
        }

        if (fila.equalsIgnoreCase("LRU")) {
            this.upLRUL1_2(tag, indice);
        }else if (fila.equalsIgnoreCase("FIFO")) {
            this.upFIFOL1_2(tag);
        } else {
            System.out.println("2ERRO");
        }

        return dado;
    }

    public synchronized char busca_na_cacheL2(String endereco, int op) {
        Bloco b = new Bloco();
        Protocolo prot;
        this.n_leiturasL2++;
        instClock += 14;
        int tag = binario_para_decimal(endereco.substring(0, 3));
        int indice = binario_para_decimal(endereco.substring(3, 5));
        int deslocamento = binario_para_decimal(endereco.substring(5, 7));
        char dado = '\0';
        prot = getCacheL2(tag, indice, deslocamento);
        while (prot.getB() == '\0') {
            this.miss_leituraL2++;
            instClock += 14;
            if (this.busca_no_buffer(endereco) == false) {
                this.busca_na_mp(endereco);
            }
            prot = getCacheL2(tag, indice, deslocamento);
        }
        if(op==1){
            this.STORE_cacheL1(prot.getBloco(), endereco);
        }else{
            this.STORE_cacheL1_2(prot.getBloco(), endereco);
        }
        if (fila.equalsIgnoreCase("LRU")) {
            this.upLRUL2(tag, indice);
        }else if (fila.equalsIgnoreCase("FIFO")) {
            this.upFIFOL2(tag);
        } else {
            System.out.println("3ERRO");
        }
        return prot.getB();
    }

    public void busca_na_mp(String endereco) {
        int e = binario_para_decimal(endereco);
        Bloco b = new Bloco();
        b.setCelula(mp.getBloco(e % 4).getCelula());
        this.STORE_cacheL2(b, endereco);
    }

    public boolean busca_no_buffer(String endereco) {
        instClock += 240;
        int rot = binario_para_decimal(endereco);
        for (int i = 0; i < 2; i++) {
            if (buffer.getDestino(i) == rot && buffer.getOcupado(i) == true) {
                Bloco b = new Bloco();
                b.setCelula(buffer.getBloco(i).getCelula());
                this.STORE_cacheL2(b, endereco);
                return true;
            }
        }
        return false;
    }

    private synchronized void STORE_cacheL2(Bloco bloco, String endereco) {

        int tag, indice, deslocamento, i = 0, subs;
        tag = binario_para_decimal(endereco.substring(0, 3));
        indice = binario_para_decimal(endereco.substring(3, 5));
        deslocamento = binario_para_decimal(endereco.substring(5, 7));
        Bloco b = new Bloco();
        for (int j = 0; j < 4; j++) {
            b.setCelula(bloco.getCelula(j), j);
        }
        while (i < 2) {
            if (cacheL2.getConjunto(indice).getQuadro(i).getBit_validade() == false) {
                cacheL2.getConjunto(indice).getQuadro(i).setRotulo(tag);
                cacheL2.getConjunto(indice).getQuadro(i).setBit_sujo(false);
                cacheL2.getConjunto(indice).getQuadro(i).setBit_validade(true);
                cacheL2.getConjunto(indice).getQuadro(i).setBloco(b);
                i = 5;
            }
            i++;
        }
        if (i == 2) {// os dois quadros estão ocupados 
            if (cacheL2.getConjunto(indice).getQuadro(0).getLru() >= cacheL2.getConjunto(indice).getQuadro(1).getLru()) {
                if (cacheL2.getConjunto(indice).getQuadro(0).getBit_sujo()) {
                    String destino = decimal_para_binario(cacheL2.getConjunto(indice).getQuadro(0).getRotulo(), 3);
                    destino = destino + decimal_para_binario(indice, 2) + "00";
                    STORE_buffer(cacheL2.getConjunto(indice).getQuadro(0).getBloco(), destino);
                }
                cacheL2.getConjunto(indice).getQuadro(0).setRotulo(tag);
                cacheL2.getConjunto(indice).getQuadro(0).setBit_sujo(false);
                cacheL2.getConjunto(indice).getQuadro(0).setBit_validade(true);
                cacheL2.getConjunto(indice).getQuadro(0).setBloco(b);
            } else {
                if (cacheL2.getConjunto(indice).getQuadro(1).getBit_sujo()) {
                    String destino = decimal_para_binario(cacheL2.getConjunto(indice).getQuadro(1).getRotulo(), 3);
                    destino = destino + decimal_para_binario(indice, 2) + "00";
                    STORE_buffer(cacheL2.getConjunto(indice).getQuadro(1).getBloco(), destino);
                }
                cacheL2.getConjunto(indice).getQuadro(1).setRotulo(tag);
                cacheL2.getConjunto(indice).getQuadro(1).setBit_sujo(false);
                cacheL2.getConjunto(indice).getQuadro(1).setBit_validade(true);
                cacheL2.getConjunto(indice).getQuadro(1).setBloco(b);
            }

        }
       

    }

    private void STORE_cacheL1(Bloco bloco, String endereco) {
        int tag, indice, deslocamento, i = 0, subs;
        tag = binario_para_decimal(endereco.substring(0, 3));
        indice = 0;
        int ind = binario_para_decimal(endereco.substring(3, 5));
        deslocamento = binario_para_decimal(endereco.substring(5, 7));
        Bloco b = new Bloco();
        for (int j = 0; j < 4; j++) {
            b.setCelula(bloco.getCelula(j), j);
        }
        while (i < 2) {
            if (cacheL1.getConjunto(indice).getQuadro(i).getBit_validade() == false) {
                cacheL1.getConjunto(indice).getQuadro(i).setRotulo(tag);
                cacheL1.getConjunto(indice).getQuadro(i).setInd(ind);
                cacheL1.getConjunto(indice).getQuadro(i).setBit_sujo(false);
                cacheL1.getConjunto(indice).getQuadro(i).setBit_validade(true);
                cacheL1.getConjunto(indice).getQuadro(i).setBloco(b);
                i = 5;
            }
            i++;
        }
        if (i == 2) {// os dois quadros estão ocupados 
            if (cacheL1.getConjunto(indice).getQuadro(0).getLru() >= cacheL1.getConjunto(indice).getQuadro(1).getLru()) {
                if (cacheL1.getConjunto(indice).getQuadro(0).getBit_sujo()) {
                    String destino = decimal_para_binario(cacheL1.getConjunto(indice).getQuadro(0).getRotulo(), 3);
                    destino = destino + decimal_para_binario(indice, 2) + "00";
                    STORE_cacheL2(cacheL1.getConjunto(indice).getQuadro(0).getBloco(), destino);
                }
                cacheL1.getConjunto(indice).getQuadro(0).setRotulo(tag);
                cacheL1.getConjunto(indice).getQuadro(0).setInd(ind);
                cacheL1.getConjunto(indice).getQuadro(0).setBit_sujo(false);
                cacheL1.getConjunto(indice).getQuadro(0).setBit_validade(true);
                cacheL1.getConjunto(indice).getQuadro(0).setBloco(b);
            } else {
                if (cacheL1.getConjunto(indice).getQuadro(1).getBit_sujo()) {
                    String destino = decimal_para_binario(cacheL1.getConjunto(indice).getQuadro(1).getRotulo(), 3);
                    destino = destino + decimal_para_binario(indice, 2) + "00";
                    STORE_cacheL2(cacheL1.getConjunto(indice).getQuadro(1).getBloco(), destino);
                }
                cacheL1.getConjunto(indice).getQuadro(1).setRotulo(tag);
                cacheL1.getConjunto(indice).getQuadro(1).setInd(ind);
                cacheL1.getConjunto(indice).getQuadro(1).setBit_sujo(false);
                cacheL1.getConjunto(indice).getQuadro(1).setBit_validade(true);
                cacheL1.getConjunto(indice).getQuadro(1).setBloco(b);
            }

        }
        

    }
    
    private void STORE_cacheL1_2(Bloco bloco, String endereco) {
        int tag, indice, deslocamento, i = 0, subs;
        tag = binario_para_decimal(endereco.substring(0, 3));
        indice = 0;
        int ind = binario_para_decimal(endereco.substring(3, 5));
        deslocamento = binario_para_decimal(endereco.substring(5, 7));
        Bloco b = new Bloco();
        for (int j = 0; j < 4; j++) {
            b.setCelula(bloco.getCelula(j), j);
        }
        while (i < 2) {
            if (cacheL1_2.getConjunto(indice).getQuadro(i).getBit_validade() == false) {
                cacheL1_2.getConjunto(indice).getQuadro(i).setRotulo(tag);
                cacheL1_2.getConjunto(indice).getQuadro(i).setInd(ind);
                cacheL1_2.getConjunto(indice).getQuadro(i).setBit_sujo(false);
                cacheL1_2.getConjunto(indice).getQuadro(i).setBit_validade(true);
                cacheL1_2.getConjunto(indice).getQuadro(i).setBloco(b);
                i = 5;
            }
            i++;
        }
        if (i == 2) {// os dois quadros estão ocupados 
            if (cacheL1_2.getConjunto(indice).getQuadro(0).getLru() >= cacheL1_2.getConjunto(indice).getQuadro(1).getLru()) {
                if (cacheL1_2.getConjunto(indice).getQuadro(0).getBit_sujo()) {
                    String destino = decimal_para_binario(cacheL1_2.getConjunto(indice).getQuadro(0).getRotulo(), 3);
                    destino = destino + decimal_para_binario(indice, 2) + "00";
                    STORE_cacheL2(cacheL1_2.getConjunto(indice).getQuadro(0).getBloco(), destino);
                }
                cacheL1_2.getConjunto(indice).getQuadro(0).setRotulo(tag);
                cacheL1_2.getConjunto(indice).getQuadro(0).setInd(ind);
                cacheL1_2.getConjunto(indice).getQuadro(0).setBit_sujo(false);
                cacheL1_2.getConjunto(indice).getQuadro(0).setBit_validade(true);
                cacheL1_2.getConjunto(indice).getQuadro(0).setBloco(b);
            } else {
                if (cacheL1_2.getConjunto(indice).getQuadro(1).getBit_sujo()) {
                    String destino = decimal_para_binario(cacheL1_2.getConjunto(indice).getQuadro(1).getRotulo(), 3);
                    destino = destino + decimal_para_binario(indice, 2) + "00";
                    STORE_cacheL2(cacheL1_2.getConjunto(indice).getQuadro(1).getBloco(), destino);
                }
                cacheL1_2.getConjunto(indice).getQuadro(1).setRotulo(tag);
                cacheL1_2.getConjunto(indice).getQuadro(1).setInd(ind);
                cacheL1_2.getConjunto(indice).getQuadro(1).setBit_sujo(false);
                cacheL1_2.getConjunto(indice).getQuadro(1).setBit_validade(true);
                cacheL1_2.getConjunto(indice).getQuadro(1).setBloco(b);
            }

        }
        

    }

    public void STORE_L1L2(String endereco, char dado) {
        int tag, indice, deslocamento; char auxbuf = dado;
        Protocolo prot;
        Bloco b = new Bloco();
        tag = binario_para_decimal(endereco.substring(0, 3));
        indice = binario_para_decimal(endereco.substring(3, 5));
        deslocamento = binario_para_decimal(endereco.substring(5, 7));

        this.n_escritasL1++;
        instClock += 3;

        while ((dado = getCacheL1(tag, indice, deslocamento)) == '\0') {
            this.miss_escritaL1++;
            instClock += 3;
            busca_na_cacheL2(endereco,1);
        }
        this.STORE_L2(endereco,auxbuf);
        ///////////////////////////////////////////////////////////////////////
        ///////////////////////////////////////////////////////////////////////
        for (int i = 0; i < 2; i++) {
            if (cacheL1.getConjunto(0).getQuadro(i).getBit_validade()) {
                if ((cacheL1.getConjunto(0).getQuadro(i).getRotulo() == tag) && (cacheL1.getConjunto(0).getQuadro(i).getInd() == indice)) {
                    cacheL1.getConjunto(0).getQuadro(i).getBloco().setCelula(auxbuf, deslocamento);
                    cacheL1.getConjunto(0).getQuadro(i).setBit_sujo(true);
                }
            }
        }
        

        if (fila.equalsIgnoreCase("LRU")) {
            this.upLRUL1(tag, indice);
        }else if (fila.equalsIgnoreCase("FIFO")) {
            this.upFIFOL1(tag);
        } else {
            System.out.println("4ERRO");
        }

    }
    
    public void STORE_L1L2_2(String endereco, char dado) {
        int tag, indice, deslocamento; char auxbuf = dado;
        Protocolo prot;
        Bloco b = new Bloco();
        tag = binario_para_decimal(endereco.substring(0, 3));
        indice = binario_para_decimal(endereco.substring(3, 5));
        deslocamento = binario_para_decimal(endereco.substring(5, 7));

        this.n_escritasL1_2++;
        instClock += 3;

        while ((dado = getCacheL1_2(tag, indice, deslocamento)) == '\0') {
            this.miss_escritaL1_2++;
            instClock += 3;
            busca_na_cacheL2(endereco,2);
        }
        this.STORE_L2(endereco,auxbuf);
        ///////////////////////////////////////////////////////////////////////
        ///////////////////////////////////////////////////////////////////////
        for (int i = 0; i < 2; i++) {
            if (cacheL1_2.getConjunto(0).getQuadro(i).getBit_validade()) {
                if ((cacheL1_2.getConjunto(0).getQuadro(i).getRotulo() == tag) && (cacheL1_2.getConjunto(0).getQuadro(i).getInd() == indice)) {
                    cacheL1_2.getConjunto(0).getQuadro(i).getBloco().setCelula(auxbuf, deslocamento);
                    cacheL1_2.getConjunto(0).getQuadro(i).setBit_sujo(true);
                }
            }
        }
        

        if (fila.equalsIgnoreCase("LRU")) {
            this.upLRUL1_2(tag, indice);
        }else if (fila.equalsIgnoreCase("FIFO")) {
            this.upFIFOL1_2(tag);
        } else {
            System.out.println("5ERRO");
        }

    }

    public synchronized void STORE_L2(String endereco, char dado) {
        int tag, indice, deslocamento;
        Protocolo prot;
        tag = binario_para_decimal(endereco.substring(0, 3));
        indice = binario_para_decimal(endereco.substring(3, 5));
        deslocamento = binario_para_decimal(endereco.substring(5, 7));
        this.n_escritasL2++;
        instClock += 14;

        prot = getCacheL2(tag, indice, deslocamento);
        while (prot.getB() == '\0') {
            this.miss_escritaL2++;
            instClock += 14;
            if (this.busca_no_buffer(endereco) == false) {
                this.busca_na_mp(endereco);
            }
            prot = getCacheL2(tag, indice, deslocamento);
        }

        for (int i = 0; i < 2; i++) {
            if (cacheL2.getConjunto(indice).getQuadro(i).getBit_validade()) {
                if (cacheL2.getConjunto(indice).getQuadro(i).getRotulo() == tag) {
                    cacheL2.getConjunto(indice).getQuadro(i).getBloco().setCelula(dado, deslocamento);
                    cacheL2.getConjunto(indice).getQuadro(i).setBit_sujo(true);
                }
            }
        }
        if (fila.equalsIgnoreCase("LRU")) {
            this.upLRUL2(tag, indice);
        }else if (fila.equalsIgnoreCase("FIFO")) {
            this.upFIFOL2(tag);
        } else {
            System.out.println("6ERRO");
        }
    }

    public synchronized static int binario_para_decimal(String bin) {
        int decimal = 0, peso = 1;
        for (int i = bin.length(); i > 0; i--) {
            if (bin.charAt(i - 1) == '1') {
                decimal = decimal + peso;
            }
            peso = peso + peso;
        }
        //t.println("ARQ2 DEBUG: " + bin + ',' + decimal);
        return decimal;
    }

    public synchronized static String decimal_para_binario(int decimal, int bits) {
        String bin = new String();
        bin = Integer.toBinaryString(decimal);
        char[] zeros = new char[bits - bin.length()];
        if (bits > bin.length()) {
            for (int i = 0; i < (bits - bin.length()); i++) {
                zeros[i] = '0';
            }
            bin = String.valueOf(zeros) + bin;
        }
        return bin;
    }

    public void STORE_buffer(Bloco bloco, String endereco) {
        Bloco b = new Bloco();
        b.setCelula(bloco.getCelula());
        if (buffer.cheio()) {
            esvazia_buffer(2);
        }
        if (!buffer.getOcupado(1)) {
            buffer.setBloco(b, 1);
            buffer.setDestino(binario_para_decimal(endereco), 1);
            buffer.setOcupado(true, 1);
        } else {
            if (buffer.getOcupado(0)) {
                esvazia_buffer(1);
            }
            buffer.setBloco(b, 0);
            buffer.setDestino(binario_para_decimal(endereco), 0);
            buffer.setOcupado(true, 0);
        }
    }

    public void esvazia_buffer(int n) {
        for (int i = 0; i < n; i++) {
            int nb = buffer.getDestino(i) / 4;
            mp.getBloco(nb).setCelula(buffer.getBloco(i).getCelula());
            buffer.setOcupado(false, i);
        }
    }

    public MemoriaPrincipal getMp() {
        return mp;
    }

    public void setMp(MemoriaPrincipal mp) {
        this.mp = mp;
    }

    public CacheL1 getCacheL1() {
        return cacheL1;
    }

    public void setCacheL1(CacheL1 cacheL1) {
        this.cacheL1 = cacheL1;
    }

    public CacheL2 getCacheL2() {
        return cacheL2;
    }

    public void setCacheL2(CacheL2 cacheL2) {
        this.cacheL2 = cacheL2;
    }

    public Buffer getBuffer() {
        return buffer;
    }

    public void setBuffer(Buffer buffer) {
        this.buffer = buffer;
    }

    public int getN_leiturasL1() {
        return n_leiturasL1;
    }

    public void setN_leiturasL1(int n_leiturasL1) {
        this.n_leiturasL1 = n_leiturasL1;
    }

    public int getN_escritasL1() {
        return n_escritasL1;
    }

    public void setN_escritasL1(int n_escritasL1) {
        this.n_escritasL1 = n_escritasL1;
    }

    public int getMiss_leituraL1() {
        return miss_leituraL1;
    }

    public void setMiss_leituraL1(int miss_leituraL1) {
        this.miss_leituraL1 = miss_leituraL1;
    }

    public int getMiss_escritaL1() {
        return miss_escritaL1;
    }

    public void setMiss_escritaL1(int miss_escritaL1) {
        this.miss_escritaL1 = miss_escritaL1;
    }

    public CacheL1 getCacheL1_2() {
        return cacheL1_2;
    }

    public void setCacheL1_2(CacheL1 cacheL1_2) {
        this.cacheL1_2 = cacheL1_2;
    }

    public int getN_leiturasL1_2() {
        return n_leiturasL1_2;
    }

    public void setN_leiturasL1_2(int n_leiturasL1_2) {
        this.n_leiturasL1_2 = n_leiturasL1_2;
    }

    public int getN_escritasL1_2() {
        return n_escritasL1_2;
    }

    public void setN_escritasL1_2(int n_escritasL1_2) {
        this.n_escritasL1_2 = n_escritasL1_2;
    }

    public int getMiss_leituraL1_2() {
        return miss_leituraL1_2;
    }

    public void setMiss_leituraL1_2(int miss_leituraL1_2) {
        this.miss_leituraL1_2 = miss_leituraL1_2;
    }

    public int getMiss_escritaL1_2() {
        return miss_escritaL1_2;
    }

    public void setMiss_escritaL1_2(int miss_escritaL1_2) {
        this.miss_escritaL1_2 = miss_escritaL1_2;
    }

    
    public int getN_leiturasL2() {
        return n_leiturasL2;
    }

    public void setN_leiturasL2(int n_leiturasL2) {
        this.n_leiturasL2 = n_leiturasL2;
    }

    public int getN_escritasL2() {
        return n_escritasL2;
    }

    public void setN_escritasL2(int n_escritasL2) {
        this.n_escritasL2 = n_escritasL2;
    }

    public int getMiss_leituraL2() {
        return miss_leituraL2;
    }

    public void setMiss_leituraL2(int miss_leituraL2) {
        this.miss_leituraL2 = miss_leituraL2;
    }

    public int getMiss_escritaL2() {
        return miss_escritaL2;
    }

    public void setMiss_escritaL2(int miss_escritaL2) {
        this.miss_escritaL2 = miss_escritaL2;
    }

    public int getInstClock() {
        return instClock;
    }

    public void setInstClock(int instClock) {
        this.instClock = instClock;
    }

    
}
