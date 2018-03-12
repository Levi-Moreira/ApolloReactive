package io.apollo.sample

import android.arch.lifecycle.Observer
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.google.firebase.auth.AuthResult
import io.apollo.reactive.livedata.LiveApolloAuth
import io.apollo.reactive.livedata.LiveResource
import io.apollo.reactive.livedata.LiveResourceStatus
import io.apollo.reactive.rx.RxApolloAuth
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MainActivity : AppCompatActivity() {

    val rxAuth = RxApolloAuth.getInstance()
    val liveAuth = LiveApolloAuth.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        rxAuth.signInAnonymously()
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe({ result ->
//                    Log.d("MainActivity", result.user.uid)
//                },
//                        { error ->
//                            error.printStackTrace()
//                        })

        val authObserver = Observer<LiveResource<AuthResult>> { result ->
            if (result?.status == LiveResourceStatus.SUCCESS) {
                Log.d("MainActivity", result.data?.user?.uid)
            } else {
                Log.d("MainActivity", result?.message)
            }
        }

        liveAuth.signInAnonymously().observe(this, authObserver)

        val email = "levi.albuquerque@gmail.com"
        val password = "levi1234"
        val disobsable = rxAuth
                .createUserWithEmailAndPassword(email, password)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ result ->
                    Log.d("MainActivity", result.user.uid)
                }, { error ->
                    error.printStackTrace()
                })


//        rxAuth
//                .signInWithEmailAndPassword(email, password)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe({ result ->
//                    Log.d("MainActivity", result.user.uid)
//                }, { error ->
//                    error.printStackTrace()
//                })

//        val email = "levi.albuquerque@conceptu.ind.br"
//        val password = "levi1234"
//
//        liveAuth.signInWithEmailAndPassword(email, password).observe(this, authObserver)

        liveAuth.signOut()
//        rxAuth.signOut()
    }
}
