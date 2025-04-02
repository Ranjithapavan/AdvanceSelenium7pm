package DDT_Practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderUsage {
	@Test(dataProvider="getData")
	public void testCase(String firstName,String lastName)
	{
		System.out.println("Firstname"+firstName+"Lastname"+lastName);
	}
	
	@DataProvider
	public Object[][] getData()
	{
		Object[][] objArr= new Object[3][2];
		objArr[0][0]="Ridith";
		objArr[0][1]="Bhat";
		objArr[1][0]="Ranjitha";
		objArr[1][1]="Pawar";
		objArr[2][0]="Sampath";
		objArr[2][1]="Kumar";
		return objArr;
	}

}
