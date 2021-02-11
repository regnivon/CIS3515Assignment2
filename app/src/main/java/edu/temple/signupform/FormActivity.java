package edu.temple.signupform;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FormActivity extends AppCompatActivity {

    private final int USERNAME = 1;
    private final int PASSWORD = 2;
    private final int PASSWORD_CONFIRM = 3;
    private final int PASSWORD_MISMATCH = 4;

    Button submit;

    List<EditText> inputFields;
    List<TextView> errorFields;
    List<String> errorTexts;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       submit = findViewById(R.id.submitButton);


        inputFields = new ArrayList<>(
                Arrays.asList(
                        (EditText)findViewById(R.id.emailInput),
                        (EditText)findViewById(R.id.usernameInput),
                        (EditText)findViewById(R.id.passwordInput),
                        (EditText)findViewById(R.id.confirmPasswordInput)
                )
        );

        errorFields = new ArrayList<>(
                Arrays.asList(
                        (TextView)findViewById(R.id.emailErrorView),
                        (TextView)findViewById(R.id.usernameErrorView),
                        (TextView)findViewById(R.id.passwordErrorView),
                        (TextView)findViewById(R.id.confirmPasswordErrorView)
                )
        );

        errorTexts = new ArrayList<>(
                Arrays.asList(
                    getString(R.string.emailError),
                    getString(R.string.usernameError),
                    getString(R.string.passwordError),
                    getString(R.string.confirmPasswordError),
                    getString(R.string.confirmPasswordMismatchError)
                )
        );


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submitPress();
            }
        });
    }

    private void submitPress() {
        boolean error = false;
        for (TextView e: errorFields) {
            e.clearComposingText();
        }
        for (int i = 0; i < inputFields.size(); i++) {
            if (TextUtils.isEmpty(inputFields.get(i).getText())) {
                errorFields.get(i).setText(errorTexts.get(i));
                error = true;
            }
        }

        if (!TextUtils.equals(inputFields.get(PASSWORD).getText().toString(),
                inputFields.get(PASSWORD_CONFIRM).getText().toString()))
        {

            errorFields.get(PASSWORD).setText(errorTexts.get(PASSWORD_MISMATCH));
            error = true;

        }

        if (!error) {
            Context context = getApplicationContext();
            CharSequence text = "Welcome, " + inputFields.get(USERNAME).getText().toString() + " to the SignUpForm App";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }
    }
}
