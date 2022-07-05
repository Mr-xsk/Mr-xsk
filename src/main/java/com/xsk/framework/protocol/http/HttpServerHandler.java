package com.xsk.framework.protocol.http;

import com.xsk.framework.Invocation;
import com.xsk.framework.register.LocalRegister;
import org.apache.commons.io.IOUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * ｜,;,,;
 * ｜                 ,;;'(    社
 * ｜        __      ,;;' ' \  会
 * ｜    /'  '\'~~'~' \ /'\.)  主
 * ｜  ,;(      )    /  |.     义
 * ｜ ,;' \    /-.,,(   ) \    码
 * ｜      ) /       ) / )|    农
 * ｜      ||        ||  \)
 * ｜      (_\       (_
 *
 * @Author Mr.Xu
 * @description:
 * @Time 2022-07-01 10:34
 */
public class HttpServerHandler {

    public void handler(HttpServletRequest req, HttpServletResponse resp) {
        try {
            //接收到的数据封装成Invocation对象
            Invocation invocation = (Invocation) new ObjectInputStream(req.getInputStream()).readObject();
            //获取接口
            String interfaceName = invocation.getInterfaceName();
            //根据方法名取出实现类对象
            Class classImpl = LocalRegister.get(interfaceName);
            //实现类对象 通过 方法名和方法参数类型列表 获取对象的方法
            Method method = classImpl.getMethod(invocation.getMethodName(), invocation.getParamType());
            //传入对象和参数 执行方法，获得返回值
            String result = (String) method.invoke(classImpl.newInstance(), invocation.getParams());
            //执行的结果进行返回
            IOUtils.write(result, resp.getOutputStream());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        }
    }
}
