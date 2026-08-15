package bista.shiddarth

import bista.shiddarth.model.Team
import com.github.ajalt.mordant.rendering.BorderType
import com.github.ajalt.mordant.rendering.TextAlign
import com.github.ajalt.mordant.rendering.TextColors
import com.github.ajalt.mordant.rendering.TextStyles
import com.github.ajalt.mordant.table.table
import com.github.ajalt.mordant.terminal.Terminal
import com.github.ajalt.mordant.widgets.Text

class TeamRenderer(
    private val terminal: Terminal = Terminal()
) {

    fun render(team: Team) {
        terminal.println()

        val teamTable = table {
            borderType = BorderType.SQUARE_DOUBLE_SECTION_SEPARATOR

            header {
                style = TextColors.brightWhite + TextStyles.bold

                row {
                    cell("Name")
                    cell("Country")
                    cell("Age")
                    cell("Position")
                }
            }

            body {
                team.players.forEach { player ->
                    row(
                        TextColors.brightBlue(player.name),
                        player.country,
                        player.age,
                        player.role
                    )
                }
            }
        }

        // Measure how wide the table will actually render
        val tableWidth = teamTable.measure(terminal).max

        terminal.print(
            Text(
                (TextColors.green + TextStyles.bold)(team.name),
                align = TextAlign.CENTER,
                width = tableWidth
            )
        )

        terminal.println()
        terminal.println(teamTable)
        terminal.println()
    }
}