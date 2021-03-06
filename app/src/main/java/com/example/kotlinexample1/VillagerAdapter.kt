package com.example.kotlinexample1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class VillagerAdapter (private val dataset: List<Villager>): RecyclerView.Adapter<VillagerAdapter.ItemViewHolder>() {

    class ItemViewHolder (private val view: View): RecyclerView.ViewHolder (view){
        val textViewName:TextView=view.findViewById(R.id.textView_name);
        val textViewBirthday:TextView=view.findViewById(R.id.textView_birthday);
        val textViewPhrase:TextView=view.findViewById(R.id.textView_phrase);
        val imageViewVillager: ImageView=view.findViewById(R.id.imageView_villager);

    }

    override fun getItemCount(): Int {
        return dataset.size;
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int){
        var villager:Villager = dataset[position];
        holder.textViewName.text=villager.name;
        holder.textViewBirthday.text=villager.birthday;
        holder.textViewPhrase.text=villager.phrase;
        Picasso.get().load(villager.houseURL).into(holder.imageViewVillager);
        holder.imageViewVillager.setOnClickListener({
            if(villager.show==true){
                Picasso.get().load(villager.villagerURL).into(holder.imageViewVillager);
                villager.show=false;
            }
          else{
                Picasso.get().load(villager.houseURL).into(holder.imageViewVillager);
                villager.show=true;
            }
        })

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VillagerAdapter.ItemViewHolder {
        val adapterLayout= LayoutInflater.from(parent.context).inflate(R.layout.item_villager, parent, false)
        return ItemViewHolder(adapterLayout);
    }

}