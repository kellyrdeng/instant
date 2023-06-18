package org.example.instant.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) {
        int portNumber = 8000;
        System.out.println("Starting server on port: " + portNumber);

        try ( 
            ServerSocket serverSocket = new ServerSocket(portNumber);
            Socket clientSocket = serverSocket.accept();
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        ) {
            System.out.println("Client connected");
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                System.out.println("Recieved from client: " + inputLine);
                out.println("Ok");
                if (inputLine.equals("Ok"))
                    break;
            }
            System.out.println("Exited");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
