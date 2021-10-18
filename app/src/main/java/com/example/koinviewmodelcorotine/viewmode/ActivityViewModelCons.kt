package com.example.koinviewmodelcorotine.viewmode

import androidx.lifecycle.*
import com.example.koinviewmodelcorotine.pojos.CustomLifeCycleOwner
import com.example.koinviewmodelcorotine.pojos.User
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.time.format.DateTimeFormatter

//class ActivityViewModelCons(var lifeCycleOwner: LifecycleOwner):ViewModel() {
class ActivityViewModelCons(var name:String,var lifeCycleOwner: LifecycleOwner):ViewModel() {

    private val users: MutableLiveData<User> by lazy {
        MutableLiveData<User>().also {
            loadUsers()
        }
    }

    fun getUsers(): LiveData<User> {
        return users
    }

    private fun loadUsers() {

        // Do an asynchronous operation to fetch users.
        //users.value=ArrayList()
        CoroutineScope(viewModelScope.coroutineContext).launch {
            repeat(100000){
                delay(2000)
//                if(lifeCycleOwner.lifecycle.currentState==Lifecycle.State.STARTED){
//                    val time=SimpleDateFormat("hh:mm:ss").format(System.currentTimeMillis())
//                    users.value=(User("dfd $it-($time)","dfd"))
//                }
                lifeCycleOwner.lifecycle.whenResumed {
                    val time=SimpleDateFormat("hh:mm:ss").format(System.currentTimeMillis())
                    users.value=(User("$name $it-($time)","dfd"))
                }
            }
        }
    }
}