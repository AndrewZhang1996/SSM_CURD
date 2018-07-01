package com.etc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.etc.common.ServiceException;
import com.etc.dao.UserMapper;
import com.etc.pojo.UserPojo;

@Service
@Transactional
public class UserService {

	@Autowired
	UserMapper mapper;

	/**
	 * 根据用户名进行查询并处理
	 * @param user 输入的用户信息
	 * @return true:存在， false:不存在
	 * @throws ServiceException 业务逻辑异常： m001用户名不存在， m002用户和密码不匹配
	 */
	public boolean checkUser(UserPojo user) throws ServiceException {

		boolean exist = false;
		UserPojo newpo = mapper.findByUname(user.getUname());
		
		if (newpo == null) {
			throw new ServiceException("m001");
		} else if (!user.getPassword().equals(newpo.getPassword())) {
				throw new ServiceException("m002");	
		} else {
			exist = true;
		}
		
		return true;
	}

	// rollbackfor 发生异常的时候回滚
	// 事务的传播:service层方法的调用时，事务是否再次开启。
	@Transactional(rollbackFor=Exception.class, propagation=Propagation.REQUIRED)
	public void insert(UserPojo user) throws ServiceException {
		
		
		UserPojo newpo = mapper.findByUname(user.getUname());
		if (newpo == null) {
			
			int i = mapper.insertUser(user);
			if (i != 1) {
				throw new ServiceException("e001");	
			}
		} else {
			throw new ServiceException("m003");
		}
		
		
		
	}

	public List<UserPojo> findByCondition(UserPojo user) {
		
		
		return mapper.findByCondition(user);
	}

	public UserPojo findById(Integer id) {
		return mapper.findById(id);
	}

	@Transactional(rollbackFor=Exception.class, propagation=Propagation.REQUIRED)
	public void update(UserPojo user) throws ServiceException {
		
		// 乐观排他: 用id和版本号做匹配：如果有数据：半小时内没人动这条数据。没有数据：要么被别人修改了，或者删除
		UserPojo up = mapper.seacherByIdAndVersion(user); // 悲观锁：锁行
		
		if (up != null) {
			// 在10：38：55.123456 Cup回退回来 这个时候有修改了这条数据怎么办？？？？悲观排他
			mapper.update(user);
		} else {
			throw new ServiceException("重新确认一下别人改了这个数据");
		}
		
		
		
	}
	@Transactional(rollbackFor=Exception.class, propagation=Propagation.REQUIRED)
	public void delete(Integer id) {
		mapper.delete(id);
		
	}
}
