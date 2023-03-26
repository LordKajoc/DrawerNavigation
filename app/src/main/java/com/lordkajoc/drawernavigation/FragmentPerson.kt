package com.lordkajoc.drawernavigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.lordkajoc.drawernavigation.databinding.FragmentPersonBinding

class FragmentPerson : Fragment() {
    lateinit var binding:FragmentPersonBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding = FragmentPersonBinding.inflate(layoutInflater)
        return binding.root
    }

}