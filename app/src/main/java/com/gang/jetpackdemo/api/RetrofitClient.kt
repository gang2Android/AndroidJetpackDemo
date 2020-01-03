package com.gang.jetpackdemo.api

import com.gang.lib_base.http.BaseRetrofitClient
import okhttp3.OkHttpClient

object RetrofitClient : BaseRetrofitClient() {

    val service by lazy { getService(
        ApiService::class.java,
        ApiService.BASE_URL
    ) }

    override fun handleBuilder(builder: OkHttpClient.Builder) {
//        val httpCacheDirectory = File(App.CONTEXT.cacheDir, "responses")
//        val cacheSize = 10 * 1024 * 1024L // 10 MiB
//        val cache = Cache(httpCacheDirectory, cacheSize)
//        builder.cache(cache)
//            .cookieJar(cookieJar)
//            .addInterceptor { chain ->
//                var request = chain.request()
//                if (!NetWorkUtils.isNetworkAvailable(App.CONTEXT)) {
//                    request = request.newBuilder()
//                        .cacheControl(CacheControl.FORCE_CACHE)
//                        .build()
//                }
//                val response = chain.proceed(request)
//                if (!NetWorkUtils.isNetworkAvailable(App.CONTEXT)) {
//                    val maxAge = 60 * 60
//                    response.newBuilder()
//                        .removeHeader("Pragma")
//                        .header("Cache-Control", "public, max-age=$maxAge")
//                        .build()
//                } else {
//                    val maxStale = 60 * 60 * 24 * 28 // tolerate 4-weeks stale
//                    response.newBuilder()
//                        .removeHeader("Pragma")
//                        .header("Cache-Control", "public, only-if-cached, max-stale=$maxStale")
//                        .build()
//                }
//                response
//            }
    }

}