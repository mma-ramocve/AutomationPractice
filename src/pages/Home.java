package pages;

public class Home {

    public static String womenMenuXPath = "//a[@class='sf-with-ul'][contains(text(),'Women')]";
    public static String summerDressesWomenMenuXPath = "//li[@class='sfHover']//a[contains(text(),'Summer Dresses')]";

    public static String dressesMenuXPath = "//*[@id=\"block_top_menu\"]/ul/li[2]/a";
    public static String summerDressesDressesMenuXPath = "//*[@id=\"block_top_menu\"]/ul/li[2]/ul/li[3]/a";

    public static String homeUrl = "http://automationpractice.com/index.php";
    public static String driverPath = "chromedriver.exe";

    public static String searchXPath = "//input[@id='search_query_top']";
    public static String submitXPath = "//button[@name='submit_search']";

    public static String FaceBookLinkXPath = "//li[@class='facebook']//a";
    public static String TwitterLinkXPath = "//li[@class='twitter']//a";
    public static String YouTubeLinkXPath = "//li[@class='youtube']//a";



}
