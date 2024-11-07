package kr.ac.kumoh.s20230358.w24w10CardDealer.service

import kr.ac.kumoh.s20230358.w24w10CardDealer.repository.CardRepository
import kr.ac.kumoh.s20230358.w24w10CardDealer.repository.InMemoryCardRepository
import kr.ac.kumoh.s20230358.w24w10CardDealer.model.Card
import org.springframework.stereotype.Service
import kotlin.random.Random

@Service
class CardService(private val repository: CardRepository) {
    companion object{
        const val NUMBER_CADS = 5
    }
    fun getAllCards(): List<Card>
    {
        return repository.getAllCards()
    }
    fun dealCard(count: Int = NUMBER_CADS){
        val suits = arrayOf(
            "spades",
            "diamonds",
            "hearts",
            "clubs",
        )
        val ranks = arrayOf(
            "2",
            "3",
            "4",
            "5",
            "6",
            "7",
            "8",
            "9",
            "10",
            "jack",
            "queen",
            "king",
            "ace",
        )
        repository.clear()
        //중복이 포함되지않는 집합(mutableSetOf) 사용
        val uniqueCards = mutableSetOf<Card>()
        while(uniqueCards.size < count)
        {
            val randomSuit = suits[Random.nextInt(suits.size)]
            val randomRanks = ranks[Random.nextInt(ranks.size)]

            uniqueCards.add(Card(randomRanks,randomSuit))
        }
        val sortedCards = uniqueCards.toList()
            .sortedWith(compareBy({suits.indexOf(it.suit)},{ranks.indexOf(it.rank)}))

        sortedCards.forEach{repository.add(it)}
    }
}