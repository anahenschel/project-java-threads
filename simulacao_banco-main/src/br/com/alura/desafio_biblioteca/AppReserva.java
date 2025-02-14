package br.com.alura.desafio_biblioteca;

import java.time.LocalDate;

public class AppReserva {

    public static void main(String[] args) throws InterruptedException {
        var livro = new Livro("Táticas do Amor", "Fabi", LocalDate.of(2023,8,21));
        var leitor = new Leitor("Ana");
        var operacao = new ReservaLivro(livro);

        Thread reservaAna = new Thread(operacao, "Ana");
        Thread reservaCarol = new Thread(operacao, "Carol");

        reservaAna.start();
        reservaCarol.start();

        reservaAna.join();
        reservaCarol.join();
    }
}
