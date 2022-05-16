package com.bsuir.localchain.to.client.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MakeTransferRs {
    private String status;
    private String transaction;
}
