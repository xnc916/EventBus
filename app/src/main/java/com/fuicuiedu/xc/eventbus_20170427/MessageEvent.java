package com.fuicuiedu.xc.eventbus_20170427;

/**
 * Created by Administrator on 2017/4/27 0027.
 */

public class MessageEvent {

    private String message;

    public MessageEvent(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
