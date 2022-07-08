package com.xsk.framework.protocol.http;

import com.xsk.framework.Invocation;
import com.xsk.framework.Invoker;
import com.xsk.framework.URL;

public class HttpInvoker implements Invoker {

    private URL url;

    public HttpInvoker(URL url) {
        this.url = url;
    }

    @Override
    public String invoke(Invocation invocation) {
        return new HttpClient().send(url.getHostname(), url.getPort(), invocation);
    }
}
