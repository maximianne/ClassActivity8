package com.example.kotlinexample1

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlinexample1.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity(){

    private lateinit var binding:ActivitySecondBinding;
    private lateinit var textViewGreeting: TextView;
    private lateinit var buttonHistory: Button;
    private final val baseURL= "http://www.behindthename.com/name/";

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);
        binding=ActivitySecondBinding.inflate(layoutInflater);
        setContentView(binding.root);

        textViewGreeting=binding.textViewGreeting;
        buttonHistory=binding.buttonHistory;

        val message  = intent.getStringExtra("name");

        textViewGreeting.text="Hello " +message;
        buttonHistory.setText("History about " + message);
        buttonHistory.setOnClickListener{
           if (message != null) {
               launchBrowser(message)
           };
       }
    }

    //when the button is clicked,
    // I want to send an implicit intent
    // with the name passed through intent= Uri
    private fun launchBrowser(name :String){
        //Uri to parse the actual url
        //start an activity with action view
        val queryURL:Uri=Uri.parse("${baseURL}${name}");
        //template string
        //"${}"
        val intent= Intent(Intent.ACTION_VIEW, queryURL);
        startActivity(intent);
    }
}