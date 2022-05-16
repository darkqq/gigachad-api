package com.bsuir.localchain.to.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorDetailsTO {
    private String status;
    private String code;
    private String details;
    private String reason;
    private String message;
}
