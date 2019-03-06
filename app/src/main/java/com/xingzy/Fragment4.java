package com.xingzy;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * @author roy.xing
 * @date 2019/3/6
 */
public class Fragment4 extends Fragment {

    public static Fragment4 getInstance() {
        return new Fragment4();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_layout1, container, false);
        view.findViewById(R.id.root_layout).setBackgroundColor(Color.parseColor("#000FF0"));
        ((Button) view.findViewById(R.id.button1)).setText("Button4");
        view.findViewById(R.id.button1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                User user = FunctionManager.getInstance().invoke("function4", User.class, new User("aaaaa", "1111111"));
                Log.e("===>Fragment4", "function4返回值接受成功" + user.getName() + user.getPwd());
            }
        });

        return view;
    }
}
