package com.socket.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author wangyufei
 * @date 2018/10/10
 */
public class Server {

    public static void main(String[] args) throws IOException{
        ServerSocket serverSocket = null;
        BufferedReader bufferedReader = null;
        try {
            serverSocket = new ServerSocket(12345);
            Socket accept = serverSocket.accept();
            bufferedReader = new BufferedReader(new InputStreamReader(accept.getInputStream()));
            System.out.println(bufferedReader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            bufferedReader.close();
            serverSocket.close();
        }
    }
}
