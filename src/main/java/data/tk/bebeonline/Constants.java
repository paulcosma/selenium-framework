package data.tk.bebeonline;

import base.BrowserFactory;

public class Constants {
    // URL.
    public static String defaultEnvironment = "production";
    public static String protocol = "https://";
    public static String domain = "bebeonline.tk/";
    public static final String URL = protocol + BrowserFactory.getTestingEnvironment(defaultEnvironment) + domain;
    public static final String ADMIN_URL = URL + "admin/";
    // Application.
    public static final String HOMEPAGE_TITLE = "Articole Copii";
    public static final String ADMINPAGE_TITLE = "Administration";
}
