package co.eco.quiz1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ConstraintLayout screen1;
    private TextView regStudList;
    private Button regBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        screen1 = findViewById(R.id.screen1);
        regStudList = findViewById(R.id.regStudList);
        regBtn = findViewById(R.id.regBtn);


        regBtn.setOnClickListener(

                view -> {
                    Intent i = new Intent(this, Register.class);
                    startActivity(i);
                }


        );
    }



    public void displayScore(){

        String data = getSharedPreferences("datos", MODE_PRIVATE).getString("student", "no hay datos almacenados");
        regStudList.setText(data);
    }


    @Override
    protected void onResume() {
        super.onResume();
        displayScore();
    }

}