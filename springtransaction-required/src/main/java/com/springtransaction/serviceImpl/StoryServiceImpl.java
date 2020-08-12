package com.springtransaction.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.springtransaction.entity.Story;
import com.springtransaction.repository.StoryRepository;
import com.springtransaction.service.StoryService;

@Service
public class StoryServiceImpl implements StoryService {
	@Autowired
	private StoryRepository storyRepository;
	
	//Saving a story is in a new transaction.
	@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRES_NEW)
	public void saveStory(Story story) {
		System.out.println("Story: $$$ "+story);
		storyRepository.save(story);
	}

}
