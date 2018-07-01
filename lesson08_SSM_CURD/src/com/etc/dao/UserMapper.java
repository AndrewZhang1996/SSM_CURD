package com.etc.dao;

import java.util.List;

import com.etc.pojo.UserPojo;

public interface UserMapper {

	UserPojo findByUname(String uname);

	int insertUser(UserPojo user);

	List<UserPojo> findByCondition(UserPojo user);

	UserPojo findById(Integer id);

	int update(UserPojo user);

	void delete(Integer id);

	UserPojo seacherByIdAndVersion(UserPojo user);

}
