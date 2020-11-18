package com.example.itools.ui.listener

import android.content.Context
import com.example.itools.model.entity.RequestClient
import java.text.FieldPosition

interface OnItemClickListener {

    fun onItemClickListener(requestClient: RequestClient, context: Context)
}