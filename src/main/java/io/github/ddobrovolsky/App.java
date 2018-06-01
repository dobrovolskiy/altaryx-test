package io.github.ddobrovolsky;

import io.github.ddobrovolsky.entities.Cow;
import io.github.ddobrovolsky.exception.LogicalException;
import io.github.ddobrovolsky.services.DairyFarm;
import io.github.ddobrovolsky.services.Farm;

/**
 *
 */
public class App {
    public static void main(String[] args) {
        Farm farm = new DairyFarm(new Cow(0, "first"));
        farm.giveBirth(0, 1, "newBorn1");
        farm.giveBirth(1, 2, "newBorn2");
        farm.giveBirth(1, 3, "newBorn3");
        farm.endLifeSpan(2);
        farm.printFarmData();
        try {
            farm.endLifeSpan(99);
        } catch (LogicalException e) {
            System.out.println("Example of exception: " + e.getMessage());
        }

    }
}
