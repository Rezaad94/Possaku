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

Mobile.startApplication('C:\\Users\\dagangan\\git\\Possaku\\androidapp\\possaku.apk', true)

Mobile.tap(findTestObject('Registration/Lewati Button - Welcome Screen'), 0)

Mobile.tap(findTestObject('Registration/Tap - Nama Usaha'), 0)

Mobile.setText(findTestObject('Registration/SetText - Nama Usaha'), 'Toko Halo', 0)

Mobile.tap(findTestObject('Registration/Tap - Nama Pengguna'), 0)

Mobile.setText(findTestObject('Registration/SetText - Nama pengguna'), 'Hallo Sya', 0)

Mobile.scrollToText('nomor')

Mobile.tap(findTestObject('Registration/Tap - Lokasi Usaha'), 0)

Mobile.setText(findTestObject('Registration/SetText - Lokasi Usaha'), 'Klaten', 0)

Mobile.tap(findTestObject('Registration/Tap - Nomor Ponsel'), 0)

Mobile.setText(findTestObject('Registration/SetText - Nomor Ponsel'), '085879214397', 0)

Mobile.tap(findTestObject('Registration/Daftar Button'), 0)

Mobile.verifyElementExist(findTestObject('Registration/Confirmation - Pop Up'), 0)


