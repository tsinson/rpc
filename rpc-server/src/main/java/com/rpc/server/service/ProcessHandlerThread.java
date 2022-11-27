package com.rpc.server.service;

import com.rpc.server.api.RpcRequest;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.Socket;

/**
 * @ClassName ProcessHandlerThread
 * @Description TODO
 * @Author zqs
 * @Date 2022/11/26 15:09
 * @ModifyDate 2022/11/26 15:09
 * @Version 1.0
 */
public class ProcessHandlerThread implements Runnable{
    private Object service;
    private Socket socket;

    public ProcessHandlerThread(Object service, Socket socket) {
        this.service = service;
        this.socket = socket;
    }

    @Override
    public void run() {
        try (ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
            ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream())) {
            RpcRequest request = (RpcRequest)inputStream.readObject();
            Object object = this.invoke(request);
            outputStream.writeObject(object);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private Object invoke(RpcRequest request)
        throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class clz = Class.forName(request.getClassName());
        Method method = clz.getMethod(request.getMethodName(), request.getTypes());
        return method.invoke(service, request.getParams());
    }
}
