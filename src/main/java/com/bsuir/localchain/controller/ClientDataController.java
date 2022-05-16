package com.bsuir.localchain.controller;

import com.bsuir.localchain.service.core.ClientService;
import com.bsuir.localchain.to.controller.request.MakeTransferRequestTo;
import com.bsuir.localchain.to.controller.response.CompanyInfoResponseTo;
import com.bsuir.localchain.to.controller.response.MakeTransferResponseTo;
import com.bsuir.localchain.to.controller.response.UserInfoResponseTo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/client/")
@RequiredArgsConstructor
@Slf4j
public class ClientDataController {

    private final ClientService clientService;

    @PostMapping(value = "/transfer", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<MakeTransferResponseTo> makeTransfer(@RequestBody MakeTransferRequestTo request) throws Exception {
        return ResponseEntity.ok(clientService.makeTransfer(request));
    }

    @GetMapping(value = "/info")
    public ResponseEntity<UserInfoResponseTo> getClientInfo() throws Exception {
        return ResponseEntity.ok(clientService.getClientInfo());
    }

    @GetMapping(value = "/company/info")
    public ResponseEntity<CompanyInfoResponseTo> getCompanyInfo() throws Exception {
        return ResponseEntity.ok(clientService.getCompanyInfo());
    }
}

