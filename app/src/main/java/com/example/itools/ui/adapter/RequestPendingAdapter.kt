package com.example.itools.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

import com.example.itools.model.entity.RequestClient

class RequestPendingAdapter(var context : Context) :
    RecyclerView.Adapter<RequestPendingAdapter.ViewHolderRequestPending>() {

    companion object var requestsList = arrayListOf<RequestClient>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderRequestPending {
        val itemView = LayoutInflater.from(context)
            .inflate(com.example.itools.R.layout.request_pending_item, parent, false)

        return ViewHolderRequestPending(itemView)
    }

    override fun getItemCount(): Int {
        return requestsList.size
    }

    override fun onBindViewHolder(holder: ViewHolderRequestPending, position: Int) {
        val requestClient = this.requestsList[position]

        holder.bind(requestClient)

    }

    fun setRequestList(requestsList: List<RequestClient>){
        this.requestsList.addAll(requestsList)
        notifyDataSetChanged()
    }

    inner class ViewHolderRequestPending(itemView: View) :
        RecyclerView.ViewHolder(itemView) {


        var name : TextView
        val prefix : TextView

        init {
            name = itemView.findViewById(com.example.itools.R.id.textview_username_request_pending)
            prefix = itemView.findViewById(com.example.itools.R.id.textview_prefix_request_pending)
        }


        fun bind(requestClient : RequestClient){
            name.text = requestClient.Cliente
            prefix.text = requestClient.Cliente.substring(0,1)
        }

    }

}
