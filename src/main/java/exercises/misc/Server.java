package exercises.misc;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
    ExecutorService executorService = Executors.newFixedThreadPool(100);


    public void run() {
        try {
            ServerSocket serverSocket = new ServerSocket(9999);
            while (true) {

                final Socket socket = serverSocket.accept();

                executorService.submit(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                            String message = bufferedReader.readLine();
                            bufferedReader.close();
                            System.out.println("server received" + message);
                            socket.close();

                            File file = new File("/Users/kayan.azimov/tmp/file");

                            PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(file)));
                            writer.write(message + "\n");
                            writer.close();

//                            new BufferedReader(new FileReader(file)).readLine();


//                    PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), false);
//                    printWriter.write("hi there");


                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                });


            }


        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

    }

    public static void main(String[] args) {
        new Server().run();
    }
}
