package br.com.alura.desafio_impressora;

public class MainImpressora {
    public static void main(String[] args) throws InterruptedException {
        var impressora1 = new Impressora(1);
        var impressora2 = new Impressora(2);

        Thread threadImp1 = new Thread(impressora1);
        Thread threadImp2 = new Thread(impressora2);

        threadImp1.setPriority(1);
        threadImp2.setPriority(10);


        threadImp1.start();
        threadImp2.start();



        Thread threadOlaMundo = new Thread(runnable);
        var isAlive = threadOlaMundo.isAlive();
        System.out.println("Runnable isAlive: " + isAlive);
        threadOlaMundo.start();
        threadOlaMundo.join();
        var isAlive2 = threadOlaMundo.isAlive();
        System.out.println("Runnable isAlive: " + isAlive2);
    }

   static Runnable runnable = () -> {
        System.out.println("Olá Mundo");
    };
}
