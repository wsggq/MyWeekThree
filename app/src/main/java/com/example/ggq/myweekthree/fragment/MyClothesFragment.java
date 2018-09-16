package com.example.ggq.myweekthree.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ExpandableListView;
import android.widget.TextView;
import com.example.ggq.myweekthree.R;
import com.example.ggq.myweekthree.entity.ShopCarEntity;
import com.itheima.retrofitutils.ItheimaHttp;
import com.itheima.retrofitutils.listener.HttpResponseListener;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import retrofit2.Call;

/**
 * A simple {@link Fragment} subclass.
 */
public class MyClothesFragment extends Fragment {
    private static final String TAG = "MyClothesFragment";

    public MyClothesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_my_clothes, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        loadData();
    }

    private void loadData() {
        Call call = ItheimaHttp.postAsync("https://www.zhaoapi.cn/product/getCarts?uid=17505", new HttpResponseListener<ShopCarEntity>() {
            @Override
            public void onResponse(ShopCarEntity shopCarEntity) {
                Log.d(TAG, "onResponse: "+shopCarEntity.getData().toString());
            }
        });
    }
}
