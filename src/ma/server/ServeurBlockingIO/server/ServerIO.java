package ma.server.ServeurBlockingIO.server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;


//Server blocking IO
public class ServerIO {

    private int port;
    private ServerSocket serverSocket;

    public ServerIO(int port)
    {
        this.port = port;
        try {
            this.serverSocket = new ServerSocket(port);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public void Listen(Socket server){

        BufferedReader Read;
        PrintWriter Print;

        try {
            InputStream InStream = server.getInputStream();
            OutputStream OutStream = server.getOutputStream();
            InputStreamReader Re = new InputStreamReader(InStream);

            Read = new BufferedReader(Re);
            Print = new PrintWriter(OutStream,true);
            String data = " 11";
            if(server.isConnected()){
//                System.out.println("yes");
//                data=Read.readLine();
//                System.out.println(data);
                byte[] buffer = new byte[1024];
                int bytesRead = InStream.read(buffer);
                String message = new String(buffer, 0, bytesRead);
                System.out.println("Received message: " + message);
            }
            else server.close();



        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public ServerSocket getServerSocket() {
        return serverSocket;
    }

    public void setServerSocket(ServerSocket serverSocket) {
        this.serverSocket = serverSocket;
    }
}
