package ac.project.savesyncapp.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun SaveSyncScreen(){
    Surface(modifier = Modifier.fillMaxSize().background(color = Color.White)) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 24.dp, vertical = 10.dp)
        ) {
            HeaderRow()
            Spacer(modifier = Modifier.height(16.dp))
            ExpenseCard()
            Spacer(modifier = Modifier.height(16.dp))
            TransactionCategory()
            Spacer(modifier = Modifier.height(16.dp))
            TransactionList()
        }

    }
}

@Composable
@Preview(showBackground = true)
fun SaveSynScreenPreview(){
    SaveSyncScreen()
}