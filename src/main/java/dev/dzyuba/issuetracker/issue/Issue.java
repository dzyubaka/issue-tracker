package dev.dzyuba.issuetracker.issue;

import dev.dzyuba.issuetracker.project.Project;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "issues")
public class Issue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;

    private String summary;

    public Issue(Project project, String summary) {
        this.project = project;
        this.summary = summary;
    }

}
