package com.example.koinviewmodelcorotine.viewmode

import androidx.lifecycle.*
import com.example.koinviewmodelcorotine.pojos.CustomLifeCycleOwner
import com.example.koinviewmodelcorotine.pojos.User
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.koin.java.KoinJavaComponent.get
import org.koin.java.KoinJavaComponent.inject
import java.text.SimpleDateFormat
import java.time.format.DateTimeFormatter

class ActivityViewModel:ViewModel() {

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
//                lifeCycleOwner.lifecycle.whenResumed {
                    val time=SimpleDateFormat("hh:mm:ss").format(System.currentTimeMillis())
                   // users.value=(User("dfd $it-($time)","dfd"))

                    users.value=(User("dfd $it-($time)","dfd"))
//                }
            }
        }
    }
}