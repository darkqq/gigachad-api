//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.bsuir.localchain.client.handler;

import javax.servlet.http.HttpServletRequest;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

public interface WebClientHandler {
    HttpHeaders getHeaders(HttpServletRequest var1, String... var2);

    <T> T proceedRequest(WebClient var1, HttpMethod var2, String var3, HttpHeaders var4, ParameterizedTypeReference<T> var5) throws Exception;

    <T> T proceedRequestWithBody(WebClient var1, HttpMethod var2, String var3, HttpHeaders var4, Object var5, ParameterizedTypeReference<T> var6) throws Exception;

    <T> T handleResponseEntity(ResponseEntity<T> var1) throws Exception;
}
