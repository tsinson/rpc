package com.rpc.server.client;

import java.lang.reflect.Proxy;

/**
 * @ClassName RpcClientProxy
 * @Description TODO
 * @Author zqs
 * @Date 2022/11/26 14:47
 * @ModifyDate 2022/11/26 14:47
 * @Version 1.0
 */
public class RpcClientProxy {
    public <T> T clientProxy(final Class<T> interfaceClz, String host, int port) {
        return (T)Proxy.newProxyInstance(interfaceClz.getClassLoader(), new Class<?>[] {interfaceClz},
            new RemoteInvocationHandler(host, port));
    }
}
