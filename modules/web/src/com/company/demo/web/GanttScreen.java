package com.company.demo.web;

import com.company.demo.entity.DateSegment;
import com.company.demo.entity.DateTaskSpan;
import com.google.common.collect.Lists;
import com.haulmont.cuba.core.global.LoadContext;
import com.haulmont.cuba.core.global.Metadata;
import com.haulmont.cuba.gui.screen.*;

import javax.inject.Inject;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@UiController("demo_GanttScreen")
@UiDescriptor("gantt-screen.xml")
@LoadDataBeforeShow
public class GanttScreen extends Screen {
    @Inject
    protected Metadata metadata;

    @Install(to = "taskSpansDl", target = Target.DATA_LOADER)
    protected List<DateTaskSpan> loadData(@SuppressWarnings("unused") LoadContext<DateTaskSpan> lc) {
        return Arrays.asList(
                span("Module 1", Month.JANUARY),
                span("Module 2", Month.FEBRUARY),
                span("Module 3", Month.MARCH)
        );
    }

    protected DateTaskSpan span(String category, Month month) {
        DateTaskSpan span = metadata.create(DateTaskSpan.class);

        span.setCategory(category);
        span.setSegments(Lists.newArrayList(
                segment(span, "Task 1", "eeaa12", month, 2),
                segment(span, "Task 2", "00aa12", month, 12),
                segment(span, "Task 3", "cc0023", month, 21)
        ));

        return span;
    }

    protected DateSegment segment(DateTaskSpan span, String task, String color, Month month, int day) {
        DateSegment segment = metadata.create(DateSegment.class);

        segment.setTaskSpan(span);
        segment.setTask(task);
        segment.setColor(color);

        ZoneId zone = ZoneId.systemDefault();
        LocalDateTime start = LocalDateTime.of(2019, month, day, 12, 30);
        LocalDateTime end = LocalDateTime.of(2019, month, day + 7, 12, 30);

        segment.setStart(Date.from(start.atZone(zone).toInstant()));
        segment.setEnd(Date.from(end.atZone(zone).toInstant()));

        return segment;
    }
}