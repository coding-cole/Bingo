package com.coding_cole.bingo.view

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.coding_cole.bingo.R
import com.coding_cole.bingo.viewModel.ListViewModel
import kotlinx.android.synthetic.main.fragment_list.*

class ListFragment : Fragment() {

    private lateinit var viewModel: ListViewModel
    private val dogsListAdapter = DogsListAdapter(arrayListOf())

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProviders.of(this).get(ListViewModel::class.java)
        viewModel.refresh()
        dogs_list.apply {
            // TODO layoutManager = GridLayoutManager(context, 2)
            layoutManager = LinearLayoutManager(context)
            adapter = dogsListAdapter
        }
        refreshLayout.setOnRefreshListener {
            dogs_list.visibility = View.GONE
            list_error.visibility = View.GONE
            loading_view.visibility = View.VISIBLE
            viewModel.refresh()
            refreshLayout.isRefreshing = false
        }

        observeViewModel()
    }

    private fun observeViewModel() {

//        viewModel.dogs.observe(viewLifecycleOwner, Observer {
//            it?.let {
//                dogs_list.visibility = View.VISIBLE
//                dogsListAdapter.updateDogsList(it)
//            }
//
//        })
        // you either name the Observer variable as done below or use the "it" like above

        viewModel.dogs.observe(viewLifecycleOwner, Observer {dogs ->
            dogs?.let {
                dogs_list.visibility = View.VISIBLE
                dogsListAdapter.updateDogsList(dogs)
            }

        })
        viewModel.dogsLoadError.observe(viewLifecycleOwner, Observer { isError ->
            isError?.let {
                list_error.visibility = if (it) View.VISIBLE else View.GONE
            }
        })
        viewModel.loading.observe(viewLifecycleOwner, Observer {isLoading ->
            isLoading?.let {
                loading_view.visibility = if (it) View.VISIBLE else View.GONE
                if (it) {
                    list_error.visibility = View.GONE
                    dogs_list.visibility = View.GONE
                }
            }
        })

    }

}