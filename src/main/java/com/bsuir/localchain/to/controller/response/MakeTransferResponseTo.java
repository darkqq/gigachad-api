package com.bsuir.localchain.to.controller.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MakeTransferResponseTo {
    private String status;
    private String transaction;
}
