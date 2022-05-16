package com.bsuir.localchain.properties;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

@Component
@Data
@RefreshScope
public class ConfigPropertiesComponent {
    @Value("https://localhost:7054")
    private String hyperledgerUrlBase;

    @Value("${path.internal.api.base}")
    private String internalApiUrlBase;

    @Value("${path.internal.api.make-transfer}")
    private String makeTransferPath;

    @Value("${path.internal.api.get-company-data}")
    private String companyDataPath;

    @Value("${path.internal.api.get-user-data}")
    private String userDataPath;

    @Value("${path.internal.api.enroll}")
    private String enrollPath;

    @Value("${path.internal.api.register-company}")
    private String registerCompanyPath;

    @Value("${path.internal.api.mint}")
    private String mintTokensPath;
}
