package fr.rhoekath.filemanager.manager;


import org.w3c.dom.Document;

import java.net.URL;
import java.net.URLConnection;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

/**
 * Created by Mickael on 14/11/2014.
 */
public class MediaManager {
    public static void xmlFromUrl(String urlString) {
        URLConnection conn;
        try {
            URL url = new URL(urlString);
            conn = url.openConnection();
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(conn.getInputStream());

            TransformerFactory fac = TransformerFactory.newInstance();
            Transformer xform = fac.newTransformer();

            xform.transform(new DOMSource(doc), new StreamResult(System.out));
        } catch (Exception e) {

        } finally {

        }
    }
}
