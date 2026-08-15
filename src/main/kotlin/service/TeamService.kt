package bista.shiddarth.service

import bista.shiddarth.model.Player
import bista.shiddarth.model.Region
import bista.shiddarth.model.Role
import bista.shiddarth.model.Team

class TeamService {

    val teamSpirit: Team = Team(
        name = "Team Spirit",
        region = Region.EEU,
        players = listOf(
            Player("Yatoro", 23, Role.CARRY, "Ukraine"),
            Player("Larl", 24, Role.MID, "Russia"),
            Player("Collapse", 24, Role.OFFLANE, "Russia"),
            Player("not me", 22, Role.SOFT_SUPPORT, "Russia"),
            Player("rue", 22, Role.HARD_SUPPORT, "Russia")
        )
    )

    val teams = listOf<Team>(teamSpirit)

    fun findTeam(name: String): Team? = teams.firstOrNull{
        it.name.equals(name,ignoreCase = true)
    }
}

