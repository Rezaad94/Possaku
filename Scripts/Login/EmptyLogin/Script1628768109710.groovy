import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

def appPath = PathUtil.relativeToAbsolutePath(GlobalVariable.G_androidApp, RunConfiguration.getProjectDir())
		
Mobile.startApplication(appPath, true)

Mobile.swipe(1, 0, 0, 0)

Mobile.tap(findTestObject('Login/TapSlide1'), 0)

Mobile.tap(findTestObject('Login/TapSlide2'), 0)

Mobile.tap(findTestObject('Login/TapSlideFinish'), 0)

Mobile.tap(findTestObject('Login/LinkLogin'), 0)

Mobile.tap(findTestObject('Login/TapInput - Nomor Handphone'), 0)

Mobile.setText(findTestObject('Login/SetText - Nomor Handphone'), '', 0)

Mobile.tap(findTestObject('Login/TapInputPIN'), 0)

Mobile.setText(findTestObject('Login/SetTextPIN'), '', 0)

Mobile.tap(findTestObject('Login/LoginButton'), 0)

Mobile.delay(3, FailureHandling.STOP_ON_FAILURE)

Mobile.closeApplication()

