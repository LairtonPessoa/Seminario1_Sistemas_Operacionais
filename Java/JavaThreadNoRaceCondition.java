public class JavaThreadNoRaceCondition {
    
    //variavel compartilhada
    static int contador = 0; 
    //uso de synchronized para sincronizar a threads 
    private static synchronized void Incrementa() {
        contador++;
    }
    
    public static void main(String[] args) throws InterruptedException {
        //thread1 incrementa contador
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                Incrementa();
            }
        });
        //thread2 incrementa contador
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                Incrementa();
            }
        });

        //não existe condição de corrida pois só uma thread por vez consegue acessar contador
        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Valor final do contador (esperado: 20000): " + contador);
    }

    
}
