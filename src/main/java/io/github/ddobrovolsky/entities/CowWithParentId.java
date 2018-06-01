package io.github.ddobrovolsky.entities;

/**
 * Created by Dmitriy Dobrovolskiy on 01.06.2018.
 *
 * @since *.*.*
 */
public class CowWithParentId extends Cow implements Animal {
    private final int parentId;

    public CowWithParentId(int cowId, String nickName, int parentId) {
        super(cowId, nickName);
        this.parentId = parentId;
    }

    public int getParentId() {
        return parentId;
    }

    @Override
    public int getId() {
        return cowId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        CowWithParentId that = (CowWithParentId) o;

        return parentId == that.parentId;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + parentId;
        return result;
    }

    @Override
    public String toString() {
        return "CowWithParentId{" +
                "parentId=" + parentId +
                ", " + super.toString() +
                '}';
    }
}
