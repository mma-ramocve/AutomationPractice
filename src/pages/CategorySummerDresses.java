package pages;

/*	Odabrati drugu haljinu koja se nalazi u Summer Dresses ponudi. Staviti u korpu dve takve haljine,
 M veličine u beloj boji.  */
public class CategorySummerDresses {
    public static String urlSummerDresses = "http://automationpractice.com/index.php?id_category=11&controller=category";
    public static String whitePrintedSummerDressXPath = "//*[@id=\"color_40\"]";
    public static String sizeXPath = "//*[@id=\"group_1\"]";
    public static String addQuantityXPath = "//*[@id=\"quantity_wanted_p\"]/a[2]/span/i";
    public static String addToCHart = "//*[@id=\"add_to_cart\"]/button/span";


}
