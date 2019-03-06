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
public class Fragment3 extends Fragment {

    public static Fragment3 getInstance() {
        return new Fragment3();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_layout1, container, false);
        view.findViewById(R.id.root_layout).setBackgroundColor(Color.parseColor("#0000FF"));
        ((Button) view.findViewById(R.id.button1)).setText("Button3");
        view.findViewById(R.id.button1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                User user = FunctionManager.getInstance().invoke("function3", User.class);
                Log.e("===>Fragment3", "function3返回值接受成功" + user.getName() + user.getPwd());
            }
        });

        FunctionManager.getInstance().registerMethod(new Function4<User,User>("function4") {
            @Override
            public User function(User o) {
                o.setName("bbbb");
                o.setPwd("123456bbbb");
                Log.e("===>Fragment3", "function4接受成功");
                return o;
            }
        });


        return view;
    }
}
