package com.rpc.server.client;

import com.rpc.server.api.RpcRequest;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * @ClassName RpcIoProcess
 * @Description TODO
 * @Author zqs
 * @Date 2022/11/26 15:23
 * @ModifyDate 2022/11/26 15:23
 * @Version 1.0
 */
public class RpcIoProcess {
    private String host;
    private int port;

    public RpcIoProcess(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public Object send(RpcRequest request) {
        ObjectInputStream inputStream = null;
        try (Socket socket = new Socket(host, port);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream())) {
            objectOutputStream.writeObject(request);
            objectOutputStream.flush();
            inputStream = new ObjectInputStream(socket.getInputStream());
            return inputStream.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
