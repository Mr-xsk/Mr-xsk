package com.xsk.framework.protocol.dubbo;

import com.xsk.framework.Invocation;
import com.xsk.framework.Invoker;
import com.xsk.framework.URL;

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
 * @Time 2022-07-07 16:05
 */
public class DubboInvoker implements Invoker {

    private URL url;

    public DubboInvoker(URL url){
        this.url = url;
    }

    @Override
    public String invoke(Invocation invocation) {
        return new NettyClient<>().send(url.getHostname(), url.getPort(), invocation);
    }
}
