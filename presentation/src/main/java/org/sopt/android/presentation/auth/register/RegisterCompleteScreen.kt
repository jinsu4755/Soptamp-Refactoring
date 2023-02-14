package org.sopt.android.presentation.auth.register

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import org.sopt.android.designsystem.component.button.SoptampButton
import org.sopt.android.designsystem.style.SoptampTheme
import org.sopt.android.presentation.config.AuthNavGraph
import org.sopt.android.presentation.destinations.LoginScreenDestination
import org.sopt.android.designsystem.R as DesignR

@AuthNavGraph()
@Destination("auth/register/complete")
@Composable
fun RegisterCompleteScreen(
    navigator: DestinationsNavigator
) {
    SoptampTheme() {
        RegisterCompleteScreen(
            onClickRegisterComplete = {
                navigator.navigate(
                    direction = LoginScreenDestination,
                    builder = {
                        launchSingleTop = true
                    }
                )
            }
        )
    }
}

@Composable
fun RegisterCompleteScreen(
    onClickRegisterComplete: () -> Unit = {}
) {
    Column(
        modifier = Modifier.fillMaxSize().padding(
            horizontal = SoptampTheme.dimens.defaultHorizontalPadding
        ),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.weight(1f))
        Image(
            painter = painterResource(id = DesignR.drawable.register_complete),
            contentDescription = "Register Complete Screen Image"
        )
        Spacer(modifier = Modifier.size(16.dp))
        Text(
            text = "가입완료",
            style = SoptampTheme.typography.h1,
            fontSize = 20.sp,
            color = SoptampTheme.colors.onSurface90
        )
        Text(
            text = "SOPTAMP에 오신 것을 환영합니다",
            style = SoptampTheme.typography.sub2,
            fontSize = 20.sp,
            color = SoptampTheme.colors.onSurface50
        )
        Spacer(modifier = Modifier.weight(1f))
        SoptampButton(
            text = "가입하기",
            textStyle = SoptampTheme.typography.h2,
            textColor = SoptampTheme.colors.white,
            buttonColors = ButtonDefaults.buttonColors(
                backgroundColor = SoptampTheme.colors.purple300,
                disabledBackgroundColor = SoptampTheme.colors.purple200
            ),
            modifier = Modifier.fillMaxWidth(),
            onClick = { onClickRegisterComplete() }
        )
        Spacer(modifier = Modifier.size(40.dp))
    }
}

@Preview(backgroundColor = 0xFFFFFF, showBackground = true)
@Composable
fun PreviewRegisterCompleteScreen() {
    SoptampTheme {
        RegisterCompleteScreen()
    }
}
