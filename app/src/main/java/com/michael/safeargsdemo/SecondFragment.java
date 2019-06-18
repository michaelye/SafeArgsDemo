package com.michael.safeargsdemo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class SecondFragment extends Fragment
{

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        setHasOptionsMenu(true);
        View view = inflater.inflate(R.layout.fragment_second, container, false);

        //未采用safe args的接收方式
//        Bundle bundle = getArguments();
//        if(bundle != null)
//        {
//            String userName = bundle.getString("user_name");
//            int age = bundle.getInt("age");
//            TextView tvSub = view.findViewById(R.id.tvSub);
//            tvSub.setText(userName + age);
//        }

        //通过safe args完成参数接收
        Bundle bundle = getArguments();
        if(bundle != null)
        {
            String userName = MainFragmentArgs.fromBundle(getArguments()).getUserName();
            int age = MainFragmentArgs.fromBundle(getArguments()).getAge();
            TextView tvSub = view.findViewById(R.id.tvSub);
            tvSub.setText(userName + age);
        }
        return view;
    }
}
