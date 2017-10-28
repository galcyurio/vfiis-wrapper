package com.github.galcyurio.commons

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * @author galcyurio
 */
class VfiisCallbackImpl <T> implements Callback<T> {

    private Callback<T> mCallback

    VfiisCallbackImpl(Callback<T>  callback) {
        mCallback = callback
    }

    @Override
    void onResponse(Call<T> call, Response<T> response) {
        mCallback.onResponse(call, response)
        // TODO:
    }

    @Override
    void onFailure(Call<T> call, Throwable t) {
        mCallback.onFailure(call, t)
        // TODO:
    }
}
