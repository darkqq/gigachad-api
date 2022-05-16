package com.bsuir.localchain.to.controller.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCompanyRequestTo {
    private String companyName;
    private String tokenName;
}
