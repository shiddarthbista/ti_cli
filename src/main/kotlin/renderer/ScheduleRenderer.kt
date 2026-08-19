package bista.shiddarth.renderer

import bista.shiddarth.model.Schedule
import com.github.ajalt.mordant.rendering.TextColors
import com.github.ajalt.mordant.rendering.TextStyles
import com.github.ajalt.mordant.terminal.Terminal
import java.time.Instant
import java.time.ZoneId
import java.time.format.DateTimeFormatter

class ScheduleRenderer(
    private val terminal: Terminal = Terminal()
) {

    private val timeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm")
    private val localZone = ZoneId.systemDefault()

    fun render(matches: List<Schedule>) {

        terminal.println()

        terminal.println(
            TextColors.brightCyan(
                TextStyles.bold("TI 2026 SCHEDULE")
            )
        )

        terminal.println()

        matches
            .groupBy { extractRound(it.leagueName) }
            .forEach { (round, roundMatches) ->

                terminal.println(
                    TextColors.brightBlue(
                        TextStyles.bold(round.uppercase())
                    )
                )

                terminal.println()

                roundMatches.forEach { match ->
                    renderMatch(match)
                }

                terminal.println()
            }
    }

    private fun renderMatch(match: Schedule) {

        val time = formatTime(match.startsAt)

        val team1 = match.teams.firstOrNull()?.name ?: "TBD"

        val team2 = match.teams.getOrNull(1)?.name ?: "TBD"

        val formattedMatch =
            time.padEnd(20) +
                    match.matchType.padEnd(9) +
                    TextColors.yellow(team1.padEnd(22)) +
                    TextStyles.dim("vs") +
                    "  " +
                    TextColors.magenta(team2)

        terminal.println(formattedMatch)
    }

    private fun formatTime(startsAt: String): String {
        return Instant.parse(startsAt)
            .atZone(localZone)
            .format(timeFormatter)
    }

    private fun extractRound(leagueName: String): String {
        return leagueName
    }
}