package io.apollo.reactive

import com.google.firebase.auth.FirebaseAuth

/**
 * Created by levi on 09/03/18.
 */

object ApolloApp {

    lateinit var firebaseAuth: FirebaseAuth

    fun initAuth(firebaseAuth: FirebaseAuth) {
        this.firebaseAuth = firebaseAuth
    }


}
