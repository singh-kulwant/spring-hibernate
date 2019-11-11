package com.in.models;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Feed {

	@Column(name = "FEED_NAME")
	private String feedName;
	@Column(name = "FEED_CATEGORY")
	private String feedCategory;
	@Column(name = "FEED_FREQUENCY")
	private String feedFrequency;

	public String getFeedName() {
		return feedName;
	}

	public String getFeedCategory() {
		return feedCategory;
	}

	public String getFeedFrequency() {
		return feedFrequency;
	}

	public void setFeedName(String feedName) {
		this.feedName = feedName;
	}

	public void setFeedCategory(String feedCategory) {
		this.feedCategory = feedCategory;
	}

	public void setFeedFrequency(String feedFrequency) {
		this.feedFrequency = feedFrequency;
	}

}
