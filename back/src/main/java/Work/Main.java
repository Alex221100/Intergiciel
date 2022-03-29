package Work;

import Work.Jobs.SummaryJob;
import Work.Producers.Pr2;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;


@SpringBootApplication
public class Main {

    public static void main(String[] args) throws SchedulerException {
        SpringApplication.run(Main.class, args);

        Scheduler scheduler = new StdSchedulerFactory().getScheduler();

        JobDetail job = JobBuilder.newJob(SummaryJob.class)
                .withIdentity("summaryJob", "group1")
                .build();

        Trigger trigger = TriggerBuilder.newTrigger()
                .withIdentity("trigger1", "group1")
                .startNow()
                .withSchedule(SimpleScheduleBuilder.simpleSchedule()
                        .withIntervalInMinutes(30)
                        .repeatForever())
                .build();

        scheduler.start();
        scheduler.scheduleJob(job, trigger);

        //Pr2.getInstance().sendCommand("country, France");
    }

}