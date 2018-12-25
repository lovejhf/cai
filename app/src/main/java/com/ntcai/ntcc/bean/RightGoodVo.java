package com.ntcai.ntcc.bean;

import com.chad.library.adapter.base.entity.MultiItemEntity;

public class RightGoodVo implements MultiItemEntity {
    private String name;
    private String tag;
    private String titleName;
    private boolean isTitle;
    private String sub;

    public String getSub() {
        return sub;
    }

    public void setSub(String sub) {
        this.sub = sub;
    }

    public boolean isTitle() {
        return isTitle;
    }

    public void setTitle(boolean title) {
        isTitle = title;
    }

    public RightGoodVo(String name) {
        this.name = name;
    }

    public String getTitleName() {
        return titleName;
    }

    public void setTitleName(String titleName) {
        this.titleName = titleName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    @Override
    public int getItemType() {
        return isTitle ?0:1;
    }
}
