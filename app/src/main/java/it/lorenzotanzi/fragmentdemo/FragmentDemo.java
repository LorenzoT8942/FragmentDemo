package it.lorenzotanzi.fragmentdemo;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.util.Log;


public class FragmentDemo extends AppCompatActivity  implements Fragment2.Fragment2Listener, Fragment1.Fragment1Listener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_demo);


        if (savedInstanceState == null){
        getSupportFragmentManager().beginTransaction().add(R.id.fragment_1, new Fragment1()).commit();
        getSupportFragmentManager().beginTransaction().add(R.id.fragment_2, new Fragment2()).commit();
        }

    }

    @Override
    public void onFragment2Button1Click() {
        Log.d("F2B1", "Button 1 of Fragment 2 clicked");

    }

    @Override
    public void onFragment2Button2Click() {
        Log.d("F2B2", "Button 2 of Fragment 2 clicked");

    }

    @Override
    public void onFragment1Button1Clicked() {
        Log.d("F1B1", "Button 1 of Fragment 1 clicked");
    }

    @Override
    public void onFragment1Button2Clicked() {
        Log.d("F1B2", "Button 2 of Fragment 1 clicked");
    }
}





