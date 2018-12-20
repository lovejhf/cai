package com.caicai.web.app.http;


import com.alibaba.fastjson.JSON;
import com.caicai.web.app.util.Constant;
import com.hjq.toast.ToastUtils;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.HttpParams;
import com.lzy.okgo.model.Response;
import com.lzy.okgo.request.PostRequest;

import java.io.IOException;
import java.util.Map;


public class HttpUtil {
    private static HttpUtil instance = null;
    private HttpUtil() {
    }

    public static synchronized HttpUtil getInstance() {
        if (instance == null) {
            synchronized (HttpUtil.class) {
                if (instance == null) {
                    instance = new HttpUtil();
                }
            }
        }
        return instance;
    }

    public void post(final String url, Map<String,Object> map, final HttpHandler httpHandler) {
        OkGo.<String> post(Constant.SERVER_PATH+url).tag(this).upJson(JSON.toJSONString(map)).execute(new StringCallback() {
            @Override
            public void onSuccess(Response<String> response) {
                /**
                 * 进行登录  刷新数据
                 *   httpHandler.requestLoginSuccess();自动登录成功回调
                 */
                httpHandler.requestSuccess(response.body());
            }
            @Override
            public void onError(Response<String> response) {
                super.onError(response);
                ToastUtils.show("似乎与服务器断开了");
                httpHandler.requestError(response.body());
            }
        });

    }


    public void get(final String url, HttpParams map, final HttpHandler httpHandler) {
        OkGo.<String> get(Constant.SERVER_PATH+url).params(map).execute(new StringCallback() {
            @Override
            public void onSuccess(Response<String> response) {
                /**
                 * 进行登录  刷新数据
                 *   httpHandler.requestLoginSuccess();自动登录成功回调
                 */
                httpHandler.requestSuccess(response.body());
            }
            @Override
            public void onError(Response<String> response) {
                super.onError(response);
                ToastUtils.show("似乎与服务器断开了");
                httpHandler.requestError(response.body());
            }
        });

    }
    public void post(final String url, final HttpHandler httpHandler) {
        OkGo.<String>post(Constant.SERVER_PATH + url)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        //json解析判断是否需要登录如果已登录否则进行登录
                        /**
                         * 进行登录  刷新数据
                         *   httpHandler.requestLoginSuccess();自动登录成功回调
                         */
                        //返回body
                        httpHandler.requestSuccess(response.body());
                    }

                    @Override
                    public void onError(Response<String> response) {
                        super.onError(response);

                        httpHandler.requestError(response.body());

                    }
                });


    }

    /**
     * 同步请求
     *
     * @param url
     * @param map
     * @return
     */
    public String post(String url, HttpParams map) {
        String response = "";
        PostRequest request = OkGo.<String>post(Constant.SERVER_PATH + url);
        request.params(map);
        try {
            response = request.execute().body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return response;
    }

}
