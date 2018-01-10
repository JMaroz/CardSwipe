package com.marozzi.cardswipe

import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.CardView
import android.view.*
import android.widget.FrameLayout
import android.widget.ImageView
import com.marozzi.cardswipe.model.CardData
import com.marozzi.requestactions.utils.CircleTransform
import com.marozzi.requestactions.utils.Utils
import com.marozzi.roundbutton.RoundButtonHelper
import com.squareup.picasso.Picasso
import com.squareup.picasso.RequestCreator
import kotlinx.android.synthetic.main.fragment_card.view.*


/**
 * Created by amarozzi on 08/01/18.
 */
class CardFragment : Fragment() {

    companion object {
        val REQUEST_ACTION = "request_action"

        fun getFragment(data: CardData): CardFragment {
            val frag = CardFragment()
            val bundle = Bundle()
            bundle.putParcelable(REQUEST_ACTION, data)
            frag.arguments = bundle
            return frag
        }
    }

    private var card = CardData()
    private lateinit var listener: CardFragmentListener

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_card, container, false)

        val bundle: Bundle? = arguments
        if (bundle != null) {
            card = bundle.getParcelable(REQUEST_ACTION)
        }

        container!!.afterMeasured {
            val height = container.height
            view.card.layoutParams = FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, (height * 0.85).toInt(), Gravity.CENTER)
        }

        updateUI(view)

        return view
    }

    inline fun <T : View> T.afterMeasured(crossinline f: T.() -> Unit) {
        viewTreeObserver.addOnGlobalLayoutListener(object : ViewTreeObserver.OnGlobalLayoutListener {
            override fun onGlobalLayout() {
                if (measuredWidth > 0 && measuredHeight > 0) {
                    viewTreeObserver.removeOnGlobalLayoutListener(this)
                    f()
                }
            }
        })
    }

    fun updateCard(card: CardData) {
        this.card = card
        updateUI(view)
    }

    fun setListener(listener: CardFragmentListener) {
        this.listener = listener
    }

    private fun updateUI(view: View?) {
        if (view == null)
            return

        view.card.setCardBackgroundColor(card.backgroundColor)
        view.main_text.text = card.mainText
        view.main_text.setTextColor(card.mainTextColor)
        if (card.mainIcon.isNotEmpty()) {
            lateinit var requestCreator: RequestCreator
            if (Utils.isLocalResource(card.mainIcon)) {
                requestCreator = Picasso.with(activity).load(Uri.parse(card.mainIcon))

//                view.main_icon.setImageURI(Uri.parse(card.mainIcon))
//                view.main_icon.scaleType = ImageView.ScaleType.FIT_CENTER
            } else {
                requestCreator = Picasso.with(activity).load(card.mainIcon)
            }
            requestCreator.centerCrop().fit().transform(CircleTransform()).into(view.main_icon)
        }

        view.second_text.text = card.secondText
        view.second_text.setTextColor(card.secondTextColor)
        if (card.secondIcon.isNotEmpty()) {
            if (Utils.isLocalResource(card.secondIcon)) {
                view.second_icon.setImageURI(Uri.parse(card.secondIcon))
                view.second_icon.scaleType = ImageView.ScaleType.FIT_CENTER
            } else {
                Picasso.with(activity).load(card.secondIcon).centerCrop().fit().into(view.second_icon)
            }
        }

        view.other_text.text = card.otherText
        view.other_text.setTextColor(card.otherTextColor)

        if (card.positiveButtonText.isNotEmpty()) {
            view.positive_button.text = card.positiveButtonText
            view.positive_button.setCustomizations(RoundButtonHelper.newBuilder()
                    .withTextColor(card.positiveButtonTextColor)
                    .withTextColorSelected(card.positiveButtonTextColor)
                    .withTextColorDisabled(card.positiveButtonTextColor)
                    .withBackgroundColor(card.positiveButtonBackgroundColor)
                    .withBackgroundColorSelected(card.positiveButtonBackgroundColorSelected)
                    .withBackgroundColorDisabled(card.positiveButtonBackgroundColorSelected)
                    .withCornerColor(card.positiveButtonBackgroundColor)
                    .withCornerColorSelected(card.positiveButtonBackgroundColorSelected)
                    .withCornerColorDisabled(card.positiveButtonBackgroundColorSelected))
            view.positive_button.isEnabled = card.positiveButtonEnable
        } else {
            view.positive_button.visibility = View.GONE
        }
        view.positive_button.setOnClickListener {
            listener.onPositiveButtonClick(card)
        }

        if (card.negativeButtonText.isNotEmpty()) {
            view.negative_button.text = card.negativeButtonText
            view.negative_button.setCustomizations(RoundButtonHelper.newBuilder()
                    .withTextColor(card.negativeButtonTextColor)
                    .withTextColorSelected(card.negativeButtonTextColor)
                    .withTextColorDisabled(card.negativeButtonTextColor)
                    .withBackgroundColor(card.negativeButtonBackgroundColor)
                    .withBackgroundColorSelected(card.negativeButtonBackgroundColorSelected)
                    .withBackgroundColorDisabled(card.negativeButtonBackgroundColorSelected)
                    .withCornerColor(card.negativeButtonBackgroundColor)
                    .withCornerColorSelected(card.negativeButtonBackgroundColorSelected)
                    .withCornerColorDisabled(card.negativeButtonBackgroundColorSelected))
            view.negative_button.isEnabled = card.negativeButtonEnable
        } else {
            view.negative_button.visibility = View.GONE
        }
        view.negative_button.setOnClickListener {
            listener.onNegativeButtonClick(card)
        }
    }

    fun getCard(): CardData {
        return card
    }

    fun getCardView(): CardView {
        return view?.card!!
    }

    interface CardFragmentListener {

        fun onPositiveButtonClick(cardData: CardData)
        fun onNegativeButtonClick(cardData: CardData)

    }
}