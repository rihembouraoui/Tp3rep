package activite_1;

import java.io.*;
import java.net.Socket;

import acitvite_2.CalcService;

public class Client {
    public static void main(String[] args) {
        String serverHost = "localhost";
        int serverPort = 12345;

        try {
            Socket clientSocket = new Socket(serverHost, serverPort);
            ObjectOutputStream out = new ObjectOutputStream(clientSocket.getOutputStream());
            ObjectInputStream in = new ObjectInputStream(clientSocket.getInputStream());

            // Créez le service de calculatrice
            CalcService calcService = new CalcService();

            // Envoyez le service de calculatrice au serveur
            out.writeObject(calcService);

            // Recevez le résultat du serveur
            int result = (int) in.readObject();
            System.out.println("Résultat du serveur : " + result);

            clientSocket.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
