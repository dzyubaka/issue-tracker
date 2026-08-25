package dev.dzyuba.issuetracker.issue;

import dev.dzyuba.issuetracker.project.Project;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/projects/{projectKey}/issues")
@RequiredArgsConstructor
public class IssueController {

    private final IssueService issueService;

    @GetMapping
    public String list(@PathVariable String projectKey, Model model) {
        List<Issue> issues = issueService.list(projectKey);
        model.addAttribute("issues", issues);
        return "issues";
    }

    @GetMapping("/new")
    public String create(@PathVariable String projectKey, Model model) {
        Project project = issueService.findProjectByKey(projectKey);
        model.addAttribute("issue", new Issue(project));
        model.addAttribute("statuses", IssueStatus.values());
        return "issue";
    }

    @GetMapping("/{issueKey}")
    public String view(@PathVariable String issueKey, Model model) {
        Issue issue = issueService.find(issueKey);
        model.addAttribute("issue", issue);
        model.addAttribute("statuses", IssueStatus.values());
        return "issue";
    }

    @PostMapping
    public String create(@PathVariable String projectKey, Issue issue) {
        issueService.create(projectKey, issue);
        return "redirect:/projects/" + projectKey;
    }

    @PostMapping("/{issueKey}")
    public String update(@PathVariable String projectKey, @PathVariable String issueKey, Issue issue) {
        issueService.update(issueKey, issue);
        return "redirect:/projects/" + projectKey;
    }

}
