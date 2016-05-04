package com.ftf.serviceImpl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ftf.model.Audit;
import com.ftf.repository.TallyAppRepository;
import com.ftf.service.TallyAppService;
import com.ftf.util.IConstant;

@Service
public class TallyAppServiceImpl implements TallyAppService {
	@Autowired
	private TallyAppRepository tallyAppRepository;

	/**
	 * Increase male or female counter.
	 * @param audit
	 */
	public boolean increaseCounter(Audit audit) {
		boolean status = false;
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		audit.setTimeStamp(dateFormat.format(date));
		audit.setIsDeleted(IConstant.IS_DELETED);
		status = tallyAppRepository.increaseCounter(audit);
		if (status == true) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Decrease male or female counter.
	 * @param audit
	 */
	public boolean decreaseCounter(Audit audit) {
		boolean status = false;
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		audit.setTimeStamp(dateFormat.format(date));
		audit.setIsDeleted(IConstant.IS_DELETED);
		status = tallyAppRepository.decreaseCounter(audit);
		if (status == true) {
			return true;
		} else {
			return false;
		}
	}

}
