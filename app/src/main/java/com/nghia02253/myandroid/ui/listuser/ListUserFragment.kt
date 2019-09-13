package com.nghia02253.myandroid.ui.listuser

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.nghia02253.myandroid.R

class ListUserFragment : Fragment() {

    companion object {
        fun newInstance() = ListUserFragment()
    }

    private lateinit var viewModel: ListUserViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.list_user_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(ListUserViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
