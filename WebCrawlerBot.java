package WebCrawler;

import java.io.IOException;
import java.util.ArrayList;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class WebCrawlerBot implements Runnable {
	private static final int MAX_DEPTH = 3;
	private Thread thread;
	private String first_link;
	private ArrayList<String> visitedLinks = new ArrayList<String>();
	private int ID;
	
	//Constructor of WebCrawlerBot
	public WebCrawlerBot(String link, int num) {
		System.out.println("WebCrawler #" + num + " created");
		first_link = link;
		ID = num;
		
		thread = new Thread(this);
		thread.start();
	}
	
	@Override
	public void run() {
		//Begin crawling
		crawl(1, first_link);
	}

	private void crawl(int level, String url) {
		//Recursively crawl through links to depth
		if(level <= MAX_DEPTH) {
			//HTTP request 
			Document doc = request(url);
			
			//If request is good, extract links from webpage and crawl
			if(doc != null) {
				for(Element link : doc.select("a[href]")) {
					String next_link = link.absUrl("href");
					if(visitedLinks.contains(next_link) == false) {
						crawl(level++, next_link);
					}
				}
			}
		}
	}

	private Document request(String url) {
		try {
			//Connect to URL
			Connection con = Jsoup.connect(url);
			Document doc = con.get();
			
			if(con.response().statusCode() == 200) {
				//If response is 200(Good!), print information about URL
				System.out.println("\n**Bot ID:" + ID + " Received Webpage at " + url);
				String title = doc.title();
				System.out.println(title);
				//Add URL to visited list
				visitedLinks.add(url);
				
				return doc;
			}
			return null;
		} catch (IOException e) {
			return null;
		}
	}
	
	//Getter method
	public Thread getThread() {
		return thread;
	}
}
