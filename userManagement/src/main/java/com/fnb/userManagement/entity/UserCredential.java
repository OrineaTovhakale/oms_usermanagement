package com.fnb.userManagement.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "user_credentials")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class UserCredential {

    private Long credentialsId;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="customerId")
    private User user;

    private String password;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    @PrePersist
    protected void oncreate(){
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onupdate(){
        this.updatedAt = LocalDateTime.now();
    }
}
