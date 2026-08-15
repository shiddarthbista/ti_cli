package bista.shiddarth.commands

import bista.shiddarth.util.teamMap
import com.github.ajalt.clikt.core.CliktCommand
import com.github.ajalt.clikt.core.Context
import com.github.ajalt.mordant.terminal.Terminal

class TeamsCommand(
    private val terminal: Terminal = Terminal()
) : CliktCommand(
    name = "teams"
) {
    override fun help(context: Context): String = "List all TI teams"

    override fun run() {
        terminal.println()
        teamMap.values
            .sorted()
            .forEach { teamName ->
                terminal.println(
                    teamName
                )
            }
    }

}

