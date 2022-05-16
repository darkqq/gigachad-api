package com.bsuir.localchain.to.controller.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EnrolUserResponseTo {
    private String token;
    private String transactionId;
    private String wallet;
}
