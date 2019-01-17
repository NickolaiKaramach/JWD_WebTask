package by.etc.karamach.controller.job;

import by.etc.karamach.service.GradeService;
import by.etc.karamach.service.ServiceException;
import by.etc.karamach.service.ServiceFactory;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class DeleteUnusedGrade implements Job {

    private static final GradeService gradeService = ServiceFactory.getInstance().getGradeService();


    public DeleteUnusedGrade() {
    }

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        try {

            gradeService.deleteUnusedGrades();

        } catch (ServiceException e) {

            throw new RuntimeException(e);

        }
    }
}
