package com.ad.campaign.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	
	/**
	 * Post method to enter AD information along with PartnerId
	 * @param partnerAd
	 * @return
	 */
	@RequestMapping(value="/ad",method=RequestMethod.POST)
	public ResponseEntity<?> postPartnerAdDetails(@RequestBody PartnerAd partnerAd){
		return new ResponseEntity<String>(partnerAdService.savePartnerAd(partnerAd), HttpStatus.CREATED);
	}
	
	/**
	 * GET method to retrieve info from db based on partner ID
	 * @param partnerId
	 * @return
	 */
	@RequestMapping(value="/ad/{partnerId}",method=RequestMethod.GET)
	public ResponseEntity<?> getLoggedInUserdetails(@PathVariable String partnerId ){
		if(null==partnerAdService.getPartnerAd(partnerId)){
			return new ResponseEntity<Object>(null,HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<PartnerAd>(partnerAdService.getPartnerAd(partnerId),HttpStatus.OK);
	}
}
