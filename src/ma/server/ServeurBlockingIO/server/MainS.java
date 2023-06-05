package ma.server.ServeurBlockingIO.server;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

import static java.lang.System.in;

public class MainS {
    public static void main(String[] args) {

        Scanner read = new Scanner(in);

        try {
            System.out.println("Donner le port de votre serveur: ");
            int port = read.nextInt();
            ServerIO server = new ServerIO(port);

            Socket s = server.getServerSocket().accept();
            System.out.println("Connection esstablish");

            while (s.isConnected())
                server.Listen(s);


        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}