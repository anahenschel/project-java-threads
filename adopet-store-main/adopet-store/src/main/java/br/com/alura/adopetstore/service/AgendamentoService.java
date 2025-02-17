package br.com.alura.adopetstore.service;

import br.com.alura.adopetstore.email.EmailRelatorioGerado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Service
public class AgendamentoService {

    @Autowired
    private RelatorioService relatorioService;

    @Autowired
    private EmailRelatorioGerado enviador;

    //seg / min / hor / dd / mm / yyyy
    @Scheduled(cron = "0 47 15 * * *")
    public void envioEmailAgendado() {
        var estoqueZerado = relatorioService.infoEstoque();
        var faturamentoObtido = relatorioService.faturamentoObtido();

        CompletableFuture.allOf(estoqueZerado, faturamentoObtido).join();

        try {
            enviador.enviar(estoqueZerado.get(), faturamentoObtido.get());
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Thread do agendamento: "+ Thread.currentThread().getName());
    }
}
