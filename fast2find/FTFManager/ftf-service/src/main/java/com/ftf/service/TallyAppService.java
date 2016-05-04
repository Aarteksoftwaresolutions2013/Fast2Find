package com.ftf.service;

import com.ftf.model.Audit;

public interface TallyAppService {
	public boolean increaseCounter(Audit audit);
	public boolean decreaseCounter(Audit audit);
}
