package bista.shiddarth

import bista.shiddarth.commands.ScheduleCommand
import bista.shiddarth.commands.TeamCommand
import com.github.ajalt.clikt.core.CliktCommand
import com.github.ajalt.clikt.core.main
import com.github.ajalt.clikt.core.subcommands


class TiCommand : CliktCommand(
    name = "ti",
) {
    override fun run() {
    }
}

fun main(args: Array<String>) {
    TiCommand()
        .subcommands(
            TeamCommand(),
            ScheduleCommand()
        )
        .main(args)
}