package kr.ac.kumoh.s20230358.w24w10CardDealer.repository
import kr.ac.kumoh.s20230358.w24w10CardDealer.model.Card

interface CardRepository {
    val size: Int
    fun add(card: Card)
    fun getAllCards(): List<Card>
    fun clear()
}