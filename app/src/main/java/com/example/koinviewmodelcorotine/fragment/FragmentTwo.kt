package com.example.koinviewmodelcorotine.fragment

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.text.method.ScrollingMovementMethod
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.example.koinviewmodelcorotine.R
import com.example.koinviewmodelcorotine.databinding.FragmentOneBinding
import com.example.koinviewmodelcorotine.databinding.FragmentTwoBinding
import com.example.koinviewmodelcorotine.pojos.CustomLifeCycleOwner
import com.example.koinviewmodelcorotine.viewmode.ActivityViewModel


class FragmentTwo : Fragment() {
    lateinit var databinding: FragmentTwoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        databinding= DataBindingUtil.inflate(layoutInflater,R.layout.fragment_two,null,false)
        return databinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        databinding.tvtitle.movementMethod=ScrollingMovementMethod()

       // Handler(Looper.getMainLooper()).postDelayed({
            val viewmodelocal: ActivityViewModel by activityViewModels()
            viewmodelocal.getUsers().observe(viewLifecycleOwner){
                with(databinding.tvtitle){
                    databinding.tvtitle.text=""+it.fName+"\n"+this.text.toString()
                }
            }
    ///    },2000)
lifecycle.addObserver(CustomLifeCycleOwner("FragTwo"))
    }

}