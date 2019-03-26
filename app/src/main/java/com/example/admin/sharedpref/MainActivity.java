package com.example.admin.sharedpref;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    private static final String SHARED_PREF_NAME = "mysharedpref";
    private static final String KEY_NAME = "keyname";

    EditText editText;
    TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.unme);
        textView = findViewById(R.id.pwd);


    }

    public void save(View v) {
        String name = editText.getText().toString();

        if (name.isEmpty()) {
            editText.setError("Name required");
            editText.requestFocus();
            return;
        }

        SharedPreferences sp = getSharedPreferences(SHARED_PREF_NAME, MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();

        editor.putString(KEY_NAME, name);

        editor.apply();

        editText.setText("");
    }

    public void loadd(View v) {
        SharedPreferences sp = getSharedPreferences(SHARED_PREF_NAME, MODE_PRIVATE);
        String name = sp.getString(KEY_NAME, null);

        if (name != null) {
            editText.setText("Welcome " + name);
        }
    }

}
