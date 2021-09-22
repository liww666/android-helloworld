package com.example.helloworld.vm

import okhttp3.MultipartBody
import okhttp3.ResponseBody


import retrofit2.Call


import retrofit2.http.POST

import retrofit2.http.Multipart
import retrofit2.http.Part


interface UploadService {
    @Multipart
    @POST("filesystem/upload")
    fun upload(
        @Part file: MultipartBody.Part?
    ): Call<ResponseBody>
}