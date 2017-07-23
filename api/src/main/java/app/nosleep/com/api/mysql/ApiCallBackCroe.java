package app.nosleep.com.api.mysql;

import app.nosleep.com.model.Response;

/**
 * Created by nosleep on 16-9-16.
 * 日期：16-9-16下午5:53
 * author:zzh
 * override:
 */

public interface ApiCallBackCroe<T> {

    public void onSuccess(Response<T> Data);

    public void onFailure(int errorEvent, String message);
}
