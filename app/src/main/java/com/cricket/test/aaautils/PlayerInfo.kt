package com.cricket.test.aaautils

import com.cricket.test.model.Batting
import com.cricket.test.model.Bowling
import java.io.Serializable

data class PlayerInfo(
    val Batting: Batting,
    val Bowling: Bowling,
    val Name_Full: String,
    val Position: String,
    val Iskeeper: Boolean,
    val Iscaptain: Boolean
): Serializable