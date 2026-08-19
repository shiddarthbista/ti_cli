package bista.shiddarth.service

import bista.shiddarth.model.LiveMatch
import bista.shiddarth.model.LivePlayer
import bista.shiddarth.model.MatchDetails
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
        private const val MATCH_URL =
            "https://api.opendota.com/api/matches"
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
            .map { (_, matches) -> matches.minByOrNull { it.game_time }!!
            }
    }

    suspend fun getMatchDetails(matchId: Long): MatchDetails {
        return client
            .get("$MATCH_URL/$matchId")
            .body()
    }

    fun getFakeLiveMatches(): List<LiveMatch> {
        val fakeLiveMatch1 = LiveMatch(
            league_id = 19719,
            game_time = 1300,
            match_id = "8948533452",
            deactivate_time = 0,
            radiant_score = 21,
            dire_score = 11,
            radiant_lead = 8170,
            team_name_radiant = "LGD Gaming",
            team_name_dire = "Team Yandex",
            team_id_radiant = 10150538,
            team_id_dire = 9823272,
            players = listOf(
                LivePlayer(account_id = 103735745, hero_id = 21, team_slot = 1, team = 0),
                LivePlayer(account_id = 177203952, hero_id = 83, team_slot = 2, team = 0),
                LivePlayer(account_id = 94054712, hero_id = 119, team_slot = 3, team = 0),
                LivePlayer(account_id = 292921272, hero_id = 20, team_slot = 4, team = 0),
                LivePlayer(account_id = 105045291, hero_id = 108, team_slot = 5, team = 0),
                LivePlayer(account_id = 81306398, hero_id = 26, team_slot = 1, team = 1),
                LivePlayer(account_id = 81306398, hero_id = 62, team_slot = 2, team = 1),
                LivePlayer(account_id = 312436974, hero_id = 93, team_slot = 3, team = 1),
                LivePlayer(account_id = 93817671, hero_id = 145, team_slot = 4, team = 1),
                LivePlayer(account_id = 103735745, hero_id = 85, team_slot = 5, team = 1),
            ),
            spectators = 0
        )
        return listOf(fakeLiveMatch1,fakeLiveMatch1)
    }
}
