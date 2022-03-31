package Work.Jobs;

import Work.Producers.Pr1;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class SummaryJob implements Job {
    public void execute(JobExecutionContext arg0) throws JobExecutionException {
        Pr1.getInstance().sendCovidSummary();
    }
}
