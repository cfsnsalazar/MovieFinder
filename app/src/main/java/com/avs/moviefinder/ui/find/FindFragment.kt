package com.avs.moviefinder.ui.find

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.avs.moviefinder.R
import com.avs.moviefinder.databinding.FragmentFindBinding
import com.avs.moviefinder.ui.MainActivity
import javax.inject.Inject

class FindFragment : Fragment() {

    @Inject
    lateinit var findViewModel: FindViewModel

    private lateinit var binding: FragmentFindBinding

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (activity as MainActivity).mainComponent.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_find, container, false)
        val root: View = binding.root
        binding.findViewModel = findViewModel
        binding.lifecycleOwner = this
        val adapter = FindAdapter()
        binding.rvFindRecyclerView.adapter = adapter
        binding.swipeRefreshLayout.setColorSchemeResources(R.color.colorPrimary)
        findViewModel.movies.observe(viewLifecycleOwner, Observer {
            it?.let {
                adapter.submitList(it)
            }
        })
        findViewModel.isProgressVisible.observe(viewLifecycleOwner, Observer {
            binding.pbFindProgress.visibility = if (it) View.VISIBLE else View.INVISIBLE
        })
        findViewModel.isError.observe(viewLifecycleOwner, Observer {
            if (it) (activity as MainActivity).showSnackBar(resources.getString(R.string.network_error_occurred))
            binding.ivError.visibility = if (it) View.VISIBLE else View.INVISIBLE
        })
        return root
    }
}