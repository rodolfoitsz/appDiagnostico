package com.diagnostico.tech.diagnostico;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




    }



    public void diagnosticar (View v){



        LinearLayout layout = (LinearLayout)findViewById(R.id.linear_checkboxes);

        ArrayList<CheckBox> checkBoxesList = new ArrayList<>();
        ArrayList<String> selectedCheckBoxes = new ArrayList<String>();

        for(int i=0;i<layout.getChildCount();i++){
            checkBoxesList.add((CheckBox) layout.getChildAt(i));
        }


        for(int i=0;i<checkBoxesList.size();i++){
            if(  checkBoxesList.get(i).isChecked()){

                selectedCheckBoxes.add(checkBoxesList.get(i).getText().toString());
                System.out.println(checkBoxesList.get(i).getText().toString());

            }





        }


        SendData sendData = new SendData(this,selectedCheckBoxes);
        sendData.execute();





    }




}
