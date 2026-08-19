package bista.shiddarth.commands

import bista.shiddarth.renderer.LiveRenderer
import bista.shiddarth.service.LiveService
import bista.shiddarth.util.heroMap
import com.github.ajalt.clikt.core.CliktCommand
import com.github.ajalt.clikt.core.Context
import com.github.ajalt.mordant.input.interactiveSelectList
import com.github.ajalt.mordant.terminal.Terminal
import kotlinx.coroutines.runBlocking

class LiveCommand(
    private val liveService: LiveService = LiveService(),
    private val renderer: LiveRenderer = LiveRenderer(),
    private val terminal: Terminal = Terminal()
) : CliktCommand(
    name = "live",
) {


    override fun help(context: Context): String = "Show Live TI Matches"

    override fun run() = runBlocking {
        val matches = liveService.getLiveMatches()

        if (matches.isEmpty()) {
            renderer.renderNoMatches()
            return@runBlocking
        }

        val matchOptions = matches.map { match ->
            "${match.team_name_radiant} vs ${match.team_name_dire}"
        }

        val selection = terminal.interactiveSelectList(
            matches.map { match ->
                "${match.team_name_radiant} vs ${match.team_name_dire}"
            },
            title = "Select a Live Match"
        )

        if (selection == null) {
            return@runBlocking
        }

        val selectedMatch = matches[matchOptions.indexOf(selection)]

        val matchDetails = liveService.getMatchDetails(
            selectedMatch.match_id.toLong()
        )

        renderer.render(
            selectedMatch,
            matchDetails
        )
    }
}