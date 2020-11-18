package com.example.itools.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.itools.R
import com.example.itools.model.entity.RequestClient
import com.example.itools.service.retrofit.RetrofitService
import com.example.itools.ui.adapter.RequestInProgressAdapter
import com.example.itools.ui.adapter.RequestPendingAdapter
import com.example.itools.ui.listener.OnItemClickListener
import com.example.itools.ui.listener.OnItemClickListenerImplementation
import com.example.itools.ui.viewmodel.EmployeeRequestsViewModel
import org.koin.android.ext.android.get
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class EmployeeRequestsControll : Fragment() {

    private lateinit var recyclerRequestPending : RecyclerView
    private lateinit var recyclerRequestInProgress: RecyclerView

    private val requestPendingAdapter by inject<RequestPendingAdapter>()
    private val requestInProgressAdapter by inject<RequestInProgressAdapter>()

    private val onItemClickListener : OnItemClickListener = OnItemClickListenerImplementation()

//    val viewModel by viewModel<EmployeeRequestsViewModel>()

    val employeeRequestsViewModel : EmployeeRequestsViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        employeeRequestsViewModel.getRequestList()

        requestInProgressAdapter.setClick(onItemClickListener)

        recyclerRequestPending = view.findViewById(R.id.requests_pending_list)
        recyclerRequestInProgress = view.findViewById(R.id.requests_in_progess_list)


        recyclerRequestInProgress.adapter = requestInProgressAdapter
        recyclerRequestPending.adapter = requestPendingAdapter


    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.employee_requests, container, false)
    }

}