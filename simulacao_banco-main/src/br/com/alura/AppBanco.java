package br.com.alura;

import java.math.BigDecimal;

public class AppBanco {

    public static void main(String[] args) {
        var cliente = new Cliente("Ana");
        var conta = new Conta(cliente, new BigDecimal("150"));
        var operacao = new OperacaoSaque(conta, new BigDecimal("150"));

        Thread saqueAna = new Thread(operacao);
        Thread saqueCaroline = new Thread(operacao);

        saqueAna.start();
        saqueCaroline.start();

        System.out.println(Thread.currentThread().getName());
    }
}
