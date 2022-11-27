package com.rpc.server.service;

import com.rpc.server.api.IMessage;

/**
 * @ClassName MessageServiceImpl
 * @Description TODO
 * @Author zqs
 * @Date 2022/11/26 15:03
 * @ModifyDate 2022/11/26 15:03
 * @Version 1.0
 */
public class MessageServiceImpl implements IMessage {
    @Override
    public String display(String msg) {
        return "receive msg:" + msg;
    }
}
