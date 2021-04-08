package com.example.tang.Ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.tang.R;

public class DiscoverFragment extends Fragment {

    int[] img = {R.drawable.pop_img1, R.drawable.pop_img2, R.drawable.pop_img3, R.drawable.pop_img4, R.drawable.pop_img5, R.drawable.pop_img6};
    String[] descript = {"[👄]正派对，等你前来", "[🐼]纯纯欲动", "PERFECT DIARY-朱正廷", "[🐯]优雅野性，一眼攻陷", "灿烂如洒落的霞光", "【🐱】慵懒魅惑"};
    LinearLayout line1;
    ImageView item_img;
    TextView item_text;

    @Nullable
    @Override

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup viewGroup, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.discover, null);
        line1 = view.findViewById(R.id.line1);
        for (int i = 0; i < img.length; i++) {
            View view1 = LayoutInflater.from(getContext()).inflate(R.layout.horizontal_item,null);
            item_img = view1.findViewById(R.id.item_img);
            item_text = view1.findViewById(R.id.item_text);
            item_img.setBackgroundResource(img[i]);
            item_text.setText(descript[i]);
            line1.addView(view1);
        }
        return view;
    }


}
