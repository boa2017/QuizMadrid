package com.example.android.quizmadrid;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private int score = 0;

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putInt("SCORE", score);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /**Loads old Points*/
        if (savedInstanceState != null) {
            score = savedInstanceState.getInt("SCORE");
        }
    }

        public void onClickWeb(View view) {
            String url = "https://www.youtube.com/watch?v=XMjpaWnXJoM";
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(url));
            startActivity(i);
            }

    public void firstQuestion() {
        RadioButton rightAnswer1 = (RadioButton) findViewById(R.id.radioButton1);
        if (rightAnswer1.isChecked()) {
            score = score + 1;

        }
    }
         public void secondQuestion() {
        RadioButton rightAnswer1 = (RadioButton) findViewById(R.id.radioButton2);
        if (rightAnswer1.isChecked()) {
            score = score + 1;

        }
    }

    public void thirdQuestion() {

        //get answer form edit text

        EditText edt = (EditText) findViewById(R.id.editableAnswer1);
        String editableAnswer1 = edt.getText().toString();
        //compare answers
        if(editableAnswer1.equalsIgnoreCase("The Charge of the Mamelukes")){
            score= score+1 ;
        }
    }
    public void fourthQuestion() {

        //get answer form edit text

        EditText edt = (EditText) findViewById(R.id.editableAnswer2);
        String editableAnswer2 = edt.getText().toString();
        //compare answers
        if(editableAnswer2.equalsIgnoreCase("1808")){
            score= score+1 ;
        }
    }

    public void fifthQuestion() {

        //get answer form edit text

        EditText edt = (EditText) findViewById(R.id.editableAnswer3);
        String editableAnswer3 = edt.getText().toString();
        //compare answers
        if(editableAnswer3.equalsIgnoreCase("1919")){
            score= score+1 ;
        }
    }

    public void sixthQuestion() {
        //choose two answers
        CheckBox chk2 = (CheckBox) findViewById(R.id.Callos);
        CheckBox chk3 = (CheckBox) findViewById(R.id.Cocido);

        if (chk2.isChecked() && chk3.isChecked ()) {
            score=score+1;
        }
    }

    public void tenthQuestionRight(View view) {
        //show a picture depending on user's answer
        RadioButton answerYes= (RadioButton) findViewById(R.id.yes);
        ImageView myImageView1= (ImageView) findViewById(R.id.right);
        ImageView myImageView2= (ImageView) findViewById(R.id.wrong);
        if (answerYes.isChecked()) {
            myImageView1.setVisibility(View.VISIBLE);
            myImageView2.setVisibility(View.GONE);

        }else{
            myImageView1.setVisibility(View.GONE);
        }

    }


    public void tenthQuestionWrong(View view) {
        //show a picture depending on user's answer
        RadioButton answerNo= (RadioButton) findViewById(R.id.no);
        ImageView myImageView1= (ImageView) findViewById(R.id.right);
        ImageView myImageView2= (ImageView) findViewById(R.id.wrong);
        if (answerNo.isChecked()) {
            myImageView2.setVisibility(View.VISIBLE);
            myImageView1.setVisibility(View.GONE);
        }else{
            myImageView2.setVisibility(View.GONE);
        }

    }

    public void getScore (View view) {
        firstQuestion();
        secondQuestion();
        thirdQuestion();
        fourthQuestion();
        fifthQuestion();
        sixthQuestion();

        TextView tv = (TextView) findViewById(R.id.display_result);
        tv.setText(String.valueOf(score));
        Button button = (Button) findViewById(R.id.button);
        button.setClickable(false);
        if (score <=3) {
            //show toast
            Toast.makeText(getApplicationContext(), "Need to improve", Toast.LENGTH_LONG).show();
        }
        if (score >=4 && score <=5) {
            //show toast
            Toast.makeText(getApplicationContext(), "Not so bad", Toast.LENGTH_LONG).show();
        }
        if (score ==6) {
            //show toast
            Toast.makeText(getApplicationContext(), "Well done", Toast.LENGTH_LONG).show();
        }
    }

    public void resetScore (View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
        score= 0;

        EditText et1=(EditText) findViewById(R.id.editableAnswer1);
        et1.setText("");
        EditText et2=(EditText) findViewById(R.id.editableAnswer2);
        et2.setText("");
        EditText et3=(EditText) findViewById(R.id.editableAnswer3);
        et3.setText("");

        ImageView myImageView1= (ImageView) findViewById(R.id.right);
        myImageView1.setVisibility(View.GONE);
        ImageView myImageView2= (ImageView) findViewById(R.id.wrong);
        myImageView2.setVisibility(View.GONE);



        TextView tv = (TextView) findViewById(R.id.display_result);
        tv.setText(String.valueOf(score));
        Button button = (Button) findViewById(R.id.button);
        button.setClickable(true);

    }

}
