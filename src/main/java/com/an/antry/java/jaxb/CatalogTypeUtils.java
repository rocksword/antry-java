package com.an.antry.java.jaxb;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class CatalogTypeUtils {
    private static JAXBContext jaxbContext = null;
    private static Marshaller marshaller = null;
    private static ObjectFactory factory = null;

    /**
     * @param catalogType
     *            is the object that is used to build xml
     * @param xmlDocument
     *            is the file where xml to output
     */
    public static void buildXml(CatalogType catalogType, File xmlDocument) {
        try {
            jaxbContext = JAXBContext.newInstance("com.an.java.jaxb");
            marshaller = jaxbContext.createMarshaller();
            ObjectFactory factory = new ObjectFactory();
            JAXBElement<CatalogType> catalogElement = factory.createCatalog(catalogType);
            marshaller.marshal(catalogElement, new FileOutputStream(xmlDocument));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    /**
     * @param xmlDocument
     *            the xml file to build object
     * @return the built object
     */
    @SuppressWarnings("unchecked")
    public static CatalogType buildObject(File xmlDocument) {
        JAXBElement<CatalogType> catalogElement = null;
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance("com.an.java.jaxb");
            Unmarshaller unMarshaller = jaxbContext.createUnmarshaller();
            catalogElement = (JAXBElement<CatalogType>) unMarshaller.unmarshal(xmlDocument);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return catalogElement.getValue();
    }
}
