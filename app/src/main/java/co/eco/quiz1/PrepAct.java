package co.eco.quiz1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;

public class PrepAct extends AppCompatActivity {

    private ConstraintLayout screen3;
    private CheckBox prepO1, prepO2, prepO3;
    private Button prepNext;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prep);
    }
}