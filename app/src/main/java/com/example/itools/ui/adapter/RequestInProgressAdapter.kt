package com.example.itools.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.itools.R
import com.example.itools.model.entity.RequestClient
import com.example.itools.ui.listener.OnItemClickListener

import org.w3c.dom.Text

class RequestInProgressAdapter(var context: Context) :
    RecyclerView.Adapter<RequestInProgressAdapter.RequestInProgressViewHolder>(){


    companion object var requestInProgressList = arrayListOf<RequestClient>()

    private lateinit var onItemClickListener : OnItemClickListener

    fun setClick(onItemClickListener: OnItemClickListener){
        this.onItemClickListener = onItemClickListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            RequestInProgressAdapter.RequestInProgressViewHolder {
        val view = LayoutInflater.from(context)
            .inflate(R.layout.request_in_progress_item, parent, false)

        return RequestInProgressViewHolder(view)
    }

    override fun getItemCount(): Int {
        return requestInProgressList.size
    }


    override fun onBindViewHolder(holder: RequestInProgressViewHolder, position: Int) {

        var requestClient = requestInProgressList.get(position)
        holder.bind(requestClient)
        holder.itemView.setOnClickListener {
            onItemClickListener.onItemClickListener(requestClient, context)
        }


    }

    fun setRequestList(requestsList: List<RequestClient>){
        this.requestInProgressList.addAll(requestsList)
        notifyDataSetChanged()
    }

    inner class RequestInProgressViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView){

        private var idRequest : TextView
        private var clientName : TextView



        fun bind(requestClient: RequestClient){
            idRequest.text = requestClient.RequestId.toString()
            clientName.text = requestClient.Cliente


        }

        init {
            idRequest = itemView.findViewById(R.id.request_progress_item_text_numero_id)
            clientName = itemView.findViewById(R.id.request_progress_item_text_cliente_name)


        }


    }

}
