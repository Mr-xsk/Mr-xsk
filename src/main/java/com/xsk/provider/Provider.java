package com.xsk.provider;

import com.xsk.framework.Protocol;
import com.xsk.framework.ProtocolFactory;
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

        String protocolName = System.getProperty("protocolName");
        URL url = new URL(protocolName,"localhost", 8082, HelloService.class.getName(), HelloServiceImpl.class);
        Protocol protocol = ProtocolFactory.getProtocol(protocolName);
        protocol.export(url);
    }
}
