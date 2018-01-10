package com.marozzi.cardswipe.model

import android.graphics.Color
import android.os.Parcel
import android.os.Parcelable

/**
 * Created by amarozzi on 22/12/17.
 */
class CardData : Parcelable {

    internal var id = ""

    internal var mainIcon = ""
    internal var mainText = ""
    internal var secondIcon = ""
    internal var secondText = ""
    internal var otherText = ""
    internal var positiveButtonText = ""
    internal var negativeButtonText = ""

    internal var backgroundColor = Color.WHITE
    internal var mainTextColor = Color.parseColor("#404142")
    internal var secondTextColor = Color.parseColor("#404142")
    internal var otherTextColor = Color.parseColor("#818181")
    internal var positiveButtonTextColor = Color.parseColor("#212a2f")
    internal var positiveButtonBackgroundColor = Color.parseColor("#f9e42b")
    internal var positiveButtonBackgroundColorSelected = Color.parseColor("#f9e42b")
    internal var positiveButtonEnable = true
    internal var negativeButtonTextColor = Color.parseColor("#f2f2f2")
    internal var negativeButtonBackgroundColor = Color.parseColor("#404142")
    internal var negativeButtonBackgroundColorSelected = Color.parseColor("#404142")
    internal var negativeButtonEnable = true

    constructor() {}

    constructor(cardToCopy: CardData) {
        this.id = cardToCopy.id
        this.mainIcon = cardToCopy.mainIcon
        this.mainText = cardToCopy.mainText
        this.secondIcon = cardToCopy.secondIcon
        this.secondText = cardToCopy.secondText
        this.otherText = cardToCopy.otherText
        this.positiveButtonText= cardToCopy.positiveButtonText
        this.negativeButtonText= cardToCopy.negativeButtonText
        this.backgroundColor = cardToCopy.backgroundColor
        this.mainTextColor = cardToCopy.mainTextColor
        this.secondTextColor = cardToCopy.secondTextColor
        this.otherTextColor = cardToCopy.otherTextColor
        this.positiveButtonTextColor = cardToCopy.positiveButtonTextColor
        this.positiveButtonBackgroundColor = cardToCopy.positiveButtonBackgroundColor
        this.positiveButtonBackgroundColorSelected = cardToCopy.positiveButtonBackgroundColorSelected
        this.positiveButtonEnable = cardToCopy.positiveButtonEnable
        this.negativeButtonTextColor = cardToCopy.negativeButtonTextColor
        this.negativeButtonBackgroundColor = cardToCopy.negativeButtonBackgroundColor
        this.negativeButtonBackgroundColorSelected= cardToCopy.negativeButtonBackgroundColorSelected
        this.negativeButtonEnable = cardToCopy.negativeButtonEnable
    }

    protected constructor(`in`: Parcel) {
        this.id = `in`.readString()
        this.mainIcon = `in`.readString()
        this.mainText = `in`.readString()
        this.secondIcon = `in`.readString()
        this.secondText = `in`.readString()
        this.otherText = `in`.readString()
        this.positiveButtonText = `in`.readString()
        this.negativeButtonText = `in`.readString()
        this.backgroundColor = `in`.readInt()
        this.mainTextColor = `in`.readInt()
        this.secondTextColor = `in`.readInt()
        this.otherTextColor = `in`.readInt()
        this.positiveButtonTextColor = `in`.readInt()
        this.positiveButtonBackgroundColor = `in`.readInt()
        this.positiveButtonBackgroundColorSelected = `in`.readInt()
        this.positiveButtonEnable = `in`.readInt() == 1
        this.negativeButtonTextColor = `in`.readInt()
        this.negativeButtonBackgroundColor = `in`.readInt()
        this.negativeButtonBackgroundColorSelected = `in`.readInt()
        this.negativeButtonEnable = `in`.readInt() == 1
    }

    fun withId(id: String): CardData {
        this.id = id
        return this
    }

    fun withMainIcon(mainIcon: String): CardData {
        this.mainIcon = mainIcon
        return this
    }

    fun withMainText(mainText: String): CardData {
        this.mainText = mainText
        return this
    }

    fun withSecondIcon(secondIcon: String): CardData {
        this.secondIcon = secondIcon
        return this
    }

    fun withSecondText(secondText: String): CardData {
        this.secondText = secondText
        return this
    }

    fun withOtherText(otherText: String): CardData {
        this.otherText = otherText
        return this
    }

    fun withPositiveButtonText(positiveButtonText: String): CardData {
        this.positiveButtonText = positiveButtonText
        return this
    }

    fun withNegativeButtonText(negativeButtonText: String): CardData {
        this.negativeButtonText = negativeButtonText
        return this
    }

    fun withBackgroundColor(backgroundColor: Int): CardData {
        this.backgroundColor = backgroundColor
        return this
    }

    fun withMainTextColor(mainTextColor: Int): CardData {
        this.mainTextColor = mainTextColor
        return this
    }

    fun withSecondTextColor(secondTextColor: Int): CardData {
        this.secondTextColor = secondTextColor
        return this
    }

    fun withOtherTextColor(otherTextColor: Int): CardData {
        this.otherTextColor = otherTextColor
        return this
    }

    fun withPositiveButtonColor(positiveButtonColor: Int): CardData {
        this.positiveButtonTextColor = positiveButtonColor
        return this
    }

    fun withPositiveButtonEnable(positiveButtonEnable: Boolean): CardData {
        this.positiveButtonEnable = positiveButtonEnable
        return this
    }

    fun withNegativeButtonColor(negativeButtonColor: Int): CardData {
        this.negativeButtonTextColor = negativeButtonColor
        return this
    }

    fun withNegativeButtonEnable(negativeButtonEnable: Boolean): CardData {
        this.negativeButtonEnable = negativeButtonEnable
        return this
    }

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeString(this.id)
        dest.writeString(this.mainIcon)
        dest.writeString(this.mainText)
        dest.writeString(this.secondIcon)
        dest.writeString(this.secondText)
        dest.writeString(this.otherText)
        dest.writeString(this.positiveButtonText)
        dest.writeString(this.negativeButtonText)
        dest.writeInt(this.backgroundColor)
        dest.writeInt(this.mainTextColor)
        dest.writeInt(this.secondTextColor)
        dest.writeInt(this.otherTextColor)
        dest.writeInt(this.positiveButtonTextColor)
        dest.writeInt(this.positiveButtonBackgroundColor)
        dest.writeInt(this.positiveButtonBackgroundColorSelected)
        if (positiveButtonEnable)
            dest.writeInt(1)
        else
            dest.writeInt(0)
        dest.writeInt(this.negativeButtonTextColor)
        dest.writeInt(this.negativeButtonBackgroundColor)
        dest.writeInt(this.negativeButtonBackgroundColorSelected)
        if (negativeButtonEnable)
            dest.writeInt(1)
        else
            dest.writeInt(0)
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as CardData

        if (id != other.id) return false

        return true
    }

    override fun hashCode(): Int {
        return id.hashCode()
    }

    companion object {

        val CREATOR: Parcelable.Creator<CardData> = object : Parcelable.Creator<CardData> {
            override fun createFromParcel(source: Parcel): CardData {
                return CardData(source)
            }

            override fun newArray(size: Int): Array<CardData> {
                return emptyArray()
            }
        }
    }
}