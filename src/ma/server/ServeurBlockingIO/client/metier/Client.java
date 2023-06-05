package ma.server.ServeurBlockingIO.client.metier;


import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

import static java.lang.System.in;

public class Client {
    private String IP;
    private int port;
    private Socket socket;

    public Client(String ip,int port){

        this.IP = ip;
        this.port = port;
    }

    public Socket connectC()
    {
        try {

            this.socket = new Socket(this.IP,this.port);
            return this.socket;

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void Run(){
        Scanner read = new Scanner(in);

        try {
            InputStream InStream = this.socket.getInputStream();
            OutputStream OutStream = this.socket.getOutputStream();

            PrintWriter Print = new PrintWriter(OutStream,true);
            while(true) {
                String data = read.nextLine();
                Print.println(data);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public String getIP() {
        return IP;
    }

    public void setIP(String IP) {
        this.IP = IP;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }
}
