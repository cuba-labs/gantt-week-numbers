package com.company.demo.entity;

import com.haulmont.chile.core.annotations.MetaClass;
import com.haulmont.chile.core.annotations.MetaProperty;
import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.Transient;
import java.util.List;

@NamePattern("%s|category")
@MetaClass(name = "demo_DateTaskSpan")
public class DateTaskSpan extends StandardEntity {

    @MetaProperty
    protected String category;

    @MetaProperty
    protected List<DateSegment> segments;

    public List<DateSegment> getSegments() {
        return segments;
    }

    public void setSegments(List<DateSegment> segments) {
        this.segments = segments;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCategory() {
        return category;
    }
}