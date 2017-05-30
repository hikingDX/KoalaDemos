package hiking.com.gridviewdemo;

import android.graphics.Color;

/**
 * Created by hiking on 2017/5/23.
 */

class ItemData {
    private String name;
    private int count;
    private String danwei;

    @Override
    public String toString() {
        return "ItemData{" +
                "name='" + name + '\'' +
                ", count=" + count +
                ", danwei='" + danwei + '\'' +
                ", color=" + color +
                '}';
    }

    public ItemData(String name, int count, String danwei, int color) {
        this.name = name;
        this.count = count;
        this.danwei = danwei;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getDanwei() {
        return danwei;
    }

    public void setDanwei(String danwei) {
        this.danwei = danwei;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    private int color;
}
