package com.bsuir.localchain.service.core;

import com.bsuir.localchain.to.controller.request.MakeTransferRequestTo;
import com.bsuir.localchain.to.controller.response.CompanyInfoResponseTo;
import com.bsuir.localchain.to.controller.response.MakeTransferResponseTo;
import com.bsuir.localchain.to.controller.response.UserInfoResponseTo;

public interface ClientService {
    MakeTransferResponseTo makeTransfer(MakeTransferRequestTo request) throws Exception;

    UserInfoResponseTo getClientInfo() throws Exception;

    CompanyInfoResponseTo getCompanyInfo() throws Exception;
}
