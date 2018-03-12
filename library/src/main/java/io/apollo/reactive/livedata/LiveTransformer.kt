package io.apollo.reactive.livedata

import android.arch.lifecycle.MutableLiveData
import com.google.android.gms.tasks.OnFailureListener
import com.google.android.gms.tasks.OnSuccessListener
import com.google.android.gms.tasks.Task
import java.lang.Exception

/**
 * Created by levi on 11/03/18.
 */

class LiveTransformer<T>(val task: Task<T>, val resultData: MutableLiveData<LiveResource<T>>) : OnSuccessListener<T>, OnFailureListener {

    init {
        task.addOnSuccessListener(this)
        task.addOnFailureListener(this)
    }

    override fun onSuccess(result: T) {
        resultData.value = LiveResource(LiveResourceStatus.SUCCESS, result, null)
    }


    override fun onFailure(exception: Exception) {
        resultData.value = LiveResource(LiveResourceStatus.ERROR, null, exception.message)
    }
}
