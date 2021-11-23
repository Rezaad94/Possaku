package com.steps.kasir
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



class Kasir {
	@Given ("User navigate to chasier page")
	def navigateToChasierPage () {
		
//		Mobile.tap(findTestObject('Login/LewatiButton'), GlobalVariable.G_Timeout)
//
//		Mobile.tap(findTestObject('Login/LinkLogin'), GlobalVariable.G_Timeout)
//
//		Mobile.tap(findTestObject('Login/TapInput - Nomor Hanphone 2'), GlobalVariable.G_Timeout)
//
//		Mobile.setText(findTestObject('Login/SetText - Nomor Handphone'), '085879214397', GlobalVariable.G_Timeout)
//
//		Mobile.tap(findTestObject('Login/TapInputPIN'), GlobalVariable.G_Timeout)
//
//		Mobile.setText(findTestObject('Login/SetTextPIN'), '111111', GlobalVariable.G_Timeout)
//
//		Mobile.tap(findTestObject('Login/LoginButton'), GlobalVariable.G_Timeout)
//		

		Mobile.tapAndHold(findTestObject('Kasir/KasirMenuButton'), GlobalVariable.G_Timeout, GlobalVariable.G_Timeout)
	}

	@And("User select item from katalog")
	def selectItem () {
		Mobile.tap(findTestObject('Kasir/KatalogButton'), GlobalVariable.G_Timeout)

		Mobile.tapAndHold(findTestObject('Kasir/PencilItem'), GlobalVariable.G_Timeout, GlobalVariable.G_Timeout)

		Mobile.tapAndHold(findTestObject('Kasir/TambahkanButton'), GlobalVariable.G_Timeout, GlobalVariable.G_Timeout)

		Mobile.tap(findTestObject('Kasir/Konfirmasi Stock 0 Button'), GlobalVariable.G_Timeout)
	}

	@And("User navigate to cart page")
	def toCartPage () {
		Mobile.tapAndHold(findTestObject('Kasir/KeranjangButton'), GlobalVariable.G_Timeout, GlobalVariable.G_Timeout)
	}

	@And ("User select Tunai Method payment")
	def tunaiMethod () {
		Mobile.tap(findTestObject('Kasir/Bayar Button (Keranjang Page)'), GlobalVariable.G_Timeout)

		Mobile.tap(findTestObject('Kasir/Tunai Method Button'), GlobalVariable.G_Timeout)
	}

	@When ("User finish transaction")
	def finishTransaction () {
		def device_height = Mobile.getDeviceHeight()

		def device_width = Mobile.getDeviceWidth()

		def int StartX = (device_width / 2)

		def int EndX = StartX

		def int StartY = (device_height * 0.30)

		def int EndY = (device_height * 0.70)

		Mobile.swipe(StartX, EndY, EndX, StartY)

		Mobile.tap(findTestObject('Kasir/BayarButton (Pembayaran Page)'), GlobalVariable.G_Timeout)

		Mobile.tap(findTestObject('Kasir/Konfirmasi Ya Pembayaran Button'), GlobalVariable.G_Timeout)
	}

	@Then ("User Navigate to success page")
	def navigateToSuccess () {
		Mobile.verifyElementExist(findTestObject('Kasir/Transaksi berhasil'), GlobalVariable.G_Timeout)
	}
}