package com.cxc.controller;

import com.cxc.po.ShortMessageObject;
import com.google.gson.JsonObject;
import org.springframework.web.bind.annotation.GetMapping;
import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AliyunSmsController {

    @GetMapping("/sendVerificationCode")
    public String sendVerificationCode (String phoneNumbers){
        if(phoneNumbers==null){
            phoneNumbers="13564397327";
        }
        ShortMessageObject shortMessageObject = new ShortMessageObject();
        shortMessageObject.setPhoneNumbers(phoneNumbers);
        shortMessageObject.setTemplateCode("SMS_232167933");
        shortMessageObject.setSignName("家具商城");
        JsonObject templateParam=new JsonObject();
        templateParam.addProperty("code",Math.round(Math.random()*1000000));
        shortMessageObject.setTemplateParam(templateParam);
        return sendSms(shortMessageObject);
    }

    public String sendSms(ShortMessageObject shortMessageObject){
        DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", "LTAI5tShLPYQzSJBRkzeTaQR", "pa9oTD95qmzfOfgW4ldawvbIblG4sZ");
        IAcsClient client = new DefaultAcsClient(profile);
        CommonRequest request = new CommonRequest();
        request.setSysMethod(MethodType.POST);
        request.setSysDomain("dysmsapi.aliyuncs.com");
        request.setSysVersion("2017-05-25");
        request.setSysAction("SendSms");
        request.putQueryParameter("RegionId", "cn-hangzhou");
        request.putQueryParameter("PhoneNumbers", shortMessageObject.getPhoneNumbers());
        request.putQueryParameter("SignName", shortMessageObject.getSignName());
        request.putQueryParameter("TemplateCode", shortMessageObject.getTemplateCode());
        request.putQueryParameter("TemplateParam", shortMessageObject.getTemplateParam().toString());
        try {
            CommonResponse response = client.getCommonResponse(request);
            System.out.println(response.getData());
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            e.printStackTrace();
        }
        return "success";
    }
}
