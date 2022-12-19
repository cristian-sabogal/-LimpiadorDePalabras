package com.platzi.limpiadordepalabras

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.platzi.limpiadordepalabras.databinding.FragmentFirstBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.LimpiarTextoBtn.setOnClickListener(){
            val textoALimpiar = binding.TextoALimpiar.text.toString()
            val parts = textoALimpiar.split("@", " ")
            val textoLimpio = parts[1]
            binding.TextoLimpio.setText(textoLimpio)
        }

        binding.TwitterBtn.setOnClickListener(){
            val website = "https://twitter.com/"
            linkTo(website)
        }

        binding.IGBtn.setOnClickListener(){
            val website = "https://instagram.com/"
            linkTo(website)
        }

        binding.LinkTreeBtn.setOnClickListener(){
            val website = "https://linktr.ee/"
            linkTo(website)
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    fun linkTo(website: String){
        val user = binding.TextoLimpio.text.toString()
        val uri = Uri.parse(website + user)
        val intent = Intent(Intent.ACTION_VIEW, uri)
        startActivity(intent)
    }


}