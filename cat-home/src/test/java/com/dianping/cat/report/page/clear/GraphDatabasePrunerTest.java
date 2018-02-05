package com.dianping.cat.report.page.clear;

import com.dianping.cat.report.page.clear.task.GraphDatabasePruner;
import com.dianping.cat.report.task.TaskBuilder;

import org.junit.Test;
import org.unidal.lookup.ComponentTestCase;

/**
 * Created by wur on 2018/2/5.
 */
public class GraphDatabasePrunerTest extends ComponentTestCase {
    @Test
    public void test() throws Exception {
        TaskBuilder builder = lookup(TaskBuilder.class, GraphDatabasePruner.ID);
        builder.buildDailyTask("cat", "cat", null);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
