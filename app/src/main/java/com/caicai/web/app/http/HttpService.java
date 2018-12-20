package com.caicai.web.app.http;


public interface HttpService {
    void Login(String uid, String password, HttpHandler httpHandler);
    void Remove(String uid, String password, HttpHandler httpHandler);
    void GetCompanyUserInfo(String uid, HttpHandler httpHandler);
    void GetBanner(String companyCode, HttpHandler httpHandler);
    void GetProjectCate(String usercode, HttpHandler httpHandler);

}
