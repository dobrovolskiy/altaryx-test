package io.github.ddobrovolsky.services;

/**
 * Basic interface for all farms
 * Created by Dmitriy Dobrovolskiy on 01.06.2018.
 *
 * @since *.*.*
 */
public interface Farm {

    public void printState();

    public void giveBirth(int parentCowId, int childCowId, String childNickName);

    public void endLifeSpan(int cowId);
}
