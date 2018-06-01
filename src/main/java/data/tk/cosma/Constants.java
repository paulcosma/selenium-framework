package data.tk.cosma;

import base.BrowserFactory;

public class Constants {
    // URL.
    public static String defaultEnvironment = "";
    public static String protocol = "https://";
    public static String domain = "cosma.tk/";
    public static final String URL = protocol + BrowserFactory.getTestingEnvironment(defaultEnvironment) + domain;
    // Application.
    public static final String HOMEPAGE_TITLE = "Cosma";
    public static final String INTRO_TITLE = "COSMA.TK";
}
