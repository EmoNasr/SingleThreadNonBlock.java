package ma.server.ServeurBlockingIO.client.presentation;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class clenttest {
    /*package whatever //do not write package name here */

        public static void main(String[] args)
        {
            try {
                String[] messages
                        = { "server",
                        "test2",
                        "test1" };
                System.out.println(
                        "Connection accepted by the Server");
                SocketChannel client = SocketChannel.open(
                        new InetSocketAddress("localhost", 4444));

                for (String msg : messages) {
                    ByteBuffer buffer
                            = ByteBuffer.allocate(1024);
                    buffer.put(msg.getBytes());
                    buffer.flip();
                    int bytesWritten = client.write(buffer);
                    System.out.println(String.format(
                            "Sending Message: %s\nBytes: %d",
                            msg, bytesWritten));
                }

                client.close();
                System.out.println("Client connection closed");
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


