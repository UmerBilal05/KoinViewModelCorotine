package com.example.koinviewmodelcorotine.pojos

import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.OnLifecycleEvent

class CustomLifeCycleOwner(val tag:String):LifecycleObserver {
    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun fun1() {
        Log.e("CustomLifeCycleOwner",tag+ "fun1: ON_RESUME" )
    }
    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun fun2() {
        Log.e("CustomLifeCycleOwner",tag+ "fun2: ON_CREATE" )
    }
    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun fun3() {
        Log.e("CustomLifeCycleOwner",tag+ "fun3: ON_DESTROY" )
    }
    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun fun4() {
        Log.e("CustomLifeCycleOwner",tag+ "fun4: ON_START" )
    }
    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun fun5() {
        Log.e("CustomLifeCycleOwner",tag+ "fun5: ON_STOP" )
    }
    
}