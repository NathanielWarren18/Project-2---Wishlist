package com.example.wishlist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.wishlist.R.*
import com.example.wishlist.R.id.*

class MainActivity : AppCompatActivity() {

    private lateinit var wishes: List<Wish>
    private lateinit var adapter: WishAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_main)

        val enterButton = findViewById<Button>(enter)
        val name = findViewById<EditText>(item_name)
        val price = findViewById<EditText>(item_price)
        val url = findViewById<EditText>(item_url)
        val wishesRv = findViewById<RecyclerView>(wishlistRv)



        enterButton.setOnClickListener {

            val userName = name.text.toString()
            val userPrice = price.text.toString()
            val userUrl = url.text.toString()

            wishes = Wish.addToList(userName, userPrice, userUrl)
            adapter.notifyDataSetChanged()

            name.text.clear()
            price.text.clear()
            url.text.clear()

            name.hint = "Enter item name"
            price.hint = "Enter item price"
            url.hint = "Enter item URL"
        }

        val adapter = WishAdapter(wishes)
        wishesRv.adapter = adapter
        wishesRv.layoutManager = LinearLayoutManager(this)
    }
}