package main;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Method;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @description: ${description}
 * @author: WangYuFei
 * @create: 2019-01-23 20:14
 **/
public class ServiceMain {

    public static void main(String[] args) throws Exception {
        System.out.println("绑定端口");
        ServerSocket serverSocket = new ServerSocket(8888);
        for (; ; ) {
            System.out.println("监听请求");
            Socket clientSocket = serverSocket.accept();
            ObjectInputStream objectInputStream = new ObjectInputStream(clientSocket.getInputStream());

            String className = objectInputStream.readUTF();
            String methodName = objectInputStream.readUTF();
            Class[] paramTypes = (Class[]) objectInputStream.readObject();
            Object[] argsForMethod = (Object[]) objectInputStream.readObject();

            Class clazz = null;
            if (className.equals(IProductService.class.getName())) {
                clazz = ProductService.class;
            }

            Method method = clazz.getMethod(methodName, paramTypes);
            Object res = method.invoke(clazz.newInstance(), argsForMethod);

            ObjectOutputStream objectOutputStream = new ObjectOutputStream(clientSocket.getOutputStream());
            objectOutputStream.writeObject(res);
            objectOutputStream.flush();

            objectInputStream.close();
            objectOutputStream.close();
            clientSocket.close();

            System.out.println("接收到请求并完成输出");

        }
    }
}
