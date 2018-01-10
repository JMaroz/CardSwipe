package com.marozzi.mergeaccount.app

import android.os.Bundle
import android.os.Handler
import android.widget.Toast
import com.marozzi.cardswipe.CardActivity
import com.marozzi.cardswipe.model.CardData
import com.marozzi.requestactions.utils.Utils

class MainActivity : CardActivity() {

    var count = 0
    var handler = Handler()
    var runnable = Runnable {
        moveToNextSlide()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setTitle("Check this profiles")
        setMessage("Ehi John, our system found this profiles that match with you. Check and add as friend.")

        addCard(CardData()
                .withId("John_Snow")
                .withMainText("John Snow")
                .withSecondText("The Wall")
                .withOtherText("Jon Snow, born Aegon Targaryen, is the son of Lyanna Stark and Rhaegar Targaryen")
                .withMainIcon(Utils.getResourceUri(resources, R.drawable.snow).toString())
                .withSecondIcon(Utils.getResourceUri(resources, R.drawable.wall).toString())
                .withPositiveButtonText("Yes, add as friend")
                .withNegativeButtonText("No thanks"))

        addCard(CardData()
                .withId("Daenerys_Targaryen")
                .withMainText("Daenerys Targaryen")
                .withSecondText("Dragonstone")
                .withOtherText("Daenerys is the only daughter and youngest child of King Aerys II Targaryen, the \"Mad King\", and his sister-wife, Rhaella")
                .withMainIcon(Utils.getResourceUri(resources, R.drawable.targaryen).toString())
                .withSecondIcon(Utils.getResourceUri(resources, R.drawable.dragonstone).toString())
                .withPositiveButtonText("Yes, add as friend")
                .withNegativeButtonText("No thanks"))

        addCard(CardData()
                .withId("Tyrion_Lannister")
                .withMainText("Tyrion Lannister")
                .withSecondText("Casterly Rock")
                .withOtherText("Lord Tyrion Lannister is the youngest child of Lord Tywin Lannister and younger brother of Cersei and Jaime Lannister")
                .withMainIcon(Utils.getResourceUri(resources, R.drawable.lannister).toString())
                .withSecondIcon(Utils.getResourceUri(resources, R.drawable.rock).toString())
                .withPositiveButtonText("Yes, add as friend")
                .withNegativeButtonText("No thanks"))

        addCard(CardData()
                .withId("Margaery_Tyrell")
                .withMainText("Margaery Tyrell")
                .withSecondText("Highgarden")
                .withOtherText("Queen Margaery Tyrell was the only daughter of Lord Mace Tyrell and Lady Alerie Tyrell, granddaughter of Lady Olenna Tyrell and sister of Ser Loras Tyrell. ")
                .withMainIcon(Utils.getResourceUri(resources, R.drawable.tyrell).toString())
                .withSecondIcon(Utils.getResourceUri(resources, R.drawable.highgarden).toString())
                .withPositiveButtonText("Yes, add as friend")
                .withNegativeButtonText("No thanks"))
    }

    override fun onPositiveButtonClick(cardData: CardData) {
        updateCard(CardData(cardData)
                .withPositiveButtonText("Added")
                .withPositiveButtonEnable(false)
                .withNegativeButtonText(""))

        increaseCount()
        handler.postDelayed(runnable, 150)
    }

    override fun onNegativeButtonClick(cardData: CardData) {
        updateCard(CardData(cardData)
                .withPositiveButtonText("")
                .withNegativeButtonEnable(false)
                .withNegativeButtonText("Skipped"))

        increaseCount()
        handler.postDelayed(runnable, 150)
    }

    override fun onDoneClicked() {
        Toast.makeText(this, "Thanks for watching, Bye!", Toast.LENGTH_LONG).show()
        finish()
    }

    private fun increaseCount() {
        count++
        if (count == 3) {
            enableDoneButton(true)
        }
    }
}
