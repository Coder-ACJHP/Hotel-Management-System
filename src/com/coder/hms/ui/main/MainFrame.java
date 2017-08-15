/**
 * @author Coder ACJHP
 * @Email hexa.octabin@gmail.com
 * @Date 15/07/2017
 */
package com.coder.hms.ui.main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.coder.hms.connection.DataSourceFactory;
import com.coder.hms.daoImpl.HotelDaoImpl;
import com.coder.hms.entities.SessionBean;
import com.coder.hms.utils.ApplicationLogoSetter;
import com.coder.hms.utils.GetLiveCurrencyRates;


public class MainFrame extends JFrame {

	/**
	 * 
	 */
	private JPanel mainPanel;
	private Main_MenuBar customMenuBar;
	private static SessionBean sessionBean;
	private static final long serialVersionUID = 1L;
	private final HotelDaoImpl hotelDaoImpl = new HotelDaoImpl();
	private final ApplicationLogoSetter logoSetter = new ApplicationLogoSetter();
	private final GetLiveCurrencyRates currency = new GetLiveCurrencyRates();
	
	/*get the external toolbar and initialize it*/
	private final Main_UpperToolbar customToolbar;
	private final Main_BottomToolbar customBottomToolbar;
	
	private final String LOGOPATH = "/com/coder/hms/icons/main_logo(128X12).png";
	
	// Set basic properties for main frame.
	public MainFrame() {

		sessionBean = SessionBean.getSESSION_BEAN();		
		
		// get operation system name to add icon (if windows to taskbar else for dock)
		mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout());
		mainPanel.setBackground(Color.decode("#066d95"));
		
		this.getContentPane().add(mainPanel, BorderLayout.CENTER);
		
		logoSetter.setApplicationLogoJFrame(this, LOGOPATH);
		customToolbar = new Main_UpperToolbar(mainPanel);
		customBottomToolbar = new Main_BottomToolbar();
		
		this.setTitle("Coder for HMS - [Main]");
		

		this.setMinimumSize(new Dimension(800, 600));
		/*make it default size of frame maximized */
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		/*set exiting from the application when clicking on X button*/
		this.addWindowListener(new WindowAdapter() {
			
			@Override
			public void windowClosing(WindowEvent e) {
				final int decision =JOptionPane.showConfirmDialog(null, "Do you really want to exit?", 
						"Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				
				if(decision == JOptionPane.YES_OPTION) {
					new DataSourceFactory().shutDown();
					System.exit(0);
				}
				else {
					setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
				}
				
				super.windowClosing(e);
			}
		});
		
		/*get the external menubar and initialize it*/
		customMenuBar = new Main_MenuBar();
		customMenuBar.setJFrame(this);
		customMenuBar.themeChanger.setFrame(this);
		/*add it to our frame*/
		this.setJMenuBar(customMenuBar.getMenuBar());
		
		//get user name from login frame and add it to main frame
		customBottomToolbar.setUserLabelText(sessionBean.getNickName().toUpperCase());
		
		customBottomToolbar.setUsdLabelText(currency.getUSDToTRYLiveCurrency());
		customBottomToolbar.setEuroLabelText(currency.getEURToTRYLiveCurrency());
		customBottomToolbar.setPoundLabelText(currency.getGBPToTRYLiveCurrency());
		customBottomToolbar.setDateLabelText("");
		customBottomToolbar.sethotelNameLabelText(hotelDaoImpl.getHotel().getName());
		
		/*add it to our frame*/
		getContentPane().add(customToolbar.getJPanel(), BorderLayout.NORTH);
		
		getContentPane().add(customBottomToolbar.getToolBar(), BorderLayout.SOUTH);

		
		this.setVisible(true);

	}
	

}