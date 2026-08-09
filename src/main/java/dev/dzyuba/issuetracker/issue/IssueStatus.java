package dev.dzyuba.issuetracker.issue;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum IssueStatus {

    TO_DO("К выполнению"),
    IN_PROGRESS("В работе"),
    DONE("Готово");

    private final String displayName;

}
