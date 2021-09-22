package com.example.helloworld.utils

import android.util.Log
import kotlin.Throws
import okhttp3.OkHttpClient
import com.example.helloworld.utils.Okhttp
import java.lang.Exception
import java.security.SecureRandom
import java.security.cert.CertificateException
import java.security.cert.X509Certificate
import java.util.concurrent.TimeUnit
import javax.net.ssl.SSLContext
import javax.net.ssl.SSLSocketFactory
import javax.net.ssl.TrustManager
import javax.net.ssl.X509TrustManager

object Okhttp {//创建一个不验证证书链的证书信任管理器。

    // Install the all-trusting trust manager
    // Create an ssl socket factory with our all-trusting manager
    //客户端不对服务器证书做任何验证
    @get:Throws(Exception::class)
    val sSLSocketFactory: SSLSocketFactory
        get() {
            //创建一个不验证证书链的证书信任管理器。
            val trustAllCerts = arrayOf<TrustManager>(object : X509TrustManager {
                @Throws(CertificateException::class)
                override fun checkClientTrusted(
                    chain: Array<X509Certificate>,
                    authType: String
                ) {
                }

                @Throws(CertificateException::class)
                override fun checkServerTrusted(
                    chain: Array<X509Certificate>,
                    authType: String
                ) {
                }

                override fun getAcceptedIssuers(): Array<X509Certificate?> {
                    return arrayOfNulls(0)
                }
            })

            // Install the all-trusting trust manager
            val sslContext = SSLContext.getInstance("TLS")
            sslContext.init(
                null, trustAllCerts,
                SecureRandom()
            )
            // Create an ssl socket factory with our all-trusting manager
            return sslContext.socketFactory
        }

    //获得无需验证任何证书的OkHttpClient实例对象
    val okHttpClientInstance: OkHttpClient?
        get() {
            try {
                return OkHttpClient.Builder()
                    .sslSocketFactory(sSLSocketFactory)
                    .readTimeout(10, TimeUnit.SECONDS)
                    .connectTimeout(10, TimeUnit.SECONDS)
                    .build()
            } catch (e: Exception) {
                Log.e("OkHttpClientError", e.message!!)
            }
            return null
        }
}