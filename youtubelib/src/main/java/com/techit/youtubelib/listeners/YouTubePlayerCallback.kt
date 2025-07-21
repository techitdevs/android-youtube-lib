package com.techit.youtubelib.listeners

import com.techit.youtubelib.interfaces.YouTubePlayer

interface YouTubePlayerCallback {
  fun onYouTubePlayer(youTubePlayer: YouTubePlayer)
}