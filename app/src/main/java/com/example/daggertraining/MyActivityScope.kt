package com.example.daggertraining

import java.lang.annotation.Documented
import javax.inject.Scope

@Scope
@Documented
@Retention(value = AnnotationRetention.RUNTIME)
annotation class MyActivityScope