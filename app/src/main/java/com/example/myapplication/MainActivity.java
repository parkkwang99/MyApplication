package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {


//    TextInputLayout TextInputEditText_email, TextInputEditText_password;
//    RelativeLayout RelativeLayout_Login;
//    이상하게 이렇게 하면 안 되고 아래처럼 private로 하면 됨

    private TextInputEditText TextInputEditText_email;
    private TextInputEditText TextInputEditText_password;
    private RelativeLayout RelativeLayout_Login;

    String emailOK = "123@gmail.com";
    String passwordOK = "1234";

    String inputEamil = "";
    String inputpassword = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        TextInputEditText_email = findViewById(R.id.TextInputEditText_email);
        TextInputEditText_password = findViewById(R.id.TextInputEditText_password);
        RelativeLayout_Login = findViewById(R.id.RelativeLayout_Login);

        // 1. 값을 가져온다. -> 검사 (123@gmail.com / 1234)가 맞는지 확인
        // 2. 클릭을 감지한다.
        // 3. 1번의 값을 다음 액티비티로 넘긴다.

        RelativeLayout_Login.setClickable(false);

        // 아이디 검사
        TextInputEditText_email.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {//글짜가 바뀌기 전
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Log.d("SENTI", s + "," + count);
                if (s != null) {
                    inputEamil = s.toString();
                    RelativeLayout_Login.setEnabled(validation());
                }
            }

            @Override
            public void afterTextChanged(Editable s) { // 글자가 바뀐 후
            }
        });

        // 비밀번호
        TextInputEditText_password.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { // 글자가 바뀌기 전

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Log.d("SENTI", s + "," + count);
                if(s != null) {
                    inputpassword = s.toString();
                    RelativeLayout_Login.setEnabled(validation());
                }
            }

            @Override
            public void afterTextChanged(Editable s) { // 글자가 바뀐 후

            }
        });

        // RelativeLayout_Login.setClickable(true);  // 클릭을 감지하는 메서드
        RelativeLayout_Login.setOnClickListener(new View.OnClickListener() { // 리소스를 안에다가 입력
            @Override
            public void onClick(View v) {

                Log.d("SENTI", "onClicki");

                String email = TextInputEditText_email.getText().toString();
                String password = TextInputEditText_password.getText().toString();
                // 가져올 값들

                Intent intent = new Intent(MainActivity.this, LoginResultActivity.class);
                intent.putExtra("email",email);
                intent.putExtra("password",password);
                startActivity(intent);
            }
        });
    }

    // 조건이 맞는지 참 거짓 판별
    public boolean validation() {
        Log.d("SENTI", inputEamil + "," + inputpassword + "," + (inputEamil.equals(emailOK)) + "," + (inputpassword.equals(passwordOK)));
        return inputEamil.equals(emailOK) && inputpassword.equals(passwordOK);
    }
}
