package com.point.system.data.entity;

import com.point.system.domain.valueobject.TransactionType;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Objects;

@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "point_transaction", schema = "point")
@Entity
@ToString
public class PointTransactionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long transactionId;

    private Long userPointId;
    private Long referenceId;
    private Long amount;
    private TransactionType transactionType;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime failureReason;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PointTransactionEntity that = (PointTransactionEntity) o;
        return userPointId.equals(that.userPointId);
    }

    @Override
    public int hashCode() { return Objects.hash(this.userPointId); }
}
