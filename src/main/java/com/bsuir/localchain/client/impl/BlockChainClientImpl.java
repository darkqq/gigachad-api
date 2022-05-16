package com.bsuir.localchain.client.impl;

import com.bsuir.localchain.client.BlockChainClient;
import com.bsuir.localchain.client.handler.WebClientHandler;
import com.bsuir.localchain.properties.ConfigPropertiesComponent;
import com.bsuir.localchain.to.client.request.MakeTransferRq;
import com.bsuir.localchain.to.client.request.MintTokensRq;
import com.bsuir.localchain.to.client.request.RegisterCompanyRq;
import com.bsuir.localchain.to.client.request.RegisterUserRq;
import com.bsuir.localchain.to.client.response.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class BlockChainClientImpl implements BlockChainClient {

    @Qualifier("web-client")
    private final WebClient webClient;

    @Qualifier("web-client-rest-handler")
    private final WebClientHandler webClientHandler;

    private final ConfigPropertiesComponent configPropertiesComponent;

    private final HttpServletRequest request;

    @Override
    public RegisterCompanyRs registerCompany(String cName, String tName) throws Exception {
        log.info("Start making API call for path: {}", configPropertiesComponent.getRegisterCompanyPath());
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
        return webClientHandler.proceedRequestWithBody(webClient, HttpMethod.POST,
                UriComponentsBuilder.fromHttpUrl(configPropertiesComponent.getInternalApiUrlBase())
                        .path(configPropertiesComponent.getRegisterCompanyPath())
                        .toUriString(),
                requestHeaders, new RegisterCompanyRq(cName, tName), new ParameterizedTypeReference<>() {
                });
    }

    @Override
    public CompanyDetailsRs getCompanyInfo() throws Exception {
        log.info("Start making API call for path: {}", configPropertiesComponent.getCompanyDataPath());
        return webClientHandler.proceedRequest(webClient, HttpMethod.GET,
                UriComponentsBuilder.fromHttpUrl(configPropertiesComponent.getInternalApiUrlBase())
                        .path(configPropertiesComponent.getCompanyDataPath())
                        .toUriString(),
                null, new ParameterizedTypeReference<>() {
                });
    }

    @Override
    public UserInfoRs getUserInfo() throws Exception {
        log.info("Start making API call for path: {}", configPropertiesComponent.getUserDataPath());
        HttpHeaders requestHeaders = new HttpHeaders();
        String header = request.getHeader("Authorization");
        log.info(header);
        requestHeaders.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
        return webClientHandler.proceedRequest(webClient, HttpMethod.GET,
                UriComponentsBuilder.fromHttpUrl(configPropertiesComponent.getInternalApiUrlBase())
                        .path(configPropertiesComponent.getUserDataPath())
                        .queryParam("token", header)
                        .toUriString(),
                requestHeaders, new ParameterizedTypeReference<>() {
                });
    }

    @Override
    public RegisterUserRs enrollUser(String username) throws Exception {
        String header = request.getHeader("Authorization");
        log.info(header);
        log.info("Start making API call for path: {}", configPropertiesComponent.getRegisterCompanyPath());
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
        return webClientHandler.proceedRequestWithBody(webClient, HttpMethod.POST,
                UriComponentsBuilder.fromHttpUrl(configPropertiesComponent.getInternalApiUrlBase())
                        .path(configPropertiesComponent.getEnrollPath())
                        .queryParam("token", header)
                        .toUriString(),
                requestHeaders, new RegisterUserRq(username), new ParameterizedTypeReference<>() {
                });
    }

    @Override
    public ActionRs mintToken(BigDecimal amount) throws Exception {
        log.info("Start making API call for path: {}", configPropertiesComponent.getMintTokensPath());
        HttpHeaders requestHeaders = new HttpHeaders();
        String header = request.getHeader("Authorization");
        log.info(header);
        requestHeaders.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
        return webClientHandler.proceedRequestWithBody(webClient, HttpMethod.POST,
                UriComponentsBuilder.fromHttpUrl(configPropertiesComponent.getInternalApiUrlBase())
                        .path(configPropertiesComponent.getMintTokensPath())
                        .toUriString(),
                requestHeaders, new MintTokensRq(header, amount), new ParameterizedTypeReference<>() {
                });
    }

    @Override
    public MakeTransferRs makeTransfer(String targetWalletId, BigDecimal amount) throws Exception {
        log.info("Start making API call for path: {}", configPropertiesComponent.getMakeTransferPath());
        HttpHeaders requestHeaders = new HttpHeaders();
        String header = request.getHeader("Authorization");
        log.info(header);
        requestHeaders.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
        return webClientHandler.proceedRequestWithBody(webClient, HttpMethod.POST,
                UriComponentsBuilder.fromHttpUrl(configPropertiesComponent.getInternalApiUrlBase())
                        .path(configPropertiesComponent.getMakeTransferPath())
                        .toUriString(),
                requestHeaders, new MakeTransferRq(header, targetWalletId, amount), new ParameterizedTypeReference<>() {
                });
    }


}
