package kr.ac.kumoh.s20230358.w24w10CardDealer.model

data class Card(
    val rank: String,
    val suit: String,
){
    val imageName: String
        get() = "${rank}_of_${suit}.png"
}
