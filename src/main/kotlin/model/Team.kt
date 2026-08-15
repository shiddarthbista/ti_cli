package bista.shiddarth.model

data class Team(
    val name: String,
    val region: Region,
    val players: List<Player>,
    val alias: List<String>
)

data class Player(
    val name: String,
    val age: Int,
    val role: Role,
    val country: String,
    val captain: Boolean = false
)

enum class Role{
    CARRY, MID, OFFLANE, HARD_SUPPORT, SOFT_SUPPORT
}

enum class Region {
    NA,
    SA,
    EEU,
    WEU,
    CN,
    SEA
}
