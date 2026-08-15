package bista.shiddarth.commands

import bista.shiddarth.renderer.ScheduleRenderer
import bista.shiddarth.service.ScheduleService
import com.github.ajalt.clikt.core.CliktCommand
import com.github.ajalt.clikt.core.Context
import kotlinx.coroutines.runBlocking

class ScheduleCommand(
    private val scheduleService: ScheduleService = ScheduleService(),
    private val renderer: ScheduleRenderer = ScheduleRenderer()
) : CliktCommand(
    name = "schedule",
) {

    override fun help(context: Context): String = "Show the TI Schedule"

    override fun run() = runBlocking {
        val matches = scheduleService.getSchedule().filter {
            it.leagueName.contains("TI 2026")
        }

        renderer.render(matches)
    }
}