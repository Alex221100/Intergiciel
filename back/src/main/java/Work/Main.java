package Work;

import Work.Jobs.SummaryJob;
import Work.Producers.Pr1;
import Work.Producers.Pr2;
import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
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

        Pr2.getInstance().sendCommand("global");
    }

}