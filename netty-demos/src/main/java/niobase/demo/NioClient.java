package niobase.demo;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Set;

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
        System.out.println("准备与服务器端建立连接");

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
                    System.out.println("client acceptAble");
                    channel.write(ByteBuffer.wrap("client connect success .".getBytes()));
                    channel.register(selector, SelectionKey.OP_WRITE);
                }
                if (key.isReadable()) {
                    SocketChannel channel = (SocketChannel) key.channel();
                    ByteBuffer buffer = ByteBuffer.allocate(1024);
                    channel.read(buffer);
                    System.out.println("receive msg : " + new String(buffer.array(), Charset.forName("UTF-8")));
                }
                if (key.isWritable()) {
                    System.out.println("client write data ...");
                    SocketChannel channel = (SocketChannel) key.channel();
                    //slowWrite(channel, "hello i am client ,now time is :" + LocalDateTime.now());
                    channel.register(selector, SelectionKey.OP_READ);
                }
                iteratorKey.remove();
            }
        }
    }
}
