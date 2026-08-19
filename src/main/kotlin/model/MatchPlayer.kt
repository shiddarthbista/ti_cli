package bista.shiddarth.model

import kotlinx.serialization.Serializable

@Serializable
data class MatchPlayer(
    val name: String,
    val account_id: Long? = null,
    val player_slot: Int,
    val hero_id: Int,
    val kills: Int = 0,
    val deaths: Int = 0,
    val assists: Int = 0,
    val level: Int = 0,
    val last_hits: Int = 0,
    val denies: Int = 0,
    val gold_per_min: Int = 0,
    val xp_per_min: Int = 0,
    val net_worth: Long = 0L
)

@Serializable
data class MatchDetails(
    val match_id: Long,
    val radiant_score: Int,
    val dire_score: Int,
    val players: List<MatchPlayer> = emptyList()
)
