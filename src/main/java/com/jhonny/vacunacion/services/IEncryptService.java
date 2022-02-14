package com.jhonny.vacunacion.services;

public interface IEncryptService {
	String encryptPassword(String password);
	boolean verifyPassword(String originalPassword, String hashPassword);
}
