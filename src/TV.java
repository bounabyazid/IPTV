import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import java.awt.List;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import uk.co.caprica.vlcj.component.EmbeddedMediaPlayerComponent;
import uk.co.caprica.vlcj.runtime.RuntimeUtil;

import com.sun.jna.NativeLibrary;

public class TV extends Frame {

	public boolean playing = true;
	private static final long serialVersionUID = 1L;
	public List list = null;
	static  EmbeddedMediaPlayerComponent MP = null;
	private JPanel LVideo = null;
	public Vector<CHANNEL> Chaines = new Vector<CHANNEL>();  //  @jve:decl-index=0:
	private JLabel Recherche = null;
	private JTextField jTextField = null;
	private JLabel Label1 = null;
	private JSlider CtrlVolume = null;
	
	public int Volume = 0;
	private boolean FullScreen = false,LChannel = true;
	private JLabel Label2 = null;
	private JLabel Label3 = null;
	
	private double width = 900,height = 555;

	public TV() throws HeadlessException {
		super();
		initialize();
	}

	public TV(GraphicsConfiguration gc) {
		super(gc);
		initialize();
	}

	public TV(String title) throws HeadlessException {
		super(title);
		initialize();
	}

	public TV(String title, GraphicsConfiguration gc) {
		super(title, gc);
		initialize();
	}

		private List getList() {
		if (list == null) {
			list = new List();
			list.setBounds(new Rectangle(10, 80, 270, 465));
			list.setBackground(Color.white);
			list.setFont(new Font("Dialog", Font.BOLD, 14));
			
			list.addMouseListener(new java.awt.event.MouseAdapter() 
			{
				public void mouseClicked(java.awt.event.MouseEvent e) 
				{
				 if (e.getClickCount() == 2)
				 {
					 String[] options = {
				                ":file-caching=0",
				                ":network-caching=10000",
				                ":sout = #transcode{vcodec=h264," +
				                "vb=800,scale=0.25,acodec=none,fps=23}:display :no-sout-rtp-sap :no-sout-standard-sap :ttl=1 :sout-keep"};

					 MP.getMediaPlayer().playMedia("http://163.172.52.182:8789/live/serversportp2/PMM106scdO/1.ts",options);
							 //Chaines.elementAt(list.getSelectedIndex()).Url,options);
					 //MP.getMediaPlayer().playMedia(Chaines.elementAt(list.getSelectedIndex()).toString());
				 }
				}
			});
		}
		return list;
	}

