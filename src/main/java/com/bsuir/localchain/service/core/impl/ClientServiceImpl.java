package com.bsuir.localchain.service.core.impl;

import com.bsuir.localchain.client.BlockChainClient;
import com.bsuir.localchain.service.core.ClientService;
import com.bsuir.localchain.to.client.response.CompanyDetailsRs;
import com.bsuir.localchain.to.client.response.MakeTransferRs;
import com.bsuir.localchain.to.client.response.UserInfoRs;
import com.bsuir.localchain.to.controller.request.MakeTransferRequestTo;
import com.bsuir.localchain.to.controller.response.CompanyInfoResponseTo;
import com.bsuir.localchain.to.controller.response.MakeTransferResponseTo;
import com.bsuir.localchain.to.controller.response.UserInfoResponseTo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {
    private final BlockChainClient blockChainClient;

    @Override
    public MakeTransferResponseTo makeTransfer(MakeTransferRequestTo request) throws Exception {
        MakeTransferRs clientResponse = blockChainClient.makeTransfer(request.getTargetWalletId(), request.getAmount());
        MakeTransferResponseTo response = new MakeTransferResponseTo();
        response.setTransaction(clientResponse.getTransaction());
        response.setStatus("SUCCESS");
        return response;
    }

    @Override
    public UserInfoResponseTo getClientInfo() throws Exception {
        UserInfoRs clientResponse = blockChainClient.getUserInfo();
        UserInfoResponseTo response = new UserInfoResponseTo();
        response.setBalance(clientResponse.getBalance());
        response.setUsername(clientResponse.getUsername());
        response.setTransactions(clientResponse.getTransactions());
        response.setWallet(clientResponse.getWallet());
        return response;
    }

    @Override
    public CompanyInfoResponseTo getCompanyInfo() throws Exception {
        CompanyDetailsRs clientResponse = blockChainClient.getCompanyInfo();
        CompanyInfoResponseTo response = new CompanyInfoResponseTo();
        response.setName(clientResponse.getName());
        response.setTokenName(clientResponse.getTokenName());
        response.setTotalTokensMinted(clientResponse.getTotalTokens());
        return response;
    }
}
