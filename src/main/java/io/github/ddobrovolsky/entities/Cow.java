package io.github.ddobrovolsky.entities;

/**
 * Created by Dmitriy Dobrovolskiy on 01.06.2018.
 *
 * @since *.*.*
 */
public class Cow {
    int cowId;
    String nickName;

    public Cow(int cowId, String nickName) {
        this.cowId = cowId;
        this.nickName = nickName;
    }

    public int getCowId() {
        return cowId;
    }

    public void setCowId(int cowId) {
        this.cowId = cowId;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cow cow = (Cow) o;

        if (cowId != cow.cowId) return false;
        return nickName != null ? nickName.equals(cow.nickName) : cow.nickName == null;

    }

    @Override
    public int hashCode() {
        int result = cowId;
        result = 31 * result + (nickName != null ? nickName.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Cow{" +
                "cowId=" + cowId +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}
