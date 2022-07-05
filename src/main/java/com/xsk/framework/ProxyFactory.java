package com.xsk.framework;

import com.xsk.framework.protocol.http.HttpClient;
import com.xsk.framework.register.RemoteMapRegister;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.List;

import static java.lang.reflect.Proxy.*;

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
 * @Time 2022-07-04 17:50
 */
public class ProxyFactory<T> {

    public static <T> T getProxy (final Class interfaceClass) {

        return (T) newProxyInstance(interfaceClass.getClassLoader(), new Class[]{interfaceClass}, new InvocationHandler() {

            /**
             * method 执行的方法
             * args 执行方法的参数
             * proxy 代理的对象
             */
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                Invocation invocation = new Invocation(interfaceClass.getName(), method.getName(),
                        method.getParameterTypes(), args);

                HttpClient httpClient = new HttpClient();

                //从注册中心获取url的集合（使用本地缓存模仿功能）
                List<URL> urls = RemoteMapRegister.get(interfaceClass.getName());

                //负载均衡从URL集合中随机获取
                URL url = LoadBalance.random(urls);

                return httpClient.send(url.getHostname(), url.getPort(), invocation);
            }
        });

    }
}
