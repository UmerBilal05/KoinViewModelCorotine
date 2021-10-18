package com.example.koinviewmodelcorotine.fragment

import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.example.koinviewmodelcorotine.R
import com.example.koinviewmodelcorotine.databinding.FragmentOneBinding
import com.example.koinviewmodelcorotine.pojos.CustomLifeCycleOwner
import com.example.koinviewmodelcorotine.pojos.User
import com.example.koinviewmodelcorotine.viewmode.ActivityViewModel
import com.example.koinviewmodelcorotine.viewmode.ActivityViewModelCons
import com.example.koinviewmodelcorotine.viewmode.ViewModelFactory
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf


class FragmentOne : Fragment() {

    val helloService by inject<User>()
    val viewmodelocalnew: ActivityViewModelCons by viewModel{ parametersOf(viewLifecycleOwner) }

//    val viewModelProviderByKoin: ActivityViewModelCons by viewModel()
//    val viewModelProviderByFrag: ActivityViewModel by viewModels()

      //private val viewModelcons:ActivityViewModelCons by viewModel{parametersOf(viewLifecycleOwner)}
     // private val viewModelcons:ActivityViewModelCons by state{parametersOf(viewLifecycleOwner)}



    lateinit var databinding: FragmentOneBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        databinding = DataBindingUtil.inflate(layoutInflater, R.layout.fragment_one, null, false)
        return databinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        databinding.tvtitle.movementMethod = ScrollingMovementMethod()
        val viewmodelocal: ActivityViewModel by activityViewModels()
      //  val insideViewModel:ActivityViewModel by getViewModel()
        viewmodelocal.getUsers().observe(viewLifecycleOwner) {
            with(databinding.tvtitle) {
                databinding.tvtitle.text = "" + it.fName + "\n" + this.text.toString()
            }
        }
        lifecycle.addObserver(CustomLifeCycleOwner("FragOne"))
     //   val viewmodelocalnew: ActivityViewModelCons by viewModels({ this }, { ViewModelFactory(viewLifecycleOwner).setUser(helloService) })
        val viewmodelocalnew: ActivityViewModelCons by viewModel { parametersOf("dflsjd",viewLifecycleOwner)}
                viewmodelocalnew.getUsers().observe(viewLifecycleOwner) {
            with(databinding.tvtitle2) {
                databinding.tvtitle2.text = "" + it.fName + "\n" + this.text.toString()
            }
        }

    // val viewmodelocalqw: ActivityViewModel =ViewModelProvider(this,ViewModelFactory(viewLifecycleOwner)).get(ActivityViewModel::class.java)
    }
}