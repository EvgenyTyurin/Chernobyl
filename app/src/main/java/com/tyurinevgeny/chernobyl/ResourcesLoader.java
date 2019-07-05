package com.tyurinevgeny.chernobyl;

import android.content.Context;
import android.content.res.Resources;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Load data from resources
 */

public class ResourcesLoader {
    private static ResourcesLoader loader;
    private static Resources resources;
    private static String packageName;

    private ResourcesLoader(Context context) {
        resources = context.getResources();
        packageName = context.getPackageName();
    }

    public static ResourcesLoader getInstance(Context context) {
        loader = new ResourcesLoader(context);
        return loader;
    }

    public static ResourcesLoader getInstance() {
        return loader;
    }

    /** @return String array string-array object in strings.xml */
    public ArrayList<String> getStringArray(String resourceName) {
        ArrayList<String> arrayList = new ArrayList<>();
        int resourceID = resources.
                getIdentifier(resourceName, "array", packageName);
        if (resourceID != 0)
            arrayList =new ArrayList<>(Arrays.asList(resources
                    .getStringArray(resourceID)));
        return arrayList;
    }

}
