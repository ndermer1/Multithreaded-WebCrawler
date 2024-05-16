Project - Our multithreaded web crawler is a Java program that explores the
internet from the given URLs and extracts information from them. For our
specific web crawler, it prints out the hyperlinks and other URLs found on the
given websites. After that, it recursively explores the found hyperlinks and
prints the hyperlinks found within those, and so on. It does this for a given
maximum depth and prints out all of the URLs it finds with the title of its
webpage.
Input - First, the program requires a “Y” (indicating yes) or “N” (indicating no)
from the user if they would like to give their own URLs for the program to
crawl through. If the user’s answer is no, the program uses three example URLs.
If the user types yes, then the program allows the user to input as many URLs as
they want using a linked list. After the user is finished, they enter “Q”
(indicating quit) and the program begins crawling through the given URLs.
Output - After the introduction messages welcoming the user to the web crawler
bot and asking them for input, the first output is the program stating that the web
crawler bots were created. After that, it prints the URL it received through
recursively crawling and the title of the webpage. For example, if given
“https://abcnews.go.com” for a link, the very first output for it we would see is
**Bot ID:1 Received Webpage at https://abcnews.go.com
ABC News - Breaking News, Latest News and Videos
Here, we can see the first line is the URL and the second line is the title.
How To Run - To run the program, you need to install jsoup as it is a
dependency. This Java library allows easy access for URL fetching and
extraction of real-world webpages. After the .jar file is installed and added to
the program’s build path, the program is ready to be run. The file for jsoup can
be installed here https://jsoup.org/download .
