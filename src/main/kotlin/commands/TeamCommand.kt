package bista.shiddarth.commands

import bista.shiddarth.TeamRenderer
import bista.shiddarth.service.TeamService
import com.github.ajalt.clikt.core.CliktCommand
import com.github.ajalt.clikt.core.Context
import com.github.ajalt.clikt.parameters.arguments.argument
import com.github.ajalt.mordant.rendering.TextColors
import com.github.ajalt.mordant.terminal.Terminal

class TeamCommand(
    private val teamService: TeamService = TeamService(),
    private val renderer: TeamRenderer = TeamRenderer(),
    private val terminal: Terminal = Terminal()
) : CliktCommand(
    name = "team",
) {

    private val teamName by argument(
        name = "team",
        help = "Team name"
    )

    override fun help(context: Context): String = "Show information about a team"

    override fun run() {
        val team = teamService.findTeam(teamName)

        if (team == null) {
            terminal.println(
                TextColors.red("Team not found: $teamName")
            )
            return
        }

        renderer.render(team)
    }

}