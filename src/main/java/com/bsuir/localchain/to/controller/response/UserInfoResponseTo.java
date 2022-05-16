package com.bsuir.localchain.to.controller.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInfoResponseTo {
    private String username;
    private BigDecimal balance;
    private List<String> transactions ;
    private String wallet;
}
