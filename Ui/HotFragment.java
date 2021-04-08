package com.example.tang.Ui;

import android.content.Context;
import android.icu.lang.UCharacter;
import android.os.Bundle;
import android.service.autofill.FieldClassification;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.tang.HotAdapter;
import com.example.tang.R;

import java.util.ArrayList;
import java.util.List;

public class HotFragment<hotConstructor> extends Fragment {
    private Context context;
    private ViewPager img_viewpager;
    private List<View> mList = new ArrayList<>();
    private LinearLayout circle;

    private int[] mImag = new int[4];

    private List<ImageView> dotList = new ArrayList<>();
    private RecyclerView recycleView;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.hot, null);
        //part1的轮播图
        img_viewpager = view.findViewById(R.id.img_viewpager);
        img_viewpager.setAdapter(pagerAdapter);

        //初始化轮播图的图片
        setmLIstImg();
        //将img_viewpager设置点击监听事件，将图片的轮播与小圆点的事件联系起来
        img_viewpager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                setCircle(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        //轮播图中的小圆点
        circle = view.findViewById(R.id.circle);
        //设置小圆点的个数是图片数
        setDot();

        //设置recycleview的adapter

        recycleView = view.findViewById(R.id.recycleView);
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
       recycleView.setLayoutManager(staggeredGridLayoutManager);

        HotAdapter hotAdapter = new HotAdapter(getContext());
        recycleView.setAdapter(hotAdapter);

        return view;

    }

    //设置小圆点的个数是图片数
    private void setDot() {
        for (int i = 0; i < mImag.length; i++) {
            ImageView imageView = new ImageView(getContext());
            imageView.setBackgroundResource(R.drawable.pointer);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT);
            layoutParams.rightMargin = 15;
            imageView.setLayoutParams(layoutParams);
            dotList.add(imageView);
            //初始化第一个圆点
            dotList.get(0).setBackgroundResource(R.drawable.pointer_used);
            circle.addView(imageView);
        }
    }


    //初始化轮播图的图片
    private void setmLIstImg() {
        //将图片new出来并放在mList里面
        ImageView imageView1 = new ImageView(getContext());
        imageView1.setBackgroundResource(R.drawable.pop_img1);
        mList.add(imageView1);
        ImageView imageView2 = new ImageView(getContext());
        imageView2.setBackgroundResource(R.drawable.pop_img2);
        mList.add(imageView2);
        ImageView imageView3 = new ImageView(getContext());
        imageView3.setBackgroundResource(R.drawable.pop_img3);
        mList.add(imageView3);
        ImageView imageView4 = new ImageView(getContext());
        imageView4.setBackgroundResource(R.drawable.pop_img4);
        mList.add(imageView4);
    }

    //part1的轮播图的adapter
    PagerAdapter pagerAdapter = new PagerAdapter() {
        @Override
        public int getCount() {
            return 4;
        }

        @Override
        public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
            return view == object;
        }

        @NonNull
        @Override
        public Object instantiateItem(@NonNull ViewGroup container, int position) {
            //用position得到当前的视图
            View child = mList.get(position);
            //再将视图添加到container中
            container.addView(child);
            return child;
        }

        @Override
        public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
            container.removeView(mList.get(position));
        }
    };

    //小圆点的选中与为选中的样式设置
    public void setCircle(int position) {
        for (int index = 0; index < mImag.length; index++) {
            dotList.get(index).setBackgroundResource(index == position ? R.drawable.pointer_used : R.drawable.pointer);

        }

    }



}
