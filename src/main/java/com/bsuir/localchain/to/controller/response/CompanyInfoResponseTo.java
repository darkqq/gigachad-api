package com.bsuir.localchain.to.controller.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompanyInfoResponseTo {
    private String name;
    private String tokenName;
    private BigDecimal totalTokensMinted;
}
