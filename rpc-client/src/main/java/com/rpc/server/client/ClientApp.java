package com.rpc.server.client;

import com.rpc.server.api.IMessage;

/**
 * client app!
 *
 */
public class ClientApp
{
    public static void main( String[] args )
    {
        RpcClientProxy rpcClientProxy = new RpcClientProxy();
        IMessage message = rpcClientProxy.clientProxy(IMessage.class, "127.0.0.1", 8080);
        String ret = message.display("hi, nice to meet you.");
        System.out.println(ret);
    }
}
