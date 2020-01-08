Feature: Adding New Contact in Free CRM 

    Background:
    
    When user is on login Page for new Contact 
	Then Tile is Free CRM for new Contact
	Then provide "naveenk" and "test123" for new Contact 
	Then Click on Login Button for new Contact
    And User On Home Page and "<browser>" for new Contact
	And User click on Contact Page

#Scenario Outline: Redirecting To New Contact 
#
#	
#	
#	Then Close the Browser for new Contact
#	
#	
#	Examples: 
#	
#		|userName|password||browser|
#		|naveenk|test123||Yes|
		
	  	 

Scenario Outline: Adding New Contact 

	#When user is on new Contact Page
	Then Provide deatils for contact page "<FirstName>" and "<lastName>" and "<Postion>"
		
	
	Examples: 
	
		|FirstName|lastName||Postion|
		|chandu|sekhar||4|
		|chandra Sekhar|M||3|
			  	 