package io.apollo.sample


import android.arch.lifecycle.LifecycleOwner
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.google.firebase.auth.FirebaseAuth
import io.apollo.reactive.rx.rxSignInWithEmailAndPassword
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MainActivity : AppCompatActivity(), LifecycleOwner {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rxAuth = FirebaseAuth.getInstance()
        rxAuth
                .rxSignInWithEmailAndPassword("levi.m.albuquerque@gmail.com", "levi1110")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ result ->
                    result?.let {
                        Log.e("MAINACTIVITY", it.user.uid)
                    }
                }, { error ->
                    error.printStackTrace()
                })
    }
}
