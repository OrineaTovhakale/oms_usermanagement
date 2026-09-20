package com.fnb.userManagement.repository;

import com.fnb.userManagement.entity.UserCredential;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserCredentialsRepository extends JpaRepository<UserCredential, Long> {

}
