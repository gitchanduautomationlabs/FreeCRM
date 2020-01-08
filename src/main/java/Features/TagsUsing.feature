Feature: Free CRM Login with using Tags 

@Sanity @Reggression 
Scenario: Login Free CRM 

	When user is on login Page scenario1 
	Then Tile is Free CRM scenario1
	Then provide "naveenk" and "test123" scenario1
	Then Click on Login Button scenario1
	And User On Home Page scenario1
	Then Close the Browser "yes" scenario1
	
@Reggression		
Scenario Outline: Adding New Contact Deatails 

	
	When user is on login Page for new Contact scenario2
	Then Tile is Free CRM for new Contact scenario2
	Then provide "naveenk" and "test123" for new Contact scenario2
	Then Click on Login Button for new Contact scenario2
	And User On Home Page and "<browser>" for new Contact scenario2
	And User click on Contact Page scenario2
	Then Provide deatils for contact page "<FirstName>" and "<lastName>" and "<Postion>" scenario2
	
	Examples: 
		|FirstName|lastName||Postion|
		|chandu|sekhar||4|
		|chandra Sekhar|M||3|
		
@Reggression
Scenario: Free CRM Create a new Deal scenario 

	Given user already Login page for Deals scenario3
	When Title of login Page is Free CRM for Deals scenario3
	Then user Enters User Name and Password for Deals scenario3
		|naveenk|test123|
	Then user Clicks on Login Button for Deals scenario3
	And user is on Home page for Deals scenario3
	And Click on Deals Button for Deals scenario3
	Then Provide details for Deals Page for Deals scenario3
		|Deals|1|40|2|
				