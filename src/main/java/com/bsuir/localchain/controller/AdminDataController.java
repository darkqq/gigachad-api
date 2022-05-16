package com.bsuir.localchain.controller;

import com.bsuir.localchain.service.core.AdminService;
import com.bsuir.localchain.service.core.impl.AdminServiceImpl;
import com.bsuir.localchain.to.controller.request.CreateCompanyRequestTo;
import com.bsuir.localchain.to.controller.request.EnrolUserRequestTo;
import com.bsuir.localchain.to.controller.request.MintTokensRequestTo;
import com.bsuir.localchain.to.controller.response.ActionResponseTo;
import com.bsuir.localchain.to.controller.response.CreateCompanyResponseTo;
import com.bsuir.localchain.to.controller.response.EnrolUserResponseTo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/admin")
@RequiredArgsConstructor
public class AdminDataController {

    private final AdminService adminService;

    @PostMapping(value = "/register", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CreateCompanyResponseTo> registerCompany(@RequestBody CreateCompanyRequestTo request) throws Exception {
        return ResponseEntity.ok(adminService.registerCompany(request));
    }

    @PostMapping(value = "/enroll", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EnrolUserResponseTo> enrollUser(@RequestBody EnrolUserRequestTo request) throws Exception {
        return ResponseEntity.ok(adminService.enrollUser(request));
    }

    @PostMapping(value = "/token/mint", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ActionResponseTo> mintTokens(@RequestBody MintTokensRequestTo request) throws Exception {
        return ResponseEntity.ok(adminService.mintToken(request));
    }
}
