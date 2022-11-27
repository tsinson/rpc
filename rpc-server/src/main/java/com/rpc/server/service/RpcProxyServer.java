package com.rpc.server.service;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @ClassName RpcProxyServer
 * @Description TODO
 * @Author zqs
 * @Date 2022/11/26 15:04
 * @ModifyDate 2022/11/26 15:04
 * @Version 1.0
 */
public class RpcProxyServer {
    public void publisher(Object service, int port) {
        ServerSocket serverSocket = null;
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        try {
            serverSocket = new ServerSocket(port);
            while (true) {
                //没有客户端请求时，accetp会阻塞
                //一个socket代表一个客户端的连接
                Socket socket = serverSocket.accept();
                //nio的多路复用，一个线程管理多个连接
                executorService.execute(new ProcessHandlerThread(service, socket));
            }
        } catch (Exception e) {

        }
    }
}
