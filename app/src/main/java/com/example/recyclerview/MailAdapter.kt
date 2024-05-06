package com.example.recyclerview

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.databinding.ItemEmailBinding

class MailAdapter(private val mails:List<MailDetails>):
    RecyclerView.Adapter<MailAdapter.MailViewHolder>()
{
        private lateinit var binding: ItemEmailBinding

    override fun getItemCount(): Int = mails.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MailViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        binding= ItemEmailBinding.inflate(layoutInflater,parent, false)
        return MailViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MailViewHolder, position: Int) {
        val data = mails[position]
        holder.bindData(data, position)
        val context = holder.itemView.context
        holder.itemView.setOnClickListener{
            val intent = Intent(context, MailDetailsActivity::class.java)
            intent.putExtra("Data", data)
            context.startActivity(intent)
        }
    }
    inner class MailViewHolder(private val localbinding: ItemEmailBinding):
        RecyclerView.ViewHolder(binding.root){

            fun bindData(mailDetails: MailDetails, position: Int)
            {
                with(localbinding)
                {
                    txtSender.text = mailDetails.sender
                    txtBody.text= mailDetails.body
                    txttime.text="10:30 PM"
                    txtTitle.text = mailDetails.title
                    if(position%2==0)
                    {
                        imgUser.setImageResource(mailDetails.imageIcon)
                    }
                    else
                    {
                        imgUser.setImageResource(mailDetails.imageIcon)
                    }

                }
            }

    }
}