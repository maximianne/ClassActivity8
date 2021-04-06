package com.example.kotlinexample1

//data class ClassName (val x:type, val y:type)
data class Villager (val name:String, val birthday:String, val phrase:String,
                     val houseURL:String, val villagerURL:String, var show:Boolean){
    //toString()
    //getters (no setters because they are all val types)
    //equals

    //all of these methods are autogenerated
}

//val do not come with setter
//var comes with both setter and getter