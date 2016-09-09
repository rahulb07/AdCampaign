package com.ad.campaign.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ad.campaign.dto.PartnerAd;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;
import com.datastax.driver.core.querybuilder.Insert;
import com.datastax.driver.core.querybuilder.QueryBuilder;
import com.datastax.driver.core.querybuilder.Select;

@Repository
public class PartnerAdDao {
	
	@Autowired
	private Session session;

	/**
	 * DAO method to retrieve ad info from db using 
	 * partnerID
	 * @param partnerId
	 * @return
	 */
	public PartnerAd getPartnerAd(String partnerId){
		PartnerAd partnerAd=null;
		Select selectFlights = QueryBuilder.select().from("adcampaign","ads");			
		selectFlights.where(QueryBuilder.eq("partner_id", partnerId));
		ResultSet resultSet=session.execute(selectFlights);
		if(!resultSet.isExhausted()){
			Row row=resultSet.one();
			partnerAd = new PartnerAd();
			partnerAd.setAdContent(row.getString("ad_content"));
			partnerAd.setDuration(row.getInt("duration"));
			partnerAd.setPartnerId(row.getString("partner_id"));
		}
		
			
		return partnerAd;
	}
	
	/**
	 * DAO method to save AD and partner info from 
	 * given object
	 * 
	 * @param partnerAd
	 * @return
	 */
	public String  savePartnerAd(PartnerAd partnerAd){
		Insert insert = QueryBuilder.insertInto("adcampaign","ads")
				.value("partner_id", partnerAd.getPartnerId())
				.value("duration", partnerAd.getDuration())
				.value("ad_content", partnerAd.getAdContent());
		session.execute(insert);
		return partnerAd.getPartnerId();
	}
}
