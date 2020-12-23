package in.b2k.model;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.UUID;

@EntityListeners(AuditingEntityListener.class)
@MappedSuperclass
@Data
public abstract class BaseEntity implements Serializable {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator",
            parameters = { @Parameter(name = "uuid_gen_strategy_class",
                    value = "org.hibernate.id.uuid.CustomVersionOneStrategy")})
    @Column(name = "ID", updatable = false, nullable = false)
    private UUID id;

    @Version
    private Integer version;

    @Column(name = "CREATED_BY", length = 31, updatable = false, nullable = false)
    @CreatedBy
    private String createdBy;

    @Column(name = "CREATED_AT", updatable = false, nullable = false)
    @CreatedDate
    private ZonedDateTime createdAt;

    @Column(name = "UPDATED_BY", length = 31, nullable = false)
    @LastModifiedBy
    private String updatedBy;

    @Column(name = "UPDATED_AT", nullable = false)
    @LastModifiedDate
    private ZonedDateTime updatedAt;

   /* @PrePersist
    void prePersist(){

    }*/

}
