package com.michael.safeargsdemo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.navigation.Navigation;


/**
 *
 */
public class MainFragment extends Fragment
{

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        view.findViewById(R.id.btnToSecondFragment).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

                //未采用safe args的传递方式
//                Bundle bundle = new Bundle();
//                bundle.putString("user_name", "Michael");
//                bundle.putInt("age", 30);
//                Navigation.findNavController(v).navigate(R.id.action_mainFragment_to_secondFragment, bundle);

                //通过safe args完成参数传递
                Bundle bundle = new MainFragmentArgs.Builder().setUserName("Michael").setAge(30).build().toBundle();
                Navigation.findNavController(v).navigate(R.id.action_mainFragment_to_secondFragment, bundle);
            }
        });

        return view;
    }
}
