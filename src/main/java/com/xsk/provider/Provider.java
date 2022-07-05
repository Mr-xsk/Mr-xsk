package com.xsk.provider;

import com.xsk.framework.protocol.http.HttpServer;
import com.xsk.framework.register.LocalRegister;
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
        new HttpServer().start("localhost",8080);
    }
}
