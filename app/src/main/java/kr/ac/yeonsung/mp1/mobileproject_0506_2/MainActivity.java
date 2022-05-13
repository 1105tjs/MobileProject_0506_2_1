package kr.ac.yeonsung.mp1.mobileproject_0506_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int[] btnNumId = {R.id.btn0, R.id.btn1, R.id.btn2, R.id.btn3, R.id.btn4
            , R.id.btn5, R.id.btn6, R.id.btn7, R.id.btn8, R.id.btn9};
    Button[] btnNum = new Button[10];
    EditText edit1, edit2;
    TextView textResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edit1 = findViewById(R.id.edit1);
        edit2 = findViewById(R.id.edit2);

        textResult = findViewById(R.id.text_result);
        for (int i = 0; i < btnNum.length; i++) {
            final int index = i;
            btnNum[index] = findViewById(btnNumId[index]);
            btnNum[index].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String num = "";
                    if (edit1.isFocused()) {
                        num = edit1.getText().toString() + btnNum[index].getText();
                        edit1.setText(num);
                    }
                    if (edit2.isFocused()) {
                        num = edit2.getText().toString() + btnNum[index].getText();
                        edit2.setText(num);
                    }
                }
            });
        }
        Button btnPlus = findViewById(R.id.btn_plus);
        Button btnMinus = findViewById(R.id.btn_minus);
        Button btnMulti = findViewById(R.id.btn_multi);
        Button btnDivide = findViewById(R.id.btn_divide);

        btnPlus.setOnClickListener(btnListner);
        btnMinus.setOnClickListener(btnListner);
        btnMulti.setOnClickListener(btnListner);
        btnDivide.setOnClickListener(btnListner);

    }
    View.OnClickListener btnListner = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            int edit1Num = Integer.parseInt(edit1.getText().toString());
            int edit2Num = Integer.parseInt(edit2.getText().toString());
            int result = 0;

            switch (view.getId()) {
                case R.id.btn_plus:
                    result = edit1Num + edit2Num;
                    break;
                case R.id.btn_minus:
                    result = edit1Num - edit2Num;
                    break;
                case R.id.btn_multi:
                    result = edit1Num * edit2Num;
                    break;
                case R.id.btn_divide:
                    result = edit1Num / edit2Num;
                    break;
            }
            textResult.setText("계산 결과 : " + result);
        }
    };
}