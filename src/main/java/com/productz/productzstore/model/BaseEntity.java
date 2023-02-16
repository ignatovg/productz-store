package com.productz.productzstore.model;

import javax.persistence.PrePersist;
import java.util.UUID;

public abstract class BaseEntity {
    abstract UUID getId();
    abstract void setId(UUID id);

    @PrePersist
    public void setIdBeforePersist() {
        if(getId() == null) {
            setId(UUID.randomUUID());
        }
    }
}
