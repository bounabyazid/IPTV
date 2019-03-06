import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Rectangle;

import javax.swing.JPanel;

import uk.co.caprica.vlcj.player.MediaPlayerFactory;
import uk.co.caprica.vlcj.player.embedded.EmbeddedMediaPlayer;

public class MediaPlayerPanel extends JPanel {

    private static final long serialVersionUID = 1L;


    MediaPlayerFactory mediaPlayerFactory = new MediaPlayerFactory();
    EmbeddedMediaPlayer mediaPlayer = mediaPlayerFactory.newEmbeddedMediaPlayer();
    Canvas c = new Canvas();
    JPanel p = new JPanel();



    public MediaPlayerPanel()   {



        c.setBackground(Color.black);
        p.setBounds(new Rectangle(290, 30, 600, 480));
        p.setLayout(new BorderLayout());
        p.add(c, BorderLayout.CENTER);


        mediaPlayer.setVideoSurface(mediaPlayerFactory.newVideoSurface(c));
        mediaPlayer.setRepeat(true);
        
        c.setVisible(true);       
        p.setVisible(true);
    }

    public  void play(String video,String[] options) {

        mediaPlayer.playMedia(video,options);

    }

}
