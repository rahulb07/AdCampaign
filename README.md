# AdCampaign
AdCampaign sample web app using cassandra database

DB Script:

CREATE KEYSPACE adcampaign WITH replication = {'class':'SimpleStrategy','replication_factor':3};
CREATE TABLE ads(partner_id text PRIMARY KEY, duration int, ad_content text)

Cassandra is used as database for this application. since each partner can be associated with single AD, partner_id is selected as the key.

Spring MVC 4.x framework is used for creating REST API
Cassandra 3.x is used to connect to cassandra and all required libraries are added as maven dependencies
Use Tomcat 7 to deploy this app.
 
 
