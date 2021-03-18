package com.example.firstapp;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener
{

    TextView termview, resultview;
    double result = 0.0;
    String term = "";
    String tmpresult = "";


    String op = "";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Button one = (Button) findViewById(R.id.one);
        Button two = (Button) findViewById(R.id.two);
        Button three = (Button) findViewById(R.id.three);
        Button four = (Button) findViewById(R.id.four);
        Button five = (Button) findViewById(R.id.five);
        Button six = (Button) findViewById(R.id.six);
        Button seven = (Button) findViewById(R.id.seven);
        Button eight = (Button) findViewById(R.id.eight);
        Button nine = (Button) findViewById(R.id.nine);
        Button zero = (Button) findViewById(R.id.zero);
        Button add = (Button) findViewById(R.id.add);
        Button sub = (Button) findViewById(R.id.sub);
        Button mul = (Button) findViewById(R.id.mul);
        Button div = (Button) findViewById(R.id.div);
        Button open = (Button) findViewById(R.id.oppa);
        Button close = (Button) findViewById(R.id.clpa);
        Button cl = (Button) findViewById(R.id.clear);
        Button equals = (Button) findViewById(R.id.eq);
        Button delete = (Button) findViewById(R.id.del);


        one.setOnClickListener(this);
        two.setOnClickListener(this);
        three.setOnClickListener(this);
        four.setOnClickListener(this);
        five.setOnClickListener(this);
        six.setOnClickListener(this);
        seven.setOnClickListener(this);
        eight.setOnClickListener(this);
        nine.setOnClickListener(this);
        zero.setOnClickListener(this);
        add.setOnClickListener(this);
        sub.setOnClickListener(this);
        mul.setOnClickListener(this);
        div.setOnClickListener(this);
        open.setOnClickListener(this);
        close.setOnClickListener(this);
        cl.setOnClickListener(this);
        equals.setOnClickListener(this);
        delete.setOnClickListener(this);

        termview = findViewById(R.id.term);
        resultview = findViewById(R.id.res);

    }

    public void changeback(View view)
    {
        setContentView(R.layout.activity_main);
    }

    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.one:

                term = term.concat("1");
                termview.setText(term);
                break;
            case R.id.two:
                term = term.concat("2");
                termview.setText(term);
                break;
            case R.id.three:
                term = term.concat("3");
                termview.setText(term);
                break;
            case R.id.four:
                term = term.concat("4");
                termview.setText(term);
                break;
            case R.id.five:
                term = term.concat("5");
                termview.setText(term);
                break;
            case R.id.six:
                term = term.concat("6");
                termview.setText(term);
                Toast.makeText(this, "Button 6 clicked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.seven:
                term = term.concat("7");
                termview.setText(term);
                break;
            case R.id.eight:
                term = term.concat("8");
                termview.setText(term);
                break;
            case R.id.nine:
                term = term.concat("9");
                termview.setText(term);
                break;
            case R.id.zero:
                term = term.concat("0");
                termview.setText(term);
                break;
            case R.id.add:
                term = term.concat("+");
                termview.setText(term);
                break;
            case R.id.sub:
                term = term.concat("-");
                termview.setText(term);
                break;
            case R.id.mul:
                term = term.concat("*");
                termview.setText(term);
                break;
            case R.id.div:
                term = term.concat("/");
                termview.setText(term);
                break;
            case R.id.oppa:
                term = term.concat("(");
                termview.setText(term);
                break;
            case R.id.clpa:
                term = term.concat(")");
                termview.setText(term);
                break;
            case R.id.clear:
                term = "";
                tmpresult = "";
                termview.setText(term);
                resultview.setText("");
                break;
            case R.id.del:
                term = term.substring(0, term.length() - 1);
                termview.setText(term);
                break;
            case R.id.eq:
                String tmpterm = term;
                if (!tmpresult.isEmpty())
                {
                    if (tmpresult.startsWith("-"))
                    {
                        tmpterm = term.concat(tmpresult);
                    }
                    else
                    {
                        tmpterm = tmpresult.concat(term);
                    }
                }
                String test = "";
                if (tmpterm.contains("("))
                {
                    test = removeParenthesis(tmpterm);
                    test = noDoubleOperators(test);
                    test = removeNegativs(test);
                    while (test.contains(")"))
                    {
                        test = removeParenthesis(test);
                        test = noDoubleOperators(test);
                        test = removeNegativs(test);
                    }
                    result = sumresult(test);
                    resultview.setText(String.valueOf(result));
                    tmpresult = String.valueOf(result);
                    term = "";
                }
                else
                {
                    result = sumresult(tmpterm);
                    resultview.setText(String.valueOf(result));
                    tmpresult = String.valueOf(result);
                    term = "";
                }
                break;
        }
    }


    ////////////////////////////////////////////////////////////////////////
    //Utility-Methods
    public static String noDoubleOperators(String a)
    {
        ArrayList<Character> chars = new ArrayList<Character>();
        for (char c : a.toCharArray())
        {
            chars.add(c);
        }

        for (int i = 0; i < chars.size(); i++)
        {
            if (chars.get(i).equals('+'))
            {
                if (chars.get(i + 1).equals('-'))
                {
                    chars.set(i, '-');
                    chars.remove(i + 1);
                    i = 0;
                }
            }
            if (chars.get(i).equals('-'))
            {
                if (chars.get(i + 1).equals('-'))
                {
                    chars.set(i, '+');
                    chars.remove(i + 1);
                    i = 0;
                }
            }
        }
        String noDoubleplusorminus = "";
        for (int l = 0; l < chars.size(); l++)
        {
            noDoubleplusorminus = noDoubleplusorminus.concat(String.valueOf(chars.get(l)));
        }
        return noDoubleplusorminus;
    }

    public static String removeNegativs(String a)
    {
        StringTokenizer tokens = new StringTokenizer(a, "*/+-", true);
        ArrayList<String> tokensList = new ArrayList<>();
        while (tokens.hasMoreTokens())
        {
            tokensList.add(tokens.nextToken());
        }
        for (int k = 0; k < tokensList.size(); k++)
        {
            if (tokensList.get(k).equals("*"))
            {
                if (tokensList.get(k + 1).equals("-"))
                {
                    String tmp = "-";
                    tokensList.set(k, String.valueOf(Double.valueOf(tokensList.get(k - 1)) * Double.valueOf(tokensList.get(k + 2))));
                    tokensList.set(k - 1, tmp);
                    tokensList.remove(k + 1);
                    tokensList.remove(k + 1);
                }
            }
            if (tokensList.get(k).equals("/"))
            {
                if (tokensList.get(k + 1).equals("-"))
                {
                    String tmp = "-";
                    tokensList.set(k, String.valueOf(Double.valueOf(tokensList.get(k - 1)) / Double.valueOf(tokensList.get(k + 2))));
                    tokensList.set(k - 1, tmp);
                    tokensList.remove(k + 1);
                    tokensList.remove(k + 1);
                }
            }
        }
        String end = "";
        for (int l = 0; l < tokensList.size(); l++)
        {
            end = end.concat(tokensList.get(l));
        }

        String result = noDoubleOperators(end);
        return result;
    }


    public static String removeParenthesis(String a)
    {
        StringTokenizer tokens = new StringTokenizer(a, "()", true);
        ArrayList<String> tokensList = new ArrayList<>();
        while (tokens.hasMoreTokens())
        {
            tokensList.add(tokens.nextToken());
        }
        if (tokensList.size() == 3)
        {
            return tokensList.get(1);
        }
        int klammerAuf = 0;
        int klammerZu = 0;

        for (int i = 0; i < tokensList.size(); i++)
        {

            if (tokensList.get(i).equals("("))
            {
                klammerAuf = i;

            }
            if (tokensList.get(i).equals(")"))
            {
                klammerZu = i;
                break;
            }
        }
        ArrayList<String> tmpList = new ArrayList<>();
        for (int j = 0; j < (klammerZu - klammerAuf - 1); j++)
        {
            tmpList.add(tokensList.get(klammerAuf + j + 1));
        }
        String tmpString = "";
        for (int k = 0; k < tmpList.size(); k++)
        {
            tmpString = tmpString.concat(tmpList.get(k));
        }


        tokensList.set(klammerAuf + 1, String.valueOf(sumresult(tmpString)));
        tokensList.remove(klammerAuf);

        for (int x = (klammerZu - 1); x > klammerAuf; x--)
        {
            tokensList.remove(x);
        }


        String end = "";
        for (int l = 0; l < tokensList.size(); l++)
        {
            end = end.concat(tokensList.get(l));
        }
        return end;
    }


    public static Double termResult(String a)
    {
        StringTokenizer tokens = new StringTokenizer(a, "*/", true);

        Double d = Double.valueOf(tokens.nextToken());
        String op = null;

        while (tokens.hasMoreTokens())
        {
            String s = tokens.nextToken();
            if ("*".equals(s) || "/".equals(s))
            {
                op = s;
            }
            else
            {
                Double tmpD = Double.valueOf(s);
                if ("*".equals(op))
                {
                    d = d * tmpD;
                }
                else if ("/".equals(op))
                {
                    d = d / tmpD;
                }
            }
        }
        return d;

    }

    public static double sumresult(String a)
    {
        if (!(a.contains("+") || a.contains("-")))
        {
            return termResult(a);
        }
        StringTokenizer elemenTokens = new StringTokenizer(a, "+-", true);

        ArrayList<String> tokens = new ArrayList<String>();

        while (elemenTokens.hasMoreTokens())
        {
            tokens.add(elemenTokens.nextToken());
        }

        for (int i = 0; i < tokens.size(); i++)
        {
            if (tokens.get(i).equals("-"))
            {
                String tmpstr = "-";
                if (tokens.get(i + 1).contains("*") || tokens.get(i + 1).contains("/"))
                {
                    tokens.set(i + 1, String.valueOf(termResult(tokens.get(i + 1))));
                }
                tokens.set(i, tmpstr.concat(tokens.get(i + 1)));
                tokens.remove(i + 1);
                i = -1;
            }
        }

        for (int j = 0; j < tokens.size(); j++)
        {
            if (tokens.get(j).equals("+"))
            {
                tokens.remove(j);
            }
        }


        double result = termResult(tokens.get(0));

        for (int i = 1; i < tokens.size(); i++)
        {
            result = result + Double.valueOf(termResult(tokens.get(i)));
        }
        return result;
    }
}