package com.marozzi.cardswipe;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.marozzi.cardswipe.model.CardData;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CardPagerAdapter extends FragmentStatePagerAdapter {

    private List<CardData> cards = new ArrayList<>();
    private HashMap<Integer, CardFragment> fragments = new HashMap<>();
    private CardFragment.CardFragmentListener listener;

    public CardPagerAdapter(FragmentManager fm, CardFragment.CardFragmentListener listener) {
        super(fm);
        this.listener = listener;
    }

    @Override
    public int getCount() {
        return cards.size();
    }

    @Override
    public Fragment getItem(int position) {
        CardFragment fragment = CardFragment.Companion.getFragment(cards.get(position));
        fragment.setListener(listener);
        fragments.put(position, fragment);
        return fragment;
    }

    public void addCard(CardData action) {
        cards.add(action);
        notifyDataSetChanged();
    }

    public void updateCard(CardData cardData) {

        int pos = -1;

        for (int i = 0; i < cards.size() && pos == -1; i++) {
            if (cards.get(i).equals(cardData)) {
                pos = i;
            }
        }

        if (pos != -1) {
            cards.set(pos, cardData);
            CardFragment frag = fragments.get(pos);
            if (frag != null)
                frag.updateCard(cardData);
        }
    }
}