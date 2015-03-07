package chemistry;

import chemistry.Constant.ElementClass;
import chemistry.exception.ChemException;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

/**
 * The periodic table, unfinished.
 *
 * @author Matthew Webb
 * @version 1.0
 */
public class PeriodicTable {

    private static final PeriodicTable pt = new PeriodicTable();

    private final HashMap<Integer, Element> elements;

    private PeriodicTable() {
        elements = new HashMap<>();
        loadElements();
    }

    /**
     * Gets the <code>PeriodicTable</code> singleton.
     *
     * @return
     */
    public static PeriodicTable getInstance() {
        return pt;
    }

    private void loadElements() {
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(new URL("").openStream());
        } catch (ParserConfigurationException | IOException | SAXException e) {
        }
    }

    /**
     * Gets an element based on atomic number.
     *
     * @param atomicNumber The atomic number of the goal element.
     * @return The element.
     */
    public Element getElement(int atomicNumber) {
        return elements.get(atomicNumber);
    }
}
