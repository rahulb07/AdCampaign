package com.ad.campaign.dto;

import com.fasterxml.jackson.annotation.JsonProperty;


public class PartnerAd {
	
	@JsonProperty("partner_id")
	private String partnerId;
	
	@JsonProperty("duration")
	private int duration;
	
	@JsonProperty("ad_content")
	private String adContent;

	public String getPartnerId() {
		return partnerId;
	}

	public void setPartnerId(String partnerId) {
		this.partnerId = partnerId;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public String getAdContent() {
		return adContent;
	}

	public void setAdContent(String adContent) {
		this.adContent = adContent;
	}


}
