//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.bsuir.localchain.properties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class WebClientConfigProperties {
    private Integer connectTimeout = 10000;
    private Integer readTimeout  = 10000;
    private Integer writeTimeout  = 10000;
    private Integer maxConnections  = 10000;
    private Integer maxAcquireTime  = 10000;
    private Integer maxIdleTime = 10000;
    private Integer maxLifeTime = 10000;
}
