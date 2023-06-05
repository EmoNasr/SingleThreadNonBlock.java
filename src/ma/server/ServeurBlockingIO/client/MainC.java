package ma.server.ServeurBlockingIO.client;

import ma.server.ServeurBlockingIO.client.metier.Client;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

import static java.lang.System.in;

public class MainC {
    public static void main(String[] args) {
        Scanner read = new Scanner(in);
        Client client = new Client("localhost",1234);

        Socket connection = client.connectC();


    }
}
