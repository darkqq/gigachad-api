package com.bsuir.localchain.to.controller.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCompanyResponseTo {
    private String adminToken;
    private String name;
    private String tokenName;
}
