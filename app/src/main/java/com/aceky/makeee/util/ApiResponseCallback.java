package com.aceky.makeee.util;

public interface ApiResponseCallback<T> {
    void onSuccess(T response);
    void onError(String errorMessage);
}
