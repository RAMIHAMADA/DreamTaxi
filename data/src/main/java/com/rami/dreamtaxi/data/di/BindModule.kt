package com.rami.dreamtaxi.data.di

import com.rami.dreamtaxi.data.repositories.OrdersRemoteRepositoryImpl
import com.rami.dreamtaxi.domain.repositories.OrdersRemoteRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface BindModule {

    @Binds
    fun bindOrdersRemoteRepositoryImplOrdersRemoteRepository(
        repository: OrdersRemoteRepositoryImpl,
    ): OrdersRemoteRepository
}