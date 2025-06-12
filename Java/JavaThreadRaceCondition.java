public class JavaThreadRaceCondition {
    
    //variavel compartilhada
    static int contador = 0; 
    
    public static void main(String[] args) throws InterruptedException {
        //thread1 incrementa contador
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                contador++;
            }
        });
        //thread2 incrementa contador
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                contador++;
            }
        });

        //condição de corrida onde modificam contador ao mesmo tempo e sem controle
        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Valor final do contador (esperado: 20000): " + contador);
    }

    
}
