package app.nosleep.com.core.mysql;

/**
 * Created by nosleep on 16-8-11.
 *
 */

public interface ActionCallBackListener<T> {

    public void onSuccess(T Data);

    public void onFailure(String errorEvent, String message);
}
