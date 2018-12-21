package com.ntcai.ntcc.http;



/**
 * Created by Administrator on 2018\2\28 0028.
 */

public interface HttpHandler {
    public abstract void requestSuccess(String response);
    public abstract void requestError(String error);
}
