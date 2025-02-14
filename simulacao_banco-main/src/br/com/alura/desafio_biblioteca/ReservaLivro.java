package br.com.alura.desafio_biblioteca;

import br.com.alura.Cliente;

public class ReservaLivro implements Runnable {

    private Leitor leitor;
    private Livro livro;


    public ReservaLivro( Livro livro) {
        this.livro = livro;
    }

    public synchronized void reservarLivro(){
        System.out.println("Iniciando reserva");

        if(!livro.getReservado()){
            livro.reservar();
            System.out.println("Reserva efetuada com sucesso! Aproveite a leitura," + Thread.currentThread().getName());
        }else {
            System.out.println("O livro já foi reservado," + Thread.currentThread().getName());
        }
        System.out.println("Reservas finalizadas!");
    }

    @Override
    public void run() {
        reservarLivro();
    }
}
