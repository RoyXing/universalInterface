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
public class Fragment2 extends Fragment {

    public static Fragment2 getInstance() {
        return new Fragment2();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_layout1, container, false);
        view.findViewById(R.id.root_layout).setBackgroundColor(Color.parseColor("#FF0000"));
        ((Button) view.findViewById(R.id.button1)).setText("Button2");
        view.findViewById(R.id.button1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FunctionManager.getInstance().invoke("function2", "hahahaha");
            }
        });

        FunctionManager.getInstance().registerMethod(new Function3<User>("function3") {
            @Override
            public User function() {
                Log.e("===>Fragment2", "function3接受成功");
                return new User("hahaha", "11111");
            }
        });
        return view;
    }
}
