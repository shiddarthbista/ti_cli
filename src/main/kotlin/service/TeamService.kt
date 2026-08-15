package bista.shiddarth.service

import bista.shiddarth.model.Player
import bista.shiddarth.model.Region
import bista.shiddarth.model.Role
import bista.shiddarth.model.Team

class TeamService {

    val teamSpirit = Team(
        name = "Team Spirit",
        region = Region.EEU,
        alias = listOf("spirit"),
        players = listOf(
            Player("Yatoro", 23, Role.CARRY, "Ukraine"),
            Player("Larl", 24, Role.MID, "Russia"),
            Player("Collapse", 24, Role.OFFLANE, "Russia"),
            Player("not me", 22, Role.SOFT_SUPPORT, "Russia",captain = true),
            Player("rue", 22, Role.HARD_SUPPORT, "Russia")
        )
    )

    val auroraGaming = Team(
        name = "Aurora Gaming",
        region = Region.EEU,
        alias = listOf("aurora"),
        players = listOf(
            Player("Nightfall", 24, Role.CARRY, "Russia",captain = true),
            Player("Mikoto", 26, Role.MID, "Indonesia"),
            Player("Ws", 21, Role.OFFLANE, "Malaysia"),
            Player("Mira", 26, Role.SOFT_SUPPORT, "Ukraine"),
            Player("kaori", 24, Role.HARD_SUPPORT, "Ukraine")
        )
    )

    val boomBoys = Team(
        name = "BoomBoys",
        region = Region.EEU,
        alias = listOf("betboom","bb"),
        players = listOf(
            Player("Kiritych~", 23, Role.CARRY, "Russia"),
            Player("gpk~", 24, Role.MID, "Russia"),
            Player("MieRo", 23, Role.OFFLANE, "Russia"),
            Player("Save-", 24, Role.SOFT_SUPPORT, "Moldova",captain = true),
            Player("Kataomi", 27, Role.HARD_SUPPORT, "Russia")
        )
    )

    val ironWing = Team(
        name = "Iron Wing",
        alias = listOf("1W","tundra"),
        region = Region.WEU,
        players = listOf(
            Player("Pure", 22, Role.CARRY, "Russia"),
            Player("bzm", 21, Role.MID, "Bulgaria"),
            Player("33", 29, Role.OFFLANE, "Israel",captain = true),
            Player("Ari", 23, Role.SOFT_SUPPORT, "United Kingdom"),
            Player("Whitemon", 26, Role.HARD_SUPPORT, "Indonesia")
        )
    )

    val teamFalcons = Team(
        name = "Team Falcons",
        region = Region.WEU,
        alias = listOf("falcons"),
        players = listOf(
            Player("skiter", 27, Role.CARRY, "Slovakia"),
            Player("Malr1ne", 21, Role.MID, "Russia"),
            Player("ATF", 21, Role.OFFLANE, "Jordan"),
            Player("Cr1t-", 30, Role.SOFT_SUPPORT, "Denmark"),
            Player("Sneyking", 31, Role.HARD_SUPPORT, "USA",captain = true)
        )
    )

    val teamLiquid = Team(
        name = "Team Liquid",
        region = Region.WEU,
        alias = listOf("liquid"),
        players = listOf(
            Player("m1CKe", 27, Role.CARRY, "Sweden"),
            Player("Nisha", 25, Role.MID, "Poland"),
            Player("Ace", 32, Role.OFFLANE, "Denmark"),
            Player("Boxi", 28, Role.SOFT_SUPPORT, "Sweden"),
            Player("tOfu", 29, Role.HARD_SUPPORT, "Germany",captain = true)
        )
    )

    val teamYandex = Team(
        name = "Team Yandex",
        region = Region.EEU,
        alias = listOf("yandex"),
        players = listOf(
            Player("watson", 24, Role.CARRY, "Kazakhstan"),
            Player("CHIRA_JUNIOR", 21, Role.MID, "Russia"),
            Player("DM", 26, Role.OFFLANE, "Russia"),
            Player("Saksa", 31, Role.SOFT_SUPPORT, "Macedonia",captain = true),
            Player("Malady", 25, Role.HARD_SUPPORT, "Kazakhstan")
        )
    )

    val xtremeGaming = Team(
        name = "Xtreme Gaming",
        region = Region.CN,
        alias = listOf("extreme","xtreme","XG"),
        players = listOf(
            Player("Ame", 29, Role.CARRY, "China"),
            Player("NothingToSay", 25, Role.MID, "Malaysia"),
            Player("Xxs", 26, Role.OFFLANE, "China"),
            Player("fy", 31, Role.SOFT_SUPPORT, "China",captain = true),
            Player("xNova", 28, Role.HARD_SUPPORT, "Malaysia")
        )
    )

