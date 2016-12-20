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



        CheckBox vomito= (CheckBox) findViewById(R.id.check_vomito);
        CheckBox nausea= (CheckBox) findViewById(R.id.check_nausea);
        CheckBox insomnia= (CheckBox) findViewById(R.id.check_insomnia);
        CheckBox fiebre= (CheckBox) findViewById(R.id.check_fiebre);
        CheckBox dolor= (CheckBox) findViewById(R.id.check_dolor);
        CheckBox prurito= (CheckBox) findViewById(R.id.check_prurito);
        CheckBox manchas= (CheckBox) findViewById(R.id.check_manchas);
        CheckBox diarrea= (CheckBox) findViewById(R.id.check_diarrea);

        ArrayList<String> selectedCheckBoxes = new ArrayList<String>();

        if(vomito.isChecked()){

            selectedCheckBoxes.add("s");

        }else selectedCheckBoxes.add("n");



        if(nausea.isChecked()){

            selectedCheckBoxes.add("s");

        }else selectedCheckBoxes.add("n");


        if(insomnia.isChecked()){

            selectedCheckBoxes.add("s");

        }else selectedCheckBoxes.add("n");

        if(fiebre.isChecked()){

            selectedCheckBoxes.add("s");

        }else selectedCheckBoxes.add("n");

        if(dolor.isChecked()){

            selectedCheckBoxes.add("s");

        }else selectedCheckBoxes.add("n");

        if(prurito.isChecked()){

            selectedCheckBoxes.add("s");

        }else selectedCheckBoxes.add("n");

        if(manchas.isChecked()){

            selectedCheckBoxes.add("s");

        }else selectedCheckBoxes.add("n");

        if(diarrea.isChecked()){

            selectedCheckBoxes.add("s");

        }else selectedCheckBoxes.add("n");

        SendData sendData = new SendData(this,selectedCheckBoxes);
        sendData.execute();

        /** LinearLayout layout = (LinearLayout)findViewById(R.id.linear_checkboxes);

         ArrayList<CheckBox> checkBoxesList = new ArrayList<>();

         for(int i=0;i<layout.getChildCount();i++){
             checkBoxesList.add((CheckBox) layout.getChildAt(i));
         }


         for(int i=0;i<checkBoxesList.size();i++){
             if(  checkBoxesList.get(i).isChecked()){
                 selectedCheckBoxes.add(checkBoxesList.get(i).getText().toString());
                 System.out.println(checkBoxesList.get(i).getText().toString());
             }





         }**/




    }




}
