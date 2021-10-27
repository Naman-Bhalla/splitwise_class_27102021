package dev.naman.splitwise_class.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 1, 2, 3, 4, 5,
    private Long id;

    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    @Column(updatable = false)
    private Date createdAt;

    @LastModifiedDate
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedAt;
}


/// id  | created_at | deleted_at
// java reflection: compile time
// GenerationType.CUSTOM
// class CustomGenerationType extends SpringGenerationTypeInterface {
//     Long getValue() {
//        // fetch
//     }
// }