	private void initialize()
	{
		NativeLibrary.addSearchPath(RuntimeUtil.getLibVlcLibraryName(),"/usr/bin/vlc");
		Label3 = new JLabel();
		Label3.setBounds(new Rectangle(352, 515, 26, 26));
		Label3.setText("");
		Label3.setEnabled(false);
		Label3.setIcon(new ImageIcon(getClass().getResource("/MediaPlayer/TVChannel.png")));
		Label3.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent e) 
			{
              if(LChannel)
              {
			    list.setVisible(false);
                jTextField.setVisible(false);
                Recherche.setVisible(false);
                LVideo.setBounds(new Rectangle(10, 30, 880, 480));
                
                MP.setSize(880, 480);

                LChannel = false;
              }
              else
              {
            	list.setVisible(true);
                jTextField.setVisible(true);
                Recherche.setVisible(true);  
				LVideo.setBounds(new Rectangle(290, 30, 600, 480));

                LChannel = true;
              }
			}
		});
		
		Label2 = new JLabel();
		Label2.setBounds(new Rectangle(320, 515, 26, 26));
		Label2.setText("");
		Label2.setIcon(new ImageIcon(getClass().getResource("/MediaPlayer/Maximiser.png")));
		Label2.addMouseListener(new java.awt.event.MouseAdapter() 
		{
			public void mouseClicked(java.awt.event.MouseEvent e) 
			{
			   if(!FullScreen)
			   {
				Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
				width = screenSize.getWidth();
				height = screenSize.getHeight();
				
				TV.this.setLocation(0,0);
				TV.this.setSize((int)width, (int)height);
				
				list.setBounds(new Rectangle(10, 78, 265, (int)height-80));
				LVideo.setBounds(new Rectangle(290, 30, (int)width-290, (int)height-80));
				CtrlVolume.setBounds(new Rectangle((int)width-210, (int)height-41, 200, 30));
				
				Label1.setBounds(new Rectangle(290, (int)height-40, 26, 26));
				Label2.setBounds(new Rectangle(320, (int)height-40, 26, 26));
				Label3.setBounds(new Rectangle(352, (int)height-40, 26, 26));
				
				FullScreen = true;
				Label2.setIcon(new ImageIcon(getClass().getResource("/MediaPlayer/Minimiser.png")));
				//JOptionPane.showMessageDialog(TV.this,MP.getMediaPlayer().getVolume());
			   }
			   else
			   {
				width = 900;
			    height = 555;
					
				TV.this.setSize(900, 555);
				TV.this.setLocationRelativeTo(null);
				
				list.setBounds(new Rectangle(10, 80, 270, 465));
				LVideo.setBounds(new Rectangle(290, 30, 600, 480));
				CtrlVolume.setBounds(new Rectangle(690, 515, 200, 30));
				
				Label1.setBounds(new Rectangle(290, 515, 26, 26));
				Label2.setBounds(new Rectangle(320, 515, 26, 26));
				Label3.setBounds(new Rectangle(352, 515, 26, 26));

				Label2.setIcon(new ImageIcon(getClass().getResource("/MediaPlayer/Maximiser.png")));
				FullScreen = false;  
			   }
			}
		});
		Label1 = new JLabel();
		Label1.setBounds(new Rectangle(290, 515, 26, 26));
		Label1.setIcon(new ImageIcon(getClass().getResource("/MediaPlayer/Pause.png")));
		Label1.setText("");
		Label1.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent e) {
             if(playing)
             {
               playing = false;
               Label1.setIcon(new ImageIcon(getClass().getResource("/MediaPlayer/Play.png")));
               MP.getMediaPlayer().pause();
             }
             else
             {
                 playing = true;
                 Label1.setIcon(new ImageIcon(getClass().getResource("/MediaPlayer/Pause.png")));
                 MP.getMediaPlayer().play();
             }
			}
		});
		
		Recherche = new JLabel();
		Recherche.setBounds(new Rectangle(240, 37, 41, 34));
		Recherche.setIcon(new ImageIcon(getClass().getResource("/loup.jpg")));
		Recherche.setText("");
		Recherche.addMouseListener(new java.awt.event.MouseAdapter() {
			@SuppressWarnings("deprecation")
			public void mouseClicked(java.awt.event.MouseEvent e) {
                int i = 0;
				while( i< list.countItems())
                {
			       if(list.getItem(i).toString().contains(jTextField.getText()))
			       {
                    list.select(i);
                    break;
                   }
			       else
			        i++;
                }
			}
		});
		
		MP = new EmbeddedMediaPlayerComponent();
		MP.getMediaPlayer().setEnableMouseInputHandling(true);
		MP.getMediaPlayer().setRepeat(true);
		MP.getMediaPlayer().setFullScreen(true);
		MP.getMediaPlayer().setVolume(400);
		
		LVideo = new JPanel();
		//LVideo.setBounds(new Rectangle(10, 30, 879, 480));
		LVideo.setBounds(new Rectangle(290, 30, 600, 480));
		
		LVideo.setLayout(new BorderLayout());
		LVideo.add(MP,BorderLayout.CENTER);
		//LVideo.setVisible(true);
		
		MediaPlayerPanel mpp = new MediaPlayerPanel();
		this.add(mpp, BorderLayout.CENTER);
	
		this.setLayout(null);
		this.setSize(900, 555);
		this.setResizable(false);
		this.setTitle("YAZID BOUNAB TV :");
		this.setVisible(false);
		
		this.add(getList(), null);
		this.add(getJTextField(), null);
		this.add(Recherche, null);

		this.add(LVideo, null);
		this.add(Label1, null);
		this.add(getCtrlVolume(), null);
		this.add(Label2, null);
		this.add(Label3, null);
		
		this.setLocationRelativeTo(null);
		this.addWindowListener(new java.awt.event.WindowAdapter() {
			public void windowClosing(java.awt.event.WindowEvent e) {
				System.exit(0);
			}
		});
	}

	private JTextField getJTextField() {
		if (jTextField == null) {
			jTextField = new JTextField();
			
			jTextField.setBounds(new Rectangle(13, 36, 225, 35));
		}
		return jTextField;
	}
	
	private JSlider getCtrlVolume() {
		if (CtrlVolume == null) {
			CtrlVolume = new JSlider();
			CtrlVolume.setBounds(new Rectangle(599, 515, 291, 30));
			CtrlVolume.setMinorTickSpacing(10);
			CtrlVolume.setMajorTickSpacing(100);
			//CtrlVolume.setPaintTicks(true);
			CtrlVolume.setPaintLabels(true);
			
			CtrlVolume.setOrientation(SwingConstants.HORIZONTAL);
			/*CtrlVolume.setMinimum(LibVlcConst.MIN_VOLUME);
			CtrlVolume.setMaximum(LibVlcConst.MAX_VOLUME);*/
			
			CtrlVolume.setMinimum(0);
			CtrlVolume.setMaximum(400);
			
			CtrlVolume.setLabelTable(CtrlVolume.createStandardLabels(100));
			CtrlVolume.addChangeListener(new javax.swing.event.ChangeListener() 
			{
				public void stateChanged(javax.swing.event.ChangeEvent e) 
				{
				  /*MP.getMediaPlayer().setVolume(CtrlVolume.getValue());
			 	  if(CtrlVolume.getValue()>100)	
				    MP.getMediaPlayer().setVolume(Volume+(CtrlVolume.getValue()*Volume/100));*/
			 	 MP.getMediaPlayer().setVolume(CtrlVolume.getValue());
				}
			});
		}
		return CtrlVolume;
	}
}