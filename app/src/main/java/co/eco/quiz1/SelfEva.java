package co.eco.quiz1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

public class SelfEva extends AppCompatActivity {

    private ConstraintLayout screen4;
    private CheckBox selfevaO1, selfevaO2, selfevaO3;
    private Button selfevaNext;

    private String studNamee, studCodee;
    private int prepScore, evaScore, total;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selfeva);

        screen4 = findViewById(R.id.screen4);
        selfevaO1 = findViewById(R.id.selfevaO1);
        selfevaO2 = findViewById(R.id.selfevaO2);
        selfevaO3 = findViewById(R.id.selfevaO3);
        selfevaNext = findViewById(R.id.selfevaNext);

        screen4 = findViewById(R.id.screen4);


        evaScore = 0;
        total = 0;

        studNamee = getIntent().getExtras().getString("nombre");
        studCodee = getIntent().getExtras().getString("codigo");

        prepScore = getIntent().getExtras().getInt("scoring");

        verifyOp();
        end();

    }


    public void end(){
        selfevaNext.setOnClickListener(

                view -> {

                    points();
                    total = evaScore + prepScore;
                    Intent i = new Intent(this, MainActivity.class);
                    save();
                    startActivity(i);
                    finish();
                }
        );



    }


    public void points(){

        if (selfevaO1.isChecked()){

            evaScore= evaScore+3;
        }

        if (selfevaO2.isChecked()){

            evaScore= evaScore+0;
        }

        if (selfevaO3.isChecked()){

            evaScore= evaScore+3;
        }


    }


    public void verifyOp(){

        selfevaNext.setEnabled(false);
        selfevaNext.setBackgroundResource(R.drawable.botongris);
        new Thread(

                ()->{

                    while(true){

                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                        if(selfevaO1.isChecked() || selfevaO2.isChecked() || selfevaO3.isChecked()){

                            runOnUiThread(
                                    ()->{
                                        selfevaNext.setEnabled(true);
                                        selfevaNext.setBackgroundResource(R.drawable.botonazul);
                                    }
                            );

                        }else{

                            runOnUiThread(

                                    ()->{
                                        selfevaNext.setEnabled(false);
                                        selfevaNext.setBackgroundResource(R.drawable.botongris);
                                    }

                            );
                        }

                    }

                }

        ).start();

    }

    public void save() {

        SharedPreferences preferences = getSharedPreferences("datos", MODE_PRIVATE);
        String datoss = studNamee + "," + studCodee + "," + total + "\n";
        String datosrn = preferences.getString("student", "");
        preferences.edit().putString("student", datosrn + datoss).apply();
    }



}