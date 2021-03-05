package com.example.firstapp;

import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{

    EditText first, second;
    TextView resultbox;
    double num1, num2;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /** Called when the user taps the Send button */
    public void changeViewType(View view) {
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);
    }


    public boolean getNumbers()
    {
        first = (EditText) findViewById(R.id.first);


        second = (EditText) findViewById(R.id.second);

        resultbox = (TextView) findViewById(R.id.res);


        String s1 = first.getText().toString();


        String s2 = second.getText().toString();


        if ((s1.equals(null) && s2.equals(null))
            || (s1.equals("") && s2.equals("")))
        {

            String result = "Please enter a value";
            resultbox.setText(result);

            return false;
        }
        else
        {

            num1 = Integer.parseInt(first.getText().toString());


            num2 = Integer.parseInt(second.getText().toString());
        }

        return true;
    }

    public void add(View v)
    {
        if (getNumbers())
        {
            double sum = num1 + num2;
            resultbox.setText(Double.toString(sum));
        }
    }

    public void sub(View v)
    {
        if (getNumbers())
        {
            double sum = num1 - num2;
            resultbox.setText(Double.toString(sum));
        }
    }

    public void div(View v)
    {
        if (getNumbers())
        {
            double sum = num1 / num2;
            resultbox.setText(Double.toString(sum));
        }
    }

    public void mul(View v)
    {
        if (getNumbers())
        {
            double sum = num1 * num2;
            resultbox.setText(Double.toString(sum));
        }
    }

    public void mod(View v)
    {
        if (getNumbers())
        {
            double sum = num1 % num2;
            resultbox.setText(Double.toString(sum));
        }
    }

}