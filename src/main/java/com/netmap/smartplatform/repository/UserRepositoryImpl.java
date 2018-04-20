package com.netmap.smartplatform.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositorySearchesResource;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.ResourceProcessor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.netmap.smartplatform.domain.User;

@RestController
@RequestMapping("/user")
public class UserRepositoryImpl implements UserRepositoryCustom, ResourceProcessor<RepositorySearchesResource> {

	@Autowired
	UserRepository userRepo;

	@Override
	@RequestMapping(value = "/search/getUserByUsername", method = RequestMethod.GET)
	public User getByUsername(@RequestParam(value = "username", required = true) String username) {
		return userRepo.findByUsername(username);
	}

	@Override
	public RepositorySearchesResource process(RepositorySearchesResource resource) {
		String href = resource.getId().getHref();
		resource.add(new Link(href + "/getByUsername{?username}").withRel("getByUsername"));
		return resource;
	}
}
