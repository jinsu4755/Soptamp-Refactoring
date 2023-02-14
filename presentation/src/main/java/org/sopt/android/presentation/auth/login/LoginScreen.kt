package org.sopt.android.presentation.auth.login

import androidx.compose.foundation.Image
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
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import org.sopt.android.designsystem.R
import org.sopt.android.designsystem.component.LoadingScreen
import org.sopt.android.designsystem.component.button.SoptampButton
import org.sopt.android.designsystem.component.button.UnderLineTextButton
import org.sopt.android.designsystem.component.dialog.NetworkErrorDialog
import org.sopt.android.designsystem.component.textfield.SoptampTextField
import org.sopt.android.designsystem.style.SoptampTheme
import org.sopt.android.presentation.auth.model.LoginUiModel
import org.sopt.android.presentation.config.AuthNavGraph
import org.sopt.android.presentation.destinations.FindAccountScreenDestination
import org.sopt.android.presentation.destinations.RegisterScreenDestination

@AuthNavGraph(true)
@Destination("auth/login")
@Composable
fun LoginScreen(
    viewModel: LoginViewModel = hiltViewModel(),
    navigator: DestinationsNavigator
) {
    val state by viewModel.state.collectAsState()
    SoptampTheme {
        Box(modifier = Modifier.fillMaxSize()) {
            var uiModel by remember {
                mutableStateOf(LoginState.Default(LoginUiModel.empty).uiModel)
            }
            when (state) {
                is LoginState.Default -> {
                    uiModel = (state as LoginState.Default).uiModel
                }

                LoginState.Loading -> {
                    LoadingScreen()
                }

                LoginState.Failure -> {
                    NetworkErrorDialog(
                        onRetry = { uiModel = LoginState.Default(LoginUiModel.empty).uiModel }
                    )
                }
            }
            LoginScreen(
                loginUiModel = uiModel,
                onClickLogin = { viewModel.login() },
                onClickFindAccount = { navigator.navigate(FindAccountScreenDestination) },
                onClickRegister = { navigator.navigate(RegisterScreenDestination) },
                onEmailChange = { viewModel.putEmail(it) },
                onPasswordChange = { viewModel.putPassword(it) }
            )
        }
    }
}

@Composable
fun LoginScreen(
    loginUiModel: LoginUiModel = LoginUiModel.empty,
    onClickLogin: () -> Unit = {},
    onClickFindAccount: () -> Unit = {},
    onClickRegister: () -> Unit = {},
    onEmailChange: (String) -> Unit = {},
    onPasswordChange: (String) -> Unit = {}
) {
    val isError = loginUiModel.isError
    val emailInput = remember { mutableStateOf(TextFieldValue()) }
    val passwordInput = remember { mutableStateOf(TextFieldValue()) }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(
                horizontal = SoptampTheme.dimens.defaultHorizontalPadding
            ),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        LoginPageImage()
        Spacer(modifier = Modifier.size(80.dp))
        SoptampTextField(
            modifier = Modifier.fillMaxWidth(),
            input = emailInput,
            onTextChange = { onEmailChange(it) },
            labelText = "ID",
            placeholderText = "이메일을 입력해주세요.",
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            isError = isError
        )
        Spacer(modifier = Modifier.size(12.dp))
        SoptampTextField(
            modifier = Modifier.fillMaxWidth(),
            input = passwordInput,
            onTextChange = { onPasswordChange(it) },
            labelText = "Password",
            placeholderText = "비밀번호를 입력해주세요.",
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            visualTransformation = PasswordVisualTransformation(),
            isError = isError
        )
        Spacer(modifier = Modifier.size(12.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 2.dp)
        ) {
            LoginPageErrorText(loginUiModel.errorMessage)
            LoginPageFindAccountButton(
                onClick = { onClickFindAccount() },
                modifier = Modifier.align(Alignment.TopEnd)
            )
        }
        Spacer(modifier = Modifier.size(52.dp))
        LoginPageLoginButton(
            onClick = { onClickLogin() },
            isEnable = emailInput.value.text.isNotEmpty() and passwordInput.value.text.isNotEmpty()
        )
        Spacer(modifier = Modifier.size(20.dp))
        LoginPageRegisterButton(
            onClick = { onClickRegister() }
        )
    }
}

@Composable
fun LoginPageImage() {
    Image(
        painter = painterResource(id = R.drawable.ic_soptamp),
        contentDescription = "Sopt Stamp Application Logo"
    )
}

@Composable
fun LoginPageErrorText(
    text: String? = null,
    modifier: Modifier = Modifier
) {
    if (text == null) return
    Text(
        modifier = modifier,
        text = text,
        color = SoptampTheme.colors.error300,
        style = SoptampTheme.typography.caption3
    )
}

@Composable
fun LoginPageFindAccountButton(
    onClick: () -> Unit = {},
    modifier: Modifier = Modifier
) {
    UnderLineTextButton(
        text = "계정 찾기",
        style = SoptampTheme.typography.caption2,
        color = SoptampTheme.colors.onSurface50,
        textAlign = TextAlign.End,
        paddingValue = PaddingValues(end = 2.dp),
        modifier = modifier,
        onClick = { onClick() }
    )
}

@Composable
fun LoginPageLoginButton(
    onClick: () -> Unit = {},
    isEnable: Boolean = false
) {
    SoptampButton(
        text = "로그인",
        textStyle = SoptampTheme.typography.h2,
        textColor = SoptampTheme.colors.white,
        modifier = Modifier
            .fillMaxWidth()
            .imePadding(),
        onClick = { onClick() },
        isEnable = isEnable
    )
}

@Composable
fun LoginPageRegisterButton(
    onClick: () -> Unit = {}
) {
    UnderLineTextButton(
        text = "회원가입 하기",
        style = SoptampTheme.typography.caption1,
        color = SoptampTheme.colors.onSurface90,
        textAlign = TextAlign.Center,
        paddingValue = PaddingValues(end = 2.dp),
        onClick = { onClick() }
    )
}

@Preview(backgroundColor = 0xFFFFFFFF, showBackground = true)
@Composable
fun PreviewLoginScreen() {
    SoptampTheme {
        LoginScreen()
    }
}
