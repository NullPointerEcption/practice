package niobase;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * <p>
 * Description:
 * </p>
 *
 * @author WangYuFei
 * @date 2019-01-29 15:50
 **/
public class DemoBuffer {
    public static void main(String[] args) throws Exception {
        RandomAccessFile file = new RandomAccessFile("data.txt", "rw");
        FileChannel channel = file.getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(50);

        int bytesRead = channel.read(buffer);
        while (bytesRead != -1) {
            buffer.flip();
            while (buffer.hasRemaining()) {
                System.out.print((char) buffer.get());
            }
            System.out.print("\n");
            buffer.clear();
            bytesRead = channel.read(buffer);
        }
        file.close();
    }
}
