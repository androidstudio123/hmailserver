package com.example.email.service.impl;

import java.util.List;

import javax.annotation.Resource;

import com.example.email.dao.FaceDao;
import com.example.email.entity.Users;
import com.example.email.service.FaceService;
import org.springframework.stereotype.Service;



@Service
public class FaceServiceImpl implements FaceService {
	@Resource
	private FaceDao facedao;


	public List<Users> selectAllUsers() {
		return facedao.selectAllUsers();
	}


	@Override
	public int save(Users user) {
		 return facedao.save(user);
	}


	@Override
	public Users queryInfoByUsername(String username) {
		// TODO Auto-generated method stub
		 return facedao.queryInfoByUsername(username);
	}

}
