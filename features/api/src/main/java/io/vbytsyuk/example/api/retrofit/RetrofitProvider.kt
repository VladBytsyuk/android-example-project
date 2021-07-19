package io.vbytsyuk.example.api.retrofit

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

internal class RetrofitProvider(
    private val url: String
) {
    inline fun <reified T> provideRetrofitApi(): T = Retrofit.Builder()
        .baseUrl(url)
        .client(okhttpClient)
        .addConverterFactory(MoshiConverterFactory.create())
        .build()
        .create(T::class.java)

    private val okhttpClient: OkHttpClient
        get() = OkHttpClient.Builder()
            .addInterceptor(httpLoggingInterceptor)
            .build()

    private val httpLoggingInterceptor: HttpLoggingInterceptor
        get() = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
}
