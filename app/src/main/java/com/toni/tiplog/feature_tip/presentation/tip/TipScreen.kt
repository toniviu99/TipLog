package com.toni.tiplog.feature_tip.presentation.tip

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
    val datePickerState = rememberDatePickerState()
    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.End
        ) {
            Column(
               modifier = Modifier
                   .weight(1f)
                   .padding(top = 60.dp)
            ) {
                Text(text = "CHANGE THE DATE", color = Color.Black)
                Spacer(modifier = Modifier.height(12.dp))
                TipLogDatePicker(Modifier, state.date) {
                   viewModel.onEvent(TipEvent.ShowDialogChange(true))
                }
                println()
                if (state.showDialog){
                    DatePickerDialog(
                        onDismissRequest = { viewModel.onEvent(TipEvent.ShowDialogChange(false)) },
                        confirmButton = {
                            Button(onClick = {
                                var dateFormatted = viewModel.formatDate(datePickerState.selectedDateMillis.toString())
                                viewModel.onEvent(TipEvent.DateChange(dateFormatted))
                                viewModel.onEvent(TipEvent.ShowDialogChange(false))
                            }) {
                                Text(text = "CONFIRM")
                            }
                        },
                        dismissButton = {
                            OutlinedButton(onClick = {
                                viewModel.onEvent(TipEvent.ShowDialogChange(false))
                            }) {
                                Text(text = "CANCEL")
                            }
                        }
                    ) {
                        DatePicker(state = datePickerState)
                    }
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
//                    textColor = Color.Black,
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
                onClick = { viewModel.onEvent(TipEvent.SaveTip)},
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
            Spacer(modifier = Modifier.height(32.dp))
            Text(text = state.error, color = Color.Black)

        }


    }
}