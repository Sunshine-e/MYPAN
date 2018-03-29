package com.ittahac.mapper;

import java.util.List;

import com.ittahac.modal.User;

public interface UserMapper {
	public List<User> getAll();
	public int add(User user);
}
