//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.bsuir.localchain.client.handler;


import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.bsuir.localchain.util.WebClientUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.reactive.function.client.WebClient;

public abstract class WebClientAbstractHandler implements WebClientHandler {
    private static final Logger log = LoggerFactory.getLogger(WebClientAbstractHandler.class);

    public WebClientAbstractHandler() {
    }

    public HttpHeaders getHeaders(HttpServletRequest request, String... forwardedHeaders) {
        HttpHeaders headers = new HttpHeaders();
        if (request.getHeader("Authorization") != null) {
            headers.put("Authorization", List.of(request.getHeader("Authorization")));
        }

        if (request.getHeader("X-Session-ID") != null) {
            headers.put("X-Session-ID", List.of(request.getHeader("X-Session-ID")));
        }

        if (request.getHeader("X-Dev-ID") != null) {
            headers.put("X-Dev-ID", List.of(request.getHeader("X-Dev-ID")));
        }

        if (forwardedHeaders != null) {
            String[] var4 = forwardedHeaders;
            int var5 = forwardedHeaders.length;

            for (int var6 = 0; var6 < var5; ++var6) {
                String header = var4[var6];
                if (request.getHeader(header) != null) {
                    headers.put(header, List.of(request.getHeader(header)));
                }
            }
        }

        return headers;
    }
    

    public <T> T proceedRequest(WebClient webClient, HttpMethod method, String url, HttpHeaders headers, ParameterizedTypeReference<T> responseClass) throws Exception {
        ResponseEntity<T> responseEntityMono = WebClientUtil.proceedRequestGeneral(webClient, method, url, headers, responseClass).block();
        return this.handleResponseEntity(responseEntityMono);
    }
    
    public <T> T proceedRequestWithBody(WebClient webClient, HttpMethod method, String url, HttpHeaders headers, Object body, ParameterizedTypeReference<T> responseClass) throws Exception {
        ResponseEntity<T> responseEntityMono = WebClientUtil.proceedRequestWithBodyGeneral(webClient, method, url, headers, body, responseClass).block();
        return this.handleResponseEntity(responseEntityMono);
    }
    

    public abstract <T> T handleResponseEntity(ResponseEntity<T> var1) throws Exception;
}
