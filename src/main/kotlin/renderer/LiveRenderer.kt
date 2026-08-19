package bista.shiddarth.renderer

import bista.shiddarth.model.LiveMatch
import bista.shiddarth.model.LivePlayer
import bista.shiddarth.model.MatchDetails
import bista.shiddarth.model.MatchPlayer
import bista.shiddarth.util.heroMap
import com.github.ajalt.mordant.rendering.TextAlign
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

    fun render(
        liveMatch: LiveMatch,
        matchDetails: MatchDetails
    ) {
        terminal.println()

        terminal.println(
            TextStyles.bold(
                TextColors.brightGreen(liveMatch.team_name_radiant) +
                        " ${liveMatch.radiant_score} - ${liveMatch.dire_score} " +
                        TextColors.brightRed(liveMatch.team_name_dire)
            )
        )

        terminal.println()

        val goldLead = when {
            liveMatch.radiant_lead > 0 ->
                "Radiant +${liveMatch.radiant_lead}"

            liveMatch.radiant_lead < 0 ->
                "Dire +${-liveMatch.radiant_lead}"

            else ->
                "Even"
        }

        terminal.println(
            "Game Time: ${TextColors.brightCyan(formatGameTime(liveMatch.game_time))}"
        )

        val goldLeadColor = when {
            liveMatch.radiant_lead > 0 -> TextColors.green
            liveMatch.radiant_lead < 0 -> TextColors.red
            else -> TextColors.yellow
        }

        terminal.println(
            "Gold Lead: ${goldLeadColor(goldLead)}"
        )

        terminal.println()

        val matchPlayers = matchDetails.players.associateBy {
            it.account_id
        }

        val radiantPlayers = liveMatch.players
            .filter { it.team == 0 }

        val direPlayers = liveMatch.players
            .filter { it.team == 1 }

        renderTeam(
            teamName = liveMatch.team_name_radiant,
            players = radiantPlayers,
            matchPlayers = matchPlayers,
            isRadiant = true,
        )

        terminal.println()

        renderTeam(
            teamName = liveMatch.team_name_dire,
            players = direPlayers,
            matchPlayers = matchPlayers,
            isRadiant = false,
        )
    }

    private fun renderTeam(
        teamName: String,
        players: List<LivePlayer>,
        matchPlayers: Map<Long?, MatchPlayer>,
        isRadiant: Boolean
    ) {

        val color = if (isRadiant) {
            TextColors.brightGreen
        } else {
            TextColors.brightRed
        }

        val playerColor = if (isRadiant) {
            TextColors.green
        } else {
            TextColors.red
        }

        terminal.println(
            color(
                TextStyles.bold(teamName)
            )
        )

        terminal.println(
            table {
                column(2) {
                    align = TextAlign.RIGHT
                }
                column(3) {
                    align = TextAlign.RIGHT
                }
                column(4) {
                    align = TextAlign.RIGHT
                }
                column(5) {
                    align = TextAlign.RIGHT
                }
                column(6) {
                    align = TextAlign.RIGHT
                }
                column(7) {
                    align = TextAlign.RIGHT
                }
                column(8) {
                    align = TextAlign.RIGHT
                }
                column(9) {
                    align = TextAlign.RIGHT
                }

                header {
                    row(
                        "Player",
                        "Hero",
                        "LVL",
                        "K",
                        "D",
                        "A",
                        "LH/DN",
                        "NW",
                        "GPM",
                        "XPM"
                    )
                }

                body {
                    players.forEach { livePlayer ->

                        val stats = matchPlayers[livePlayer.account_id]

                        row(
                            playerColor(stats?.name ?: "Unknown"),
                            TextColors.cyan(heroMap[livePlayer.hero_id] ?: "Unknown"),
                            stats?.level?.toString() ?: "-",
                            stats?.kills?.toString() ?: "-",
                            stats?.deaths?.toString() ?: "-",
                            stats?.assists?.toString() ?: "-",
                            stats?.let {
                                "${it.last_hits}/${it.denies}"
                            } ?: "0/0",
                            TextColors.yellow(stats?.net_worth?.toString() ?: "-"),
                            TextColors.yellow(stats?.gold_per_min?.toString() ?: "-"),
                            stats?.xp_per_min?.toString() ?: "-"
                        )
                    }
                }
            }
        )
    }

    private fun formatGameTime(seconds: Int): String {
        val minutes = seconds / 60
        val remainingSeconds = seconds % 60

        return "%02d:%02d".format(
            minutes,
            remainingSeconds
        )
    }
}