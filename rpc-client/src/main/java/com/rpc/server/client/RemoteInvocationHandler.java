package com.rpc.server.client;

import com.rpc.server.api.RpcRequest;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @ClassName RemoteInvocationHandler
 * @Description TODO
 * @Author zqs
 * @Date 2022/11/26 15:01
 * @ModifyDate 2022/11/26 15:01
 * @Version 1.0
 */
public class RemoteInvocationHandler implements InvocationHandler {
    private String host;
    private int port;

    public RemoteInvocationHandler(String host, int port) {
        this.host = host;
        this.port = port;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //1.组装参数
        //2.序列化
        //3.网络传输
        RpcRequest request = new RpcRequest();
        request.setClassName(method.getDeclaringClass().getName());
        request.setMethodName(method.getName());
        request.setParams(args);
        request.setTypes(method.getParameterTypes());
        RpcIoProcess process = new RpcIoProcess(host, port);
        return process.send(request);
    }
}
