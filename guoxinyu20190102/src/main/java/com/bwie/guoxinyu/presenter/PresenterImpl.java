package com.bwie.guoxinyu.presenter;

import com.bwie.guoxinyu.model.ModelImpl;
import com.bwie.guoxinyu.model.MyCallBack;
import com.bwie.guoxinyu.view.Iview;

import java.util.Map;

public class PresenterImpl implements Ipresenter {
    private Iview mIview;
    private ModelImpl model;

    public PresenterImpl(Iview iview) {
        mIview = iview;
        model = new ModelImpl();
    }

    /**
     * post
     */
    @Override
    public void reqyestPost(String url, Map<String, String> map, Class clazz) {
        model.requestPost(url, map, clazz, new MyCallBack() {
            @Override
            public void onSuccess(Object o) {
                mIview.requestData(o);
            }

            @Override
            public void onFail(String error) {
                mIview.requestFail(error);
            }
        });
    }

    /**
     * get
     */
    @Override
    public void requestGet(String url, Class clazz) {

    }

    public void onDetach() {
        if (mIview != null) {
            mIview = null;
        }
        if (model != null) {
            model = null;
        }
    }
}