    val teamVision = Team(
        name = "TEAM VISION",
        alias = listOf("vision","Parivision","pari"),
        region = Region.EEU,
        players = listOf(
            Player("Satanic", 18, Role.CARRY, "Russia"),
            Player("No[o]ne-", 28, Role.MID, "Ukraine"),
            Player("Noticed", 24, Role.OFFLANE, "Russia"),
            Player("9Class", 23, Role.SOFT_SUPPORT, "Russia"),
            Player("Dukalis", 24, Role.HARD_SUPPORT, "Russia",captain = true)
        )
    )

    val nigmaGalaxy = Team(
        name = "Nigma Galaxy",
        region = Region.WEU,
        alias = listOf("nigma"),
        players = listOf(
            Player("SumaiL", 27, Role.CARRY, "Pakistan"),
            Player("lorenof", 23, Role.MID, "Ukraine"),
            Player("Davai", 26, Role.OFFLANE, "Belgium"),
            Player("OmaR", 23, Role.SOFT_SUPPORT, "Lebanon"),
            Player("GH", 31, Role.HARD_SUPPORT, "Lebanon",captain = true)
        )
    )

    val huligani = Team(
        name = "HULIGANI",
        region = Region.EEU,
        alias = listOf("liga","l1ga"),
        players = listOf(
            Player("ssnovv1", 22, Role.CARRY, "Russia"),
            Player("Mirage`", 25, Role.MID, "Kazakhstan"),
            Player("Corrupted", 29, Role.OFFLANE, "Russia"),
            Player("sayuw", 28, Role.SOFT_SUPPORT, "Russia"),
            Player("RESPECT", 25, Role.HARD_SUPPORT, "Belarus")
        )
    )

    val teamResilience = Team(
        name = "Team Resilience",
        region = Region.CN,
        alias = listOf("resilience"),
        players = listOf(
            Player("YSR-04E", 26, Role.CARRY, "China"),
            Player("Echozz", 25, Role.MID, "China"),
            Player("niu", 25, Role.OFFLANE, "China"),
            Player("planet", 28, Role.SOFT_SUPPORT, "China",captain = true),
            Player("zzq", 28, Role.HARD_SUPPORT, "China")
        )
    )

    val viciGaming = Team(
        name = "Vici Gaming",
        region = Region.CN,
        alias = listOf("vici","VG"),
        players = listOf(
            Player("shiro", 25, Role.CARRY, "China"),
            Player("Xm", 27, Role.MID, "China"),
            Player("Bach", 28, Role.OFFLANE, "China"),
            Player("XinQ", 28, Role.SOFT_SUPPORT, "China"),
            Player("y`", 28, Role.HARD_SUPPORT, "China",captain = true)
        )
    )

    val og = Team(
        name = "OG",
        region = Region.SEA,
        alias = listOf("og"),
        players = listOf(
            Player("Natsumi", 25, Role.CARRY, "Philippines"),
            Player("Yopaj-", 24, Role.MID, "Philippines"),
            Player("Raven", 27, Role.OFFLANE, "Philippines"),
            Player("TIMS", 29, Role.SOFT_SUPPORT, "Philippines"),
            Player("skem", 26, Role.HARD_SUPPORT, "Philippines",captain = true)
        )
    )

    val gamerLegion = Team(
        name = "GamerLegion",
        region = Region.NA,
        alias = listOf("gl"),
        players = listOf(
            Player("Ghost", 28, Role.CARRY, "Malaysia"),
            Player("RCY", 27, Role.MID, "USA"),
            Player("Fayde", 27, Role.OFFLANE, "USA"),
            Player("Bignum", 31, Role.SOFT_SUPPORT, "Ukraine",captain = true),
            Player("Speeed", 27, Role.HARD_SUPPORT, "USA")
        )
    )

    val lgdGaming = Team(
        name = "LGD Gaming",
        region = Region.SA,
        alias = listOf("lgd"),
        players = listOf(
            Player("Yuma", 25, Role.CARRY, "Nicaragua"),
            Player("Topson", 28, Role.MID, "Finland"),
            Player("Wisper", 24, Role.OFFLANE, "Bolivia"),
            Player("Thiolicor", 27, Role.SOFT_SUPPORT, "Brazil"),
            Player("KJ", 26, Role.HARD_SUPPORT, "Brazil",captain = true)
        )
    )

    val teams = listOf(
        teamSpirit, auroraGaming, boomBoys, ironWing, teamFalcons,
        teamLiquid, teamYandex, xtremeGaming, teamVision, nigmaGalaxy,
        huligani, teamResilience, viciGaming, og, gamerLegion, lgdGaming
    )

    fun findTeam(name: String): Team? = teams.firstOrNull { team ->
        team.name.equals(name, ignoreCase = true) ||
                team.alias.any { it.equals(name, ignoreCase = true) }
    }
}