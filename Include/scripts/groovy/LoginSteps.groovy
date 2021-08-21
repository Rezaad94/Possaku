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



class LoginSteps {

	@Given ("User Open App")
	def openApp() {
		println ("\n Openapp Steps")

		def appPath = PathUtil.relativeToAbsolutePath(GlobalVariable.G_androidApp, RunConfiguration.getProjectDir())
		
		Mobile.startApplication(appPath, true)
	}

	@And("User Navigate to Login Page")
	def navigateToLoginPage() {
		println ("\n navigeteToLoginPage Steps")

		Mobile.tap(findTestObject('Login/TapSlide1'), GlobalVariable.G_Timeout)

		Mobile.tap(findTestObject('Login/TapSlide2'), GlobalVariable.G_Timeout)

		Mobile.tap(findTestObject('Login/TapSlideFinish'), GlobalVariable.G_Timeout)

		Mobile.tap(findTestObject('Login/LinkLogin'), GlobalVariable.G_Timeout)
	}

	@When("User input (.*) and (.*)")
	def enterCredential(phone, PIN) {
		println ("\n enterCredential Steps")
		
		if (phone == "empty" && PIN == "empty") {
						
			Mobile.tap(findTestObject('Login/TapInput - Nomor Hanphone 2'), GlobalVariable.G_Timeout)
			
			Mobile.tap(findTestObject('Login/TapInputPIN'), GlobalVariable.G_Timeout)
			
		} else if(phone != "empty" && PIN == "empty") {
			
			Mobile.tap(findTestObject('Login/TapInput - Nomor Hanphone 2'), GlobalVariable.G_Timeout)
			
			Mobile.setText(findTestObject('Login/SetText - Nomor Handphone'), phone, GlobalVariable.G_Timeout)
			
			Mobile.tap(findTestObject('Login/TapInputPIN'), GlobalVariable.G_Timeout)
			
			
		} else if(phone == "empty" && PIN != "empty") {
			
			Mobile.tap(findTestObject('Login/TapInput - Nomor Hanphone 2'), GlobalVariable.G_Timeout)

			Mobile.tap(findTestObject('Login/TapInputPIN'), GlobalVariable.G_Timeout)

			Mobile.setText(findTestObject('Login/SetTextPIN'), PIN, GlobalVariable.G_Timeout)
		} 
		
		else {

			Mobile.tap(findTestObject('Login/TapInput - Nomor Hanphone 2'), GlobalVariable.G_Timeout)

			Mobile.setText(findTestObject('Login/SetText - Nomor Handphone'), phone, GlobalVariable.G_Timeout)

			Mobile.tap(findTestObject('Login/TapInputPIN'), GlobalVariable.G_Timeout)

			Mobile.setText(findTestObject('Login/SetTextPIN'), PIN, GlobalVariable.G_Timeout)
		}
	}

	@And("User click login button")
	def clickLoginButton() {
		println ("\n clickLoginButton Steps")

		Mobile.tap(findTestObject('Login/LoginButton'), GlobalVariable.G_Timeout)
	}

	@Then ("User navigate to home page")
	def navigateToHomePage () {
		println ("\n navigateToHomePage Steps")

		Mobile.verifyElementExist(findTestObject('Login/SearchProduk'), GlobalVariable.G_Timeout)
	}
	
	@Then ("Verification Invalid Login Appear")
	def verificationFailed () {
		println ("\n Verification Appear")
		
		if (Mobile.verifyElementExist(findTestObject('Login/TapInput - Nomor Hanphone 2'), GlobalVariable.G_Timeout, FailureHandling.OPTIONAL)) {
			
			def phone = Mobile.getAttribute(findTestObject('Login/TapInput - Nomor Hanphone 2'), 'text', GlobalVariable.G_Timeout)
			def PIN = Mobile.getAttribute(findTestObject('Login/TapInputPIN'), 'text', GlobalVariable.G_Timeout)
		
			println (phone)
			println (PIN)
			
			if (phone == "Nomor Handphone" && PIN == "") {
				println ("\n in verif 1")
				Mobile.verifyElementExist(findTestObject('Login/warning message - input phone number'), GlobalVariable.G_Timeout)
				
				Mobile.verifyElementExist(findTestObject('Login/warning message - input pin number'), GlobalVariable.G_Timeout)
			
			} else if(phone == "Nomor Handphone" && PIN != "") {
				println ("\n in verif 2")
				Mobile.verifyElementExist(findTestObject('Login/warning message - input phone number'), GlobalVariable.G_Timeout)
			 
			} else(phone != "Nomor Handphone" && PIN == "") {
				println ("\n in verif 3")
				
				Mobile.verifyElementExist(findTestObject('Login/warning message - input pin number'), GlobalVariable.G_Timeout)
			}
			
		} else {
			 println ("\n in verif 4")
			 Mobile.verifyElementExist(findTestObject('Login/Pop Up mesaage - login Failed'), GlobalVariable.G_Timeout)
		}
	}
}