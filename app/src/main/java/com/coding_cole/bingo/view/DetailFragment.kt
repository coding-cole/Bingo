package com.coding_cole.bingo.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import com.coding_cole.bingo.R
import com.coding_cole.bingo.viewModel.DetailViewModel
import kotlinx.android.synthetic.main.fragment_detail.*

class DetailFragment : Fragment() {

    private var dogUuid = 0
    private lateinit var viewModel: DetailViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProviders.of(this).get(DetailViewModel::class.java)
        viewModel.fetch()

        // retrieving the arguments
        arguments?.let {
            // if argument is not null(arguments(?)) because of the question mark...run
            dogUuid = DetailFragmentArgs.fromBundle(it).doguid
        }

        observeViewModel()

    }

    private fun observeViewModel() {
        viewModel.dogLiveData.observe(viewLifecycleOwner, Observer { dog ->
            dog?.let {
                dog_name.text = dog.dogBreed
                dog_purpose.text = dog.bredFor
                dog_tempraments.text = dog.temperaments
                dog_lifespan.text = dog.lifeSpan
            }
        })
    }

}