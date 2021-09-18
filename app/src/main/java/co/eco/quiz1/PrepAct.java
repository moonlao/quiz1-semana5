package co.eco.quiz1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;

public class PrepAct extends AppCompatActivity {

    private ConstraintLayout screen3;
    private CheckBox prepO1, prepO2, prepO3;
    private Button prepNext;

    private int prepScore;
    private String nameName, codeCode;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prep);


        screen3 = findViewById(R.id.screen3);
        prepO1 = findViewById(R.id.prepO1);
        prepO2 = findViewById(R.id.prepO2);
        prepO3 = findViewById(R.id.prepO3);

        prepNext = findViewById(R.id.prepNext);

        prepScore = 0;
        codeCode = getIntent().getExtras().getString("codigo");

        nameName = getIntent().getExtras().getString("nombre");
        verifyOp();
        next();

    }



    public void next(){
        prepNext.setOnClickListener(
                view -> {

                    points();

                    Intent i = new Intent(this, SelfEva.class);

                    i.putExtra("nombre", nameName);
                    i.putExtra("codigo", codeCode);
                    i.putExtra("scoring", prepScore);

                    startActivity(i);
                    finish();
                }
        );
    }


    public void points(){

        if (prepO1.isChecked()){

            prepScore=prepScore+1;
        }

        if (prepO2.isChecked()){

            prepScore= prepScore+3;
        }

        if (prepO3.isChecked()){

            prepScore= prepScore+0;
        }


    }


    public void verifyOp(){

        prepNext.setEnabled(false);
        prepNext.setBackgroundResource(R.drawable.botongris);
        new Thread(

                ()->{

                    while(true){

                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                        if(prepO1.isChecked() || prepO2.isChecked() || prepO3.isChecked()){

                            runOnUiThread(
                                    ()->{
                                        prepNext.setEnabled(true);
                                        prepNext.setBackgroundResource(R.drawable.botonazul);
                                    }
                            );

                        }else{

                            runOnUiThread(

                                    ()->{
                                        prepNext.setEnabled(false);
                                        prepNext.setBackgroundResource(R.drawable.botongris);
                                    }

                            );
                        }

                    }

                }

        ).start();

    }
}