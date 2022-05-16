package com.bsuir.localchain.client;

import com.bsuir.localchain.to.client.response.*;

import java.math.BigDecimal;

public interface BlockChainClient {
    RegisterCompanyRs registerCompany(String cName, String tName) throws Exception;
    CompanyDetailsRs getCompanyInfo() throws Exception;
    UserInfoRs getUserInfo() throws Exception;
    RegisterUserRs enrollUser(String username) throws Exception;
    ActionRs mintToken(BigDecimal amount) throws Exception;
    MakeTransferRs makeTransfer(String targetWalletId, BigDecimal amount) throws Exception;
}
