package com.example.myfragmentapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView


class SecondFragment : Fragment() {
    lateinit var textViewFragment2: TextView
    lateinit var buttonViewFragment2: Button

    private var text: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            text = it.getString("text")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_second, container, false)
        textViewFragment2 = view.findViewById(R.id.textViewFragment2)
        text?.let {
            textViewFragment2.text = it
        }
        buttonViewFragment2 = view.findViewById(R.id.buttonFragment2)
        buttonViewFragment2.setOnClickListener {
            textViewFragment2.text = "${textViewFragment2.text} Clicked"
        }

        return view
    }
}