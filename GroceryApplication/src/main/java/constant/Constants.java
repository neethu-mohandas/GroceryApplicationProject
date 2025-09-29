package constant;

public class Constants {

	public static final String VALIDCREDENTIALERROR = "User couldnot login with valid credentials";
	public static final String INVALIDUSERNAMEERROR = "User able to login with invalid username";
	public static final String INVALIDPASSWORDERROR = "User able to login with invalid password";
	public static final String INVALIDCREDENTIALSERROR = "User able to login with invalid credentials";

	public static final String LOGOUTERROR = "User not able to logout";

	public static final String ADDNEWADMINUSERERROR = "User not able to add new admin user";
	public static final String SEARCHADMINUSERERROR = "User couldnot search the admin users list";
	public static final String RESETADMINUSERERROR = "User couldnot reset the admin users list";

	public static final String ADDNEWSERROR = "User not able to save the entered news";
	public static final String SEARCHNEWSERROR = "User not able to get correct news search results";
	public static final String RESETNEWSERROR = "User couldnot reset the news";

	public static final String EXCELPATH = System.getProperty("user.dir") + "\\src\\test\\resources\\Testdata.xlsx";

	public static final String CONFIGPATH = System.getProperty("user.dir")
			+ "\\src\\main\\resources\\config.properties";

}
