import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Scraper {
   public static void main(String[] args) {
	   	try {
	   		
	   		  Document document = Jsoup.connect("https://economictimes.indiatimes.com/markets/cryptocurrency").get();		     		      
		      //System.out.println(document.title());		      
		      Element paragraphs = document.select("tbody").first();		     
		      System.out.println(paragraphs.text());		      
		      for(int i=0;i<4;i++) 
		      {
			      Element paragraphs1 = document.select("td.qc_coinname").get(i);		     
			      System.out.print(paragraphs1.text()+"\t\t");
			      
			      paragraphs1 = document.select("td.qc_value").get(i);		     
			      System.out.println(paragraphs1.text());
		      }		     	
	   	}catch(Exception ee) {ee.printStackTrace();} 
		      
   }
}