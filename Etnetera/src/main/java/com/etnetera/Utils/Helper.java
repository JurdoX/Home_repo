package com.etnetera.Utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import org.apache.log4j.Logger;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;

import com.etnetera.model.Person;

public class Helper {
	
	private static Logger logger = Logger.getLogger(Helper.class);
	private static String URL = "http://www.patria.cz/export/ct/zavery.asp";

	/**
	 * connect to URL and get values from the elements
	 * 
	 * @param element
	 * @return value of element
	 */
	public String getElement(String element) {
		URL url;
		SAXBuilder builder = new SAXBuilder();
		try {
			// get URL content
			url = new URL(URL);
			URLConnection conn = url.openConnection();

			// open the stream and put it into BufferedReader
			BufferedReader br = new BufferedReader(new InputStreamReader(
					conn.getInputStream()));

			String inputLine;
			StringBuilder sb = new StringBuilder();
			while ((inputLine = br.readLine()) != null) {
				sb.append(inputLine);
			}

			// parse XML from string
			Document document = builder.build(new StringReader(sb.toString()));
			Element rootNode = document.getRootElement();
			Element px = rootNode.getChild("px");
			element = px.getChildText(element);

			br.close();
		} catch (MalformedURLException e) {
			logger.error("URL Exception: " + e);
		} catch (IOException e) {
			logger.error("IOException: " + e);
		} catch (JDOMException e) {
			logger.error("JDOM Exception: " + e);
		}

		return element;
	}

	/**
	 * create CSV file CSV file content export of DB
	 * 
	 * @param list
	 * @return content of CSV file
	 */
	public String createCSV(List<Person> list) {
		StringBuilder sb = new StringBuilder();
		for (Person p : list) {
			sb.append(p.getName());
			sb.append(";");
			sb.append(p.getPhone());
			sb.append(";");
			sb.append(p.getEmail());
			sb.append(";");
			sb.append(p.getDate());
			sb.append(";");
			sb.append(p.getClose());
			sb.append(";");
			sb.append(p.getChanged());
			sb.append("\n");
		}

		return sb.toString();
	}
	
}
