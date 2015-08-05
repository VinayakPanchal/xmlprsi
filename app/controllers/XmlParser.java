package controllers;

import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.soap.Node;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

/**
 * Created by vpanchal on 7/22/2015.
 */
public class XmlParser {

    String fname;
    String lname;
    String email;

    public static void parse(String res) throws Exception {
        DocumentBuilder dbuild = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        InputStream is = new ByteArrayInputStream(res.getBytes());
        org.w3c.dom.Document doc = dbuild.parse(is);
        Element root = doc.getDocumentElement();
        System.out.println("Root Element :" + doc.getDocumentElement().getNodeName());
        NodeList nList = doc.getElementsByTagName("Resume");
        System.out.println("----------------------------");
        System.out.println(nList.getLength());
        for (int resumeCounter = 0; resumeCounter < nList.getLength(); resumeCounter++) {
            org.w3c.dom.Node nNode = nList.item(resumeCounter);
            System.out.println("\nCurrent Element is: " + nNode.getNodeName());
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element e = (Element) nNode;
                System.out.println("FirstName is: " + e.getElementsByTagName("First").item(0).getTextContent());
                System.out.println("Email is: " + e.getElementsByTagName("EmailAddress").item(0).getTextContent());


            }
        }
    }
}
