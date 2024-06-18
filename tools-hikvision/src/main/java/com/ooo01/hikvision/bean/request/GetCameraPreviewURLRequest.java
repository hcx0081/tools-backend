package com.ooo01.hikvision.bean.request;

import com.alibaba.fastjson2.JSONObject;
import com.hikvision.artemis.sdk.ArtemisHttpUtil;

public class GetCameraPreviewURLRequest extends AbstractRequest {
    public GetCameraPreviewURLRequest() {
        super("/api/video/v1/cameras/previewURLs");
    }
    
    public static void main(String[] args) {
        String result = new GetCameraPreviewURLRequest().execute();
        System.out.println("result结果示例: " + result);
    }
    
    @Override
    public String execute() {
        /**
         * STEP4：设置参数提交方式
         */
        String contentType = "application/json";
        
        /**
         * STEP5：组装请求参数
         */
        JSONObject jsonBody = new JSONObject();
        jsonBody.put("cameraIndexCode", "748d84750e3a4a5bbad3cd4af9ed5101");
        jsonBody.put("streamType", 0);
        jsonBody.put("protocol", "rtsp");
        jsonBody.put("transmode", 1);
        jsonBody.put("expand", "streamform=ps");
        String body = jsonBody.toJSONString();
        /**
         * STEP6：调用接口
         */
        String result = ArtemisHttpUtil.doPostStringArtemis(getPath(), body, null, null, contentType, null);// post请求application/json类型参数
        return result;
    }
}
