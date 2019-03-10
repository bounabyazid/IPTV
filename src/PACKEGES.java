import java.awt.Frame;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JCheckBox;
import javax.swing.ImageIcon;
import java.awt.Rectangle;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Checkbox;

public class PACKEGES extends Frame {

	private static final long serialVersionUID = 1L;
	private JCheckBox jCheckBox1 = null;
	private JCheckBox jCheckBox2 = null;
	private JCheckBox jCheckBox3 = null;
	private JCheckBox jCheckBox4 = null;
	private JButton jButton1 = null;
	private JButton jButton2 = null;
	private JButton jButton3 = null;
	private JButton jButton4 = null;
	public PACKEGES() throws HeadlessException {
		// TODO Auto-generated constructor stub
		super();
		initialize();
	}

	public PACKEGES(GraphicsConfiguration arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
		initialize();
	}

	public PACKEGES(String arg0) throws HeadlessException {
		super(arg0);
		// TODO Auto-generated constructor stub
		initialize();
	}

	public PACKEGES(String arg0, GraphicsConfiguration arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
		initialize();
	}

	/**
	 * This method initializes jCheckBox1	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getJCheckBox1() {
		if (jCheckBox1 == null) {
			jCheckBox1 = new JCheckBox();
			jCheckBox1.setIcon(new ImageIcon(getClass().getResource("/Icons/fransh.png")));
			jCheckBox1.setBounds(new Rectangle(35, 54, 180, 180));
			jCheckBox1.setBackground(Color.white);
			jCheckBox1.setText("");
		}
		return jCheckBox1;
	}

	/**
	 * This method initializes jCheckBox2	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getJCheckBox2() {
		if (jCheckBox2 == null) {
			jCheckBox2 = new JCheckBox();
			jCheckBox2.setIcon(new ImageIcon(getClass().getResource("/Icons/arabic.png")));
			jCheckBox2.setBounds(new Rectangle(264, 54, 180, 180));
			jCheckBox2.setBackground(Color.white);
			jCheckBox2.setText("");
		}
		return jCheckBox2;
	}

	/**
	 * This method initializes jCheckBox3	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getJCheckBox3() {
		if (jCheckBox3 == null) {
			jCheckBox3 = new JCheckBox();
			jCheckBox3.setIcon(new ImageIcon(getClass().getResource("/Icons/beinsport.png")));
			jCheckBox3.setActionCommand("");
			jCheckBox3.setBounds(new Rectangle(493, 54, 180, 180));
			jCheckBox3.setBackground(Color.white);
			jCheckBox3.setText("");
		}
		return jCheckBox3;
	}

	/**
	 * This method initializes jCheckBox4	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getJCheckBox4() {
		if (jCheckBox4 == null) {
			jCheckBox4 = new JCheckBox();
			jCheckBox4.setIcon(new ImageIcon(getClass().getResource("/Icons/america.png")));
			jCheckBox4.setActionCommand("");
			jCheckBox4.setBounds(new Rectangle(722, 54, 180, 180));
			jCheckBox4.setBackground(Color.white);
			jCheckBox4.setText("");
		}
		return jCheckBox4;
	}

	/**
	 * This method initializes jButton1	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton1() {
		if (jButton1 == null) {
			jButton1 = new JButton();
			jButton1.setBounds(new Rectangle(181, 452, 130, 35));
			jButton1.setText("Select All");
			jButton1.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					jCheckBox1.setSelected(true);
					jCheckBox2.setSelected(true);
					jCheckBox3.setSelected(true);
					jCheckBox4.setSelected(true);

				}
			});
		}
		return jButton1;
	}

	/**
	 * This method initializes jButton2	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton2() {
		if (jButton2 == null) {
			jButton2 = new JButton();
			jButton2.setBounds(new Rectangle(324, 452, 130, 35));
			jButton2.setText("Deslect All");
			jButton2.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					jCheckBox1.setSelected(false);
					jCheckBox2.setSelected(false);
					jCheckBox3.setSelected(false);
					jCheckBox4.setSelected(false);				}
			});
		}
		return jButton2;
	}

	/**
	 * This method initializes jButton3	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton3() {
		if (jButton3 == null) {
			jButton3 = new JButton();
			jButton3.setBounds(new Rectangle(465, 452, 130, 35));
			jButton3.setText("Next");
		}
		return jButton3;
	}

	/**
	 * This method initializes jButton4	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton4() {
		if (jButton4 == null) {
			jButton4 = new JButton();
			jButton4.setBounds(new Rectangle(607, 452, 130, 35));
			jButton4.setText("Exit");
			jButton4.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					System.exit(0);
				}
			});
		}
		return jButton4;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
      new PACKEGES(); 
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		GridLayout gridLayout = new GridLayout();
		this.setLayout(null);
		this.setSize(935, 510);
		this.setTitle("Frame");

		this.add(getJCheckBox1(), null);
		this.add(getJCheckBox2(), null);
		this.add(getJCheckBox3(), null);
		this.add(getJCheckBox4(), null);
		this.add(getJButton1(), null);
		this.add(getJButton2(), null);
		this.add(getJButton3(), null);
		this.add(getJButton4(), null);
		this.setVisible(true);
	}

}  //  @jve:decl-index=0:visual-constraint="9,48"
