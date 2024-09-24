package ac.project.savesyncapp.ui.screen

import ac.project.savesyncapp.R
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.materialIcon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp



@Composable
fun ExpenseCard(){
    Box(
        modifier = Modifier.fillMaxSize()
            .padding(horizontal = 2.dp,
                vertical = 10.dp)
            .clip(RoundedCornerShape(10))
            .background(colorResource(R.color.card_purple))
            .height(250.dp)
    ){
        Column(
            modifier = Modifier.fillMaxWidth().padding(16.dp),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally) {
            BalanceRow()
            MonthlyExpensesProgress(
                minValue = 25000f,
                maxValue = 45000f,
                progressValue = 0.55f
            )
            IncomeExpenseRow()
        }
    }
}

@Composable
fun BalanceRow(){
        Text("Total Balance",fontSize = 24.sp, fontWeight = FontWeight.SemiBold, color = Color.White)
        Spacer(modifier = Modifier.height(5.dp))
        Text("Rs 45000", fontSize =  22.sp, fontWeight = FontWeight.Light, color = Color.White)
}

@Composable
fun MonthlyExpensesProgress(
    minValue: Float,   // Minimum value (left side)
    maxValue: Float,   // Maximum value (right side)
    progressValue: Float    // Progress (0.0 to 1.0)
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top=16.dp)
    ) {
        Text(
            text = "Monthly Expenses",
            color = Color.White,
            fontSize = 16.sp
        )

        Spacer(modifier = Modifier.height(8.dp))

        // Progress Bar
        LinearProgressIndicator(
            progress = { progressValue },
            modifier = Modifier
                .fillMaxWidth()
                .height(8.dp),
            color = Color(0xFF4CAF50), // Green progress bar color
            trackColor = Color(0xFFD3D3D3), // Light gray for background
        )

        Spacer(modifier = Modifier.height(8.dp))

        // Row for displaying min and max values
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Rs ${minValue}",
                color = Color.White,
                fontSize = 14.sp
            )
            Text(
                text = "Rs ${maxValue}",
                color = Color.White,
                fontSize = 14.sp
            )
        }
    }
}

@Composable
fun IncomeExpenseRow(){
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        CardItem("Income",75000f)
        CardItem("Expense",35000f)
    }
}

@Composable
fun CardItem(title:String,amount:Float){
    Box(
        modifier = Modifier.padding(16.dp)
        .clip(RoundedCornerShape(15))
        .background(color = Color.White)
            .fillMaxHeight()

    ){
        Column(modifier = Modifier.padding(horizontal = 16.dp, vertical = 1.dp),
            horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = title,fontSize = 16.sp, style = MaterialTheme.typography.titleLarge, fontWeight = FontWeight.Bold, color = Color.DarkGray)
            Text(text = "Rs $amount",fontSize = 16.sp, style = MaterialTheme.typography.titleSmall, fontWeight = FontWeight.Light, color = Color.DarkGray)
        }
    }
}