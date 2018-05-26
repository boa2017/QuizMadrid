/*
 *
 *  * PROJECT LICENSE
 *  *
 *  * This project was submitted by Beatriz Ovejero as part of the Android Developer
 *  * Nanodegree at Udacity.
 *  *
 *  * As part of Udacity Honor code, your submissions must be your own work, hence
 *  * submitting this project as yours will cause you to break the Udacity Honor Code
 *  * and the suspension of your account.
 *  *
 *  * As author of the project, I allow you to check it as a reference, but if you submit it
 *  * as your own project, it's your own responsibility if you get expelled.
 *  *
 *  * Copyright (c) 2018 Beatriz Ovejero
 *  *
 *  * Besides the above notice, the following license applies and this license notice must be
 *  * included in all works derived from this project.
 *  *
 *  * MIT License
 *  *
 *  * Permission is hereby granted, free of charge, to any person obtaining a copy
 *  * of this software and associated documentation files (the "Software"), to deal
 *  * in the Software without restriction, including without limitation the rights
 *  * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 *  * copies of the Software, and to permit persons to whom the Software is
 *  * furnished to do so, subject to the following conditions:
 *  *
 *  * The above copyright notice and this permission notice shall be included in all
 *  * copies or substantial portions of the Software.
 *  *
 *  * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 *  * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 *  * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 *  * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 *  * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 *  * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 *  * SOFTWARE.
 *
 */

package com.example.android.quizmadrid;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.ShareActionProvider;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.android.quizmadrid.R.id.webView;


public class MainActivity extends AppCompatActivity {

    int score = 0;
    private WebView myWebView;
    private ShareActionProvider mShareActionProvider;

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

