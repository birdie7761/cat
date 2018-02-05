package com.dianping.cat.report.page.clear.task;

import com.dianping.cat.Cat;
import com.dianping.cat.Constants;
import com.dianping.cat.core.dal.Graph;
import com.dianping.cat.core.dal.GraphDao;
import com.dianping.cat.message.Transaction;
import com.dianping.cat.report.task.TaskBuilder;

import org.unidal.dal.jdbc.DalException;
import org.unidal.helper.Threads;
import org.unidal.lookup.annotation.Inject;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by wur on 2018/2/5.
 */
public class GraphDatabasePruner implements TaskBuilder {
    public static final String ID = Constants.GRAPH_DATABASE_PRUNER;

    @Inject
    private GraphDao m_graphDao;

    private static final int DURATION = -1;

    public boolean buildDailyTask(String name, String domain, Date period) {
        Threads.forGroup("cat").start(new DeleteTask());

        return true;
    }

    @Override
    public boolean buildHourlyTask(String name, String domain, Date period) {
        throw new RuntimeException("daily report builder don't support hourly task");
    }

    @Override
    public boolean buildMonthlyTask(String name, String domain, Date period) {
        throw new RuntimeException("daily report builder don't support monthly task");
    }

    @Override
    public boolean buildWeeklyTask(String name, String domain, Date period) {
        throw new RuntimeException("daily report builder don't support weekly task");
    }

    public boolean pruneDatabase(int months) {
        Date period = queryPeriod(months);
        return pruneGraph(period);
    }
    private boolean pruneGraph(Date period) {
        boolean succes = true;
        Transaction t = Cat.newTransaction("DeleteTask", "Graph");
        try {
            pruneGraphTable(period);
            t.setStatus(Transaction.SUCCESS);
        } catch (DalException e) {
            t.setStatus(e);
            Cat.logError(e);
            succes = false;
        } finally {
            t.complete();
        }
        return succes;
    }

    public void pruneGraphTable(Date period) throws DalException {
        Graph graph = new Graph();

        graph.setPeriod(period);
        m_graphDao.deleteBeforePeriod(graph);
    }

    public Date queryPeriod(int months) {
        Calendar cal = Calendar.getInstance();

        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.MILLISECOND, 0);
        cal.add(Calendar.MONTH, months);
        return cal.getTime();
    }

    public class DeleteTask implements Threads.Task {

        @Override
        public void run() {
            try {
                pruneDatabase(DURATION);
            } catch (Exception e) {
                Cat.logError(e);
            }
        }

        @Override
        public String getName() {
            return "delete-graph-job";
        }

        @Override
        public void shutdown() {
        }
    }
}
