package io.vbytsyuk.example.core.di

import org.koin.core.module.Module

abstract class DiModule<in D : DiModule.Dependencies, out A : DiModule.Api>(
    private val dependencies: D
) {

    interface Dependencies

    interface Api

    abstract val api: A
}
