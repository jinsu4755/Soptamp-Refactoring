package org.sopt.android.designsystem.component.textfield

import androidx.compose.foundation.border
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusState
import androidx.compose.ui.focus.onFocusEvent
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.android.designsystem.style.SoptampTheme

@Composable
fun SoptampTextField(
    input: MutableState<TextFieldValue>,
    onTextChange: (String) -> Unit = {},
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    readOnly: Boolean = false,
    labelText: String = "",
    placeholderText: String = "",
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
    isError: Boolean = false,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions(),
    singleLine: Boolean = true,
    maxLines: Int = Int.MAX_VALUE,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    onFocus: (FocusState) -> Unit = {}
) {
    var textFieldType by remember {
        mutableStateOf(TextFieldType.GRAY)
    }

    val isInputTextIsEmpty = input.value.text.isEmpty()

    val inputTextFieldShape = RoundedCornerShape(12.dp)

    val inputTextFieldColors = TextFieldDefaults.textFieldColors(
        backgroundColor = textFieldType.backgroundColor,
        focusedIndicatorColor = Color.Transparent,
        unfocusedIndicatorColor = Color.Transparent,
        errorLabelColor = SoptampTheme.colors.error200,
        errorIndicatorColor = Color.Transparent,
        textColor = if (isInputTextIsEmpty) SoptampTheme.colors.onSurface60 else SoptampTheme.colors.black,
        placeholderColor = SoptampTheme.colors.black,
        focusedLabelColor = SoptampTheme.colors.onSurface40,
        unfocusedLabelColor = SoptampTheme.colors.onSurface40
    )

    val inputTextFieldModifier = modifier.border(
        width = if (isInputTextIsEmpty) 0.dp else 1.dp,
        color = textFieldType.borderColor,
        shape = inputTextFieldShape
    ).onFocusEvent {
        textFieldType = if (isError) {
            TextFieldType.ERROR
        } else {
            if (it.hasFocus) {
                TextFieldType.WHITE
            } else {
                TextFieldType.GRAY
            }
        }
        onFocus(it)
    }

    TextField(
        value = input.value.text,
        onValueChange = {
            input.value = TextFieldValue(it)
            onTextChange(it)
        },
        modifier = inputTextFieldModifier,
        enabled = enabled,
        readOnly = readOnly,
        textStyle = SoptampTheme.typography.caption1,
        label = {
            Text(
                text = labelText,
                style = SoptampTheme.typography.caption4
            )
        },
        placeholder = {
            Text(
                text = placeholderText,
                style = SoptampTheme.typography.caption1
            )
        },
        leadingIcon = leadingIcon,
        trailingIcon = trailingIcon,
        isError = isError,
        visualTransformation = visualTransformation,
        keyboardOptions = keyboardOptions,
        keyboardActions = keyboardActions,
        singleLine = singleLine,
        maxLines = maxLines,
        interactionSource = interactionSource,
        shape = inputTextFieldShape,
        colors = inputTextFieldColors
    )
}

@Preview(backgroundColor = 0xFFFFFF, showBackground = true)
@Composable
fun PreviewSoptampTextField() {
    SoptampTheme {
        val input = remember {
            mutableStateOf(TextFieldValue())
        }
        Column() {
            SoptampTextField(
                input = input,
                onTextChange = {},
                placeholderText = "이메일을 입력해주세요.",
                labelText = "ID"
            )
        }
    }
}
