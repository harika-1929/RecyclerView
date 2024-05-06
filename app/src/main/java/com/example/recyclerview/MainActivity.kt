package com.example.recyclerview

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var mailadapter: MailAdapter
    private val mailList = ArrayList<MailDetails>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        prepareDataSet()
    }

    private fun prepareDataSet() {
        mailList.apply {
            add(
                MailDetails(
                sender = "Facebook",
                title =  "you got a new friend request",
                body= "do you want to accept the request.?",
                isFav = true,
                    imageIcon = R.drawable.user2
                )
            )
            add(MailDetails(
                sender = "Gmail",
                title =  "you got a new Mail",
                body= "do you want to check it.?",
                isFav = true
            ))
            add(MailDetails(
                sender = "Skype",
                title =  "you got a new ping",
                body= "do you want to check it.?",
                isFav = true
            ))
        }
        mailadapter= MailAdapter(mailList)
        with(binding)
        {
            recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
            recyclerView.adapter= mailadapter
            ItemTouchHelper(object:ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT)
            {
                override fun onSwiped(viewHolder: RecyclerView.ViewHolder, dir: Int) {
                    val position = viewHolder.adapterPosition
                    mailList.removeAt(position)
                    mailadapter.notifyItemRemoved(position)
                    Snackbar.make(
                        findViewById(R.id.main),
                        if(dir ==ItemTouchHelper.LEFT) "Deleted" else "Archived",
                        Snackbar.LENGTH_SHORT
                    ).show()
                }

                override fun onMove(
                    p0: RecyclerView,
                    p1: RecyclerView.ViewHolder,
                    p2: RecyclerView.ViewHolder
                ): Boolean {
                    return false
                }
            }).attachToRecyclerView(recyclerView)

        }
    }
}