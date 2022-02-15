package com.cxc.po;

import com.google.gson.JsonObject;
import lombok.Data;

@Data
public class ShortMessageObject {
    private String templateCode;
    private String phoneNumbers;
    private String signName;
    private JsonObject templateParam;
}
