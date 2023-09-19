package com.example.wishlist

class Wish(val name: String, val price: String, val url: String){

    companion object{

        var wishes: MutableList<Wish> = ArrayList()

        fun addToList(name: String, price: String, url: String) : MutableList<Wish> {
            val wish = Wish(name, price, url)
            wishes.add(wish)

            return wishes
        }
    }
}