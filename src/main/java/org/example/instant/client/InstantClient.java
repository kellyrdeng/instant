package org.example.instant.client;

import java.io.BufferedReader;
import java.io.IOError;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class InstantClient {
    
    public static void main(String[] args) {
        String serverHost = "127.0.0.1";
        int portNumber = 8000;

        try (
            Socket socket = new Socket(serverHost, portNumber);
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            Scanner keyboard = new Scanner(System.in);
        ) {
            while (keyboard.hasNextLine()) {
                String inputLine = keyboard.nextLine();
                out.println(inputLine);
                System.out.println(in.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
