package dev.dzyuba.issuetracker.issue;

import dev.dzyuba.issuetracker.project.Project;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IssueRepository extends CrudRepository<Issue, Long> {

    List<Issue> findByProjectOrderByNumberDesc(Project project);

    Issue findByProjectAndNumber(Project project, int number);

}
