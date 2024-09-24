package ac.project.savesyncapp.ui.screen

import ac.project.savesyncapp.R
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.util.Locale.Category

@Composable
fun TransactionCategory(){
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 10.dp)
    ) {

        Text("Top Categories",style = MaterialTheme.typography.titleLarge.copy(   // Copy titleLarge and customize properties
            fontSize = 20.sp,  // Custom font size
            color = Color.DarkGray,
            fontWeight = FontWeight.SemiBold
        ))
        Spacer(modifier = Modifier.height(10.dp))
        CategoriesRow()
    }
}

@Composable
fun CategoriesRow() {
    // List of categories with icons and names
    val categories = listOf(
        Pair("Income", painterResource(id = R.drawable.salary)), // Replace with actual drawable resource
        Pair("Expenses", painterResource(id = R.drawable.expenses)),
        Pair("Statistics", painterResource(id = R.drawable.stats)),
        Pair("Goals", painterResource(id = R.drawable.target))
    )

    // LazyRow to display the category items
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier.padding(vertical = 5.dp)
    ) {
        items(categories) { category ->
            // Each item is a CategoryRowItem
            CategoryRowItem(name = category.first, icon = category.second)
        }
    }
}

@Composable
fun CategoryRowItem(name: String, icon: Painter) {
    // Box layout for the category item
    Box(
        modifier = Modifier
            .padding(horizontal = 8.dp)
            .clip(RoundedCornerShape(20.dp))
            .background(colorResource(R.color.category_lightblue))
            .height(80.dp) // Adjusted the height
            .width(80.dp)  // Adjusted the width for better text placement
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            // Image for the icon
            Image(
                painter = icon,
                contentDescription = null,
                modifier = Modifier.size(40.dp) // Adjust size as needed
            )
            // Text for the category name
            Text(
                text = name,
                fontSize = 14.sp,
                style = MaterialTheme.typography.titleLarge, fontWeight = FontWeight.SemiBold,
                color = colorResource(R.color.card_purple),
                modifier = Modifier.padding(top = 4.dp)
            )
        }
    }
}
