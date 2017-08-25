/**
 * @author Coder ACJHP
 * @Email hexa.octabin@gmail.com
 * @Date 15/07/2017
 */
package com.coder.hms.utils;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.coder.hms.ui.external.InformationFrame;

public class GetLiveCurrencyRates {

	private static LoggingEngine loggingEngine;
	
	public GetLiveCurrencyRates() {
		loggingEngine = LoggingEngine.getInstance();
	}
	
	public String getUSDToTRYLiveCurrency() {

		String UsdRate = "";
		URL yahooUSDCurrency = null;
		try {
			yahooUSDCurrency = new URL("https://query.yahooapis.com/v1/public/yql?q=SELECT%20*%20FROM%20yahoo.finance."
					+ "xchange%20WHERE%20pair%3D%22USDTRY%22&diagnostics=true&env=store%3A%2F%2Fdatatables.org%2Falltableswithkeys");
			UsdRate =  getXMLParser(yahooUSDCurrency);
		} catch (MalformedURLException e) {
			final InformationFrame frame = new InformationFrame();
			frame.setMessage(e.getMessage());
			frame.setVisible(true);
		}
		return UsdRate;
	}
	
	public String getEURToTRYLiveCurrency() {

		String EurRate = "";
		URL yahooEURCurrency = null;
		try {
			yahooEURCurrency = new URL("https://query.yahooapis.com/v1/public/yql?q=SELECT%20*%20FROM%20yahoo.finance."
					+ "xchange%20WHERE%20pair%3D%22EURTRY%22&diagnostics=true&env=store%3A%2F%2Fdatatables.org%2Falltableswithkeys");
			EurRate =  getXMLParser(yahooEURCurrency);
		} catch (MalformedURLException e) {
			final InformationFrame frame = new InformationFrame();
			frame.setMessage(e.getMessage());
			frame.setVisible(true);
		}
		return EurRate;
	}
	
	public String getGBPToTRYLiveCurrency() {

		String GbpRate = "";
		URL yahooEURCurrency = null;
		try {
			yahooEURCurrency = new URL("https://query.yahooapis.com/v1/public/yql?q=SELECT%20*%20FROM%20yahoo.finance."
					+ "xchange%20WHERE%20pair%3D%22GBPTRY%22&diagnostics=true&env=store%3A%2F%2Fdatatables.org%2Falltableswithkeys");
			GbpRate =  getXMLParser(yahooEURCurrency);
		} catch (MalformedURLException e) {
			final InformationFrame frame = new InformationFrame();
			frame.setMessage(e.getMessage());
			frame.setVisible(true);
		}
		return GbpRate;
	}
	
	public String getXMLParser(final URL url) {
		
		String results = "";
			try {

				DocumentBuilderFactory bdFactory = DocumentBuilderFactory.newInstance();
				DocumentBuilder builder = bdFactory.newDocumentBuilder();
				Document doc = builder.parse(url.openStream());
				
				doc.getDocumentElement().normalize();
				
				NodeList nList = doc.getElementsByTagName("results");
				for(int i=0; i < nList.getLength(); i++) {
					Node nNode = nList.item(i);
					if(nNode.getNodeName().equalsIgnoreCase("results")) {
						Element eElement = (Element) nNode;
						results = eElement.getElementsByTagName("Name").item(0).getTextContent() +
									" : " +eElement.getElementsByTagName("Rate").item(0).getTextContent();
					}
				}
				
			} catch (MalformedURLException e) {
				loggingEngine.setMessage(e.getMessage());
			} catch (ParserConfigurationException e) {
				loggingEngine.setMessage(e.getMessage());
			} catch (SAXException e) {
				loggingEngine.setMessage(e.getMessage());
			} catch (IOException e) {
				loggingEngine.setMessage(e.getMessage());
			}
			
			return results;
	}
	
}
