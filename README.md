### ReactiveApollo

Apollo is a wrapper for Firebase calls using RxJava and LiveData streams. 
This library is idea for those who want to unify their network layer under the same async request/response paradigm.


## Usage

Right now the library provides callbacks only for the Authentication methods.

To initialize the wrapper you simply add the initialization to your application class:

```kotlin
class ApolloSampleApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        ApolloApp.initAuth(FirebaseAuth.getInstance())
    }
}
```

To use it you simply call the getInstance() method just like firebase to create an object of the desired class and then you can call the normal firebase auth methods:

```kotlin
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
```

To use the LiveData instance you simply do (you need to setup the lifecycle owner as well):

```kotlin
val liveAuth = LiveApolloAuth.getInstance()
liveAuth.signInAnonymously().observe(this, Observer { 
    //result
})
```

As this library is still in development there's no gradle integration yet. You can simply clone this repository and add it as a module to your project.



This library was highly inspired by the work of [Nickolay Moskalenko](https://github.com/nmoskalenko/RxFirebase)