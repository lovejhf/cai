package com.ntcai.ntcc.db;

import com.litesuits.orm.db.annotation.PrimaryKey;
import com.litesuits.orm.db.annotation.Table;
import com.litesuits.orm.db.enums.AssignType;

import java.util.Date;

@Table("search_history")
public class SearchHistory {
    @PrimaryKey(AssignType.BY_MYSELF)
    private String name;
    private Date crate_time;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCrate_time() {
        return crate_time;
    }

    public void setCrate_time(Date crate_time) {
        this.crate_time = crate_time;
    }
}
