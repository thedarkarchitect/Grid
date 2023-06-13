package com.example.grid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.grid.model.DataSource.topics
import com.example.grid.model.Topic
import com.example.grid.ui.theme.GridTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GridTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    GridApp()
                }
            }
        }
    }
}

@Composable
fun GridApp( modifier: Modifier = Modifier) {

        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            content = {
                items(topics){
                        topic ->
                    Box (
                        contentAlignment = Alignment.Center,
                        modifier = modifier
                            .padding(10.dp)
                ) {
                    GridItem(
                        num = topic.numberOfCourses,
                        image = topic.topicImage,
                        course = topic.topicName
                    )
                }

                }
            },

        )


}

@Composable
fun GridItem(
    num: Int,
    image: Int,
    course: Int,
    modifier: Modifier = Modifier
){
    Card(
        modifier = modifier,

    ) {
        Row(
            modifier = modifier
        ){
            Image(
                painter = painterResource(id = image),
                contentDescription = null,
                modifier = modifier
                    .height(69.5.dp)
                    .width(68.dp)
            )
            Spacer(modifier = modifier.padding(end=16.dp))
            Column(
                modifier = modifier
                        .padding(top = 16.dp,
                            end = 16.dp
                        )
            ) {
                Text(text = stringResource(id = course), style = MaterialTheme.typography.bodySmall)
                Spacer(modifier = modifier.padding(bottom = 8.dp))
                Row(
                    modifier = modifier
                ) {
                    Image(painter = painterResource(id = R.drawable.ic_grain) , contentDescription = null , colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.secondary))
                    Spacer(modifier = modifier.padding(end = 8.dp))
                    Text(text = num.toString() )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GridPreview() {
    GridTheme {
        GridApp()
//        GridItem(num = 321)
    }
}