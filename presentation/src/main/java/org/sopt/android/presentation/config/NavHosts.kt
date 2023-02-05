package org.sopt.android.presentation.config

import com.ramcosta.composedestinations.annotation.NavGraph
import com.ramcosta.composedestinations.annotation.RootNavGraph

@RootNavGraph(true)
@NavGraph
annotation class OnboardingNavGraph(
    val start: Boolean = false
)

@RootNavGraph
@NavGraph
annotation class AuthNavGraph(
    val start: Boolean = false
)
