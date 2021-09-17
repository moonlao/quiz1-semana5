package co.eco.quiz1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;

public class SelfEva extends AppCompatActivity {

    private ConstraintLayout screen4;
    private CheckBox selfevaO1, selfevaO2, selfeva03;
    private Button selfevaNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selfeva);
    }
}