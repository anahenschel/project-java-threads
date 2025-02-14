package br.com.alura.desafio_biblioteca;

import java.time.LocalDate;

public class Livro {
    String titulo;

    private String autor;
    private LocalDate dataLancamento;
    private boolean reservado;

    public boolean getReservado() {
        return reservado;
    }

    public Livro(String titulo, String autor, LocalDate dataLancamento) {
        this.titulo = titulo;
        this.autor = autor;
        this.dataLancamento = dataLancamento;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public LocalDate getDataLancamento() {
        return dataLancamento;
    }

    public void reservar() {
        this.reservado = true;
    }
}
