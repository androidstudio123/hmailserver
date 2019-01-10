package com.example.email.dao;

import com.example.email.entity.Users;

import java.util.List;



public interface FaceDao {

	public List<Users> selectAllUsers();

	public int save(Users users);
	
	 public Users queryInfoByUsername(String username);

}
