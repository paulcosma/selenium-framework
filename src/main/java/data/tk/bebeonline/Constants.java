package data.tk.bebeonline;

import base.BrowserFactory;

public class Constants {
    // Application.
    public final static String HOMEPAGE_TITLE = "Articole Copii";
    // URL.
    public static String defaultEnvironment = "production";
    public static String protocol = "https://";
    public static String domain = "bebeonline.tk/";
    public static String URL = protocol + BrowserFactory.getTestingEnvironment(defaultEnvironment) + domain;
}
