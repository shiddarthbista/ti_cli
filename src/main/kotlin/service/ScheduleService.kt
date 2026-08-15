package bista.shiddarth.service

import bista.shiddarth.model.Schedule
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json

class ScheduleService {

    private val client = HttpClient {
        install(ContentNegotiation) {
            json(
                Json {
                    ignoreUnknownKeys = true
                }
            )
        }
    }

    suspend fun getSchedule(): List<Schedule> {
        return client
            .get("https://dota.haglund.dev/v1/matches")
            .body()
    }
}