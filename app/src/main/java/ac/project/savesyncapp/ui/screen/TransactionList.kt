package ac.project.savesyncapp.ui.screen

import ac.project.savesyncapp.R
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class Transaction(
    val name: String,
    val type: String,
    val icon: Int,
    val amount: Float
)


@Composable
fun TransactionList() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 10.dp, vertical = 10.dp)
    ) {

        Text(
            "Recent Transactions",
            style = MaterialTheme.typography.titleLarge.copy(   // Copy titleLarge and customize properties
                fontSize = 20.sp,  // Custom font size
                color = Color.DarkGray,
                fontWeight = FontWeight.SemiBold
            )
        )


    }
    TransactionListItems()
}

@Composable
fun TransactionListItems()
{
    val transactions = listOf(
        Transaction("Grocery Shopping", "Expense", R.drawable.expenses,800f),
        Transaction("Salary", "Income", R.drawable.salary,52000f),
        Transaction("Rent", "Expense", R.drawable.expenses,19000f),
        Transaction("Grocery Shopping", "Expense", R.drawable.expenses,800f),
        Transaction("Salary", "Income", R.drawable.salary,52000f),
        Transaction("Rent", "Expense", R.drawable.expenses,19000f)
    )


        LazyColumn( modifier = Modifier.fillMaxWidth().height(250.dp).padding(vertical = 8.dp)
        ) {
            items(transactions) { transaction ->
                TransactionItem(
                    item = transaction
                )
            }
        }

}

@Composable
fun TransactionItem(item:Transaction){
    Box(modifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = 8.dp, vertical = 5.dp)
        .clip(RoundedCornerShape(10.dp))
        .background(colorResource(R.color.category_lightblue))
        .height(60.dp) // Adjusted the height
        ){
        Row(
            modifier = Modifier.fillMaxWidth().padding(horizontal = 10.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .padding(5.dp)
                    .clip(RoundedCornerShape(10.dp))
                    .background(colorResource(R.color.white))
                    .height(50.dp) // Adjusted the height
                    .width(50.dp) , // Adjusted the width for better text placement
            ){
                // Image for the icon
                Image(
                    painter = painterResource(id=item.icon),
                    contentDescription = null,
                    modifier = Modifier
                        .size(30.dp)
                        .align(Alignment.Center) // Center the image within the Box
                )
            }
            Column(modifier = Modifier.padding(horizontal = 16.dp, vertical = 3.dp),
                horizontalAlignment = Alignment.CenterHorizontally) {
                // Text for the category name
                Text(
                    text = item.name,
                    fontSize = 16.sp,
                    style = MaterialTheme.typography.bodyMedium, fontWeight = FontWeight.Medium,
                    color = colorResource(R.color.card_purple),
                )
                Text(
                    text = item.type,
                    fontSize = 14.sp,
                    style = MaterialTheme.typography.bodySmall, fontWeight = FontWeight.Light,
                    color = colorResource(R.color.teal_700),
                )
            }

            Text(
                text = "Rs ${item.amount}",
                fontSize = 16.sp,
                style = MaterialTheme.typography.bodyMedium, fontWeight = FontWeight.Medium,
                color = if (item.type == "Expense") Color.Red else colorResource(R.color.teal_700)
            )

        }
    }
}