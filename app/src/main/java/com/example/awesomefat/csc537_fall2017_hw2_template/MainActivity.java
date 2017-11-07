package com.example.awesomefat.csc537_fall2017_hw2_template;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    static  String displayString="";
    EditText string1,string2;
    Button addition;
    TextView result;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinkedList ll = new LinkedList();

        ll.addFront(3);
        ll.addFront(4);
        ll.addFront(8);
        ll.addFront(9);
        ll.addFront(8);
        ll.addFront(9);
        ll.addFront(8);
        ll.addFront(9);
        ll.addFront(8);
        ll.addFront(3);

//        ll.display();
//        System.out.println(ll.removeEnd());
//        ll.display();

        LinkedList l2 = new LinkedList();
        l2.addFront(6);
        l2.addFront(8);
        l2.addFront(8);
        l2.addFront(7);

//        l2.display();

        LinkedList l3 = HugeNumber.addLists(ll,l2);
       // l3.display();
        Log.d("dd",displayString);


        string1=(EditText)findViewById(R.id.first_string);
        string2=(EditText)findViewById(R.id.second_string);
        result=(TextView)findViewById(R.id.result);

        addition=(Button)findViewById(R.id.add_button);
        addition.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        hideKeyboard();
        result.setText("");
        displayString="";
        if(string1.getText().toString().isEmpty() || string2.getText().toString().isEmpty())
        {
            Toast.makeText(this, "Enter both numbers to add", Toast.LENGTH_SHORT).show();
            return;
        }
        String s1=new StringBuilder(string1.getText().toString()).reverse().toString();
        String s2=new StringBuilder(string2.getText().toString()).reverse().toString();
        if(s1.length()<=1)
        {
            s1=s1+"0";
        }
        if(s2.length()<=1)
        {
            s2=s2+"0";
        }
        LinkedList l1=new LinkedList(),l2=new LinkedList(),l3=new LinkedList();
        char[] array = s1.toCharArray();
        for (char s:array)
        {
            String temp=""+s;
           l1.addFront(Integer.parseInt(temp));
        }
        array = s2.toCharArray();
        for (char s:array)
        {
            String temp=""+s;
            l2.addFront(Integer.parseInt(temp));
        }

        l3=HugeNumber.addLists(l1,l2);

        l3.display();

        result.setText(displayString);
        displayString="";
    }

    void hideKeyboard() {
        try {
            InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
        } catch (Exception e) {

        }
    }

}
