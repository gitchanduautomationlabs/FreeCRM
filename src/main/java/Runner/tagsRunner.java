package Runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "C:\\Practice LeanFT and Selenium\\freeCRMCucumber\\src\\main\\java\\Features\\TagsUsing.feature"
/* the path of the feature File */
		, glue = { "StepDefinations" }, /* The Path of the Definition File */
		format = { "pretty", "html:test-outputtags" ,"json:json_output/cucumber.json","junit:junit_xml/cucumber.xml" }, 
		dryRun = false, /*To check the mapping proper between feature and step definition file*/
		monochrome = true  /*Display the Output in console in pretty output means Readable Formate*/
		,strict= true   /*It will check if any step is not defined in step definition file */
		/*,tags= {"@Sanity,@Reggression"}*/  /*Either Sanity or Regression like OR Condition*/
		,tags= {"@Sanity","@Reggression"}   /*Should Sanity or Regression like And Condition*/
		)
public class tagsRunner {

}
