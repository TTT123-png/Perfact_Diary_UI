package com.example.tang;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class HotAdapter extends RecyclerView.Adapter<HotAdapter.holder> {
    private Context mcontext;
    private ImageView img_view;
    private TextView text_view;
    private TextView num_view;
    private List<HotConstructor> dataSource = new ArrayList<HotConstructor>();


    public HotAdapter(Context context) {
        this.mcontext = context;
        initData();
    }


    @NonNull
    @Override
    public holder onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {
        return new holder(LayoutInflater.from(mcontext).inflate(R.layout.hot_recycleview, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull holder holder, int position) {
        HotConstructor hotList = dataSource.get(position);
        LinearLayout.LayoutParams params1 = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, getRandomIMG());
        img_view.setLayoutParams(params1);
        img_view.setBackgroundResource(getImg(position));
        text_view.setText(hotList.getTitle());
        num_view.setText(hotList.getNum() + "");

    }

    @Override
    public int getItemCount() {
        return dataSource.size() ;
    }

    class holder extends RecyclerView.ViewHolder {
        public holder(@NonNull View itemView) {
            super(itemView);
            img_view = itemView.findViewById(R.id.img_view);
            text_view = itemView.findViewById(R.id.text_view);
            num_view = itemView.findViewById(R.id.num_view);

        }
    }

    public int getImg(int position) {
        switch (position % 6) {
            case 0:
                return R.drawable.a1;
            case 1:
                return R.drawable.b1;
            case 2:
                return R.drawable.c1;
            case 3:
                return R.drawable.d1;
            case 4:
                return R.drawable.f1;
            case 5:
                return R.drawable.g1;

        }
        return 0;
    }

    /* public void  initData(){
         for (int index = 0; index < 20; index++) {
             String s = "这是第"+index+"条标题";
             dataSource.add(s);
         }
       }*/
    /*返回不同的itemview的高度*/
    private int getRandomIMG() {
        return (int) (Math.random() * 300 + 400);
    }

    private void initData() {
        String[] Title = {"#完美日记睫毛打底膏", "#平价美妆雾面唇釉", "#九色眼影", "#沙漠玫瑰土豆泥十六色眼影", "#白胖子氨基酸卸妆水", "#小金盖粉底液"};
        int[] num = {233, 45, 65, 867, 999, 789};
        //int[] img = {R.drawable.a1, R.drawable.b1, R.drawable.c1, R.drawable.d1, R.drawable.e1, R.drawable.f1};
        for (int index = 0; index < Title.length; index++) {
            HotConstructor hcs = new HotConstructor();
            hcs.setTitle(Title[index]);
            hcs.setNum(num[index]);
            dataSource.add(hcs);
        }


    }
}