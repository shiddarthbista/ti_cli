package bista.shiddarth.service

import bista.shiddarth.model.LiveMatch
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json

class LiveService(
) {

    companion object {
        private const val LIVE_URL =
            "https://api.opendota.com/api/live"

        private const val TI_LEAGUE_ID = 19719L
    }

    private val client = HttpClient {
        install(ContentNegotiation) {
            json(
                Json {
                    ignoreUnknownKeys = true
                }
            )
        }
    }

    suspend fun getLiveMatches(): List<LiveMatch> {
        return client
            .get(LIVE_URL)
            .body<List<LiveMatch>>()
            .filter { it.league_id == TI_LEAGUE_ID && it.deactivate_time == 0L }
            .groupBy { setOf(it.team_id_radiant, it.team_id_dire) }
            .map { (_, matches) -> matches.minByOrNull { it.game_time }!! }
    }
}