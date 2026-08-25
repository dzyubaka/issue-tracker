package dev.dzyuba.issuetracker.project;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/projects")
@RequiredArgsConstructor
public class ProjectController {

    private final ProjectRepository projectRepository;

    @GetMapping
    public String list(Model model) {
        model.addAttribute("projects", projectRepository.findAll());
        return "projects";
    }

    @GetMapping("/new")
    public String create() {
        return "project";
    }

    @GetMapping("/{key}")
    public String view(@PathVariable String key) {
        return "redirect:/projects/" + key + "/issues";
    }

    @PostMapping
    public String create(String key, String name) {
        projectRepository.save(new Project(key, name));
        return "redirect:";
    }

}
