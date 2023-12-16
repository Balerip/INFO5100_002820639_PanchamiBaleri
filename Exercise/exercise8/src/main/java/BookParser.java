import org.json.JSONArray;
import org.json.JSONObject;
import org.json.XML;

public class BookParser {

    public static void main(String[] args) {
        // Sample XML
        String xmlData = "<BookShelf>" +
                "  <Book>" +
                "    <title>The Fantastic Five</title>" +
                "    <publishedYear>2022</publishedYear>" +
                "    <numberOfPages>500</numberOfPages>" +
                "    <authors>" +
                "      <author>Hero One</author>" +
                "      <author>Hero Two</author>" +
                "      <author>Hero Three</author>" +
                "      <author>Hero Four</author>" +
                "      <author>Hero Five</author>" +
                "    </authors>" +
                "  </Book>" +
                "  <Book>" +
                "    <title>Introduction to C</title>" +
                "    <publishedYear>2020</publishedYear>" +
                "    <numberOfPages>400</numberOfPages>" +
                "    <authors>" +
                "      <author>Coding Guru</author>" +
                "    </authors>" +
                "  </Book>" +
                "  <Book>" +
                "    <title>Twilight</title>" +
                "    <publishedYear>2005</publishedYear>" +
                "    <authors>" +
                "      <author>Stephenie Meyer</author>" +
                "    </authors>" +
                "  </Book>" +
                "</BookShelf>";

        // Parse XML
        JSONObject jsonFromXml = XML.toJSONObject(xmlData);
        System.out.println("JSON from XML:\n" + jsonFromXml.toString(2));

        // Parse JSON
        String jsonData = "{ \"BookShelf\": { \"Book\": [" +
                " { \"title\": \"Machine Learning\", \"publishedYear\": 2019, \"numberOfPages\": 600, \"authors\": [\"Andrew Ng\"] }" +
                "] } }";

        JSONObject jsonObject = new JSONObject(jsonData);
        System.out.println("\nParsed JSON:\n" + jsonObject.toString(2));


        // Add an additional entry programmatically
        JSONObject newBook = new JSONObject()
                .put("title", "Updated Title")
                .put("numberOfPages", 300)
                .put("authors", new JSONArray()
                        .put("Alice Wonderland")
                        .put("Bob Builder")
                        .put("Charlie Author"));
        // Add newBook to the existing jsonObject
        jsonObject.getJSONObject("BookShelf").getJSONArray("Book").put(jsonFromXml).put(newBook);


        // Print updated JSON
        System.out.println("\nUpdated JSON:\n" + jsonObject.toString(2));

        // Convert JSON back to XML
        String updatedXmlData = XML.toString(jsonObject);
        System.out.println("\nXML from updated JSON:\n" + updatedXmlData);
        String formattedXmlData = updatedXmlData.replaceAll("><", ">\n<");

        // Print the formatted XML data for better readability
        System.out.println("\nFormatted XML from updated JSON:\n" + formattedXmlData);

    }
}