package com.steps.registration
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
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

import com.kms.katalon.core.webui.exception.WebElementNotFoundException

import cucumber.api.java.en.And
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When


class RegistrationSteps {

	@Given ("User navigate to Registration Page")
	def navigateToRegistpage() {
		println ("\n Navigate To Regist Page")

		Mobile.tap(findTestObject('Registration/Lewati Button - Welcome Screen'), GlobalVariable.G_Timeout)
	}

	@When ("User input (.*), (.*), (.*) and (.*)")
	def inputinfo(nama_usaha, nama_pengguna, lokasi_usaha, nomor_ponsel) {
		println ("\n Input info")

		if (nama_usaha == "empty" && nama_pengguna == "empty" && lokasi_usaha == "empty" && nomor_ponsel == "empty") {

			Mobile.scrollToText('nomor')
		} else {

			Mobile.tap(findTestObject('Registration/Tap - Nama Usaha'), GlobalVariable.G_Timeout)

			Mobile.setText(findTestObject('Registration/SetText - Nama Usaha'), nama_usaha ,GlobalVariable.G_Timeout)

			Mobile.tap(findTestObject('Registration/Tap - Nama Pengguna'), GlobalVariable.G_Timeout)

			Mobile.setText(findTestObject('Registration/SetText - Nama pengguna'), nama_pengguna , GlobalVariable.G_Timeout)

			Mobile.scrollToText('nomor')

			Mobile.tap(findTestObject('Registration/Tap - Lokasi Usaha'), GlobalVariable.G_Timeout)

			Mobile.setText(findTestObject('Registration/SetText - Lokasi Usaha'), lokasi_usaha, GlobalVariable.G_Timeout)

			Mobile.tap(findTestObject('Registration/Tap - Nomor Ponsel'), GlobalVariable.G_Timeout)

			Mobile.setText(findTestObject('Registration/SetText - Nomor Ponsel'), nomor_ponsel, GlobalVariable.G_Timeout)
		}
	}


	@And ("Click Daftar Button")
	def clickDaftarButton() {
		println ("\n Click Daftar Button")

		Mobile.tap(findTestObject('Registration/Daftar Button'), GlobalVariable.G_Timeout)
	}

	@Then ("Verify that registration is invalid")
	def invalidVerification () {
		println ("\n Varification Steps")

		Mobile.verifyElementExist(findTestObject('Registration/Confirmation - Pop Up'), GlobalVariable.G_Timeout)
	}
}