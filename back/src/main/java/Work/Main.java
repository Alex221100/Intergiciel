package Work;

import Work.Jobs.SummaryJob;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
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
                        .withIntervalInMinutes(30)
                        .repeatForever())
                .build();

        scheduler.scheduleJob(job, trigger);
        scheduler.start();
    }

}