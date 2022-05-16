package com.bsuir.localchain.to.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorsTO {
    private List<ErrorDetailsTO> errors;
}