package com.example.helloworld

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import com.bumptech.glide.Glide
import com.example.helloworld.bean.WeatherData
import com.example.helloworld.bean.upload.UploadResp
import com.example.helloworld.utils.GlideEngine
import com.example.helloworld.utils.Okhttp
import com.example.helloworld.vm.UploadService
import com.example.helloworld.vm.WeatherService
import com.google.gson.Gson
import com.luck.picture.lib.PictureSelector
import com.luck.picture.lib.config.PictureConfig
import com.luck.picture.lib.config.PictureMimeType
import com.luck.picture.lib.entity.LocalMedia
import okhttp3.MediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File
import java.lang.Exception
import java.security.SecureRandom
import java.security.cert.X509Certificate
import javax.net.ssl.*

class UploadImageActivity : AppCompatActivity() {
    lateinit var uploadBtn: Button

    lateinit var imgView4 : ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_upload_image)
        handleSSLHandshake()
        uploadBtn = findViewById(R.id.btn_upImage)
        imgView4 = findViewById(R.id.iv_4)
        uploadBtn.setOnClickListener{
            PictureSelector.create(this)
                .openGallery(PictureMimeType.ofImage())
                .imageEngine(GlideEngine.createGlideEngine()) // 请参考Demo GlideEngine.java
                .forResult(PictureConfig.CHOOSE_REQUEST);
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            when (requestCode) {
                PictureConfig.CHOOSE_REQUEST ->
                    // 结果回调
                {
                    var result = PictureSelector.obtainMultipleResult(data)
                    val file = File(result.get(0).realPath)
                    val requestBody = RequestBody.create(MediaType.get("image/png"), file)
                    val formData: MultipartBody.Part =
                        MultipartBody.Part.createFormData("file", file.name, requestBody)

                    val retrofit = Retrofit.Builder()
                        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                        .addConverterFactory(GsonConverterFactory.create())
                        .baseUrl("http://121.196.56.55/")
                        .client(Okhttp.okHttpClientInstance)
                        .build()
                    var uploadService = retrofit.create(UploadService::class.java)


                    var  call = uploadService.upload(formData);
                    call?.enqueue(object:Callback<ResponseBody>{


                        override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                            Log.e("Upload error:", t.message!!);
                        }

                        override fun onResponse(
                            call: Call<ResponseBody>,
                            response: Response<ResponseBody>
                        ) {
                            Log.v("Upload", "success");
                            var resp = Gson().fromJson(response.body()?.string(), UploadResp::class.java)

                            Glide.with(applicationContext).load(resp.fileSystem.filePath).into(imgView4)
                        }
                    })
                }

                }
            }
        }

    fun handleSSLHandshake() {
        try {
            val trustAllCerts: Array<TrustManager> =
                arrayOf<TrustManager>(object : X509TrustManager {
                    val acceptedIssuers: Array<Any?>?
                        get() = arrayOfNulls(0)

                    override fun checkClientTrusted(certs: Array<X509Certificate?>?, authType: String?) {}
                    override fun checkServerTrusted(certs: Array<X509Certificate?>?, authType: String?) {}
                    override fun getAcceptedIssuers(): Array<X509Certificate> {
                        TODO("Not yet implemented")
                    }
                })
            val sc: SSLContext = SSLContext.getInstance("TLS")
            // trustAllCerts信任所有的证书
            sc.init(null, trustAllCerts, SecureRandom())
            HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory())
            HttpsURLConnection.setDefaultHostnameVerifier { hostname, session -> true }
        } catch (ignored: Exception) {
        }
    }
    }





