package org.sopt.android.presentation.auth.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.android.designsystem.component.textfield.SoptampTextField
import org.sopt.android.designsystem.style.SoptampTheme

@Composable
fun RegisterPasswordInputField(
    title: String,
    onPasswordChange: (String) -> Unit = {},
    onPasswordConfirmChange: (String) -> Unit = {},
    keyboardOptions: KeyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
    visualTransformation: PasswordVisualTransformation = PasswordVisualTransformation(),
    passwordLabelText: String = "",
    passwordConfirmLabelText: String = "",
    isError: Boolean = false,
    message: String = ""
) {
    val passwordInput = remember {
        mutableStateOf(TextFieldValue())
    }

    val passwordConfirmInput = remember {
        mutableStateOf(TextFieldValue())
    }

    Column(
        modifier = Modifier.fillMaxWidth().wrapContentHeight()
    ) {
        Text(
            text = title,
            style = SoptampTheme.typography.sub1,
            color = SoptampTheme.colors.onSurface90
        )
        Spacer(modifier = Modifier.size(16.dp))
        SoptampTextField(
            input = passwordInput,
            onTextChange = { onPasswordChange(it) },
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = keyboardOptions,
            visualTransformation = visualTransformation,
            labelText = passwordLabelText,
            isError = isError
        )
        Spacer(modifier = Modifier.size(12.dp))
        SoptampTextField(
            input = passwordConfirmInput,
            onTextChange = { onPasswordConfirmChange(it) },
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = keyboardOptions,
            visualTransformation = visualTransformation,
            labelText = passwordConfirmLabelText,
            isError = isError
        )
        Spacer(modifier = Modifier.size(12.dp))
        Text(
            text = message,
            style = SoptampTheme.typography.caption3,
            color = if (isError) SoptampTheme.colors.error300 else SoptampTheme.colors.access300
        )
    }
}

@Preview(backgroundColor = 0xFFFFFF, showBackground = true)
@Composable
fun PreviewRegisterPasswordInputField() {
    SoptampTheme {
        RegisterPasswordInputField(title = "비밀번호")
    }
}
