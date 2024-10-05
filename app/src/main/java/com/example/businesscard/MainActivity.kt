package com.example.businesscard


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.sharp.Email
import androidx.compose.material.icons.sharp.Phone
import androidx.compose.material.icons.sharp.Share
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BusinessCardTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    IconCompose(
                        stringResource(R.string.name),
                        stringResource(R.string.title)
                    )
                    ContactCompose(
                        stringResource(R.string.phone),
                        stringResource(R.string.email),
                        stringResource(R.string.social)
                    )
                }
            }
        }
    }
}

@Composable
fun IconCompose(name: String, title: String, modifier: Modifier = Modifier) {
    val image = painterResource(R.drawable.android_logo)

   Column(
       modifier = modifier
           .fillMaxSize(),
       verticalArrangement = Arrangement.Center,
       horizontalAlignment = Alignment.CenterHorizontally
   ){
       Image(
        painter = image,
           contentDescription = null,
           modifier  = modifier
               .width(300.dp)
               .height(200.dp)
       )
       Text(
           text = name,
           fontSize = 30.sp,
           fontWeight = FontWeight.Bold,
           textAlign = TextAlign.Center,
           modifier = modifier
               .padding(16.dp)

       )
       Text(
           text = title,
           fontSize = 14.sp,
           textAlign = TextAlign.Center,
           modifier = modifier

       )
   }
}

@Composable
fun ContactCompose(phone: String, email: String, social: String,modifier: Modifier = Modifier){
    val phoneIcon = Icons.Sharp.Phone
    val shareIcon = Icons.Sharp.Share
    val emailIcon = Icons.Sharp.Email

    Column(
        verticalArrangement = Arrangement.Bottom,
        modifier = Modifier
        .fillMaxSize()
            .padding(start = 50.dp,bottom = 40.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .padding(16.dp)
        ) {
            Icon(
                phoneIcon,
                contentDescription = "Phone Icon",
                modifier = Modifier
                    .padding(horizontal = 10.dp)
            )
            Text(
                text = phone,
            )
        }
        Row(
            modifier = Modifier
                .padding(16.dp)
        ) {
            Icon(
                emailIcon,
                contentDescription = "Email Icon",
                modifier = Modifier
                    .padding(horizontal = 10.dp)
            )
            Text(
                text = email,
            )
        }
        Row(
            horizontalArrangement = Arrangement.Absolute.Right,
            modifier = Modifier
                    .padding(16.dp)
        ) {
            Icon(
                shareIcon,
                contentDescription = "Share Icon",
                modifier = Modifier
                    .padding(horizontal = 10.dp)
            )
            Text(
                text = social,
            )
        }
    }
}
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BusinessCardTheme {
        IconCompose(
            stringResource(R.string.name),
            stringResource(R.string.title)
        )
        ContactCompose(
            stringResource(R.string.phone),
            stringResource(R.string.email),
            stringResource(R.string.social)
        )
    }
}