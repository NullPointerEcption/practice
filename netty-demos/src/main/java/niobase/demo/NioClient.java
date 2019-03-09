package niobase.demo;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.Set;

import static niobase.demo.Util.slowWrite;

/**
 * <p>
 * Description:
 * </p>
 *
 * @author WangYuFei
 * @date 2019-03-09 09:34
 **/
public class NioClient {

    public static void main(String[] args) throws Exception {
        Selector selector = Selector.open();

        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.configureBlocking(false);
        socketChannel.connect(new InetSocketAddress("localhost", 1111));

        int selectableKeys = socketChannel.validOps();
        socketChannel.register(selector, selectableKeys);
        for (; selector.select() > 0; ) {

            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            Iterator<SelectionKey> iteratorKey = selectionKeys.iterator();
            while (iteratorKey.hasNext()) {
                SelectionKey key = iteratorKey.next();
                if (key.isConnectable()) {
                    SocketChannel channel = (SocketChannel) key.channel();
                    if (channel.isConnectionPending()) {
                        channel.finishConnect();
                    }
                    slowWrite(channel, "client connect success .." + LocalDateTime.now());
                    System.out.println("client acceptAble");
                }
                if (key.isReadable()) {
                    SocketChannel channel = (SocketChannel) key.channel();
                    ByteBuffer buffer = ByteBuffer.allocate(1024);
                    channel.read(buffer);
                    System.out.println("client readAble and read msg : " + new String(buffer.array()));
                    slowWrite(channel, "client received data ...");
                }
                if (key.isWritable()) {
                    SocketChannel channel = (SocketChannel) key.channel();
                    slowWrite(channel, "hello i am client ,now time is :" + LocalDateTime.now());
                }
                iteratorKey.remove();
            }
        }
    }
}
