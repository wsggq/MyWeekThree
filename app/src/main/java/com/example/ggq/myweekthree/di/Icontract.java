package com.example.ggq.myweekthree.di;

import com.example.ggq.myweekthree.entity.NewsEntity;
import java.util.List;

public interface Icontract {
    public interface  IView{
        void showdata(List<NewsEntity.DataBean> dataBeans);
    }
    public interface IPresenter<iview>{
        //关联
        void attachview(iview iview);
        //取消
        void detachview(iview iview);
        //逻辑方法
        void requestinfo(String keywords, String page);
    }
    public  interface  IModel{
        //接口
        public  interface  onCallBackListener{
            //请求方法
            void responsemsg(List<NewsEntity.DataBean> dataBeans);
        }
        //方法
        void requestdata(onCallBackListener onCallBackListener, String keywords, String page);
    }
}
