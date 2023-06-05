package ma.server.ServeurBlockingIO.server;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;
import java.util.logging.Handler;

public class SingleThreadNonBlock {

    public static void main(String[] args) {

        try {
            Selector selector = Selector.open();
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.configureBlocking(false);

            ServerSocket serverSocket = serverSocketChannel.socket();
            serverSocket.bind(
                    new InetSocketAddress("127.0.0.1",4444)
            );

            int ops = serverSocketChannel.validOps();
            serverSocketChannel.register(selector,SelectionKey.OP_ACCEPT);

            while (true){
                selector.select();
                Set<SelectionKey> selectionKeys = selector.selectedKeys();
                Iterator<SelectionKey> i = selectionKeys.iterator();

                while(i.hasNext()){
                    SelectionKey key = i.next();
                    if(key.isAcceptable()){
                        handleAcccept(selector,key);

                    } else if (key.isReadable()) {
                        handleRead(selector,key);
//                       handleRead2(key);
                    }
                    i.remove();
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    private static void handleAcccept(Selector selector,SelectionKey key) throws IOException {
        System.out.println("Connection Accepted..");
        ServerSocketChannel serverSocketChannel = (ServerSocketChannel) key.channel();
        SocketChannel sockethCannelClient  = serverSocketChannel.accept();
        sockethCannelClient.configureBlocking(false);
        sockethCannelClient.register(selector,SelectionKey.OP_READ);
    }

    private static void handleRead(Selector selector,SelectionKey key) throws IOException {
        System.out.println("Reading client's message.");

        SocketChannel socketChannel = (SocketChannel) key.channel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        socketChannel.read(byteBuffer);

        String request = new String(byteBuffer.array()).trim();
        String reponse = "Request Size: "+request.length();

        ByteBuffer byteBufferReponse = ByteBuffer.allocate(1024);
        byteBufferReponse.put(reponse.getBytes());
        byteBufferReponse.flip();

        int writtenBytes = socketChannel.write(byteBufferReponse);
        System.out.println("Sending "+writtenBytes+" Bytes");
    }


    private static void handleRead2(SelectionKey key)
            throws IOException
    {
        System.out.println("Reading client's message.");

        // create a ServerSocketChannel to read the request
        SocketChannel client = (SocketChannel)key.channel();

        // Create buffer to read data
        ByteBuffer buffer = ByteBuffer.allocate(1024);

        client.read(buffer);

        // Parse data from buffer to String
        String data = new String(buffer.array()).trim();
        if (data.length() > 0) {
            System.out.println("Received message: " + data);
            if (data.equalsIgnoreCase(
                    "hello")) {
                client.close();
                System.out.println("Connection closed...");
            }
        }
    }



}
