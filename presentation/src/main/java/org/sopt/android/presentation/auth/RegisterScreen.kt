package org.sopt.android.presentation.auth

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import org.sopt.android.designsystem.component.button.SoptampButton
import org.sopt.android.designsystem.component.button.SoptampIconButton
import org.sopt.android.designsystem.component.topappbar.SoptTopAppBar
import org.sopt.android.designsystem.style.SoptampTheme
import org.sopt.android.presentation.auth.component.RegisterInputField
import org.sopt.android.presentation.auth.component.RegisterPasswordInputField
import org.sopt.android.presentation.auth.model.RegisterUiModel
import org.sopt.android.presentation.config.AuthNavGraph
import org.sopt.android.designsystem.R as DesignR

@AuthNavGraph()
@Destination("auth/register")
@Composable
fun RegisterScreen(
    navigator: DestinationsNavigator
) {
    SoptampTheme {
        RegisterScreen()
    }
}

@Composable
fun RegisterScreen(
    registerUiModel: RegisterUiModel = RegisterUiModel.empty,
    onNicknameChange: (String) -> Unit = {},
    onEmailChange: (String) -> Unit = {},
    onPasswordChange: (String) -> Unit = {},
    onPasswordConfirmChange: (String) -> Unit = {},
    onClickCheckNickname: () -> Unit = {},
    onClickCheckEmail: () -> Unit = {},
    onClickRegister: () -> Unit = {}
) {
    Scaffold(
        topBar = { RegisterHeader() }
    ) { paddingValues ->
        Column(
            modifier = Modifier.padding(
                start = SoptampTheme.dimens.defaultHorizontalPadding,
                end = SoptampTheme.dimens.defaultHorizontalPadding,
                bottom = paddingValues.calculateBottomPadding()
            ),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            RegisterInputField(
                title = "닉네임",
                onTextChange = { onNicknameChange(it) },
                labelText = "한글/영문 NN자로 입력해주세요.",
                isError = registerUiModel.nicknameCheckState.isPass ?: false,
                message = registerUiModel.nicknameCheckMessage,
                onClickButton = { onClickCheckNickname() }
            )
            Spacer(modifier = Modifier.size(38.dp))
            RegisterInputField(
                title = "이메일",
                onTextChange = { onEmailChange(it) },
                labelText = "이메일을 입력해주세요.",
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                isError = registerUiModel.emailCheckState.isPass ?: false,
                message = registerUiModel.emailCheckMessage,
                onClickButton = { onClickCheckEmail() }
            )
            Spacer(modifier = Modifier.size(38.dp))
            RegisterPasswordInputField(
                title = "비밀번호",
                onPasswordChange = { onPasswordChange(it) },
                onPasswordConfirmChange = { onPasswordConfirmChange(it) },
                passwordLabelText = "영문, 숫자, 특수문자 포함 N자 이상 입력해주세요.",
                passwordConfirmLabelText = "확인을 위해 비밀번호를 한 번 더 입력해주세요.",
                isError = registerUiModel.passwordCheckState.isPass ?: false &&
                    registerUiModel.passwordConfirmCheckState.isPass ?: false,
                message = registerUiModel.passwordCheckMessage
            )
            Spacer(modifier = Modifier.size(68.dp))
            SoptampButton(
                text = "가입하기",
                textStyle = SoptampTheme.typography.h2,
                textColor = SoptampTheme.colors.white,
                buttonColors = ButtonDefaults.buttonColors(
                    backgroundColor = SoptampTheme.colors.purple300,
                    disabledBackgroundColor = SoptampTheme.colors.purple200
                ),
                modifier = Modifier.fillMaxWidth(),
                onClick = { onClickRegister() },
                isEnable = registerUiModel.isAllInputNotEmpty
            )
        }
    }
}

@Composable
fun RegisterHeader(
    onClickBackNav: () -> Unit = {}
) {
    SoptTopAppBar(
        title = { RegisterHeaderTitle() },
        navigationIcon = {
            SoptampIconButton(
                imageVector = ImageVector.vectorResource(id = DesignR.drawable.arrow_letf),
                onClick = { onClickBackNav() }
            )
        }
    )
}

@Composable
fun RegisterHeaderTitle() {
    Text(
        text = "회원가입",
        style = SoptampTheme.typography.h2,
        color = SoptampTheme.colors.black,
        fontSize = 20.sp
    )
}

@Preview(backgroundColor = 0xFFFFF, showBackground = true)
@Composable
fun PreviewRegisterScreen() {
    SoptampTheme {
        RegisterScreen()
    }
}
