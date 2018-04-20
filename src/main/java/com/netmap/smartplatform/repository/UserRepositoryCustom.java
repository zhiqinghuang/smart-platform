package com.netmap.smartplatform.repository;

import com.netmap.smartplatform.domain.User;

public interface UserRepositoryCustom {

	public User getByUsername(String username);

}