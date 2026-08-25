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
        Project project = findProjectByKey(projectKey);
        return issueRepository.findByProjectOrderByNumberDesc(project);
    }

    public Issue find(String issueKey) {
        String[] projectAndNumber = issueKey.split("-");
        Project project = findProjectByKey(projectAndNumber[0]);
        return issueRepository.findByProjectAndNumber(project, Integer.parseInt(projectAndNumber[1]));
    }

    public void create(String projectKey, Issue issue) {
        Project project = findProjectByKey(projectKey);
        int number = project.getLastIssueNumber() + 1;
        issue.setProject(project);
        issue.setNumber(number);
        issueRepository.save(issue);
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

    public Project findProjectByKey(String projectKey) {
        return projectRepository.findByKey(projectKey);
    }

}
