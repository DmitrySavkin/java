package org.iMage.plugins;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ServiceLoader;

/**
 * Knows all available plugins and is responsible for using the service loader
 * API to detect them.
 */
public final class PluginManager {

    /**
     * No constructor for utility class.
     */
    private PluginManager() {
    }

    /**
     * @return all available plugins sorted alphabetically by their name in
     * ascending order.
     */
    public static List<JmjrstPlugin> getPlugins() {
        ArrayList<JmjrstPlugin> pluginList = new ArrayList<>();
        Iterator<JmjrstPlugin> services = ServiceLoader.load(JmjrstPlugin.class).iterator();
        while (services.hasNext()) {
            JmjrstPlugin service = services.next();
            pluginList.add(service);
        }
        Collections.sort(pluginList);
        return pluginList;
    }
}
