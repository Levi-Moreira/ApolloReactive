package io.apollo.reactive.rx

import com.google.firebase.auth.AuthCredential
import com.google.firebase.auth.AuthResult
import io.apollo.reactive.ApolloApp
import io.reactivex.Single

/**
 * Created by levi on 09/03/18.
 */

object RxApolloAuth {

    val firebaseUser = ApolloApp.firebaseAuth.currentUser

    fun getInstance(): RxApolloAuth = this


    fun signInAnonymously(): Single<AuthResult> {
        return Single.create({ emitter ->
            val task = ApolloApp.firebaseAuth.signInAnonymously()
            RxSingleTransformer<AuthResult>(task, emitter)
        })
    }

    fun createUserWithEmailAndPassword(email: String, password: String): Single<AuthResult> {
        return Single.create({ emitter ->
            val task = ApolloApp.firebaseAuth.createUserWithEmailAndPassword(email, password)
            RxSingleTransformer<AuthResult>(task, emitter)
        })
    }

    fun signInWithEmailAndPassword(email: String, password: String): Single<AuthResult> {
        return Single.create({ emitter ->
            val task = ApolloApp.firebaseAuth.signInWithEmailAndPassword(email, password)
            RxSingleTransformer<AuthResult>(task, emitter)
        })
    }

    fun signInWithCredential(credential: AuthCredential): Single<AuthResult> {
        return Single.create({ emitter ->
            val task = ApolloApp.firebaseAuth.signInWithCredential(credential)
            RxSingleTransformer<AuthResult>(task, emitter)
        })
    }

    fun signInWithCustomToken(token: String): Single<AuthResult> {
        return Single.create({ emitter ->
            val task = ApolloApp.firebaseAuth.signInWithCustomToken(token)
            RxSingleTransformer<AuthResult>(task, emitter)
        })
    }

    fun signOut() {
        ApolloApp.firebaseAuth.signOut()
    }
}
