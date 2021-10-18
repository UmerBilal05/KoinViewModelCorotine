package com.example.koinviewmodelcorotine.viewmode

import android.os.Bundle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.koinviewmodelcorotine.fragment.FragmentTwo
import com.example.koinviewmodelcorotine.pojos.User

//class ViewModelFactory(val lifecycleOwner: LifecycleOwner):ViewModelProvider.NewInstanceFactory() {
class ViewModelFactory(val lifecycleOwner: LifecycleOwner):ViewModelProvider.Factory {

    private var user: User?=null
    private var definetViewModel:Boolean=false
    fun setUser(user: User):ViewModelFactory{
        this.user=user
        return this
    }
    fun setDefinetModel(definetViewModel: Boolean):ViewModelFactory{
        this.definetViewModel=definetViewModel
        return this
    }


    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        FragmentTwo::class.java.name
        if(modelClass.isAssignableFrom(ActivityViewModelCons::class.java)){
            return ActivityViewModel() as T
            //return ActivityViewModelCons(lifecycleOwner) as T
        }else
            return create(modelClass)
    }
}
