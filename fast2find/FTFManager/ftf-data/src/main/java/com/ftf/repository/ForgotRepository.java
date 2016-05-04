package com.ftf.repository;

import java.util.List;

public interface ForgotRepository {
	@SuppressWarnings("rawtypes")
	public List getPassword(String email);
}
