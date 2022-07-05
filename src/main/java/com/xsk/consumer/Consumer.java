package com.xsk.consumer;

import com.xsk.framework.Invocation;
import com.xsk.framework.ProxyFactory;
import com.xsk.framework.protocol.http.HttpClient;
import com.xsk.provider.api.HelloService;

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
        helloService.sayHello("xushikai");

    }
}
