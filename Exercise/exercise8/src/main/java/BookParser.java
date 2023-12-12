import org.json.JSONArray;
import org.json.JSONObject;
import org.json.XML;

public class BookParser {

    public static void main(String[] args) {
        // Sample XML
        String xmlData = "<BookShelf>" +
                "  <Book>" +
                "    <title>Java Programming</title>" +
                "    <publishedYear>2022</publishedYear>" +
                "    <numberOfPages>500</numberOfPages>" +
                "    <authors>" +
                "      <author>John Doe</author>" +
                "      <author>Jane Smith</author>" +
                "    </authors>" +
                "  </Book>" +
                "  <Book>" +
                "    <title>Data Structures and Algorithms</title>" +
                "    <publishedYear>2020</publishedYear>" +
                "    <numberOfPages>400</numberOfPages>" +
                "    <authors>" +
                "      <author>Alan Turing</author>" +
                "    </authors>" +
                "  </Book>" +
                "  <Book>" +
                "    <title>Web Development with JavaScript</title>" +
                "    <publishedYear>2021</publishedYear>" +
                "    <numberOfPages>300</numberOfPages>" +
                "    <authors>" +
                "      <author>Grace Hopper</author>" +
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
                .put("title", "Introduction to Programming")
                .put("publishedYear", 2023)
                .put("numberOfPages", 250)
                .put("authors", new JSONArray().put("Alice Wonderland").put("Bob Builder"));

        jsonObject.getJSONObject("BookShelf").getJSONArray("Book").put(newBook);

        // Print updated JSON
        System.out.println("\nUpdated JSON:\n" + jsonObject.toString(2));

        // Convert JSON back to XML
        String updatedXmlData = XML.toString(jsonFromXml);
        System.out.println("\nXML from updated JSON:\n" + updatedXmlData);
    }
}