package com.rpc.server;

import com.rpc.server.api.IMessage;
import com.rpc.server.service.MessageServiceImpl;
import com.rpc.server.service.RpcProxyServer;

/**
 * Hello world!
 *
 */
public class ServerApp
{
    public static void main(String[] args) {
        IMessage message = new MessageServiceImpl();
        RpcProxyServer rpcProxyServer = new RpcProxyServer();
        rpcProxyServer.publisher(message, 8080);
    }
}
