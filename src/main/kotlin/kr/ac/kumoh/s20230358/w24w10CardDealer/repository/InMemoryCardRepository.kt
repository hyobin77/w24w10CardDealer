package kr.ac.kumoh.s20230358.w24w10CardDealer.repository

import kr.ac.kumoh.s20230358.w24w10CardDealer.model.Card
import org.apache.coyote.http11.Constants.a
import org.springframework.stereotype.Repository

@Repository
class InMemoryCardRepository :CardRepository {
    private val cards = mutableListOf<Card>()

    override val size: Int
        get() = cards.size

    override fun add(card: Card) {
        cards.add(card)
    }

    override fun getAllCards(): List<Card> {
        return cards
    }

    override fun clear() {
        cards.clear()
    }

}