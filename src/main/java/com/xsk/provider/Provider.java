package com.xsk.provider;

import com.xsk.framework.URL;
import com.xsk.framework.protocol.http.HttpServer;
import com.xsk.framework.register.LocalRegister;
import com.xsk.framework.register.RemoteMapRegister;
import com.xsk.provider.api.HelloService;
import com.xsk.provider.impl.HelloServiceImpl;

/**
 * ｜,;,,;
 * ｜                 ,;;'(    社
 * ｜        __      ,;;' ' \   会
 * ｜    /'  '\'~~'~' \ /'\.)  主
 * ｜  ,;(      )    /  |.     义
 * ｜ ,;' \    /-.,,(   ) \    码
 * ｜      ) /       ) / )|    农
 * ｜      ||        ||  \)
 * ｜      (_\       (_
 *
 * @Author Mr.Xu
 * @description:
 * @Time 2022-07-01 10:13
 */
public class Provider {

    public static void main(String[] args) {

        //本地注册
        LocalRegister.regist(HelloService.class.getName(), HelloServiceImpl.class);

        //注册中心注册
        URL url = new URL("localhost", 8080);
        RemoteMapRegister.regist(HelloService.class.getName(), url);

        new HttpServer().start(url.getHostname(),url.getPort());
    }
}
