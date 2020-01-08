Feature: Using Maps on Deals Page 

Scenario: Using Maps on Deals 

	Given user already Login page for Dealsmap 
	When Title of login Page is Free CRM for Dealsmap 
	Then user Enters User Name and Password for Dealsmap 
		|user|pwd|
		|naveenk|test123|
	Then user Clicks on Login Button for Dealsmap 
	And user is on Home page for Dealsmap 
	And Click on Deals Button for Dealsmap 
	Then Provide details for Deals Page for Dealsmap 
		|DealsTitle|probability|amount|commision|
		|Deals1|1|40|2|
		|Deals2|2|50|3|
		|Deals3|3|60|4|
		