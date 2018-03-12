package io.apollo.reactive.rx

import com.google.android.gms.tasks.OnFailureListener
import com.google.android.gms.tasks.OnSuccessListener
import com.google.android.gms.tasks.Task
import io.reactivex.SingleEmitter
import java.lang.Exception

/**
 * Created by levi on 11/03/18.
 */

class RxSingleTransformer<T>(task: Task<T>, val emitter: SingleEmitter<T>) : OnSuccessListener<T>, OnFailureListener {

    init {
        task.addOnFailureListener(this)
        task.addOnSuccessListener(this)
    }

    override fun onSuccess(result: T) {
        if (!emitter.isDisposed)
            emitter.onSuccess(result)
    }

    override fun onFailure(exception: Exception) {
        if (!emitter.isDisposed)
            emitter.onError(exception)
    }
}
