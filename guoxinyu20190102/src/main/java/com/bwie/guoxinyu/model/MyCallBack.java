package com.bwie.guoxinyu.model;

public interface MyCallBack<E> {
    void onSuccess(E e);
    void onFail(String error);
}
