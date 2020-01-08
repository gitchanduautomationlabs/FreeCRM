package Runner;

import cucumber.api.junit.Cucumber;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "C:\\Practice LeanFT and Selenium\\freeCRMCucumber\\src\\main\\java\\Features\\login.feature"
/* the path of the feature File */
		, glue = { "StepDefinations" }, /* The Path of the Definition File */
		format = { "pretty", "html:test-output" ,"json:json_output/cucumber.json","junit:junit_xml/cucumber.xml" }, 
		dryRun = false, /*To check the mapping proper between feature and step definition file*/
		monochrome = true  /*Display the Output in console in pretty output means Readable Formate*/
		,strict= true   /*It will check if any step is not defined in step definition file */
		
		)
public class testRunner {

}
