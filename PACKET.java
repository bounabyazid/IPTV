package polo;

import java.util.Vector;

import javax.swing.ImageIcon;

public class PACKET 
{
	private String Name = "",Link = "";
	private ImageIcon img = null;
	private Vector<String> Channels = new Vector<String>();
	
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getLink() {
		return Link;
	}
	public void setLink(String link) {
		Link = link;
	}
	public ImageIcon getImg() {
		return img;
	}
	public void setImg(ImageIcon img) {
		this.img = img;
	}
	public Vector<String> getChannels() {
		return Channels;
	}
	public void setChannels(Vector<String> channels) {
		Channels = channels;
	}
	
}
