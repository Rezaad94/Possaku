package utilities
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable

import org.openqa.selenium.WebElement
import org.openqa.selenium.WebDriver
import org.openqa.selenium.By

import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.webui.driver.DriverFactory

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObjectProperty

import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.util.internal.PathUtil
import com.kms.katalon.core.webui.exception.WebElementNotFoundException

import cucumber.api.java.en.And
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When
import cucumber.api.Scenario
import cucumber.api.java.After;
import cucumber.api.java.Before;


class Hook {

	@Before
	public void beforeScenario(Scenario scenario) {
		println 'This is a before scenario method: ' + scenario.getName()
		println 'This is a before scenario method: ' + scenario.getId()
		
		String[] tab = scenario.getId().split("/");
		int rawFeatureNameLength = tab.length;
		String featureName = tab[rawFeatureNameLength - 2];
		println("featureName: " + featureName);
		
		if (featureName == "Login" || featureName == "Registration")  {
			def appPath = PathUtil.relativeToAbsolutePath(GlobalVariable.G_androidApp, RunConfiguration.getProjectDir())
			
			Mobile.startApplication(appPath, true)
		}
		else {
			def appPath = PathUtil.relativeToAbsolutePath(GlobalVariable.G_androidApp, RunConfiguration.getProjectDir())
			
			Mobile.startApplication(appPath, false)
		}

		
	}

	@After
	public void afterScenario(Scenario scenario) {
		println 'This is a after scenario method: ' + scenario.getName()
	}
}