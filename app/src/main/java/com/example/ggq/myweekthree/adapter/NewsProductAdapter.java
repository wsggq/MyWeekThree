package com.example.ggq.myweekthree.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ggq.myweekthree.R;
import com.example.ggq.myweekthree.entity.NewsEntity;
import com.facebook.drawee.view.SimpleDraweeView;
import java.util.List;
import butterknife.BindView;
import butterknife.ButterKnife;

public class NewsProductAdapter extends RecyclerView.Adapter<NewsProductAdapter.ViewHolder> {
    private Context context;
    private List<NewsEntity.DataBean> dataBean;
    private static final String TAG = "NewsProductAdapter";
    public NewsProductAdapter(Context context, List<NewsEntity.DataBean> dataBean) {
        this.context = context;
        this.dataBean = dataBean;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recycler_list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        NewsEntity.DataBean list = dataBean.get(position);
        String[] split = list.getImages().split("\\|");
        holder.sdvImg.setImageURI(split[0]);
        holder.tvTitle.setText(list.getTitle());
        holder.tvPrice.setText("¥"+list.getPrice());
    }

    @Override
    public int getItemCount() {
        return dataBean.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.sdv_img)
        SimpleDraweeView sdvImg;
        @BindView(R.id.tv_title)
        TextView tvTitle;
        @BindView(R.id.tv_price)
        TextView tvPrice;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
