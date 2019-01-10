package com.example.email.service;

import java.util.List;

import com.example.email.entity.Users;

public interface FaceService {

	public List<Users> selectAllUsers();
	
    public int save(Users user);
    
    public Users queryInfoByUsername(String username);

}
