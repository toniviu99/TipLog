package com.toni.tiplog.feature_tip.presentation.tip

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.toni.tiplog.feature_tip.presentation.components.TipLogDatePicker

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TipScreen(
    viewModel: TipViewModel = hiltViewModel()
) {

    val state = viewModel.state

    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.End
        ) {
            Column(
               modifier = Modifier.weight(1f).padding(top = 60.dp)
            ) {
                Text(text = "CHANGE THE DATE", color = Color.Black)
                Spacer(modifier = Modifier.height(12.dp))
                TipLogDatePicker(Modifier, "24/07/2022") {
                    Log.d("toni", "click")
                }
            }


        }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 50.dp),
            verticalArrangement = Arrangement.Center,
        ) {
            Spacer(modifier = Modifier.height(60.dp))
            Text(text = "INSERT NEW TIP", color = Color.Black)
            Spacer(modifier = Modifier.height(12.dp))
            TextField(
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Decimal,
                ),
                value = state.tipAmount,
                singleLine = true,
                textStyle = MaterialTheme.typography.bodyLarge,
                onValueChange = { viewModel.onEvent(TipEvent.TipChange(it)) },
                shape = RoundedCornerShape(90.dp),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color.Transparent,
                    unfocusedBorderColor = Color.Transparent,
                    textColor = Color.Black,
                    cursorColor = Color.Gray,
                    containerColor = MaterialTheme.colorScheme.secondary,
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp),

            )
            Spacer(modifier = Modifier.height(32.dp))
            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp),
                onClick = {  },
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    contentColor = Color.White
                ),
                shape = RoundedCornerShape(90.dp)
            ) {
                Text(
                    text = "SAVE",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.SemiBold,
                )
            }

        }


    }
}