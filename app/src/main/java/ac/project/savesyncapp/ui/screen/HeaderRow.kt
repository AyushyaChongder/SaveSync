package ac.project.savesyncapp.ui.screen


import ac.project.savesyncapp.R
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding

import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight

import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun HeaderRow(){
    Row(
        modifier = Modifier.fillMaxWidth().padding(top=8.dp),
        verticalAlignment = Alignment.Top,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        ProfileIcon()
        HeaderText("Ayushya")
        NotifyIcon()
    }

}

@Composable
fun ProfileIcon(){
    Surface(
        color = Color.LightGray,
        shape = CircleShape,
        modifier = Modifier
            .size(48.dp)
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment =  Alignment.Center
        ){
            Image(
                painter = painterResource(id = R.drawable.womanimg),
                contentDescription = "Profile icon",
                modifier = Modifier.size(28.dp)
            )
        }
    }
}


@Composable
fun HeaderText(name:String){
    Column(
        modifier = Modifier.padding(end = 88.dp),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Center
    ) {
        Text("Hello $name", style = MaterialTheme.typography.titleLarge.copy(   // Copy titleLarge and customize properties
            fontSize = 20.sp,  // Custom font size
            color = Color.DarkGray  // Custom color
        ))
        Text("Good Morning",style = MaterialTheme.typography.bodySmall.copy(   // Copy titleLarge and customize properties
            fontSize = 18.sp,  // Custom font size
            color = Color.Gray  // Custom color
        ))
    }
}


@Composable
fun NotifyIcon(){
    Surface(
        color = Color.White,
        shape = CircleShape,
        modifier = Modifier
            .size(48.dp)
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment =  Alignment.Center
        ){
            Image(painter = painterResource(R.drawable.baseline_notifications_none_24),
                contentDescription = "Notification Icon",
                modifier = Modifier.size(28.dp))
        }
    }
}