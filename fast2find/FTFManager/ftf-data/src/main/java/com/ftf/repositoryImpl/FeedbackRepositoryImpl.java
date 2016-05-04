package com.ftf.repositoryImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.ftf.model.FeedbackDetails;
import com.ftf.repository.FeedbackRepository;

@Repository
public class FeedbackRepositoryImpl implements FeedbackRepository {
	@Autowired
	private HibernateTemplate hibernateTemplate;

	/**
   * feedbackInfoAdd Method use to save user feedback into database.
   * @param feedbackDetails
   */
	public boolean feebackInfoAdd(FeedbackDetails feedbackDetails) {
		hibernateTemplate.save(feedbackDetails);
		return true;
	}
}
