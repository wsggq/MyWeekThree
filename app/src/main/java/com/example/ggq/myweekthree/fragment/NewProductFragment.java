package com.example.ggq.myweekthree.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ggq.myweekthree.R;
import com.example.ggq.myweekthree.adapter.NewsProductAdapter;
import com.example.ggq.myweekthree.di.Icontract;
import com.example.ggq.myweekthree.di.PresenterImpl;
import com.example.ggq.myweekthree.entity.NewsEntity;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;
import java.util.List;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class NewProductFragment extends Fragment implements Icontract.IView, OnRefreshListener, View.OnClickListener, XRecyclerView.LoadingListener {
    private static final String TAG = "NewProductFragment";
    @BindView(R.id.xrecycler_view)
    XRecyclerView xrecyclerView;
    @BindView(R.id.refreshLayout)
    SmartRefreshLayout refreshLayout;
    @BindView(R.id.tv_bug)
    TextView tv_bug;
    Unbinder unbinder;
    private PresenterImpl presenter;
    private int page = 1;
    private List<NewsEntity.DataBean> list = new ArrayList<>();

    public NewProductFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_new_product, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        presenter = new PresenterImpl();
        presenter.attachview(this);
        presenter.requestinfo("笔记本",page+"");
        xrecyclerView.setLoadingMoreEnabled(true);
        refreshLayout.setOnRefreshListener(this);
        xrecyclerView.setLoadingListener(this);
        //refreshLayout.setOnLoadMoreListener(this);
        tv_bug.setOnClickListener(this);
        //设置布局管理器
        GridLayoutManager manager = new GridLayoutManager(getActivity(), 2, GridLayoutManager.VERTICAL, false);
        xrecyclerView.setLayoutManager(manager);
        NewsProductAdapter adapter = new NewsProductAdapter(getActivity(), list);
        //设置适配器
        xrecyclerView.setAdapter(adapter);
    }

    @Override
    public void showdata(List<NewsEntity.DataBean> newsEntities) {
        Log.d(TAG, "showdata: "+newsEntities);
        list.addAll(newsEntities);
        refreshLayout.finishRefresh();//结束下拉
        refreshLayout.finishLoadMore();//结束上拉
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
        presenter.detachview(this);
    }

    @Override
    public void onRefresh(@NonNull RefreshLayout refreshLayout) {
        page = 1;
        presenter.requestinfo("笔记本",page+"");
    }

    @Override
    public void onClick(View v) {
        int a= Integer.parseInt("q");//当用户点击按钮的时候特意写了一个异常
    }

    @Override
    public void onRefresh() {

    }

    @Override
    public void onLoadMore() {
        page++;
        Log.d(TAG, "onLoadMore: "+page);
        presenter.requestinfo("笔记本",page+"");
        xrecyclerView.loadMoreComplete();
    }
}
