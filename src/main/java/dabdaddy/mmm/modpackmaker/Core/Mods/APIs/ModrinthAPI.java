package dabdaddy.mmm.modpackmaker.Core.Mods.APIs;

import com.google.gson.JsonObject;
import dabdaddy.mmm.modpackmaker.Core.Mods.ModAPI;

public class ModrinthAPI extends ModAPI
{
    @Override
    protected String getAPIName()
    {
        return "Modrinth";
    }

    @Override
    protected String getBaseURL()
    {
        return "https://api.modrinth.com/v2/";
    }

    @Override
    protected String generateDefaultFacets()
    {
        String defaultFacets = "&facets=";

        String facets = "[[\"project_type:mod\"]]";
        String facetsEncoded = encodeToUTF(facets);

        defaultFacets += facetsEncoded;
        return defaultFacets;
    }

    @Override
    public JsonObject getPage(int pageNumber)
    {
        String params = "offset=";
        String query = encodeToUTF(Integer.toString(pageNumber * 10));
        params += query;
        params += generateDefaultFacets();
        return getJSONObject("search?" + params);
    }

    @Override
    public JsonObject getProject(String idOrSlug)
    {
        return getJSONObject("project/" + idOrSlug);
    }
}
