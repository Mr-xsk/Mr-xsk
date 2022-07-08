package com.xsk.framework.protocol.http;

import com.xsk.framework.Invocation;
import com.xsk.framework.Invoker;
import com.xsk.framework.Protocol;
import com.xsk.framework.URL;
import com.xsk.framework.protocol.dubbo.DubboInvoker;
import com.xsk.framework.protocol.dubbo.NettyServer;
import com.xsk.framework.register.LocalRegister;
import com.xsk.framework.register.RemoteMapRegister;

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
 * @Time 2022-07-07 15:12
 */
public class HttpProtocol implements Protocol {

    @Override
    public void export(URL url) {
        //本地注册
        LocalRegister.regist(url.getInterfaceName(), url.getImplClass());
        //注册中心注册
        RemoteMapRegister.regist(url.getInterfaceName(), url);
        //启动Tomcat
        new HttpServer().start(url.getHostname(), url.getPort());
    }

    @Override
    public Invoker refer(URL url) {
        return new HttpInvoker(url);
    }
}
