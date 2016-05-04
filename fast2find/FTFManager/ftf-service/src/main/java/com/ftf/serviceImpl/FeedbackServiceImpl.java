package com.ftf.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ftf.model.FeedbackDetails;
import com.ftf.repository.FeedbackRepository;
import com.ftf.service.FeedbackService;
import com.ftf.util.IConstant;

@Service
public class FeedbackServiceImpl implements FeedbackService {
	@Autowired
	private FeedbackRepository feedbackRepository;

	/**
   * feedbackInfoAdd Method use to save user feedback into database.
   * @param feedbackDetails
   * set isDeleted one
   */
	public boolean feedbackInfoAdd(FeedbackDetails feedbackDetails) {
		boolean status = false;
		if (feedbackDetails != null) {
			feedbackDetails.setIsDeleted(IConstant.IS_DELETED);
			status = feedbackRepository.feebackInfoAdd(feedbackDetails);
			return status;
		}
		return status;
	}
}
