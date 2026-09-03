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

    private IssueType type;

    public String getKey() {
        return project.getKey() + '-' + number;
    }

    public Issue(Project project) {
        this.project = project;
    }

}
