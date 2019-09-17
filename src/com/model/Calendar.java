package com.model;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Calendar 
{
public static void main(String[] args) throws InterruptedException 
{
	System.setProperty("webdriver.chrome.driver", "D:\\cjc Software\\Testing\\chromedriver_win32\\chromedriver.exe");
	WebDriver driver=new ChromeDriver();
	driver.get("https://www.path2usa.com/travel-companions");
	driver.manage().window().maximize();
	driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
	
	driver.findElement(By.id("travel_date")).click();
	while(!driver.findElement(By.cssSelector("[class='datepicker-days'] [class='datepicker-switch']")).getText().contains("May"))
	{
		//System.out.println("hi");
	driver.findElement(By.cssSelector("[class='datepicker-days'] [class='next']")).click();
	}
	List<WebElement>ls=driver.findElements(By.className("day"));
	int count=ls.size();
	Thread.sleep(5000);
	System.out.println("The nomber of day are :"+count);
	for(int i=0;i<count;i++)
	{
	String text= driver.findElements(By.className("day")).get(i).getText();
	System.out.println(text);
	//Thread.sleep(5000);
	if(text.equals("18"))
	{
		driver.findElements(By.className("day")).get(i).click();
		break;
	}
	}
}
}
