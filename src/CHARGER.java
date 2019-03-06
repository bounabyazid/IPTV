import java.awt.Checkbox;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.TextArea;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.swing.JButton;

public class CHARGER extends Frame 
{
	private static final long serialVersionUID = 1L;
	private JButton jButton1 = null;
	private JButton jButton2 = null;
	private JButton jButton3 = null;
	private Checkbox checkbox = null;
	private TextArea textArea = null;
	
	private TV tv = new TV();
	
	public CHARGER() throws HeadlessException 
	{
		super();
		initialize();
	}

	public CHARGER(GraphicsConfiguration gc)
	{
		super(gc);
		initialize();
	}

	public CHARGER(String title) throws HeadlessException 
	{
		super(title);
		initialize();
	}

	public CHARGER(String title, GraphicsConfiguration gc) 
	{
		super(title, gc);
		initialize();
	}
	
	private JButton getJButton1() 
	{
		if (jButton1 == null) 
		{
			jButton1 = new JButton();
			jButton1.setBounds(new Rectangle(218, 318, 159, 34));
			jButton1.setText("Charger Codes");
			
			jButton1.addActionListener(new java.awt.event.ActionListener() 
			{
				public void actionPerformed(java.awt.event.ActionEvent e) 
				{
                 if(checkbox.getState())
                 {
                   String Channel = "";
                   int i = 0;
                   for (String line : textArea.getText().split("\\n"))
                   {
                	 line = line.replace("\\n", "");
                	 if(line.contains("#EXTINF:"))
                	 {
                	  i++;
                	  tv.list.add(i+":"+line.substring(11));
                	  Channel = line.substring(11);
                	 }
                	 else
                	  tv.Chaines.add(new CHANNEL(Channel,line.replaceAll("[\r\n]+", "")));   
                   }
                   jButton1.setEnabled(false);
                   jButton2.setEnabled(true);
                 }
                 else
                 {
                	 try
                     {
                		 InputStream in = getClass().getClassLoader().getResourceAsStream("TV.m3u"); 
                		 BufferedReader reader = new BufferedReader(new InputStreamReader(in));
                		 String line = null,Channel = "";
                		 int i = 0;
                         while ( (line = reader.readLine()) != null) 
                         {
                             textArea.append(line+"\n");
                             line = line.replace("\\n", "");
                             if(line.contains("#EXTINF:"))
                        	 {
                              i++;
                           	  tv.list.add(i+"-"+line.substring(11));
                        	  Channel = line.substring(11);
                        	 }
                        	 else
                        	 {
                        	  tv.Chaines.add(new CHANNEL(Channel,line.replaceAll("[\r\n]+", "")));
                        	 }
                         }
                         jButton1.setEnabled(false);
                         jButton2.setEnabled(true);
                     }
                     catch(Exception e2) { System.out.println(e2); }
                 }
				}
			});
		}
		return jButton1;
	}

	
	private JButton getJButton2() 
	{
		if (jButton2 == null) 
		{
			jButton2 = new JButton();
			jButton2.setBounds(new Rectangle(387, 318, 135, 36));
			jButton2.setEnabled(false);
			jButton2.setText("Suivant");
			jButton2.addActionListener(new java.awt.event.ActionListener() 
			{
				public void actionPerformed(java.awt.event.ActionEvent e) 
				{
                  CHARGER.this.dispose();
                  tv.setVisible(true);
				}
			});
		}
		return jButton2;
	}

	private JButton getJButton3() 
	{
		if (jButton3 == null) 
		{
			jButton3 = new JButton();
			jButton3.setBounds(new Rectangle(533, 315, 122, 38));
			jButton3.setText("Fermer");
			jButton3.addActionListener(new java.awt.event.ActionListener() 
			{
				public void actionPerformed(java.awt.event.ActionEvent e) 
				{
					System.exit(0);
				}
			});
		}
		return jButton3;
	}

	private Checkbox getCheckbox() 
	{
		if (checkbox == null) 
		{
			checkbox = new Checkbox();
			checkbox.setFont(new Font("Dialog", Font.PLAIN, 24));
			checkbox.setLocation(new Point(198, 320));
			checkbox.setSize(new Dimension(16, 30));
			checkbox.setState(false);
			checkbox.addItemListener(new java.awt.event.ItemListener() 
			{
				public void itemStateChanged(java.awt.event.ItemEvent e) 
				{
                  if(checkbox.getState())
                  {
                   jButton1.setText("Coller les Codes");
                   textArea.setEnabled(true);
                  }
                  else
                  {
                   jButton1.setText("Charger Codes");
                   textArea.setEnabled(false);
                  }
				}
			});
		}
		return checkbox;
	}

	private TextArea getTextArea() 
	{
		if (textArea == null) 
		{
			textArea = new TextArea();
			textArea.setBounds(new Rectangle(13, 38, 643, 270));
		}
		return textArea;
	}

	public static void main(String[] args) 
	{
		new CHARGER();
	}

	private void initialize() {
		this.setLayout(null);
		this.setSize(670, 366);
		this.setTitle("TV BOUNAB YAZID :");

		this.add(getJButton1(), null);
		this.add(getJButton2(), null);
		this.add(getJButton3(), null);
		this.add(getCheckbox(), null);
		this.add(getTextArea(), null);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.addWindowListener(new java.awt.event.WindowAdapter() 
		{
			public void windowClosing(java.awt.event.WindowEvent e) 
			{
				System.exit(0);
			}
		});
	}

}  //  @jve:decl-index=0:visual-constraint="20,1"
