package com.example.recyclerview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.recyclerview.databinding.ActivityMailDetailsBinding
import com.example.recyclerview.databinding.ItemEmailBinding

class MailDetailsActivity: AppCompatActivity() {
    private lateinit var binding: ActivityMailDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMailDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initViews()
    }

    private fun initViews() {
        val email = intent.extras?.get("Data") as MailDetails
        with(binding)
        {
            txtSender.text = email.sender
            txtBody.text = email.body
            txtTitle.text= email.title
            imgUser.setImageResource(email.imageIcon)
        }
    }
}