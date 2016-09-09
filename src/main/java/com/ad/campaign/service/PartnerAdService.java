package com.ad.campaign.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ad.campaign.dao.PartnerAdDao;
import com.ad.campaign.dto.PartnerAd;

@Service
public class PartnerAdService {
	
	@Autowired
	private PartnerAdDao partnerAdDao;

	/**
	 * Service methods to implement business 
	 * @param partnerId
	 * @return
	 */
	public PartnerAd getPartnerAd(String partnerId){
		return partnerAdDao.getPartnerAd(partnerId);
	}
	
	/**
	 * Service methods to implement business 
	 * @param partnerId
	 * @return
	 */
	public String  savePartnerAd(PartnerAd partnerAd){
		return partnerAdDao.savePartnerAd(partnerAd);
	}
}
