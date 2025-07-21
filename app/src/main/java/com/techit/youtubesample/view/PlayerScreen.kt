package com.techit.youtubesample.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.viewinterop.AndroidView
import com.techit.youtubelib.interfaces.YouTubePlayer
import com.techit.youtubelib.listeners.AbstractYouTubePlayerListener
import com.techit.youtubelib.options.IFramePlayerOptions
import com.techit.youtubelib.view.YouTubePlayerView
import com.techit.youtubesample.extensions.extractYouTubeId


@Composable
fun YoutubePlayerScreen(youtubeUrl:String){

    val videoId = youtubeUrl.extractYouTubeId()

    Box(modifier = Modifier
        .fillMaxSize()) {
        Column {
            Text("Welcome to Youtube Player", modifier = Modifier.fillMaxWidth().background(
                Color.Red).align(Alignment.CenterHorizontally))
            Row(modifier = Modifier.background(Color.Green)) {
                AndroidView(
                    modifier = Modifier.fillMaxSize(),
                    factory = { ctx ->
                        YouTubePlayerView(ctx).apply {
                            enableAutomaticInitialization = false           // 🔑
                            keepScreenOn = true
                            val opts = IFramePlayerOptions.Builder()
                                .controls(0)
                                .fullscreen(0)
                                .autoplay(1)
                                .rel(0)
                                .build()

                            initialize(object : AbstractYouTubePlayerListener() {
                                override fun onReady(player: YouTubePlayer) {
                                    videoId?.let {
                                        player.loadVideo(it, 0f)
                                    }
                                    // lastVideoId.value = videoId
                                }
                            }, opts)
                        }
                    },
                    update = { view ->

                    }
                )
            }
        }

    }
}