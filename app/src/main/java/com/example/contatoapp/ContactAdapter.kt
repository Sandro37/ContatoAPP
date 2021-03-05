package com.example.contatoapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ContactAdapter(var listener: ClickContactListener): RecyclerView.Adapter<ContactAdapter.ContactAdapterViewHolder>(){

    private val list: MutableList<Contact> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactAdapterViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.contact_item, parent, false)
        return ContactAdapterViewHolder(view, list, listener)
    }

    override fun onBindViewHolder(holder: ContactAdapterViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

    fun updateList(lista: List<Contact>) {
        this.list.clear()
        this.list.addAll(lista)
        notifyDataSetChanged()
    }

    class  ContactAdapterViewHolder (itemView: View, var list: List<Contact>, var listener: ClickContactListener): RecyclerView.ViewHolder(itemView){
        private val txtName: TextView = itemView.findViewById(R.id.txt_name)
        private val txtPhone: TextView = itemView.findViewById(R.id.txt_phone)
        private val  imgViewPhoto: ImageView = itemView.findViewById(R.id.iv_photograph)

        init {
            itemView.setOnClickListener {
                listener.clickItemContact(list[adapterPosition])
            }
        }

        fun bind(contact: Contact){
            txtName.text = contact.name
            txtPhone.text = contact.phone
        }
    }
}