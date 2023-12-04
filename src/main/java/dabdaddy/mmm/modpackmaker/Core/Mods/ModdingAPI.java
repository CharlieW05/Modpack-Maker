package dabdaddy.mmm.modpackmaker.Core.Mods;

import dabdaddy.mmm.modpackmaker.Core.Mods.APIs.ModrinthAPI;

public class ModdingAPI
{
    public static ModdingAPI s_Instance;

    private ModdingAPIType m_Type;

    private ModrinthAPI m_Modrinth;

    public ModdingAPI(ModdingAPIType type)
    {
        s_Instance = this;

        m_Type = type;
        switch(m_Type)
        {
            case MODRINTH -> { m_Modrinth = new ModrinthAPI(); }
        }
    }

    /**
     * Get the current API in use
     * @return The API in use
     */
    public ModAPI getAPI()
    {
        switch(m_Type)
        {
            case MODRINTH -> { return m_Modrinth; }
        }

        return m_Modrinth;
    }
}
