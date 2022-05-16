package com.bsuir.localchain.to.controller.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MakeTransferRequestTo {
    private String targetWalletId;
    private BigDecimal amount;
}
