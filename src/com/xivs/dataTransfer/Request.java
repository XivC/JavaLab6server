package com.xivs.dataTransfer;

import java.io.Serializable;
import java.util.HashMap;

/**
 * Класс стандартного ответа.
 * body хранит строковые поля
 * attachments хранит любые dataTransference
 */
public class Request implements Serializable {

    public final String method;
    public final HashMap<String, DataTransference<?>> attachments;

    public Request(String method, HashMap<String, DataTransference<?>> attachments) {

        this.method = method;
        this.attachments = attachments;
    }


}
