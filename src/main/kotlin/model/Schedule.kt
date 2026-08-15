package bista.shiddarth.model

import kotlinx.serialization.Serializable

@Serializable
data class Schedule(
    val id: String,
    val hash: String,
    val matchType: String,
    val startsAt: String,
    val leagueName: String,
    val teams: List<MatchTeam>
)

@Serializable
data class MatchTeam(
    val name: String,
    val url: String? = null
)