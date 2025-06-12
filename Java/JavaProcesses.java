import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.io.IOException;

public class JavaProcesses {
    public static void main(String[] args) {
        String[] urls = {
            "google.com",
            "youtube.com",
            "127.0.0.1",
            "sitenaoexistente.com.br"
        };

        ArrayList<Process> processes = new ArrayList<>();

        //Cria e inicia um processo de ping para cada URL
        for (String url : urls) {
            try {
                Process process = createPingProcess(url);
                processes.add(process);
            } catch (IOException e) {
                System.err.println("Erro ao iniciar o processo para URL: " + url);
                e.printStackTrace();
            }
        }

        for (Process process : processes) {
            printProcessOutput(process);
        }
    }

    //Cria um processo de ping para uma URL usando ProcessBuilder
    private static Process createPingProcess(String url) throws IOException {
        String[] command = {"ping", url};
        ProcessBuilder builder = new ProcessBuilder(command);
        return builder.start();
    }

    //Lê e imprime a saída do processo até que ele termine
    private static void printProcessOutput(Process process) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
            System.out.println("\nSaída do processo:");

            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            int exitCode = process.waitFor();
            System.out.println("Processo finalizado com código: " + exitCode);
        } catch (IOException | InterruptedException e) {
            System.err.println("Erro ao ler a saída do processo.");
            e.printStackTrace();
        }
    }
}