        WebView myWebView = (WebView) this.findViewById(webView);
        String playVideo = "<html><body><iframe class=\"youtube-player\" type=\"text/html\" width=\"400\" height=\"360\" src=\"https://www.youtube.com/embed/XMjpaWnXJoM\" frameborder=\"0\"></body></html>";
        myWebView.getSettings().setJavaScriptEnabled(true);
        myWebView.loadData(playVideo, "text/html", "utf-8");

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate menu resource file.
        getMenuInflater().inflate(R.menu.filename, menu);
        // Locate MenuItem with ShareActionProvider
        MenuItem item = menu.findItem(R.id.menu_item_share);
        // Fetch and store ShareActionProvider
        mShareActionProvider = (ShareActionProvider) MenuItemCompat.getActionProvider(item);
        // Set share Intent.
        mShareActionProvider.setShareIntent(createShareIntent());
        return true;
    }

    // Create and return the Share Intent
    private Intent createShareIntent() {
        Intent shareIntent = new Intent(Intent.ACTION_SEND);
        shareIntent.setType("text/plain");
        shareIntent.putExtra(Intent.EXTRA_TEXT, "This is the final version of my Madrid Quiz App");
        return shareIntent;
    }

    public void firstQuestion() {
        RadioButton rightAnswer1 = (RadioButton) findViewById(R.id.radioButton1);
        if (rightAnswer1.isChecked()) {
            score = score + 1;

        }
    }

    public void secondQuestion() {
        RadioButton rightAnswer1 = (RadioButton) findViewById(R.id.radioButton7);
        if (rightAnswer1.isChecked()) {
            score = score + 1;

        }
    }

    public void thirdQuestion() {

        //get answer form edit text

        EditText edt = (EditText) findViewById(R.id.editableAnswer1);
        String editableAnswer1 = edt.getText().toString();
        //compare answersº  º
        if (editableAnswer1.equalsIgnoreCase(getString(R.string.Mamelukes))) {
            score = score + 1;
        }
    }

    public void fourthQuestion() {

        //get answer form edit text

        EditText edt = (EditText) findViewById(R.id.editableAnswer2);
        String editableAnswer2 = edt.getText().toString();
        //compare answers
        if (editableAnswer2.equalsIgnoreCase("1808")) {
            score = score + 1;
        }
    }

    public void fifthQuestion() {

        //get answer form edit text

        EditText edt = (EditText) findViewById(R.id.editableAnswer3);
        String editableAnswer3 = edt.getText().toString();
        //compare answers
        if (editableAnswer3.equalsIgnoreCase("1919")) {
            score = score + 1;
        }
    }

    public void sixthQuestion() {
        //choose two answers
        CheckBox chk1 = (CheckBox) findViewById(R.id.checkb1);
        CheckBox chk2 = (CheckBox) findViewById(R.id.checkb2);
        CheckBox chk3 = (CheckBox) findViewById(R.id.checkb3);
        CheckBox chk4 = (CheckBox) findViewById(R.id.checkb4);

        if ((chk2.isChecked() && chk3.isChecked()) && (!chk1.isChecked() && !chk4.isChecked())) {
            score = score + 1;
        }

    }

    public void tenthQuestionRight(View view) {
        //show a picture depending on user's answer
        RadioButton answerYes = (RadioButton) findViewById(R.id.yes);
        ImageView myImageView1 = (ImageView) findViewById(R.id.right);
        ImageView myImageView2 = (ImageView) findViewById(R.id.wrong);
        if (answerYes.isChecked()) {
            myImageView1.setVisibility(View.VISIBLE);
            myImageView2.setVisibility(View.GONE);

        } else {
            myImageView1.setVisibility(View.GONE);
        }

    }


    public void tenthQuestionWrong(View view) {
        //show a picture depending on user's answer
        RadioButton answerNo = (RadioButton) findViewById(R.id.no);
        ImageView myImageView1 = (ImageView) findViewById(R.id.right);
        ImageView myImageView2 = (ImageView) findViewById(R.id.wrong);
        if (answerNo.isChecked()) {
            myImageView2.setVisibility(View.VISIBLE);
            myImageView1.setVisibility(View.GONE);
        } else {
            myImageView2.setVisibility(View.GONE);
        }

    }

    public void getScore(View view) {
        firstQuestion();
        secondQuestion();
        thirdQuestion();
        fourthQuestion();
        fifthQuestion();
        sixthQuestion();

        TextView tv = (TextView) findViewById(R.id.display_result);
        tv.setText(String.valueOf(score));
        Button button = (Button) findViewById(R.id.submitButton);
        button.setClickable(false);
        if (score <= 3) {
            //show toast
            Toast.makeText(getApplicationContext(), "Need to improve", Toast.LENGTH_LONG).show();
        }
        if (score >= 4 && score <= 5) {
            //show toast
            Toast.makeText(getApplicationContext(), "Not so bad", Toast.LENGTH_LONG).show();
        }
        if (score == 6) {
            //show toast
            Toast.makeText(getApplicationContext(), "Well done", Toast.LENGTH_LONG).show();
        }
    }

    public void resetScore(View view) {
        score = 0;

        CheckBox checkb1 = (CheckBox) findViewById(R.id.checkb1);
        checkb1.setChecked(false);
        CheckBox checkb2 = (CheckBox) findViewById(R.id.checkb2);
        checkb2.setChecked(false);
        CheckBox checkb3 = (CheckBox) findViewById(R.id.checkb3);
        checkb3.setChecked(false);
        CheckBox checkb4 = (CheckBox) findViewById(R.id.checkb4);
        checkb4.setChecked(false);

        RadioButton radioButton1 = (RadioButton) findViewById(R.id.radioButton1);
        radioButton1.setChecked(false);

        RadioButton radioButton2 = (RadioButton) findViewById(R.id.radioButton2);
        radioButton2.setChecked(false);

        RadioButton radioButton3 = (RadioButton) findViewById(R.id.radioButton3);
        radioButton3.setChecked(false);

        RadioButton radioButton4 = (RadioButton) findViewById(R.id.radioButton4);
        radioButton4.setChecked(false);

        RadioButton radioButton5 = (RadioButton) findViewById(R.id.radioButton5);
        radioButton5.setChecked(false);

        RadioButton radioButton6 = (RadioButton) findViewById(R.id.radioButton6);
        radioButton6.setChecked(false);

        RadioButton radioButton7 = (RadioButton) findViewById(R.id.radioButton7);
        radioButton7.setChecked(false);

        RadioButton yes = (RadioButton) findViewById(R.id.yes);
        yes.setChecked(false);

        RadioButton no = (RadioButton) findViewById(R.id.no);
        no.setChecked(false);

        EditText et1 = (EditText) findViewById(R.id.editableAnswer1);
        et1.setText("");
        EditText et2 = (EditText) findViewById(R.id.editableAnswer2);
        et2.setText("");
        EditText et3 = (EditText) findViewById(R.id.editableAnswer3);
        et3.setText("");

        ImageView myImageView1 = (ImageView) findViewById(R.id.right);
        myImageView1.setVisibility(View.GONE);
        ImageView myImageView2 = (ImageView) findViewById(R.id.wrong);
        myImageView2.setVisibility(View.GONE);

        TextView tv = (TextView) findViewById(R.id.display_result);
        tv.setText(String.valueOf(score));
        Button button = (Button) findViewById(R.id.submitButton);
        button.setClickable(true);
    }

}