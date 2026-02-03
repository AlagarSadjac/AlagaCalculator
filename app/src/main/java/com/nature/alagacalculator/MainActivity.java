package com.nature.alagacalculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    float f1,f2;
    EditText e;
    Button B1,B2,B3,B4,B5,B6,B7,B8,B9,B0,clear,ac,ope,clo,dot,add,sub,div,mul, equ;
    Boolean Aadd=false;
    Boolean Ssub=false;
    Boolean Mmul=false;
    Boolean Ddiv=false;

    @Override
    protected  void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        e = findViewById(R.id.e);
        clear = findViewById(R.id.clear);
        ope = findViewById(R.id.ope);
        clo = findViewById(R.id.clo);
        div = findViewById(R.id.div);
        B7 = findViewById(R.id.B7);
        B8 = findViewById(R.id.B8);
        B9 = findViewById(R.id.B9);
        mul = findViewById(R.id.mul);
        B4 = findViewById(R.id.B4);
        B5 = findViewById(R.id.B5);
        B6 = findViewById(R.id.B6);
        add = findViewById(R.id.add);
        B1 = findViewById(R.id.B1);
        B2 = findViewById(R.id.B2);
        B3 = findViewById(R.id.B3);
        sub = findViewById(R.id.sub);
        ac = findViewById(R.id.ac);
        B0 = findViewById(R.id.B0);
        dot = findViewById(R.id.dot);
        equ = findViewById(R.id.equ);



        View.OnClickListener numberListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button b = (Button) v;
                e.append(b.getText().toString());
            }
        };

// Set Listener for all buttons:
        B0.setOnClickListener(numberListener);
        B1.setOnClickListener(numberListener);
        B2.setOnClickListener(numberListener);
        B3.setOnClickListener(numberListener);
        B4.setOnClickListener(numberListener);
        B5.setOnClickListener(numberListener);
        B6.setOnClickListener(numberListener);
        B7.setOnClickListener(numberListener);
        B8.setOnClickListener(numberListener);
        B9.setOnClickListener(numberListener);
        dot.setOnClickListener(numberListener);


// Logical for Add, Sub, Mul, Div
        add.setOnClickListener(v -> {
            if(!e.getText().toString().isEmpty()) {
                f1 = Float.parseFloat(e.getText().toString());
                Aadd = true;
                e.setText(null);
            }
        });

        sub.setOnClickListener(v -> {
            if(!e.getText().toString().isEmpty()) {
                f1 = Float.parseFloat(e.getText().toString());
                Ssub = true;
                e.setText(null);
            }
        });

        mul.setOnClickListener(v -> {
            if(!e.getText().toString().isEmpty()) {
                f1 = Float.parseFloat(e.getText().toString());
                Mmul = true;
                e.setText(null);}
        });

        div.setOnClickListener(v -> {
            if(!e.getText().toString().isEmpty()) {
                f1 = Float.parseFloat(e.getText().toString());
                Ddiv = true;
                e.setText(null);}
        });

// Logical for Equal Button
        equ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    String val = e.getText().toString();

                    // Enter only if th box is not empty
                    if (!val.isEmpty()) {
                        f2 = Float.parseFloat(val);

                        if (Aadd == true) {
                            e.setText(String.valueOf(f1 + f2));
                            Aadd = false;
                        } else if (Ssub == true) {
                            e.setText(String.valueOf(f1 - f2));
                            Ssub = false;
                        } else if (Mmul == true) {
                            e.setText(String.valueOf(f1 * f2));
                            Mmul = false;
                        } else if (Ddiv == true) {
                            if (f2 != 0) {
                                e.setText(String.valueOf(f1 / f2));
                            } else {
                                e.setText("Error"); // சைபரால் வகுக்க முடியாது
                            }
                            Ddiv = false;
                        }
                    }
                } catch (Exception error) {
                    // Maybe brackets or incorrect numbers
                    // Show error here to prevent the crash
                    e.setText("Error");
                }
            }
        });
// Logical for clear button
        ac.setOnClickListener(v -> {
            e.setText("");
            f1 = 0;
            f2 = 0;
        });

// Clear - Remove only one number
        clear.setOnClickListener(v -> {
            String text = e.getText().toString();
            if (text.length() > 0) {

// Clear - Remove only the last number
                e.setText(text.substring(0, text.length() - 1));
            }
        });

// Logical for Open Bracket '('
        ope.setOnClickListener(v -> {
            e.append("(");
        });

// Logical for Close Bracket ')'
        clo.setOnClickListener(v -> {
            e.append(")");
        });

//Logical for dot Button
        dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String data = e.getText().toString();

                // If the box is empty, it will show '0.'
                if (data.isEmpty()) {
                    e.setText("0.");
                }
                // It allows a dot only if it's not already there
                else if (!data.contains(".")) {
                    e.append(".");
                }
            }
        });

    }}






