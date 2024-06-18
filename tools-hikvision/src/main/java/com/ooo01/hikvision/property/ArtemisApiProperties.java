package com.ooo01.hikvision.property;

import com.hikvision.artemis.sdk.config.ArtemisConfig;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.annotation.PostConstruct;

/**
 * {@code @description:} 海康威视API配置项类
 */
@Configuration
@PropertySource({"classpath:api-config.properties"})
@ConfigurationProperties(prefix = "artemis.api")
@Data
public class ArtemisApiProperties {
    /**
     * STEP2：设置OpenAPI接口的上下文
     */
    private String path;
    private String host;
    private String appKey;
    private String appSecret;
    
    @PostConstruct
    public void iniConfig() {
        /**
         * STEP1：设置平台参数，根据实际情况,设置host appkey appsecret 三个参数.
         */
        ArtemisConfig.host = this.host;// 平台的ip端口
        ArtemisConfig.appKey = this.appKey;// 密钥appkey
        ArtemisConfig.appSecret = this.appSecret;// 密钥appSecret
    }
}
