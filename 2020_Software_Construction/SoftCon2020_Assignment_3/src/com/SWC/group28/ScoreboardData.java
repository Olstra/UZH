package com.SWC.group28;

import java.util.ArrayList;
import java.util.Iterator;

public class ScoreboardData implements Subject {
    int PlayerRemainingBoats;
    int EnemyBoatsDestroyed;
    ArrayList<Observer> observerList;

    public ScoreboardData() {
        observerList = new ArrayList<Observer>();
    }

    @Override
    public void registerObserver(Observer o){
        observerList.add(o);}

    @Override
    public void unregisterObserver(Observer o) {
        observerList.remove(observerList.indexOf(o));
    }

    @Override
    public void notifyObservers() {
        for (Iterator<Observer> it =
             observerList.iterator(); it.hasNext();)
        {
            Observer o = it.next();
            o.update(PlayerRemainingBoats, EnemyBoatsDestroyed);
        }
    }
}
