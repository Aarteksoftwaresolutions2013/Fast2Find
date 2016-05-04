package com.ftf.repository;
import com.ftf.model.Audit;
public interface TallyAppRepository {
	public boolean increaseCounter(Audit audit);
	public boolean decreaseCounter(Audit audit);
}
