package com;

import com.Work.Jobs.SummaryJob;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@ComponentScan(basePackages = {"com.Data.Repository"})
@EnableJpaRepositories(basePackages = {"com.Data.Repository"})
@EntityScan(basePackages = {"com.Data.Entity"})
public class Main {

    public static void main(String[] args) throws SchedulerException {
        SpringApplication.run(Main.class, args);

        Scheduler scheduler = new StdSchedulerFactory().getScheduler();

        JobDetail job = JobBuilder.newJob(SummaryJob.class)
                .withIdentity("summaryJob", "group1")
                .build();

        Trigger trigger = TriggerBuilder.newTrigger()
                .withIdentity("summaryJob", "group1")
                .startNow()
                .withSchedule(SimpleScheduleBuilder.simpleSchedule()
                        .withIntervalInSeconds(10)
                        .repeatForever())
                .build();

        scheduler.scheduleJob(job, trigger);
        scheduler.start();

        //Pr2.getInstance().sendCommand("global");
    }

}