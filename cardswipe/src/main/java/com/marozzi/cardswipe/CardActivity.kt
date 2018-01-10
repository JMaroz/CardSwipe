package com.marozzi.cardswipe

import android.animation.Animator
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.animation.AccelerateDecelerateInterpolator
import com.marozzi.cardswipe.model.CardData
import kotlinx.android.synthetic.main.activity_cards.*

/**
 * Created by amarozzi on 22/12/17.
 */
abstract class CardActivity : AppCompatActivity(), CardFragment.CardFragmentListener {

    private val adapter = CardPagerAdapter(supportFragmentManager, this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cards)
        setSupportActionBar(toolbar)

        layout_done.visibility = View.INVISIBLE
        done.isEnabled = false

        viewpager.enabledSwipe = false
        viewpager.adapter = adapter
        viewpager.offscreenPageLimit = 6
        viewpager.setCurrentItem(0, false)
        viewpager.rotationX = 2f
        viewpager.pageMargin = resources.getDimensionPixelOffset(R.dimen.space_16dp)

        start.setOnClickListener{
            viewpager.animate()
                    .translationX(0f)
                    .rotationX(0f)
                    .setDuration(350)
                    .setInterpolator(AccelerateDecelerateInterpolator())
                    .setListener(AnimateListener())
        }

        done.setOnClickListener {
            onDoneClicked()
        }
    }

    abstract fun onDoneClicked()

    fun addCard(data: CardData) {
        adapter.addCard(data)
    }

    fun updateCard(card: CardData) {
        adapter.updateCard(card)
    }

    fun moveToSlide(pos: Int): Boolean {
        if (pos >= 0 && pos < adapter.count) {
            viewpager.setCurrentItem(pos, true)
            return true
        }
        return false
    }

    fun moveToNextSlide(): Boolean {
        return moveToSlide(viewpager.currentItem + 1)
    }

    fun moveToPreviusSlide(): Boolean {
        return moveToSlide(viewpager.currentItem - 1)
    }

    fun setTitle(title: String) {
        info_title.text = title
    }

    override fun setTitle(title: Int) {
        info_title.setText(title)
    }

    fun setMessage(message: String) {
        info_message.text = message
    }

    fun enableDoneButton(enable: Boolean) {
        done.isEnabled = enable
    }

    inner class AnimateListener : Animator.AnimatorListener {
        override fun onAnimationRepeat(animation: Animator?) {

        }

        override fun onAnimationEnd(animation: Animator?) {
            viewpager.enabledSwipe = true
            info_layout.visibility = View.GONE
            layout_done.visibility = View.VISIBLE
        }

        override fun onAnimationCancel(animation: Animator?) {
        }

        override fun onAnimationStart(animation: Animator?) {
        }


    }
}