package dev.dzyuba.issuetracker.project;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/projects")
@RequiredArgsConstructor
public class ProjectController {

    private final ProjectRepository projectRepository;

    @GetMapping
    public String list() {
        return "projects";
    }

    @PostMapping
    public String create(String key) {
        projectRepository.save(new Project(key));
        return "redirect:";
    }

}
