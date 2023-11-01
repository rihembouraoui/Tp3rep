package acitvite_2;

import java.io.*;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        String serverHost = "localhost";
        int serverPort = 12345;

        try {
            Socket clientSocket = new Socket(serverHost, serverPort);
            InputStream inputStream = clientSocket.getInputStream();
            OutputStream outputStream = clientSocket.getOutputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            PrintWriter writer = new PrintWriter(outputStream, true);

            String message = "Bonjour, serveur!";
            writer.println(message);

            String response = reader.readLine();
            System.out.println("Réponse du serveur : " + response);

            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}