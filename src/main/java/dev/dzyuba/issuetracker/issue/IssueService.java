package dev.dzyuba.issuetracker.issue;

import dev.dzyuba.issuetracker.project.Project;
import dev.dzyuba.issuetracker.project.ProjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class IssueService {

    private final IssueRepository issueRepository;

    private final ProjectRepository projectRepository;

    public List<Issue> list(String projectKey) {
        Project project = projectRepository.findByKey(projectKey);
        return issueRepository.findByProjectOrderByNumberDesc(project);
    }

    public Issue find(String issueKey) {
        String[] projectAndNumber = issueKey.split("-");
        Project project = projectRepository.findByKey(projectAndNumber[0]);
        return issueRepository.findByProjectAndNumber(project, Integer.parseInt(projectAndNumber[1]));
    }

    public void create(String projectKey, String summary, String description) {
        Project project = projectRepository.findByKey(projectKey);
        int number = project.getLastIssueNumber() + 1;
        issueRepository.save(new Issue(project, number, summary, description, IssueStatus.TO_DO));
        project.setLastIssueNumber(number);
        projectRepository.save(project);
    }

    public void update(String issueKey, Issue issue) {
        Issue oldIssue = find(issueKey);
        oldIssue.setSummary(issue.getSummary());
        oldIssue.setDescription(issue.getDescription());
        oldIssue.setStatus(issue.getStatus());
        issueRepository.save(oldIssue);
    }

}
