package io.github.ddobrovolsky.services;

import io.github.ddobrovolsky.collections.LinkedDataStore;
import io.github.ddobrovolsky.entities.Cow;
import io.github.ddobrovolsky.entities.CowWithParentId;

/**
 * Implementation of Farm with {@link LinkedDataStore} inside
 * Created by Dmitriy Dobrovolskiy on 01.06.2018.
 *
 * @see Farm
 * @see LinkedDataStore
 * @since *.*.*
 */
public class DairyFarm implements Farm {
    private LinkedDataStore<CowWithParentId> cows = new LinkedDataStore<>();

    public DairyFarm(Cow first) {
        cows.add(new CowWithParentId(0, first.getNickName(), first.getCowId()));
    }

    @Override
    public void giveBirth(int parentCowId, int childCowId, String childNickName) {
        CowWithParentId newBorn = new CowWithParentId(childCowId, childNickName, parentCowId);
        cows.add(newBorn);
    }

    @Override
    public void endLifeSpan(int cowId) {
        cows.remove(cowId);
    }

    @Override
    public void printFarmData() {
        cows.printAll();
    }
}
