package com.example.kotlinexample1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.kotlinexample1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    //private
    //var and val
    //var--> change the value later
    //val--> once you declare you cannot change the values anymore
    private lateinit var buttonGo: Button;
    private lateinit var  editTextName: EditText;
    private lateinit var binding:ActivityMainBinding;
    private lateinit var butonV:Button;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater);
        setContentView(binding.root); //connects to all the views in this layout
        buttonGo=binding.buttonGo;
        butonV=binding.buttonVillagers;

        editTextName=binding.editTextName;
        //using their new thing they reccomend you to use

        /**
        setContentView(R.layout.activity_main)
        buttonGo=findViewById(R.id.button_go);
        editTextName=findViewById(R.id.editText_name);
         **/

        buttonGo.setOnClickListener{
           // toastInput("Hello, " + editTextName.text.toString());
            launchSecondActivity(editTextName.text.toString());
        }
        butonV.setOnClickListener{
            launchThirdActivity()
        }
    }
    private fun toastInput(text: String){
        Toast.makeText(this,text, Toast.LENGTH_LONG).show();
    }

    private fun launchSecondActivity(message:String){
        val intent = Intent(this,SecondActivity::class.java);
                                                //refer to the class that you are linking to
        intent.putExtra("name", message);
        startActivity(intent);
    }
    private fun launchThirdActivity(){
        val intent= Intent(this, ThirdActivity::class.java)
        startActivity(intent);
    }
}