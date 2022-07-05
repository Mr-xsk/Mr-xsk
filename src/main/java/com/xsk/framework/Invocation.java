package com.xsk.framework;

import java.io.Serializable;


public class Invocation implements Serializable {

    //接口名
    private String interfaceName;
    //方法名
    private String methodName;
    //方法参数类型列表
    private Class[] paramType;
    //方法参数值
    private Object[] params;

    public Invocation() {
    }

    public Invocation(String interfaceName, String methodName, Class[] paramType, Object[] params) {
        this.interfaceName = interfaceName;
        this.methodName = methodName;
        this.paramType = paramType;
        this.params = params;
    }

    public String getInterfaceName() {
        return interfaceName;
    }

    public void setInterfaceName(String interfaceName) {
        this.interfaceName = interfaceName;
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

    public Class[] getParamType() {
        return paramType;
    }

    public void setParamType(Class[] paramType) {
        this.paramType = paramType;
    }
}
