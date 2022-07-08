package com.xsk.consumer;

import com.xsk.framework.Invocation;
import com.xsk.framework.ProxyFactory;
import com.xsk.framework.protocol.http.HttpClient;
import com.xsk.provider.api.HelloService;

import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map;

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
 * @Time 2022-07-01 10:08
 */
public class Consumer {

    public static void main(String[] args) {

        HelloService helloService = ProxyFactory.getProxy(HelloService.class);
        String result = helloService.sayHello("xushikai");
        System.out.println(result);

    }
}
