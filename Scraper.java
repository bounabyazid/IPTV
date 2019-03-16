package polo;

import java.util.List;
import java.util.Vector;

import javax.swing.JOptionPane;

import org.jsoup.Jsoup;
import org.jsoup.helper.Validate;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class Scraper {

	static String URL="https://www.iptvsat.com";
	static String packetsList="";
	static String imgLinks = "";
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//document.getElementById("td_uid_4_5c8ca392137b4").getElementsByClassName("td-image-wrap")[0].getAttribute("href")
		
		try{
		Document document = Jsoup.connect(URL).get();
//		JOptionPane.showMessageDialog(null,"start");
//		JOptionPane.showMessageDialog(null,document.title());
//		JOptionPane.showMessageDialog(null,"end");
				
		Element parent = document.getElementsByClass("tdc-row").first();
		Elements packets = parent.getElementsByClass("td-image-wrap");
		
		String img ="";
	
		if(parent== null)
			System.out.println("Failed to fetch the packets");
			//TODO: 
		else
			

		
//		Vector<PACKET> VPackets = new Vector<PACKET>();
		
		for(Element packet: packets){
			String link = packet.attr("href");
			
			Element imgElem = packet.getElementsByTag("img").first();
//			getElementsByTag("src");
//			JOptionPane.showMessageDialog(null, "Image "+imgElems.toString());
//			JOptionPane.showMessageDialog(null, "\nLink "+ link);
			packetsList +=imgElem.attr("src") + "\n "+ imgElem.attr("src") + img +link +"\n";
//			imgLinks +="\n "+imgLinks;
		}
		

		for(Element packet: packets){
			String link = packet.attr("href");
			
			Element imgElem = packet.getElementsByTag("img").first();
//			getElementsByTag("src");
//			JOptionPane.showMessageDialog(null, "Image "+imgElems.toString());
//			JOptionPane.showMessageDialog(null, "\nLink "+ link);
			packetsList +=imgElem.attr("src") + "\n "+link +"\n" + imgElem.attr("src");
			imgLinks +="\n ";
		}
		
		

		for(Element packet: packets){
			Elements imNodes = packet.getElementsByTag("img");

			for(Element im: imNodes){
				String img2 = im.attr("data-img-url");
				
				img += "\n" +img2;
				}
		}
		
		
		
		
		JOptionPane.showMessageDialog(null, "\nLinks \n\n "+img );
//		JOptionPane.showMessageDialog(null, "\nImage links \n\n "+ imgLinks);
		//.getAttribute("href");
		
		
	}catch(Exception e){JOptionPane.showMessageDialog(null, "Unable to access the address "+ URL);}

	}

}
