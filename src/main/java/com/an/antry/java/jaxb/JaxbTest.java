package com.an.antry.java.jaxb;

import java.io.File;
import java.util.List;

//JAXB2.0使用
//http://wenku.baidu.com/link?url=KCTuO5wkEUhakc-mBlxMHLOfKy32_DHMpme4fOcZ6wpGkwqkQtdhO85UZjtNs3f8R3Sh0nFXi3PfbDolMuJY3GlAWDdWeRpcXVJ_-j3seVK
public class JaxbTest {
    private ObjectFactory factory = new ObjectFactory();

    /**
     * @param xmlDocument
     *            is the output xml file
     */
    public void testObject2Xml(File xmlDocument) {
        CatalogType catalog = factory.createCatalogType();
        assmbleCatalogForTest(catalog);
        CatalogTypeUtils.buildXml(catalog, xmlDocument);
    }

    /**
     * @param xmlDocument
     *            is the source xml file for generating Object
     * @return
     */
    public CatalogType testXml2Object(File xmlDocument) {
        return CatalogTypeUtils.buildObject(xmlDocument);
    }

    // This function is used to assemble CatalogType object for test
    private CatalogType assmbleCatalogForTest(CatalogType catalog) {
        catalog.setSection("Java Technology");
        catalog.setPublisher("IBM developerWorks");
        JournalType journal = factory.createJournalType();
        ArticleType article = factory.createArticleType();
        article.setLevel("Intermediate");
        article.setDate("January-2004");
        article.setTitle("Service Oriented Architecture Frameworks");
        article.setAuthor("Naveen Balani");
        List<JournalType> journalList = catalog.getJournal();
        journalList.add(journal);
        List<ArticleType> articleList = journal.getArticle();
        articleList.add(article);
        article = factory.createArticleType();
        article.setLevel("Advanced");
        article.setDate("October-2003");
        article.setTitle("Advance DAO Programming");
        article.setAuthor("Sean Sullivan");
        articleList.add(article);
        article = factory.createArticleType();
        article.setLevel("Advanced");
        article.setDate("May-2002");
        article.setTitle("Best Practices in EJB Exception Handling");
        article.setAuthor("Srikanth Shenoy");
        articleList.add(article);
        return catalog;
    }

    public static void main(String[] argv) {
        JaxbTest test = new JaxbTest();
        String filepath = "jaxbTest.xml";
        test.testObject2Xml(new File(filepath));

        CatalogType type = test.testXml2Object(new File(filepath));
        System.out.println(type.toString());
    }
}
