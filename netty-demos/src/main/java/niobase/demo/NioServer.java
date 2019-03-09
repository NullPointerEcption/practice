package niobase.demo;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * <p>
 * Description:
 * </p>
 *
 * @author WangYuFei
 * @date 2019-02-22 15:15
 **/
public class NioServer {
    @SuppressWarnings("unused")
    public static void main(String[] args) throws Exception {

        // Selector: multiplexor of SelectableChannel objects
        Selector selector = Selector.open(); // selector is open here

        // ServerSocketChannel: selectable channel for stream-oriented listening sockets
        ServerSocketChannel crunchifySocket = ServerSocketChannel.open();
        InetSocketAddress crunchifyAddr = new InetSocketAddress("localhost", 1111);

        // Binds the channel's socket to a local address and configures the socket to listen for connections
        crunchifySocket.bind(crunchifyAddr);

        // Adjusts this channel's blocking mode.
        crunchifySocket.configureBlocking(false);

        int ops = crunchifySocket.validOps();
        SelectionKey selectKy = crunchifySocket.register(selector, ops, null);

        // Infinite loop..
        // Keep server running
        // Selects a set of keys whose corresponding channels are ready for I/O operations
        while (selector.select() > 0) {
            log("i'm a server and i'm waiting for new connection and buffer select...");

            // token representing the registration of a SelectableChannel with a Selector
            Set<SelectionKey> crunchifyKeys = selector.selectedKeys();
            Iterator<SelectionKey> crunchifyIterator = crunchifyKeys.iterator();

            while (crunchifyIterator.hasNext()) {
                SelectionKey myKey = crunchifyIterator.next();

                // Tests whether this key's channel is ready to accept a new socket connection
                if (myKey.isAcceptable()) {
                    SocketChannel crunchifyClient = crunchifySocket.accept();

                    // Adjusts this channel's blocking mode to false
                    crunchifyClient.configureBlocking(false);

                    // Operation-set bit for read operations
                    crunchifyClient.register(selector, SelectionKey.OP_READ);
                    log("Connection Accepted: " + crunchifyClient.getLocalAddress() + "\n");

                    // Tests whether this key's channel is ready for reading
                } else if (myKey.isReadable()) {
                    SocketChannel crunchifyClient = (SocketChannel) myKey.channel();
                    System.out.println("准备读取数据，客户端地址为：" + crunchifyClient.getRemoteAddress() + "---" + crunchifyClient);
                    ByteBuffer crunchifyBuffer = ByteBuffer.allocate(256);
                    int readedByte = crunchifyClient.read(crunchifyBuffer);
                    String result = new String(crunchifyBuffer.array()).trim();

                    log("Message received: " + result);

                    if (readedByte == -1) {
                        crunchifyClient.write(ByteBuffer.wrap("hello this is wyf server!".getBytes()));
                        crunchifyClient.close();
                    }

                    //Util.slowWrite(crunchifyClient, "hello this is wyf server!");
                    crunchifyClient.register(selector, SelectionKey.OP_WRITE);
                } else if (myKey.isWritable()) {
                    System.out.println("触发了写事件");
                    SocketChannel socketChannel = (SocketChannel) myKey.channel();
                    Util.slowWrite(socketChannel, "iam data from 服务器端关心的写事件");
                }
                crunchifyIterator.remove();
            }
        }
    }

    private static void log(String str) {
        System.out.println(str);
    }
}
