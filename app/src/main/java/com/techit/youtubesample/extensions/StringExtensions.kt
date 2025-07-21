package com.techit.youtubesample.extensions



fun String.extractYouTubeId(): String {
    // Implement URL parsing to extract video ID
    val pattern = "(?<=watch\\?v=|/videos/|embed\\/|youtu.be\\/|\\/v\\/|\\/e\\/|watch\\?v%3D|watch\\?feature=player_embedded&v=|%2Fvideos%2F|embed%\u200C\u200B2F|youtu.be%2F|%2Fv%2F)[^#\\&\\?\\n]*"
    val compiledPattern = java.util.regex.Pattern.compile(pattern)
    val matcher = compiledPattern.matcher(this)
    return if (matcher.find()) {
        matcher.group() ?: ""
    } else {
        this // fallback to assuming it's already an ID
    }
}