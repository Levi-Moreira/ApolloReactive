package io.apollo.sample

import android.app.Application

import com.google.firebase.auth.FirebaseAuth

import io.apollo.reactive.ApolloApp

/**
 * Created by levi on 09/03/18.
 */

class ApolloSampleApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        ApolloApp.initAuth(FirebaseAuth.getInstance())
    }
}
