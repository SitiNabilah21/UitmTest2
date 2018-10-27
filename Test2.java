/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 *//**SITI NABILAH BINTI MOHAMMAD ZAIN
 * 2017421006 
 * TEST2 : WEB SCRAPPER JAVA
 * 
 *
 * @author smohammadzai
 */
package test.pkg2;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;



public class Test2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here  public static void main(String[] args) {
        print("Fetching....");
		Document document;
		try {
			//Get Document object after parsing the html from given url.
			document = Jsoup.connect("https://en.wikipedia.org/wiki/JavaScript").get();
                        
                        Elements contents = document.select("#toc"); //Get table of contents
                        print("\n " + contents.text());  //Print table of contents
			   
                     
                       Elements media = document.select("[src]");//Get pictures
        
                        print("\nPictures:" + media.size()); //Print pictures
                        for (Element src : media) {
                            if (src.tagName().equals("img"))
                                print(" "+ src.tagName()+ src.attr("abs:src")+ src.attr("width")+ src.attr("height"));
                    else
                        print(" " + src.tagName() + src.attr("abs:src"));
        }
                        
                        Elements ref = document.select("#mw-content-text > div > div.reflist.columns.references-column-width");//Get references
                        //System.out.println(ref.get(0).text()); //Print References
                        print("\nReferences:" + ref.text());
                        
                    

		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	public static void print(String string) {
		System.out.println(string);
    }

    }
    

