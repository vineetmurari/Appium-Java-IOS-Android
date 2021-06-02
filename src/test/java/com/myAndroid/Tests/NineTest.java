package com.myAndroid.Tests;

import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

import org.testng.annotations.BeforeTest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;

public class NineTest {

	@BeforeTest
	public void beforeTest() {
		try {
			Runtime.getRuntime().exec("cmd /c start cmd.exe /K \"emulator -avd Emulator123\"");
		} catch (Exception e) {
			System.out.println("HEY Buddy ! U r Doing Something Wrong ");
			e.printStackTrace();
		}
	}

	@Test
	public void f() throws Exception {

		AndroidDriver<AndroidElement> driver;

		DesiredCapabilities capabilities = new DesiredCapabilities();

		capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Android");
		capabilities.setCapability(MobileCapabilityType.VERSION, "5.0.4");
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Emulator123");
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
		capabilities.setCapability(MobileCapabilityType.APP,
				"C:\\Users\\Dell\\Desktop\\Tutorials\\Mobile Test Apps\\ApiDemos-debug.apk");
		capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "60");

		driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

		Thread.sleep(2000);

		AndroidElement Views = driver.findElementByAccessibilityId("Views");
		Views.click();
		Thread.sleep(2000);
		driver.quit();

	}

	@AfterTest
	public void afterTest() throws Exception {

		// Create an arrayList
		ArrayList<String> CMD_PID = new ArrayList<String>();

		// Kill Command
		String KILL = "taskkill /IM ";

		// Kill qemu-system-i386.exe
		Runtime.getRuntime().exec(KILL + "qemu-system-i386.exe"); ///EMULATOR IS CLOSED
		
		System.out.println("CLOSED EMULATOR");

		Thread.sleep(4000);

		// Kill Command
		String TASKLIST = "tasklist /fi \"imagename eq cmd.exe\" /fo list /v ";

		Process p1 = Runtime.getRuntime().exec(TASKLIST);

		BufferedReader reader = new BufferedReader(new InputStreamReader(p1.getInputStream()));
		String line;
		while ((line = reader.readLine()) != null) {
			if (line.contains("Window") || line.contains("PID")) {
				CMD_PID.add(line);
			}
		}

		String KILL_PID = "Taskkill /PID %1$s /F ";

		for (int i = 0; i < CMD_PID.size(); i++) {
			if (CMD_PID.get(i).contains("Emulator")) {
				String killpid = String.format(KILL_PID, CMD_PID.get(i - 1).replace("PID", "").replace(":", "").trim());
				Runtime.getRuntime().exec(killpid);
				Thread.sleep(5000);

			}
		}
	}
}
