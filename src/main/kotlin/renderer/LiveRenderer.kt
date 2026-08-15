package bista.shiddarth.renderer

import bista.shiddarth.model.LiveMatch
import com.github.ajalt.mordant.rendering.BorderType.Companion.SQUARE_DOUBLE_SECTION_SEPARATOR
import com.github.ajalt.mordant.rendering.TextColors
import com.github.ajalt.mordant.rendering.TextStyles
import com.github.ajalt.mordant.table.table
import com.github.ajalt.mordant.terminal.Terminal

class LiveRenderer(
    private val terminal: Terminal = Terminal()
) {

    fun renderNoMatches() {
        terminal.println()
        terminal.println(TextStyles.dim("No TI matches are currently live."))
        terminal.println()
    }

    fun selectMatch(matches: List<LiveMatch>): LiveMatch {

        terminal.println()
        terminal.println(TextColors.brightWhite(TextStyles.bold("LIVE NOW")))
        terminal.println()

        matches.forEachIndexed { index, match ->

            val radiant = cleanText(match.team_name_radiant, "Radiant")
            val dire = cleanText(match.team_name_dire, "Dire")

            terminal.println(
                "${index + 1}. " +
                        "$radiant vs $dire " +
                        "(${formatGameTime(match.game_time)})"
            )
        }

        terminal.println()

        while (true) {
            terminal.print("Select a match (1-${matches.size}): ")

            val selection = readlnOrNull()?.trim()?.toIntOrNull()

            if (selection != null && selection in 1..matches.size) {
                return matches[selection - 1]
            }

            terminal.println(
                TextColors.red("Invalid selection. Please choose 1-${matches.size}.")
            )
        }
    }

    fun renderMatch(
        match: LiveMatch,
        heroMap: Map<Int, String>
    ) {
        val radiant = cleanText(match.team_name_radiant, "Radiant")
        val dire = cleanText(match.team_name_dire, "Dire")

        terminal.println()

        terminal.println(
            TextColors.brightWhite(
                TextStyles.bold(
                    "$radiant ${match.radiant_score} - " +
                            "${match.dire_score} $dire"
                )
            )
        )

        terminal.println()

        terminal.println("Game Time: ${formatGameTime(match.game_time)}")
        terminal.println("Gold Lead: ${formatGoldLead(match.radiant_lead)}")
        terminal.println("Spectators: ${match.spectators}")

        terminal.println()

        renderPlayers(match = match, heroMap = heroMap)

        terminal.println()
    }

    private fun renderPlayers(
        match: LiveMatch,
        heroMap: Map<Int, String>
    ) {
        val radiantPlayers = match.players
            .filter { it.team == 0 }
            .sortedBy { it.team_slot }

        val direPlayers = match.players
            .filter { it.team == 1 }
            .sortedBy { it.team_slot }

        val rowCount = maxOf(radiantPlayers.size, direPlayers.size)

        terminal.print(
            table {
                borderType = SQUARE_DOUBLE_SECTION_SEPARATOR
                header {
                    row {
                        cell(TextColors.brightGreen(TextStyles.bold("Player")))
                        cell(TextColors.brightGreen(TextStyles.bold("Hero")))
                        cell(TextColors.brightRed(TextStyles.bold("Player")))
                        cell(TextColors.brightRed(TextStyles.bold("Hero")))
                    }
                }

                body {
                    for (i in 0 until rowCount) {
                        val radiant = radiantPlayers.getOrNull(i)
                        val dire = direPlayers.getOrNull(i)

                        row {
                            // Radiant team
                            cell(TextColors.green(cleanText("${radiant?.team_tag}.${radiant?.name}","")))
                            cell(
                                TextColors.cyan(
                                    radiant?.let { cleanText(heroMap[it.hero_id], "Unknown") } ?: ""
                                )
                            )

                            // Dire team
                            cell(TextColors.red(cleanText("${dire?.team_tag}.${dire?.name}","")))
                            cell(
                                TextColors.cyan(
                                    dire?.let { cleanText(heroMap[it.hero_id], "Unknown") } ?: ""
                                )
                            )
                        }
                    }
                }
            }
        )
    }

    private fun formatGameTime(seconds: Int): String {
        if (seconds < 0) return "Starting in ${-seconds}s"
        val minutes = seconds / 60
        val remainingSeconds = seconds % 60
        return "%02d:%02d".format(minutes, remainingSeconds)
    }

    private fun formatGoldLead(lead: Int): String {
        return when {
            lead > 0 -> TextColors.brightGreen("Radiant +$lead")
            lead < 0 -> TextColors.brightRed("Dire +${-lead}")
            else -> "Even"
        }
    }

    private fun cleanText(value: String?, fallback: String): String {
        val cleaned = value
            ?.replace(Regex("\\p{C}"), "")
            ?.trim()

        return if (cleaned.isNullOrBlank()) fallback else cleaned
    }
}