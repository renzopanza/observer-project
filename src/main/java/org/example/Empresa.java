package org.example;

import java.util.Observable;
import java.util.Observer;

public class Empresa implements Observer {
    private String nomeEmpresa;
    private String ultimaNotificacao;

    public Empresa(String nomeEmpresa){
        this.nomeEmpresa = nomeEmpresa;
    }

    public String getUltimaNotificacao(){
        return this.ultimaNotificacao;
    }

    public void lancarFaturamento(Faturamento faturamento){
        faturamento.addObserver(this);
    }

    public void update(Observable faturamento, Object arg1){
        this.ultimaNotificacao = "Informações de faturamento para a empresa: " + this.nomeEmpresa + " -> " + faturamento.toString();
    }
}
