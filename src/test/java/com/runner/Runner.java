package com.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(publish = true,
plugin = { "pretty", 
		"html:target/site/cucumber-pretty", 
		"rerun:target/rerun.txt",
	    "json:target/cucumber.json",
	},

	features = { "./src/test/resources/Login.feature",
			
}, 
	glue = { "com.stepdef" }, // step def package name
	monochrome = true// remove all ?? & console will be easily readable 
	//dryRun = true,//check feature file 
	//strict = true //stepdef>>every step has code or not
	//,tags= {"@ScenarioTwo"}
)

public class Runner extends AbstractTestNGCucumberTests {

	
	
}
