package com.ad.campaign.rest.copy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ad.campaign.dto.PartnerAd;
import com.ad.campaign.service.PartnerAdService;

@RestController
@RequestMapping("/service")
public class PartnerAdRestService {

	@Autowired
	private PartnerAdService partnerAdService;
	
	@RequestMapping(value="/ad",method=RequestMethod.POST)
	public String postPartnerAdDetails(@RequestBody PartnerAd partnerAd){
		return partnerAdService.savePartnerAd(partnerAd);
	}
	
	@RequestMapping(value="/ad/{partnerId}",method=RequestMethod.GET)
	public PartnerAd getLoggedInUserdetails(@PathVariable String partnerId ){
		return partnerAdService.getPartnerAd(partnerId);
	}
}
