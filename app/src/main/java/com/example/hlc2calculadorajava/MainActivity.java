package com.example.hlc2calculadorajava;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tv;
    TextView tvm;
    int operacion;
    float n1 = 0.0f;
    float n2 = 0.0f;
    float resul = 0.0f;
    float mem = 0.0f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = findViewById(R.id.textView);
        tvm = findViewById(R.id.textViewMen);


        Button btn0 = findViewById(R.id.btn0);
        btn0.setOnClickListener(imprimeNum);

        Button btn1 = findViewById(R.id.btn1);
        btn1.setOnClickListener(imprimeNum);

        Button btn2 = findViewById(R.id.btn2);
        btn2.setOnClickListener(imprimeNum);

        Button btn3 = findViewById(R.id.btn3);
        btn3.setOnClickListener(imprimeNum);

        Button btn4 = findViewById(R.id.btn4);
        btn4.setOnClickListener(imprimeNum);

        Button btn5 = findViewById(R.id.btn5);
        btn5.setOnClickListener(imprimeNum);

        Button btn6 = findViewById(R.id.btn6);
        btn6.setOnClickListener(imprimeNum);

        Button btn7 = findViewById(R.id.btn7);
        btn7.setOnClickListener(imprimeNum);

        Button btn8 = findViewById(R.id.btn8);
        btn8.setOnClickListener(imprimeNum);

        Button btn9 = findViewById(R.id.btn9);
        btn9.setOnClickListener(imprimeNum);

        Button btnPun = findViewById(R.id.btnPun);
        btnPun.setOnClickListener(imprimeNum);


        Button btnAc = findViewById(R.id.btnAc);
        btnAc.setOnClickListener(borrar);

        Button btnC = findViewById(R.id.btnC);
        btnC.setOnClickListener(borrar);

        Button btnSetMem = findViewById(R.id.btnSetMem);
        btnSetMem.setOnClickListener(memoria);

        Button btnGetMem = findViewById(R.id.btnGetMem);
        btnGetMem.setOnClickListener(memoria);


        Button btnDiv = findViewById(R.id.btnDiv);
        btnDiv.setOnClickListener(recibeOperacion);

        Button btnMul = findViewById(R.id.btnMul);
        btnMul.setOnClickListener(recibeOperacion);

        Button btnRes = findViewById(R.id.btnRes);
        btnRes.setOnClickListener(recibeOperacion);

        Button btnSum = findViewById(R.id.btnSum);
        btnSum.setOnClickListener(recibeOperacion);

        Button btnIgu = findViewById(R.id.btnIgu);
        btnIgu.setOnClickListener(realizaOperacion);
    }

    private View.OnClickListener imprimeNum = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if ((String) tv.getText() == "0")
                tv.setText("");
            switch (view.getId()) {
                case R.id.btn0:
                    tv.setText(tv.getText() + "0");
                    break;
                case R.id.btn1:
                    tv.setText(tv.getText() + "1");
                    break;
                case R.id.btn2:
                    tv.setText(tv.getText() + "2");
                    break;
                case R.id.btn3:
                    tv.setText(tv.getText() + "3");
                    break;
                case R.id.btn4:
                    tv.setText(tv.getText() + "4");
                    break;
                case R.id.btn5:
                    tv.setText(tv.getText() + "5");
                    break;
                case R.id.btn6:
                    tv.setText(tv.getText() + "6");
                    break;
                case R.id.btn7:
                    tv.setText(tv.getText() + "7");
                    break;
                case R.id.btn8:
                    tv.setText(tv.getText() + "8");
                    break;
                case R.id.btn9:
                    tv.setText(tv.getText() + "9");
                    break;
                case R.id.btnPun:
                    if ((String) tv.getText() == "")
                        tv.setText("0");
                    tv.setText(tv.getText() + ".");
                    break;
            }
        }
    };

    private View.OnClickListener borrar = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (view.getId() == R.id.btnAc) {
                n1 = 0.0f;
                n2 = 0.0f;
                mem = 0.0f;
                tvm.setText("");
            } else if (n1 != 0 && n2 == 0 && (String) tv.getText() == "0") {
                    n1 = 0.0f;
                } else if (n1 != 0 && n2 != 0) {
                        n2 = 0.0f;
                }
            resul = 0.0f;
            tv.setText("0");
        }
    };

    private View.OnClickListener memoria = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.btnSetMem:
                    mem = Float.parseFloat((String) tv.getText());
                    tvm.setText("M");
                    break;
                case R.id.btnGetMem:
                    asignarMemoria();
                    tv.setText(String.valueOf(mem));
                    mem = 0.0f;
                    tvm.setText("");
                    break;
            }
        }
    };

    private void asignarMemoria() {
        if(n1 != 0 && n2 == 0)
            n2 = mem;
        else
            n1 = mem;
    }

    private View.OnClickListener recibeOperacion = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            n1 = Float.parseFloat((String) tv.getText());
            tv.setText("0");
            switch (view.getId()) {
                case R.id.btnSum:
                    operacion = 1;
                    break;
                case R.id.btnRes:
                    operacion = 2;
                    break;
                case R.id.btnMul:
                    operacion = 3;
                    break;
                case R.id.btnDiv:
                    operacion = 4;
                    break;
            }
        }
    };

    private View.OnClickListener realizaOperacion = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            n2 = Float.parseFloat((String) tv.getText());
            switch (operacion) {
                case 1:
                    resul = n1 + n2;
                    break;
                case 2:
                    resul = n1 - n2;
                    break;
                case 3:
                    resul = n1 * n2;
                    break;
                case 4:
                    resul = n1 / n2;
                    break;
            }
            tv.setText(Float.toString(resul));
            n1 = 0.0f;
            n2 = 0.0f;
        }
    };

}