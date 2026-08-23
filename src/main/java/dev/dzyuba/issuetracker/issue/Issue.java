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

    private Integer number;

    private String summary;

    private String description;

    private IssueStatus status;

    public String getKey() {
        return project.getKey() + '-' + number;
    }

    public Issue(Project project, Integer number, String summary, String description, IssueStatus status) {
        this.project = project;
        this.number = number;
        this.summary = summary;
        this.description = description;
        this.status = status;
    }

}
