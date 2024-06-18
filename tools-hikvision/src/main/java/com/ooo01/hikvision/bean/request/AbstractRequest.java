package com.ooo01.hikvision.bean.request;

import com.ooo01.hikvision.property.ArtemisApiProperties;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Component
public abstract class AbstractRequest {
    private final String uri;
    @Resource
    private ArtemisApiProperties artemisApiProperties;
    
    public AbstractRequest(String uri) {
        this.uri = uri;
    }
    
    public Map<String, String> getPath() {
        /**
         * STEP3：设置接口的URI地址
         */
        final String url = artemisApiProperties.getPath() + uri;
        Map<String, String> path = new HashMap<String, String>(2) {
            {
                put("https://", url);// 根据现场环境部署确认是http还是https
            }
        };
        return path;
    }
    
    public abstract String execute();
}
