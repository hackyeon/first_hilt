package com.hackyeon.first_hilt.di

import com.hackyeon.first_hilt.api.network.NaverDataService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@InstallIn(SingletonComponent::class)
@Module
object NetworkModule {

    @Singleton
    @Provides
    fun provideNaverDataService(): NaverDataService = NaverDataService.create()

}