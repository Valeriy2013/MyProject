package com.sokolovskiy.utils;

import java.util.ArrayList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/*
 * Default Notification handler class for receiving ContentHandler
 * events raised by the SAX Parser
 * 
 * */
public class XParser extends DefaultHandler {

//		 <id>1</id>
//		<name>Иван Иванов</name>
//    	<position>форвард</position>
//    	<age>25</age>
//		<_height>212</_height>
//		<weight>111</weight>
//		<citizenship>Украина</citizenship>
//		<team>БК Одесса</team>
//		<photo>photo1</photo>
	ArrayList<String> idlist = new ArrayList<String>();
	ArrayList<String> namelist = new ArrayList<String>();
	ArrayList<String> positionlist = new ArrayList<String>();
	ArrayList<String> agelist = new ArrayList<String>();
	ArrayList<String> _heightlist = new ArrayList<String>();
	ArrayList<String> weightlist = new ArrayList<String>();
	ArrayList<String> citizenshiplist = new ArrayList<String>();
	ArrayList<String> teamlist = new ArrayList<String>();
	ArrayList<String> photolist = new ArrayList<String>();
	
	//temp variable to store the data chunk read while parsing 
	private String tempStore	=	null;
		
	public XParser() {
		// TODO Auto-generated constructor stub
	}
	
	/*
	 * Clears the tempStore variable on every start of the element
	 * notification
	 * 
	 * */
	public void startElement (String uri, String localName, String qName,
			   Attributes attributes) throws SAXException {
	
		super.startElement(uri, localName, qName, attributes);
		
		if (localName.equalsIgnoreCase("id")) {
			tempStore = "";
		} else if (localName.equalsIgnoreCase("name")) {
			tempStore = "";
		} 
		else if (localName.equalsIgnoreCase("position")) {
			tempStore = "";
		}
		else if (localName.equalsIgnoreCase("age")) {
			tempStore = "";
		}
		else if (localName.equalsIgnoreCase("_height")) {
			tempStore = "";
		}
		else if (localName.equalsIgnoreCase("weight")) {
			tempStore = "";
		}
		else if (localName.equalsIgnoreCase("citizenship")) {
			tempStore = "";
		}
		else if (localName.equalsIgnoreCase("team")) {
			tempStore = "";
		}
		else if (localName.equalsIgnoreCase("photo")) {
			tempStore = "";
		}		
		else {
			tempStore = "";
		}
	}
	
	/*
	 * updates the value of the tempStore variable into
	 * corresponding list on receiving end of the element
	 * notification
	 * */
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		super.endElement(uri, localName, qName);
		
		if (localName.equalsIgnoreCase("id")) {
			idlist.add(tempStore);
		} 
		else if (localName.equalsIgnoreCase("name")) {
			namelist.add(tempStore);
		}
		else if (localName.equalsIgnoreCase("age")) {
			agelist.add(tempStore);
		}
		else if (localName.equalsIgnoreCase("position")) {
			positionlist.add(tempStore);
		}
		else if (localName.equalsIgnoreCase("_height")) {
			_heightlist.add(tempStore);
		}
		else if (localName.equalsIgnoreCase("weight")) {
			weightlist.add(tempStore);
		}
		else if (localName.equalsIgnoreCase("citizenship")) {
			citizenshiplist.add(tempStore);
		}
		else if (localName.equalsIgnoreCase("team")) {
			teamlist.add(tempStore);
		}
		else if (localName.equalsIgnoreCase("photo")) {
			photolist.add(tempStore);
		}
		
		tempStore = "";
	}
	
	/*
	 * adds the incoming data chunk of character data to the 
	 * temp data variable - tempStore
	 * 
	 * */
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		super.characters(ch, start, length);
		tempStore += new String(ch, start, length);
	}

}
