package com.bsuir.localchain.service.core.impl;

import com.bsuir.localchain.client.BlockChainClient;
import com.bsuir.localchain.service.core.AdminService;

import com.bsuir.localchain.to.client.response.ActionRs;
import com.bsuir.localchain.to.client.response.RegisterCompanyRs;
import com.bsuir.localchain.to.client.response.RegisterUserRs;
import com.bsuir.localchain.to.controller.request.CreateCompanyRequestTo;
import com.bsuir.localchain.to.controller.request.EnrolUserRequestTo;
import com.bsuir.localchain.to.controller.request.MintTokensRequestTo;
import com.bsuir.localchain.to.controller.response.ActionResponseTo;
import com.bsuir.localchain.to.controller.response.CreateCompanyResponseTo;
import com.bsuir.localchain.to.controller.response.EnrolUserResponseTo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {
    private final BlockChainClient blockChainClient;

    @Override
    public CreateCompanyResponseTo registerCompany(CreateCompanyRequestTo request) throws Exception {
        RegisterCompanyRs clientResponse = blockChainClient.registerCompany(request.getCompanyName(), request.getTokenName());
        CreateCompanyResponseTo response = new CreateCompanyResponseTo();
        response.setAdminToken(clientResponse.getAdminToken());
        response.setTokenName(clientResponse.getTokenName());
        response.setName(clientResponse.getName());
        return response;
    }

    @Override
    public EnrolUserResponseTo enrollUser(EnrolUserRequestTo request) throws Exception {
        RegisterUserRs clientResponse = blockChainClient.enrollUser(request.getUsername());
        EnrolUserResponseTo response = new EnrolUserResponseTo();
        response.setToken(clientResponse.getToken());
        response.setWallet(clientResponse.getWallet());
        response.setTransactionId(clientResponse.getTransactionId());
        return response;
    }

    @Override
    public ActionResponseTo mintToken(MintTokensRequestTo request) throws Exception {
        ActionRs clientResponse = blockChainClient.mintToken(request.getAmount());
        return new ActionResponseTo(clientResponse.getTransactionId());
    }
}
