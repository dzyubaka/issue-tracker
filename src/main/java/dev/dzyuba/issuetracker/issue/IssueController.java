package dev.dzyuba.issuetracker.issue;

import dev.dzyuba.issuetracker.project.Project;
import dev.dzyuba.issuetracker.project.ProjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/projects/{key}/issues")
@RequiredArgsConstructor
public class IssueController {

    private final ProjectRepository projectRepository;

    private final IssueRepository issueRepository;

    @GetMapping
    public String list() {
        return "issues";
    }

    @PostMapping
    public String create(@PathVariable String key, String issue) {
        Project project = projectRepository.findByKey(key);
        issueRepository.save(new Issue(project, issue));
        return "redirect:";
    }

}
