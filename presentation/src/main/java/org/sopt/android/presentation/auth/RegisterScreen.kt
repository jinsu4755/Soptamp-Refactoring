package org.sopt.android.presentation.auth

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.ramcosta.composedestinations.result.ResultBackNavigator
import org.sopt.android.designsystem.component.button.SoptampButton
import org.sopt.android.designsystem.component.button.SoptampIconButton
import org.sopt.android.designsystem.component.topappbar.SoptTopAppBar
import org.sopt.android.designsystem.component.utils.rememberKeyBoardState
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
    viewModel: RegisterViewModel = hiltViewModel(),
    navigator: DestinationsNavigator,
    resultNavigator: ResultBackNavigator<Boolean>
) {
    val state by viewModel.state.collectAsState()
    SoptampTheme {
        Box(modifier = Modifier.fillMaxSize()) {
            var uiModel by remember {
                mutableStateOf(RegisterState.Default(RegisterUiModel.empty).uiModel)
            }
            when (state) {
                is RegisterState.Default -> {
                    uiModel = (state as RegisterState.Default).uiModel
                }

                RegisterState.Loading -> {}
                RegisterState.Failure -> {}
            }
            RegisterScreen(
                uiModel = uiModel,
                onNicknameChange = { viewModel.putNickname(it) },
                onEmailChange = { viewModel.putEmail(it) },
                onPasswordChange = { viewModel.putPassword(it) },
                onPasswordConfirmChange = { viewModel.putPasswordConfirm(it) },
                onClickCheckNickname = {},
                onClickCheckEmail = {},
                onClickRegister = {},
                onClickBackNav = { resultNavigator.navigateBack() }
            )
        }
    }
}

@Composable
fun RegisterScreen(
    uiModel: RegisterUiModel = RegisterUiModel.empty,
    onNicknameChange: (String) -> Unit = {},
    onEmailChange: (String) -> Unit = {},
    onPasswordChange: (String) -> Unit = {},
    onPasswordConfirmChange: (String) -> Unit = {},
    onClickCheckNickname: () -> Unit = {},
    onClickCheckEmail: () -> Unit = {},
    onClickRegister: () -> Unit = {},
    onClickBackNav: () -> Unit = {}
) {
    Scaffold(
        topBar = { RegisterHeader(onClickBackNav = { onClickBackNav() }) }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(
                    start = SoptampTheme.dimens.defaultHorizontalPadding,
                    end = SoptampTheme.dimens.defaultHorizontalPadding,
                    bottom = paddingValues.calculateBottomPadding()
                ),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            val isShowKeyboard by rememberKeyBoardState()
            var isFocusPassword by remember { mutableStateOf(false) }
            var isFocusPasswordConfirm by remember { mutableStateOf(false) }
            val density = LocalDensity.current
            Spacer(modifier = Modifier.weight(1f))
            AnimatedVisibility(
                visible = !((isFocusPassword or isFocusPasswordConfirm) and isShowKeyboard),
                enter = slideInVertically {
                    with(density) { -328.dp.roundToPx() }
                },
                exit = slideOutVertically()
            ) {
                Column() {
                    RegisterInputField(
                        title = "닉네임",
                        onTextChange = { onNicknameChange(it) },
                        labelText = "한글/영문 NN자로 입력해주세요.",
                        isError = !(uiModel.nicknameCheckState.isPass),
                        message = uiModel.nicknameCheckMessage,
                        onClickButton = { onClickCheckNickname() }
                    )
                    Spacer(modifier = Modifier.size(38.dp))
                    RegisterInputField(
                        title = "이메일",
                        onTextChange = { onEmailChange(it) },
                        labelText = "이메일을 입력해주세요.",
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                        isError = !(uiModel.emailCheckState.isPass),
                        message = uiModel.emailCheckMessage,
                        onClickButton = { onClickCheckEmail() }
                    )
                    Spacer(modifier = Modifier.size(38.dp))
                }
            }
            RegisterPasswordInputField(
                title = "비밀번호",
                onPasswordChange = { onPasswordChange(it) },
                onPasswordConfirmChange = { onPasswordConfirmChange(it) },
                passwordLabelText = "영문, 숫자, 특수문자 포함 8자 이상 16자 이하 입력해주세요.",
                passwordConfirmLabelText = "확인을 위해 비밀번호를 한 번 더 입력해주세요.",
                isErrorPassword = !uiModel.passwordCheckState.isPass,
                isErrorPasswordConfirm = !uiModel.passwordConfirmCheckState.isPass,
                message = uiModel.passwordCheckMessage,
                onFocusPassword = { isFocusPassword = it.hasFocus },
                onFocusPasswordConfirm = { isFocusPasswordConfirm = it.hasFocus }
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
                modifier = Modifier
                    .fillMaxWidth()
                    .imePadding(),
                onClick = { onClickRegister() },
                isEnable = uiModel.isAllInputNotEmpty
            )
            Spacer(modifier = Modifier.weight(1f))
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
        },
        contentPadding = PaddingValues(start = 16.dp)
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
