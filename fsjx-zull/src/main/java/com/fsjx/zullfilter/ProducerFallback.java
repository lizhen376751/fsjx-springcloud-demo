package com.fsjx.zullfilter;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.zuul.filters.route.ZuulFallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;


import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 暂时不用
 * Created by Administrator on 2018\6\1 0001.
 */
//@Component
public class ProducerFallback  implements ZuulFallbackProvider {
    private final Logger logger = LoggerFactory.getLogger(ProducerFallback.class);

        @Override
        public ClientHttpResponse fallbackResponse() {

            return new ClientHttpResponse() {
                @Override
                public HttpHeaders getHeaders() {
                    return null;
                }
                @Override
                public InputStream getBody() throws IOException {
                    return new ByteArrayInputStream("服务暂时不可用".getBytes());
                }

                @Override
                public String getStatusText() throws IOException {
                    // TODO Auto-generated method stub
                    return "Service Down";
                }

                @Override
                public HttpStatus getStatusCode() throws IOException {
                    // TODO Auto-generated method stub
                    return HttpStatus.OK;
                }

                @Override
                public int getRawStatusCode() throws IOException {
                    // TODO Auto-generated method stub
                    return 200;
                }

                @Override
                public void close() {
                    // TODO Auto-generated method stub

                }
            };
        }

        @Override
        public String getRoute() {
            // TODO Auto-generated method stub
            return "*";
        }


}
