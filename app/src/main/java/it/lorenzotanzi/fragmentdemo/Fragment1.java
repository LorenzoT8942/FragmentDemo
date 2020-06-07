package it.lorenzotanzi.fragmentdemo;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


public class Fragment1 extends Fragment implements View.OnClickListener{

     Fragment1Listener activityCallback;
     private Button btn_1;
     private Button btn_2;
     private TextView tv_text;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_1, container, false);
        tv_text = (TextView) view.findViewById(R.id.tv_text);
        btn_1 = (Button) view.findViewById(R.id.btn_1);
        btn_2 = (Button) view.findViewById(R.id.btn_2);

        btn_1.setOnClickListener(this);
        return view;
    }

    @Override
    public void onAttach(Context context){
        super.onAttach(context);

        try{
            activityCallback = (Fragment1Listener)context;
        } catch (ClassCastException e){
            throw new ClassCastException(context.toString() + "Must implement Fragment1Listener interface");
        }
    }

    @Override
    public void onDetach(){
        super.onDetach();
        activityCallback = null;
    }

    public interface Fragment1Listener {
        public void onFragment1Button1Clicked();

        public void onFragment1Button2Clicked();
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btn_1)  activityCallback.onFragment1Button1Clicked();

        if (view.getId() == R.id.btn_2)  activityCallback.onFragment1Button2Clicked();
    }
}