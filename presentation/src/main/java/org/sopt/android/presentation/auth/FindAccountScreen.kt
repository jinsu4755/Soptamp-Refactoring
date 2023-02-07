package org.sopt.android.presentation.auth

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.result.ResultBackNavigator
import org.sopt.android.designsystem.component.button.SoptampIconButton
import org.sopt.android.designsystem.component.topappbar.SoptTopAppBar
import org.sopt.android.designsystem.style.SoptampTheme
import org.sopt.android.presentation.auth.component.FindAccountButton
import org.sopt.android.presentation.config.AuthNavGraph
import org.sopt.android.designsystem.R as DesignR

@AuthNavGraph
@Destination("auth/find_account")
@Composable
fun FindAccountScreen(
    resultBackNavigator: ResultBackNavigator<Unit>
) {
    SoptampTheme {
        FindAccountScreen(
            onClickBackNav = { resultBackNavigator.navigateBack() }
        )
    }
}

@Composable
fun FindAccountScreen(
    onClickBackNav: () -> Unit = {}
) {
    Scaffold(
        topBar = { FindAccountHeader { onClickBackNav() } }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(
                    start = SoptampTheme.dimens.defaultHorizontalPadding,
                    end = SoptampTheme.dimens.defaultHorizontalPadding,
                    bottom = paddingValues.calculateBottomPadding(),
                    top = 40.dp
                )
        ) {
            val uriHandler = LocalUriHandler.current
            FindAccountContentText()
            Spacer(modifier = Modifier.size(56.dp))
            FindAccountButton(
                text = "이메일 찾기",
                onClick = {
                    uriHandler.openUri("https://forms.gle/XkVFMUPsWWV1DXU38")
                }
            )
            Spacer(modifier = Modifier.size(12.dp))
            FindAccountButton(
                text = "비밀번호 찾기",
                onClick = {
                    uriHandler.openUri("https://forms.gle/bUgTG9ooRVgPZ8K39")
                }
            )
        }
    }
}

@Composable
fun FindAccountHeader(
    onClickBackNav: () -> Unit = {}
) {
    SoptTopAppBar(
        title = { FindAccountHeaderTitle() },
        navigationIcon = {
            SoptampIconButton(
                imageVector = ImageVector.vectorResource(id = DesignR.drawable.arrow_letf),
                onClick = { onClickBackNav() }
            )
        },
        contentPadding = PaddingValues(start = 16.dp)
    )
}

@Composable
fun FindAccountHeaderTitle() {
    Text(
        text = "계정 찾기",
        style = SoptampTheme.typography.h2,
        color = SoptampTheme.colors.black,
        fontSize = 20.sp
    )
}

@Composable
fun FindAccountContentText() {
    Text(
        text = "아래 구글 폼을 제출해 주시면\n" +
            "평일 기준 3-5일 이내로\n" +
            "아이디 / 임시 비밀번호를 전송 드립니다.",
        style = SoptampTheme.typography.sub3,
        color = SoptampTheme.colors.onSurface70
    )
}

@Preview(backgroundColor = 0xFFFFFF, showBackground = true)
@Composable
fun PreviewFindAccountScreen() {
    SoptampTheme {
        FindAccountScreen()
    }
}
