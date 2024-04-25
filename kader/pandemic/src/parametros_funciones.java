import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import java.util.Scanner;

public class parametros_funciones {
	private static Scanner sc = new Scanner(System.in);
	public static void leerParametros() {
		try {
            File inputFile = new File("parametros.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();

            System.out.println("Root element: " + doc.getDocumentElement().getNodeName());

            NodeList nodeList = doc.getElementsByTagName("parametros");

            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    String numCiudadesInfectadasInicio = element.getElementsByTagName("numCiudadesInfectadasInicio").item(0).getTextContent();
                    String numCuidadesInfectadasRonda = element.getElementsByTagName("numCuidadesInfectadasRonda").item(0).getTextContent();
                    String numEnfermedadesActivasDerrota = element.getElementsByTagName("numEnfermedadesActivasDerrota").item(0).getTextContent();
                    String numBrotesDerrota = element.getElementsByTagName("numBrotesDerrota").item(0).getTextContent();

                    

                    System.out.println("CiudadesInfectadasInicio: " + numCiudadesInfectadasInicio);
                    System.out.println("CuidadesInfectadasRonda: " + numCuidadesInfectadasRonda);
                    System.out.println("numEnfermedadesActivasDerrota: " + numEnfermedadesActivasDerrota);
                    System.out.println("numBrotesDerrota: " + numBrotesDerrota);
                    System.out.println("----------------------");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
	public static void modifyParametros() {
		try {
	        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
	        DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
	        
	        Document doc = docBuilder.newDocument();
	        System.out.println("Vas a modificar o crear el archivo editParametros.xml");
	        Element rootElement = doc.createElement("parametros");
	        doc.appendChild(rootElement);
	        System.out.println("Vas a modificar el numCiudadesInfectadasInicio:");
	        Element item = doc.createElement("numCiudadesInfectadasInicio");
	        rootElement.appendChild(item);
	        
	        item.appendChild(doc.createTextNode(valor()));
	        System.out.println("Vas a modificar el numCuidadesInfectadasRonda:");
	        Element item2 = doc.createElement("numCuidadesInfectadasRonda");
	        rootElement.appendChild(item2);
	        
	        item2.appendChild(doc.createTextNode(valor()));
	        
	        System.out.println("Vas a modificar el numEnfermedadesActivasDerrota:");
	        Element item3 = doc.createElement("numEnfermedadesActivasDerrota");
	        rootElement.appendChild(item3);
	        
	        item3.appendChild(doc.createTextNode(valor()));
	        
	        
	        System.out.println("Vas a modificar el numBrotesDerrota:");
	        Element item4 = doc.createElement("numBrotesDerrota");
	        rootElement.appendChild(item4);
	        
	        item4.appendChild(doc.createTextNode(valor()));
	        
	        
	        TransformerFactory transformerFactory = TransformerFactory.newInstance();
	        Transformer transformer = transformerFactory.newTransformer();
	        transformer.setOutputProperty(OutputKeys.INDENT, "yes"); 
	        DOMSource source = new DOMSource(doc);
	        StreamResult result = new StreamResult("editParametros.xml");

	        transformer.transform(source, result);

	        System.out.println("XML file saved successfully.");

	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	public static String valor() {
		boolean num = false;
        String valor;
        do {
        	System.out.println("Pon numeros: ");
            valor = sc.nextLine();
            for (int i = 0; i < valor.length() ; i++) {
            	if (Character.isDigit(valor.charAt(i))) {
            		num = true;
            		break;
            	}
            }
        } while (num == false);
        return valor;
	}
}


