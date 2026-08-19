package bista.shiddarth.model

data class LiveScoreboardPlayer(
    val teamTag: String,
    val name: String,
    val hero: String,
    val level: Int,
    val kills: Int,
    val deaths: Int,
    val assists: Int,
    val lastHits: Int,
    val denies: Int,
    val gpm: Int,
    val xpm: Int
)