package com.example.ggq.myweekthree.di;

import android.util.Log;

import com.example.ggq.myweekthree.entity.NewsEntity;

import java.lang.ref.WeakReference;
import java.util.List;

public class PresenterImpl implements Icontract.IPresenter<Icontract.IView>{
    private Icontract.IView iview;
    private ModelImpl moudleimp;
    private WeakReference<Icontract.IView> iviewWeakReference;
    private WeakReference<Icontract.IModel> weakReference;
    private static final String TAG = "PresenterImpl";

    @Override
    public void attachview(Icontract.IView iview) {
        this.iview = iview;
        moudleimp = new ModelImpl();
        //创建弱引用
        iviewWeakReference = new WeakReference<>(iview);
        weakReference = new WeakReference<Icontract.IModel>(moudleimp);
    }

    @Override
    public void requestinfo(String keywords,String page) {
        moudleimp.requestdata(new Icontract.IModel.onCallBackListener() {
            @Override
            public void responsemsg(List<NewsEntity.DataBean> dataBeans) {
                Log.d(TAG, "responsemsg: "+dataBeans);
                iview.showdata(dataBeans);
            }
        },keywords,page);
    }
    @Override
    public void detachview(Icontract.IView iview) {
        //取消关联
        iviewWeakReference.clear();
        weakReference.clear();
    }
}
