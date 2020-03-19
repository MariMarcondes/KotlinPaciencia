package com.example.kotlinpaciencia

import org.junit.Test

class GameTest {
    @Test
    fun kingInFirstFoundationPile() {
        // arrange
        var numGames = 0
        var maxGames = 10000

        // act
        for (i in 1..maxGames) {
            numGames++
            GameModel.resetGame()
            for (j in i..100) {
                GamePresenter.onDeckTap()
                GamePresenter.onWasteTap()
                GameModel.tableauPiles.forEachIndexed{index, tableauPile ->
                    GamePresenter.onTableauTap(index, tableauPile.cards.lastIndex)
                }
            }
            if (GameModel.foundationPiles[0].cards.size == 13) {
                break
            }
        }

        // assert
        GameModel.debugPrint()
        println("# Games: $numGames")
        assert(numGames < maxGames)
    }
}