package io.apollo.reactive.rx

import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthCredential
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import io.reactivex.Single

/**
 * Created by levi on 11/03/18.
 */
fun Task<AuthResult>.toRxSingle(): Single<AuthResult> {
    return Single.create { emitter ->
        this.addOnSuccessListener { result ->
            if (!emitter.isDisposed)
                emitter.onSuccess(result)
        }

        this.addOnFailureListener { error ->
            if (!emitter.isDisposed)
                emitter.onError(error)
        }
    }
}

fun FirebaseAuth.rxSignInWithEmailAndPassword(email: String, password: String): Single<AuthResult> {
    return this.signInWithEmailAndPassword(email, password).toRxSingle()
}

fun FirebaseAuth.rxSignInAnonimously(): Single<AuthResult> {
    return this.signInAnonymously().toRxSingle()
}

fun FirebaseAuth.rxSignInWithCustomToken(token: String): Single<AuthResult> {
    return this.signInWithCustomToken(token).toRxSingle()
}

fun FirebaseAuth.rxSignInWithCredential(credential: AuthCredential): Single<AuthResult> {
    return this.signInWithCredential(credential).toRxSingle()
}

fun FirebaseAuth.rxCreateUserWithEmailAndPassword(email: String, password: String): Single<AuthResult> {
    return this.createUserWithEmailAndPassword(email, password).toRxSingle()
}

