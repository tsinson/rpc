package com.rpc.server.api;

import java.io.Serializable;
import java.util.Arrays;

/**
 * @ClassName RpcRequest
 * @Description TODO
 * @Author zqs
 * @Date 2022/11/26 15:16
 * @ModifyDate 2022/11/26 15:16
 * @Version 1.0
 */
public class RpcRequest implements Serializable {
    private String className;
    private String methodName;
    private Object[] params;
    private Class[] types;

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public Object[] getParams() {
        return params;
    }

    public void setParams(Object[] params) {
        this.params = params;
    }

    public Class[] getTypes() {
        return types;
    }

    public void setTypes(Class[] types) {
        this.types = types;
    }

    @Override
    public String toString() {
        return "RpcRequest{" + "className='" + className + '\'' + ", methodName='" + methodName + '\'' + ", params="
            + Arrays.toString(params) + ", types=" + Arrays.toString(types) + '}';
    }
}
