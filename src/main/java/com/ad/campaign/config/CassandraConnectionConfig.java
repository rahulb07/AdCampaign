package com.ad.campaign.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;

@Configuration
public class CassandraConnectionConfig {

	@Bean
	public Cluster getCassandraCluster() {
		return Cluster.builder().addContactPoint("localhost").withPort(9042)
				.build();
	}
	
	@Bean
	public Session getSession(){
		return getCassandraCluster().connect("adcampaign");
	}
}
