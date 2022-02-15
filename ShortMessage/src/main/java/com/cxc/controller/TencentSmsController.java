package com.cxc.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import com.tencentcloudapi.common.Credential;
import com.tencentcloudapi.common.profile.ClientProfile;
import com.tencentcloudapi.common.profile.HttpProfile;
import com.tencentcloudapi.common.exception.TencentCloudSDKException;
import com.tencentcloudapi.sms.v20210111.SmsClient;
import com.tencentcloudapi.sms.v20210111.models.*;


//欢迎使用腾讯云开发者工具套件（SDK）3.0，
@RestController
public class TencentSmsController {
    @GetMapping("saytencent")
    public String say(){
        return "say";
    }

    @GetMapping("sendSmsTencent")
    public String sendSmsTencent(String[] phoneNumbers, String templateId, String[] templateParam ) {
        String result = new String();
        try{
            // 实例化一个认证对象，入参需要传入腾讯云账户secretId，secretKey,此处还需注意密钥对的保密
            // 密钥可前往https://console.cloud.tencent.com/cam/capi网站进行获取
            Credential cred = new Credential("AKIDylHXWFitnRovrc9RTFm47vTmpb7OREm6", "6wWqvjIcgU2KNBj26uSkmZ6UfaEafU5u");
            // 实例化一个http选项，可选的，没有特殊需求可以跳过
            HttpProfile httpProfile = new HttpProfile();
            httpProfile.setEndpoint("sms.tencentcloudapi.com");
            // 实例化一个client选项，可选的，没有特殊需求可以跳过
            ClientProfile clientProfile = new ClientProfile();
            clientProfile.setHttpProfile(httpProfile);
            // 实例化要请求产品的client对象,clientProfile是可选的
            SmsClient client = new SmsClient(cred, "ap-guangzhou", clientProfile);
            // 实例化一个请求对象,每个接口都会对应一个request对象
            SendSmsRequest req = new SendSmsRequest();
            req.setSignName("回形针个人网");
            req.setSmsSdkAppId("1400622868");
            req.setPhoneNumberSet(phoneNumbers);
            req.setTemplateId(templateId);
            req.setTemplateParamSet(templateParam);
            // 返回的resp是一个SendSmsResponse的实例，与请求对象对应
            SendSmsResponse resp = client.SendSms(req);
            // 输出json格式的字符串回包
            System.out.println(SendSmsResponse.toJsonString(resp));
            result = SendSmsResponse.toJsonString(resp);
        } catch (TencentCloudSDKException e) {
            System.out.println(e.toString());
        }
        return result;
    }
}
