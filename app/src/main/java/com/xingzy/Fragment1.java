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

/**
 * @author roy.xing
 * @date 2019/3/6
 */
public class Fragment1 extends Fragment {

    public static Fragment1 getInstance(){
        return new Fragment1();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_layout1, container, false);
        view.findViewById(R.id.root_layout).setBackgroundColor(Color.parseColor("#00FF00"));
        view.findViewById(R.id.button1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FunctionManager.getInstance().invoke("function1");
            }
        });
        FunctionManager.getInstance().registerMethod(new Function2<String>("function2") {
            @Override
            public void function(String s) {
                Log.e("===>Fragment1", "function2接受成功");
            }
        });

        return view;
    }
}
