package org.example;

import java.util.Observable;

public class Faturamento extends Observable {
    private Integer anoFaturamento;
    private Integer mesFaturamento;
    private Integer valorFaturamento;
    private String nomeSetor;

    public Faturamento(Integer anoFaturamento, Integer mesFaturamento, Integer valorFaturamento, String nomeSetor) {
        this.anoFaturamento = anoFaturamento;
        this.mesFaturamento = mesFaturamento;
        this.valorFaturamento = valorFaturamento;
        this.nomeSetor = nomeSetor;
    }

    public void lancarFaturamentos(){
        setChanged();
        notifyObservers();
    }

    @Override
    public String toString(){
        return "{Faturamento -> " +
                "Ano: " + anoFaturamento + ", " +
                "Mês: " + mesFaturamento + ", " +
                "Valor: " + valorFaturamento + ", " +
                "Setor: " + nomeSetor +
                " }";
    }
}
