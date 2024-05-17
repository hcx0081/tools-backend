package com.ooo01.business.property;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties("xxx.xxx")
public class AAADemoProperties {
    private String xxx;
}
