package io.apollo.reactive.livedata

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import com.google.firebase.auth.AuthCredential
import com.google.firebase.auth.AuthResult
import io.apollo.reactive.ApolloApp

/**
 * Created by levi on 11/03/18.
 */

object LiveApolloAuth {
    val firebaseUser = ApolloApp.firebaseAuth.currentUser

    fun getInstance(): LiveApolloAuth = this

    fun signInAnonymously(): LiveData<LiveResource<AuthResult>> {
        val resultLiveData = MutableLiveData<LiveResource<AuthResult>>()
        val task = ApolloApp.firebaseAuth.signInAnonymously()
        LiveTransformer<AuthResult>(task, resultLiveData)
        return resultLiveData
    }

    fun signInWithEmailAndPassword(email: String, password: String): LiveData<LiveResource<AuthResult>> {
        val resultLiveData = MutableLiveData<LiveResource<AuthResult>>()
        val task = ApolloApp.firebaseAuth.signInWithEmailAndPassword(email, password)
        LiveTransformer<AuthResult>(task, resultLiveData)
        return resultLiveData
    }

    fun createUserWithEmailAndPassword(email: String, password: String): LiveData<LiveResource<AuthResult>> {
        val resultLiveData = MutableLiveData<LiveResource<AuthResult>>()
        val task = ApolloApp.firebaseAuth.createUserWithEmailAndPassword(email, password)
        LiveTransformer<AuthResult>(task, resultLiveData)

        return resultLiveData
    }

    fun signInWithCredential(credential: AuthCredential): LiveData<LiveResource<AuthResult>> {
        val resultLiveData = MutableLiveData<LiveResource<AuthResult>>()
        val task = ApolloApp.firebaseAuth.signInWithCredential(credential)
        LiveTransformer<AuthResult>(task, resultLiveData)
        return resultLiveData
    }

    fun signInWithCustomToken(token: String): LiveData<LiveResource<AuthResult>> {
        val resultLiveData = MutableLiveData<LiveResource<AuthResult>>()
        val task = ApolloApp.firebaseAuth.signInWithCustomToken(token)
        LiveTransformer<AuthResult>(task, resultLiveData)
        return resultLiveData
    }


    fun signOut() {
        ApolloApp.firebaseAuth.signOut()
    }
}
