package it.lorenzotanzi.fragmentdemo;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Fragment2 extends Fragment implements View.OnClickListener{


    Fragment2Listener activityCallback;


    private Button btn_1;
    private Button btn_2;
    private TextView tv_text;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_2, container, false);
        tv_text = (TextView) view.findViewById(R.id.rv_title2);
        btn_1 = (Button) view.findViewById(R.id.btn_1);
        btn_2 = (Button) view.findViewById(R.id.btn_2);
        btn_1.setOnClickListener(this);
        btn_2.setOnClickListener(this);
        return view;
    }

     @Override
     public void onAttach(Context context){
        super.onAttach(context);

        try {
            activityCallback = (Fragment2Listener) context;
        }catch (ClassCastException e){
            throw new ClassCastException(context.toString() + "must implement Fragment2Listener interface");
        }
     }

     @Override
     public void onDetach(){
        super.onDetach();
        activityCallback = null;
     }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btn_1){
            activityCallback.onFragment2Button1Click();
        }

        if (view.getId() == R.id.btn_2){
            activityCallback.onFragment2Button2Click();
        }

    }

    public interface Fragment2Listener {

        public void onFragment2Button1Click();

        public void onFragment2Button2Click();
    }
}