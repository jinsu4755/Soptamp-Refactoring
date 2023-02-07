package org.sopt.android.presentation.config

import com.ramcosta.composedestinations.annotation.NavGraph
import com.ramcosta.composedestinations.annotation.RootNavGraph

@RootNavGraph()
@NavGraph
annotation class OnboardingNavGraph(
    val start: Boolean = false
)

@RootNavGraph(true)
@NavGraph
annotation class AuthNavGraph(
    val start: Boolean = false
)
