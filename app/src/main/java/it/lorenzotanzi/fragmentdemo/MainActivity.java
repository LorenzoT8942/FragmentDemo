package it.lorenzotanzi.fragmentdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Context context = getApplicationContext();
        Holder holder = new Holder(context);

    }

    private class Holder implements View.OnClickListener{

        Context context;


        Holder(Context context){
            this.context = context;
            Button Demo1_btn = (Button)findViewById(R.id.demo_btn);
            Demo1_btn.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (view.getId() == R.id.demo_btn){
                Intent i = new Intent(context, FragmentDemo.class);
                startActivity(i);
            }
        }


    }
}
