package bista.shiddarth.model

import kotlinx.serialization.Serializable

@Serializable
data class LiveMatch(
    val league_id: Long,
    val game_time: Int,
    val spectators: Int,
    val match_id: String,
    val deactivate_time: Long,

    val radiant_score: Int,
    val dire_score: Int,
    val radiant_lead: Int,

    val team_name_radiant: String,
    val team_name_dire: String,

    val team_id_radiant: Long? = null,
    val team_id_dire: Long? = null,

    val players: List<LivePlayer> = emptyList()
)

@Serializable
data class LivePlayer(
    val account_id: Long,
    val hero_id: Int,
    val team_slot: Int,
    val team: Int,
)
