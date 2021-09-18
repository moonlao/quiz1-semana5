package co.eco.quiz1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Register extends AppCompatActivity {

    private ConstraintLayout screen2;
    private EditText name, code;
    private Button regNext;

    private Boolean verifyRegNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        name = findViewById(R.id.name);
        code = findViewById(R.id.code);
        regNext = findViewById(R.id.regNext);



        regNext.setOnClickListener(

                view -> {

                    load();

                    String studName = name.getText().toString();
                    String studCode = code.getText().toString();

                    if (studName==null || studCode == null || studName.isEmpty() || studCode.isEmpty()){
                        Toast.makeText(this, "complete los campos de datos", Toast.LENGTH_SHORT).show();

                    }else if(verifyRegNext){

                        Intent i = new Intent(this, PrepAct.class);
                        i.putExtra("nombre", studName);
                        i.putExtra("codigo", studCode);

                        startActivity(i);
                        finish();
                    }
                }
        );
    }




    public void load(){

        verifyRegNext = true;
        String datass = getSharedPreferences("datos", MODE_PRIVATE).getString("nombre", "no hay dats almacenados");


        if (datass.contains(name.getText().toString()) && datass.contains(code.getText().toString())){
            Toast.makeText(this, "el estudiante ya completó la encuesta", Toast.LENGTH_SHORT).show();
            verifyRegNext = false;
        }
    }
}