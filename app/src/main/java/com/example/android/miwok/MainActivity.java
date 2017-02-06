
package com.example.android.miwok;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

import static com.example.android.miwok.R.id.numbers;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Set the content of the activity to use the activity_main.xml layout file
        setContentView(R.layout.activity_main);
        TextView numbers=(TextView)findViewById(R.id.numbers);
      numbers.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {

        Intent numbersIntent=new Intent(MainActivity.this,Numbers.class);
        startActivity(numbersIntent);
    }
});
        TextView family =(TextView)findViewById(R.id.family);
        family.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent family=new Intent(MainActivity.this,Family.class);
                startActivity(family);
            }
        });
        TextView colors =(TextView)findViewById(R.id.colors);
        colors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent colors=new Intent(MainActivity.this,ColorsActivity.class);
                startActivity(colors);
            }
        });
        TextView phrases=(TextView)findViewById(R.id.phrases);
        phrases.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent phrases =new Intent(MainActivity.this,Phrase.class);
                startActivity(phrases);
            }
        });
    }

//    public void opennumbersActivity(View view)
//    {
//        Intent i=new Intent(this,NumbersActivity.class);
//        startActivity(i);
//    }
}
