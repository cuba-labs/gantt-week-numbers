package com.company.demo.entity;

import com.haulmont.chile.core.annotations.MetaClass;
import com.haulmont.chile.core.annotations.MetaProperty;
import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.*;
import java.util.Date;

@NamePattern("%s|task")
@MetaClass(name = "demo_DateSegment")
public class DateSegment extends StandardEntity {

    @MetaProperty
    protected Date start;

    @MetaProperty
    protected Date end;

    @MetaProperty
    protected String color;

    @MetaProperty
    protected String task;

    @MetaProperty
    protected DateTaskSpan taskSpan;

    public void setTaskSpan(DateTaskSpan taskSpan) {
        this.taskSpan = taskSpan;
    }

    public DateTaskSpan getTaskSpan() {
        return taskSpan;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getStart() {
        return start;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public Date getEnd() {
        return end;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public String getTask() {
        return task;
    }
}