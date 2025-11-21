package com.point.system.application.dto.issue;

import lombok.*;

@Getter
@AllArgsConstructor
@Setter
public class PointIssueCommand {

    private final Long userNo;
    private final Long pointPolicyNo;
    private final Long amount;
    private Integer lifeSpan;
    private String comment;
}
