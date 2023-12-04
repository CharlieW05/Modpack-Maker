package dabdaddy.mmm.modpackmaker.Core.Mods;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import dabdaddy.mmm.modpackmaker.ApplicationUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ModAPI
{
    protected HttpClient m_Client;
    protected JsonParser m_Parser;

    public ModAPI()
    {
        m_Client = HttpClient.newHttpClient();
        m_Parser = new JsonParser();
    }

    /**
     * Gets a HTTP response from a certain URL
     * @param path The URL to grab data from
     * @return A HttpResponse object holding the response data in String form
     */
    public HttpResponse<String> get(String path)
    {
        try
        {
            String url = getBaseURL() + path;
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .build();
            HttpResponse<String> response = m_Client.send(request, HttpResponse.BodyHandlers.ofString());
            return response;
        }
        catch (IOException e)
        {
            ApplicationUtils.fatalError("Error in " + getAPIName() + " API: " + e.getMessage());
        }
        catch (InterruptedException e)
        {
            ApplicationUtils.fatalError("Error in " + getAPIName() + " API: " + e.getMessage());
        }

        return null;
    }

    /**
     * Gets a HTTP response from a certain URL and converts it to a GSON JsonObject
     * @param path The URL to grab data from
     * @return A JsonObject object holding the response data in JSON
     */
    public JsonObject getJSONObject(String path)
    {
        try
        {
            HttpResponse<String> response = get(path);
            String res = response.body();
            Object obj = m_Parser.parse(res);
            return (JsonObject) obj;
        }
        catch (JsonSyntaxException e)
        {
            ApplicationUtils.fatalError("Error in " + getAPIName() + " API: " + e.getMessage());
        }

        return null;
    }

    /**
     * Gets a HTTP response from a certain URL and converts it to a GSON JsonArray
     * @param path The URL to grab data from
     * @return A JsonArray object holding the response data in JSON
     */
    public JsonArray getJSONArray(String path)
    {
        try
        {
            HttpResponse<String> response = get(path);
            String res = response.body();
            Object obj = m_Parser.parse(res);
            return (JsonArray) obj;
        }
        catch (JsonSyntaxException e)
        {
            ApplicationUtils.fatalError("Error in " + getAPIName() + " API: " + e.getMessage());
        }

        return null;
    }

    /**
     * Convert a string to a UTF-8 string
     * @param toEncode The string to be encoded
     * @return The UTF-8 encoded string
     */
    protected String encodeToUTF(String toEncode)
    {
        try
        {
            String encoded = URLEncoder.encode(toEncode, "UTF-8");
            return encoded;
        }
        catch (UnsupportedEncodingException e)
        {
            ApplicationUtils.fatalError("Error in " + getAPIName() + " API: " + e.getMessage());
        }

        return toEncode;
    }

    // To be overriden
    protected String getBaseURL() { return ""; }
    protected String generateDefaultFacets() { return ""; }
    protected String getAPIName() { return ""; }

    /**
     * Get a single page of project entries
     * @param pageNumber The page offset to use when grabbing the page
     * @return A JsonObject that contains all of the project entries in the page
     */
    public JsonObject getPage(int pageNumber) { return null; }

    /**
     * Get all of the data relevant to a single project
     * @param idOrSlug The ID or Slug that is linked to that project
     * @return A JsonObject that contains the project data
     */
    public JsonObject getProject(String idOrSlug) { return null; }
}
