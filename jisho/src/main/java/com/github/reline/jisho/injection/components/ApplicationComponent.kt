/*
 * Copyright 2017 Nathaniel Reline
 *
 * This work is licensed under the Creative Commons Attribution-ShareAlike 4.0 International License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/4.0/ or
 * send a letter to Creative Commons, PO Box 1866, Mountain View, CA 94042, USA.
 */

package com.github.reline.jisho.injection.components

import android.app.Application
import com.github.reline.jisho.Jisho
import com.github.reline.jisho.injection.modules.ApplicationModule
import com.github.reline.jisho.injection.modules.MainActivityModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
        modules = [
            AndroidInjectionModule::class,
            ApplicationModule::class,
            MainActivityModule::class]
)
interface ApplicationComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): ApplicationComponent
    }

    fun inject(application: Jisho)
}
