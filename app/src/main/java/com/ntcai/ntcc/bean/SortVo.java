package com.ntcai.ntcc.bean;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.List;

public class SortVo implements Serializable {
    private String name;
    private List<CategoryTwoArray>categoryTwoArray;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<CategoryTwoArray> getCategoryTwoArray() {
        return categoryTwoArray;
    }

    public void setCategoryTwoArray(List<CategoryTwoArray> categoryTwoArray) {
        this.categoryTwoArray = categoryTwoArray;
    }
}
