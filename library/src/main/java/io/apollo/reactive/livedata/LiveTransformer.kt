package io.apollo.reactive.livedata

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import com.google.android.gms.tasks.OnFailureListener
import com.google.android.gms.tasks.OnSuccessListener
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthCredential
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import io.apollo.reactive.rx.toRxSingle
import io.reactivex.Single
import java.lang.Exception

/**
 * Created by levi on 11/03/18.
 */
fun Task<AuthResult>.toLiveData(): LiveData<LiveResource<AuthResult>> {
    val resultData: MutableLiveData<LiveResource<AuthResult>> = MutableLiveData()

    this.addOnSuccessListener { result ->
        resultData.value = LiveResource(LiveResourceStatus.SUCCESS, result, null)
    }

    this.addOnFailureListener { error ->
        resultData.value = LiveResource(LiveResourceStatus.ERROR, null, error.message)
    }

    return resultData
}

fun FirebaseAuth.liveSignInWithEmailAndPassword(email: String, password: String): LiveData<LiveResource<AuthResult>> {
    return this.signInWithEmailAndPassword(email, password).toLiveData()
}

fun FirebaseAuth.liveSignInAnonimously(): LiveData<LiveResource<AuthResult>> {
    return this.signInAnonymously().toLiveData()
}

fun FirebaseAuth.liveSignInWithCustomToken(token: String): LiveData<LiveResource<AuthResult>> {
    return this.signInWithCustomToken(token).toLiveData()
}

fun FirebaseAuth.liveSignInWithCredential(credential: AuthCredential): LiveData<LiveResource<AuthResult>> {
    return this.signInWithCredential(credential).toLiveData()
}

fun FirebaseAuth.liveCreateUserWithEmailAndPassword(email: String, password: String): LiveData<LiveResource<AuthResult>> {
    return this.createUserWithEmailAndPassword(email, password).toLiveData()
}