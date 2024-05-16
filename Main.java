package WebCrawler;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		//Creates ArrayList for the bots and the scanner for user input
		ArrayList<WebCrawlerBot> bots = new ArrayList<>();
		Scanner scan = new Scanner(System.in);
		
		//Introduction Messages
		System.out.println("Welcome to Nathan and Joe's Webcrawler!");
		System.out.println("Would you like to input your own examples? Enter (Y/N)");
		String response = scan.next();
		
		//If user responds N, use example URL's
		if(response.equalsIgnoreCase("N")){
			System.out.println("Here's some examples!\nhttps://abcnews.go.com\nhttps://npr.org\nhttps://nytimes.com");
			bots.add(new WebCrawlerBot("https://abcnews.go.com", 1));
			bots.add(new WebCrawlerBot("https://npr.org", 2));
			bots.add(new WebCrawlerBot("https://nytimes.com", 3));
			
		//If user responds Y, allow them input their own URL's
		}else if(response.equalsIgnoreCase("Y")){
			ArrayList<String> URLs = new ArrayList<>();
			System.out.println("Input a URL and then press ENTER. Enter \"Q\" to finish");
			while(true) {
				//Get user response
				response = scan.next();
				//If input Q, stop taking inputs and create bots
				if(response.equalsIgnoreCase("Q")){
					for(int i=0; i<URLs.size(); i++) {
						bots.add(new WebCrawlerBot(URLs.get(i), i+1));
					}
					break;
				}else{
					//Input URL
					URLs.add(response);
				}
			}
		}else { //User inputed something that was not Y or N
			System.out.println("You have entered an invalid input.");
		}
		
		for(WebCrawlerBot w : bots) {
			//Wait for each bot's thread to finish execution
			try {
				w.getThread().join();
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
		scan.close();
	}
}
