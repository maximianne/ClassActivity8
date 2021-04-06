package com.example.kotlinexample1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinexample1.databinding.ActivityThirdBinding
import org.json.JSONObject

class ThirdActivity: AppCompatActivity() {
    //read in the json file
    //creating an arraylist of villager
    //create the adapter with the lsit of villagers
    //set it to the recyclerview

    private  lateinit var villagerList:ArrayList<Villager>
    private lateinit var binding:ActivityThirdBinding
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityThirdBinding.inflate(layoutInflater)
        setContentView(binding.root)
        villagerList= ArrayList<Villager>()

        recyclerView = binding.recyclerViewVillagers

        val jsonFileContent= loadJSONfromAssets("villagers.json");
        val jsonObject= JSONObject(jsonFileContent);
        val jsonArray=jsonObject.getJSONArray("villagers");

        for(i in 0 until jsonArray.length()){
            val villagerJSONObject = jsonArray.getJSONObject(i);

            val name:String= villagerJSONObject.get("name").toString();
            val birthday:String= villagerJSONObject.get("birthday").toString();
            val phrase:String= villagerJSONObject.get("phrase").toString();
            val house:String= villagerJSONObject.get("house").toString();
            val villagerURL:String= villagerJSONObject.get("villager").toString();

            val villagerObject:Villager= Villager(name,birthday,phrase,house,villagerURL, true);
            villagerList.add(villagerObject);
        }
        recyclerView.adapter=VillagerAdapter(villagerList);
        recyclerView.layoutManager=LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true);


    }

    private fun loadJSONfromAssets(filename:String):String{
        return applicationContext.assets.open(filename).bufferedReader().use {it.readText()} }


}