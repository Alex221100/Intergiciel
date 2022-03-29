package Work.Jobs;

import Work.Producers.Pr1;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;

public class SummaryJob implements Job {

    @Autowired
    private Pr1 pr1;

    public void execute(JobExecutionContext arg0) throws JobExecutionException {
        if (pr1 != null) {
            pr1.sendCovidSummary();
        }
    }
}
