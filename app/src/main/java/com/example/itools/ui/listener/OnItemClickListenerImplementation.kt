package com.example.itools.ui.listener

import android.content.Context
import android.widget.Toast
import com.example.itools.model.entity.RequestClient

class OnItemClickListenerImplementation : OnItemClickListener {
    override fun onItemClickListener(requestClient: RequestClient, context: Context) {
        Toast.makeText(context, "Esse e o click ${requestClient.Cliente}", Toast.LENGTH_SHORT).show()
    }
}