package niobase.demo;

import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.concurrent.TimeUnit;

/**
 * <p>
 * Description:
 * </p>
 *
 * @author WangYuFei
 * @date 2019-03-09 11:02
 **/
public class Util {

    public static void slowWrite(SocketChannel socketChannel, String msg) throws Exception {
        TimeUnit.SECONDS.sleep(5);
        socketChannel.write(ByteBuffer.wrap(msg.getBytes()));
    }
}
