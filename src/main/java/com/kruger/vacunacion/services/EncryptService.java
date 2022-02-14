package com.kruger.vacunacion.services;

import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

@Service
public class EncryptService implements IEncryptService{

	
	@Override
	public String encryptPassword(String password) {
		return BCrypt.hashpw(password,BCrypt.gensalt());
	}

	@Override
	public boolean verifyPassword(String originalPassword, String hashPassword) {
		String original = encryptPassword(originalPassword);
		if(original.equals(hashPassword)) return true;
		return false;
	}

	
}
