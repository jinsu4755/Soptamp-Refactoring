package org.sopt.android.presentation.auth.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.android.designsystem.component.button.SoptampButton
import org.sopt.android.designsystem.component.textfield.SoptampTextField
import org.sopt.android.designsystem.style.SoptampTheme

@Composable
fun RegisterInputField(
    title: String,
    onTextChange: (String) -> Unit = {},
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    labelText: String = "",
    placeholderText: String = "",
    isError: Boolean = false,
    message: String = "",
    buttonText: String = "확인",
    onClickButton: () -> Unit = {}
) {
    val input = remember {
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
        Spacer(modifier = Modifier.size(12.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            SoptampTextField(
                input = input,
                onTextChange = { onTextChange(it) },
                modifier = Modifier.weight(0.77f),
                keyboardOptions = keyboardOptions,
                visualTransformation = visualTransformation,
                labelText = labelText,
                placeholderText = placeholderText,
                isError = isError
            )
            Spacer(modifier = Modifier.size(4.dp))
            SoptampButton(
                text = buttonText,
                textStyle = SoptampTheme.typography.sub3,
                textColor = SoptampTheme.colors.white,
                buttonColors = ButtonDefaults.buttonColors(
                    backgroundColor = SoptampTheme.colors.purple300,
                    disabledBackgroundColor = SoptampTheme.colors.purple200
                ),
                isEnable = input.value.text.isNotEmpty(),
                onClick = { onClickButton() }
            )
        }
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
fun PreviewRegisterInputField() {
    SoptampTheme {
        RegisterInputField(
            title = "닉네임",
            labelText = "input content",
            message = "message"
        )
    }
}
