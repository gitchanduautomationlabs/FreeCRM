Feature: Free CRM Login with Data Driven 

# With out Examples Key word in Data Provider 
#Scenario: Login Free CRm 

	#When user is on login Page 
	#Then Tile is Free CRM 
	#Then provide "naveenk" and "test123" 
	#Then Click on Login Button 
	#And User On Home Page 
	#Then Close the Browser "yes"
   
   
Scenario Outline: Login Free CRm 

	When user is on login Page 
	Then Tile is Free CRM 
	Then provide "<userName>" and "<password>" 
	Then Click on Login Button
	And User On Home Page and "<browser>" 
	Then Close the Browser "yes" 
	
	  Examples:
	  
	  	|userName|password||browser|
	  	|naveenk|test123||Yes|
	  	|naveenk|test@123||No|
	  	|naveenk|test1234||No|
	  	
	  
	  
	  	
	  