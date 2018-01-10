package com.marozzi.mergeaccount.app

import android.os.Bundle
import com.marozzi.cardswipe.CardActivity
import com.marozzi.cardswipe.model.CardData
import com.marozzi.requestactions.utils.Utils

class MainActivity : CardActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setTitle("Check your profiles")
        setMessage("Ehi John, it seems that our staff created a profile associated to your email address yet.Verify and confirm to merge your profiles.")

        var pos = 0;
        while (pos < 10) {
            addCard(CardData()
                    .withId(Integer.toString(pos))
                    .withMainText("John Appleseed")
                    .withSecondText("Virgin Active Collection Milano Corso Como")
                    .withOtherText("Registered on December 12th, 2017 at 4:18 PM")
                    .withMainIcon(Utils.getResourceUri(resources, R.drawable.image).toString())
                    .withSecondIcon(Utils.getResourceUri(resources, R.drawable.virgin).toString())
                    .withPositiveButtonText("It's me")
                    .withNegativeButtonText("Fuck not, is not me"))
            pos++
        }
    }

    override fun onPositiveButtonClick(cardData: CardData) {
        updateCard(CardData(cardData)
                .withPositiveButtonText("Ok Thanks")
                .withPositiveButtonEnable(false)
                .withNegativeButtonText(""))
        moveToNextSlide()
        enableDoneButton(true)
    }

    override fun onNegativeButtonClick(cardData: CardData) {
        updateCard(CardData(cardData)
                .withPositiveButtonText("")
                .withNegativeButtonEnable(false)
                .withNegativeButtonText("Oh no, i'm so sorry"))
        moveToNextSlide()
    }
}
