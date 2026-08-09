package dev.dzyuba.issuetracker.project;

import dev.dzyuba.issuetracker.issue.Issue;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "projects")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "project")
    private List<Issue> issues;

    private String key;

    public Project(String key) {
        this.key = key;
    }

}
