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

    private IssueStatus status;

    public Issue(Project project, Integer number, String summary, IssueStatus status) {
        this.project = project;
        this.number = number;
        this.summary = summary;
        this.status = status;
    }

}
