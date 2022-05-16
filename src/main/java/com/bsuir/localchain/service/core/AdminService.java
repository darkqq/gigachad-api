package com.bsuir.localchain.service.core;

import com.bsuir.localchain.to.controller.request.CreateCompanyRequestTo;
import com.bsuir.localchain.to.controller.request.EnrolUserRequestTo;
import com.bsuir.localchain.to.controller.request.MintTokensRequestTo;
import com.bsuir.localchain.to.controller.response.ActionResponseTo;
import com.bsuir.localchain.to.controller.response.CreateCompanyResponseTo;
import com.bsuir.localchain.to.controller.response.EnrolUserResponseTo;

public interface AdminService {

    CreateCompanyResponseTo registerCompany(CreateCompanyRequestTo request) throws Exception;

    EnrolUserResponseTo enrollUser(EnrolUserRequestTo request) throws Exception;

    ActionResponseTo mintToken(MintTokensRequestTo request) throws Exception;
}
