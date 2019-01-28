package main;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.Socket;

/**
 * @description: ${description}
 * @author: WangYuFei
 * @create: 2019-01-23 19:47
 **/
public class ApiMain {

    public static void main(String[] args) {
        IProductService productService = rpc(IProductService.class);
        Product product = productService.findById("test");
        System.out.println(product);
    }

    private static IProductService rpc(final Class<IProductService> clazz) {
        return (IProductService) Proxy.newProxyInstance(clazz.getClassLoader(), new Class[]{clazz}, new InvocationHandler() {

            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Socket socket = new Socket("127.0.0.1", 8888);

                String clazzNamename = clazz.getName();
                String methodName = method.getName();
                Class<?>[] parameterTypes = method.getParameterTypes();

                ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
                objectOutputStream.writeUTF(clazzNamename);
                objectOutputStream.writeUTF(methodName);
                objectOutputStream.writeObject(parameterTypes);
                objectOutputStream.writeObject(args);

                ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
                Object o = objectInputStream.readObject();

                objectInputStream.close();
                objectOutputStream.close();
                socket.close();

                return o;
            }
        });

    }
}
