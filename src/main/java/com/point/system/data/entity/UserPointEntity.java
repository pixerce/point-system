package com.point.system.data.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Objects;

@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user_point", schema = "point")
@Entity
@ToString
public class UserPointEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userPointNo;

    private Long userNo;
    private Long pointPolicyNo;
    private Long amount;
    private Long balance;
    private LocalDateTime startDate;
    private LocalDateTime expirationDate;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserPointEntity that = (UserPointEntity) o;
        return userPointNo.equals(that.userPointNo);
    }

    @Override
    public int hashCode() { return Objects.hash(this.userPointNo); }
}
