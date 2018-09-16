package com.example.ggq.myweekthree;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.ggq.myweekthree.fragment.ChoicenessFragment;
import com.example.ggq.myweekthree.fragment.ClassifyFragment;
import com.example.ggq.myweekthree.fragment.MyClothesFragment;
import com.example.ggq.myweekthree.fragment.NewProductFragment;
import com.example.ggq.myweekthree.fragment.PersonalCenterFragment;
import com.hjm.bottomtabbar.BottomTabBar;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.bottom_tab_bar)
    BottomTabBar bottomTabBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        bottomTabBar.init(getSupportFragmentManager())
                .setFontSize(16)
                .setImgSize(100, 100)
                .addTabItem("新品", R.mipmap.new_icon_press, R.mipmap.new_icon, NewProductFragment.class)
                .addTabItem("精选", R.mipmap.choice_icon_press, R.mipmap.choice_icon, ChoicenessFragment.class)
                .addTabItem("分类", R.mipmap.classify_icon_press, R.mipmap.classify_icon, ClassifyFragment.class)
                .addTabItem("我的衣服", R.mipmap.wardrobe_icon_press, R.mipmap.wardrobe_icon, MyClothesFragment.class)
                .addTabItem("个人中心", R.mipmap.person_icon_press, R.mipmap.person_icon, PersonalCenterFragment.class);
    }
}
