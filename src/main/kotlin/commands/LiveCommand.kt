package bista.shiddarth.commands

import bista.shiddarth.renderer.LiveRenderer
import bista.shiddarth.service.LiveService
import bista.shiddarth.util.heroMap
import com.github.ajalt.clikt.core.CliktCommand
import com.github.ajalt.clikt.core.Context
import kotlinx.coroutines.runBlocking

class LiveCommand(
    private val liveService: LiveService = LiveService(),
    private val renderer: LiveRenderer = LiveRenderer()
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

        val selectedMatch = renderer.selectMatch(matches)

        renderer.renderMatch(
            match = selectedMatch,
            heroMap = heroMap
        )
    }
}