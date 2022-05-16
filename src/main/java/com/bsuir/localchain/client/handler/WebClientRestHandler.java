//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.bsuir.localchain.client.handler;


import java.util.Objects;

import com.bsuir.localchain.to.common.ErrorCommon;
import com.bsuir.localchain.to.common.ErrorDetailsTO;
import com.bsuir.localchain.to.common.ErrorsTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

@Component("web-client-rest-handler")
public class WebClientRestHandler extends WebClientAbstractHandler {
    private static final Logger log = LoggerFactory.getLogger(WebClientRestHandler.class);

    public WebClientRestHandler() {
    }

    public <T> T handleResponseEntity(ResponseEntity<T> responseEntity) throws Exception {
        T response = null;
        if (responseEntity != null) {
            if (!responseEntity.getStatusCode().is2xxSuccessful()) {
                String errorCode = null;
                String errorMessage = null;
                if (responseEntity.getBody() instanceof ErrorsTO) {
                    ErrorDetailsTO errorDetailsTO = null;
                    ErrorsTO errorsTO = (ErrorsTO)responseEntity.getBody();
                    if (!CollectionUtils.isEmpty(errorsTO.getErrors())) {
                        errorDetailsTO = errorsTO.getErrors().get(0);
                    }

                    if (Objects.nonNull(errorDetailsTO)) {
                        errorCode = errorDetailsTO.getCode();
                        errorMessage = errorDetailsTO.getMessage();
                    }
                }

                if (responseEntity.getStatusCode().is4xxClientError()) {
                    throw new Exception(errorMessage);
                }
                if(responseEntity.getStatusCode().is5xxServerError()){
                    throw new Exception(responseEntity.toString());
                }

                throw new Exception(errorMessage);
            }

            response = responseEntity.getBody();
        }

        return response;
    }
}
