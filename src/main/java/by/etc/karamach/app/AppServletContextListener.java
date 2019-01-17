package by.etc.karamach.app;

import by.etc.karamach.controller.job.DeleteUnusedGrade;
import by.etc.karamach.dao.pool.ConnectionPool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.newTrigger;

public class AppServletContextListener implements ServletContextListener {
    private static final Logger logger = LogManager.getLogger();

    private static ConnectionPool connectionPool;
    private static Scheduler scheduler;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        initConnectionPool();

        scheduleJobs();
    }


    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        destroyConnectionPool();

        shutdownSchedule();
    }

    private void initConnectionPool() {
        connectionPool = ConnectionPool.getInstance();
    }

    private void destroyConnectionPool() {
        connectionPool.dispose();
    }

    private void scheduleJobs() {
        try {

            scheduler = StdSchedulerFactory.getDefaultScheduler();

            scheduler.start();

            JobDetail job = newJob(DeleteUnusedGrade.class)
                    .withIdentity("deleteUnusedGrade", "group1")
                    .build();

            Trigger trigger = newTrigger()
                    .withIdentity("deleteUnusedGradeTrigger", "group1")
                    .startNow()
                    .withSchedule(
                            simpleSchedule()
                                    .withIntervalInHours(1)
                                    .repeatForever())
                    .build();

            scheduler.scheduleJob(job, trigger);


        } catch (SchedulerException e) {

            logger.error(e);
            throw new RuntimeException(e);
        }
    }

    private void shutdownSchedule() {
        try {

            scheduler.shutdown();

        } catch (SchedulerException e) {

            logger.error(e);
            throw new RuntimeException(e);
        }
    }




}
