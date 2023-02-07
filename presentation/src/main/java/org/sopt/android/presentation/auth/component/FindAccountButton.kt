package org.sopt.android.presentation.auth.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.android.designsystem.R
import org.sopt.android.designsystem.component.button.SoptampIconButton
import org.sopt.android.designsystem.style.SoptampTheme

@Composable
fun FindAccountButton(
    text: String,
    onClick: () -> Unit = {}
) {
    Button(
        onClick = { onClick() },
        contentPadding = PaddingValues(
            start = 16.dp,
            end = 3.dp,
            top = 12.dp,
            bottom = 12.dp
        ),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = SoptampTheme.colors.purple200
        ),
        shape = RoundedCornerShape(9.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = text,
                style = SoptampTheme.typography.h3,
                color = SoptampTheme.colors.purple300,
                modifier = Modifier.weight(1f)
            )
            SoptampIconButton(
                imageVector = ImageVector.vectorResource(id = R.drawable.right_forward),
                tint = SoptampTheme.colors.purple300,
                onClick = { onClick() }
            )
        }
    }
}

@Preview(backgroundColor = 0xFFFFFF, showBackground = true)
@Composable
fun PreviewFindAccountButton() {
    SoptampTheme {
        FindAccountButton(text = "text")
    }
}
