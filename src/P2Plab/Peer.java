/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package P2Plab;

/**
 *
 * @author Gule Narjis
 */
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Peer {
    private static final int PORT = 5000;

    public static void main(String[] args) throws IOException {
        // Create server socket to listen for incoming connections
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Peer is listening on port " + PORT);

        // Thread to handle incoming messages
        Thread serverThread = new Thread(() -> {
            try {
                while (true) {
                    Socket clientSocket = serverSocket.accept();
                    BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                    String message = in.readLine();
                    System.out.println("Received: " + message);
                    clientSocket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        serverThread.start();

        // Client side: send messages in a loop until 'exit'
        Scanner scanner = new Scanner(System.in);
        String message;
        while (true) {
            System.out.print("Enter message (type 'exit' to quit): ");
            message = scanner.nextLine();
            if ("exit".equalsIgnoreCase(message)) break;

            try (Socket socket = new Socket("localhost", PORT)) {
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                out.println(message);
            } catch (IOException e) {
                System.out.println("Error sending message: " + e.getMessage());
            }
        }
        scanner.close();
        serverSocket.close();
    }
}
