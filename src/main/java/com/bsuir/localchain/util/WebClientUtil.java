package com.bsuir.localchain.util;

import java.util.Objects;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClient.RequestBodySpec;
import org.springframework.web.reactive.function.client.WebClient.RequestHeadersSpec;
import reactor.core.publisher.Mono;

public final class WebClientUtil {
    private static final Logger log = LoggerFactory.getLogger(WebClientUtil.class);

    private WebClientUtil() {
        throw new UnsupportedOperationException();
    }

    public static <T> Mono<ResponseEntity<T>> proceedRequestWithBodyGeneral(WebClient webClient, HttpMethod method, String url, HttpHeaders headers, Object body, ParameterizedTypeReference<T> responseClass) {
        return setUpRequestWithBody(webClient, method, url, headers, body).exchangeToMono((clientResponse) -> {
            if (clientResponse.statusCode().is5xxServerError() || clientResponse.statusCode().is4xxClientError()) {
                clientResponse.body((clientHttpResponse, context) -> {
                    return clientHttpResponse.getBody();
                });
            }

            return clientResponse.toEntity(responseClass);
        }).onErrorContinue((throwable, o) -> {
            log.error(String.format("Got an error from webClient call: %s. The object is: %s", throwable.getMessage(), o));
        });
    }

    public static <T> Mono<ResponseEntity<T>> proceedRequestGeneral(WebClient webClient, HttpMethod method, String url, HttpHeaders headers, ParameterizedTypeReference<T> responseClass) {
        return setUpRequest(webClient, method, url, headers).exchangeToMono((clientResponse) -> {
            if (clientResponse.statusCode().is5xxServerError() || clientResponse.statusCode().is4xxClientError()) {
                clientResponse.body((clientHttpResponse, context) -> {
                    return clientHttpResponse.getBody();
                });
            }

            return clientResponse.toEntity(responseClass);
        }).onErrorContinue((throwable, o) -> {
            log.error(String.format("Got an error from webClient call: %s. The object is: %s", throwable.getMessage(), o));
        });
    }

    private static RequestHeadersSpec<?> setUpRequestWithBody(WebClient webClient, HttpMethod method, String url, HttpHeaders headers, Object body) {
        RequestBodySpec setUpRequest = setUpRequest(webClient, method, url, headers);
        return headers != null && Objects.equals(headers.getContentType(), MediaType.MULTIPART_FORM_DATA) ? setUpRequest.body(BodyInserters.fromMultipartData((MultiValueMap)body)) : setUpRequest.body(Mono.just(body), new ParameterizedTypeReference<Object>() {
        });
    }

    private static RequestBodySpec setUpRequest(WebClient webClient, HttpMethod method, String url, HttpHeaders headers) {
        return (RequestBodySpec)((RequestBodySpec)webClient.method(method).uri(url, new Object[0])).headers((httpHeaders) -> {
            httpHeaders.clear();
            if (headers != null) {
                httpHeaders.addAll(headers);
            }

        });
    }
}
