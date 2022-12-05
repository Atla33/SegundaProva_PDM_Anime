package com.example.segundaprovaanimes.ui.detalhes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.segundaprovaanimes.databinding.FragmentDetalhesBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class DetalhesFragment : Fragment() {

    private lateinit var _binding: FragmentDetalhesBinding
    private lateinit var _viewmodel: DetalhesViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetalhesBinding.inflate(inflater, container, false)
        _viewmodel = ViewModelProvider(this)[DetalhesViewModel::class.java]

        _binding.viewmodel = _viewmodel
        _binding.lifecycleOwner = this

        var id = arguments?.getInt("position")
        _viewmodel.animeSelecionado(id!!)
        return _binding.root
    }
}