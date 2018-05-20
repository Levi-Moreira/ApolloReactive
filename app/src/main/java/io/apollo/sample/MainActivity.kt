package io.apollo.sample


import android.arch.lifecycle.LifecycleOwner
import android.arch.lifecycle.Observer
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import io.apollo.reactive.livedata.LiveApolloAuth
import io.apollo.reactive.rx.RxApolloAuth
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MainActivity : AppCompatActivity(), LifecycleOwner {

    val rxAuth = RxApolloAuth.getInstance()
    val liveAuth = LiveApolloAuth.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rxAuth = RxApolloAuth.getInstance()
        rxAuth
                .signInAnonymously()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    //result ok
                }, {
                    //result error
                })

        val liveAuth = LiveApolloAuth.getInstance()
        liveAuth.signInAnonymously().observe(this, Observer {
            //result
        })
    }
}
