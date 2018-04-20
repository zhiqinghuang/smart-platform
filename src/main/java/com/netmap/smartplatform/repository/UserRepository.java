package com.netmap.smartplatform.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.netmap.smartplatform.domain.User;

@RepositoryRestResource(collectionResourceRel = "user", path = "user")
public interface UserRepository extends JpaRepository<User, Long>, UserRepositoryCustom {

	User findByUsername(@Param("username") String username);
}
