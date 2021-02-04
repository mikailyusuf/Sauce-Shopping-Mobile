package com.mikail.sauceshopping.di

import android.content.Context
import androidx.room.Room
import com.mikail.sauceshopping.localDb.SauceDb
import com.mikail.sauceshopping.network.ApiHelper
import com.mikail.sauceshopping.network.ApiHelperImpl
import com.mikail.sauceshopping.network.SauceApi
import com.mikail.sauceshopping.network.ServiceInterceptor
import com.mikail.sauceshopping.utils.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton


@Module
@InstallIn(ApplicationComponent::class)
class ApplicationModule {


    @Provides
    @Singleton
    fun provideArtcleDB(@ApplicationContext context: Context) = Room.databaseBuilder(
        context.applicationContext,
        SauceDb::class.java,
        "sauce.db"
    ).build()



    @Provides
    @Singleton
    fun provideArticleDAO(db: SauceDb) = db.getDao()


    @Provides
    @Singleton
    fun provideApiHelper(apiHelper: ApiHelperImpl): ApiHelper = apiHelper


    @Provides
    @Singleton
    fun provideRetrofit(): SauceApi {

        val logging = HttpLoggingInterceptor()
        logging.setLevel(HttpLoggingInterceptor.Level.BODY)
        val client = OkHttpClient.Builder()
            .addInterceptor(logging)
            .connectTimeout(120, TimeUnit.SECONDS) //Backend is really slow
            .writeTimeout(120, TimeUnit.SECONDS)
            .readTimeout(120, TimeUnit.SECONDS)
            .addNetworkInterceptor(ServiceInterceptor())
            .build()

        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .client(client)
            .build()
            .create(SauceApi::class.java)
    }

}