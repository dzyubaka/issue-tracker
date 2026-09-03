package dev.dzyuba.issuetracker.issue;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum IssueType {

    EPIC("Эпик"),
    STORY("История"),
    TASK("Задание"),
    BUG("Баг");

    private final String displayName;

}
