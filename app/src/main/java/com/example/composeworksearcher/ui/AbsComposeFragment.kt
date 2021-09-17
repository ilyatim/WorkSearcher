package com.example.composeworksearcher.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment

/**
 * Абстрактрый класс для реализации compose в фрагментах.
 * Необходимо лишь переопределить метод Content()
 */
abstract class AbsComposeFragment() : Fragment() {

    @Composable
    abstract fun Content()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = ComposeView(requireContext()).apply {
        setContent { Content() }
    }
}