package com.caicai.web.app.http;

import com.lzy.okgo.model.HttpParams;

import java.util.HashMap;
import java.util.Map;

public class IHttpService implements HttpService {
    private static IHttpService instance = null;

    private IHttpService() {
    }

    public static synchronized IHttpService getInstance() {
        if (instance == null) {
            synchronized (IHttpService.class) {
                if (instance == null) {
                    instance = new IHttpService();
                }
            }
        }
        return instance;
    }
    /**
     * 登录
     * @param uid
     * @param password
     * @param httpHandler
     */
    @Override
    public void Login(String uid, String password, HttpHandler httpHandler) {
        Map<String,Object> map = new HashMap<>();
        map.put("uid",uid);
        map.put("userpassword",password);
        HttpUtil.getInstance().post("CheckLogin", map, httpHandler);


    }

    @Override
    public void Remove(String uid, String password, HttpHandler httpHandler) {
        Map<String,Object> httpParams = new HashMap<>();
        httpParams.put("uid", uid);
        httpParams.put("userpassword", password);
        HttpUtil.getInstance().post("RemoveTeam", httpParams, httpHandler);
    }

    @Override
    public void GetCompanyUserInfo(String uid,HttpHandler httpHandler) {
       HttpParams httpParams = new HttpParams();
        httpParams.put("uid", uid);
        HttpUtil.getInstance().get("GetCompanyUserInfo", httpParams, httpHandler);
    }

    @Override
    public void GetBanner(String companyCode, HttpHandler httpHandler) {
        HttpParams httpParams = new HttpParams();
        httpParams.put("companyCode", companyCode);
        HttpUtil.getInstance().get("GetBanner", httpParams, httpHandler);
    }

    @Override
    public void GetProjectCate(String usercode, HttpHandler httpHandler) {
        HttpParams httpParams = new HttpParams();
        httpParams.put("usercode", usercode);
        HttpUtil.getInstance().get("GetProjectCate", httpParams, httpHandler);
    }
}
