package data.tk.cosma;

import base.BrowserFactory;

public class Constants {
    // Application.
    public final static String HOMEPAGE_TITLE = "Cosma";
    public final static String INTRO_TITLE = "COSMA.TK";
    // URL.
    public static String defaultEnvironment = "";
    public static String protocol = "https://";
    public static String domain = "cosma.tk/";
    public static String URL = protocol + BrowserFactory.getTestingEnvironment(defaultEnvironment) + domain;
}
