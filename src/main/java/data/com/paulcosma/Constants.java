package data.com.paulcosma;

import base.BrowserFactory;

public class Constants {
    // Application.
    public final static String HOMEPAGE_TITLE = "Paul Cosma";
    public final static String HELLO_MESSAGE = "Hello! We'll be ready soon ...";
    public final static String FOOTER_MESSAGE = "Powered by Bootstrap";
    public final static String EXTERNAL_LINK_FACEBOOK = "https://www.facebook.com/paulcosma";
    public final static String EXTERNAL_LINK_TWITTER = "https://twitter.com/PaulPCosma";
    public final static String EXTERNAL_LINK_GITHUB = "https://github.com/paulcosma";
    public final static String EXTERNAL_LINK_LINKEDIN = "https://www.linkedin.com/";
    public final static String EXTERNAL_LINK_BOOTSTRAP = "http://getbootstrap.com/";
    public final static String EMAIL_ALERT_VALID = "Valid email. Thank you!";
    public final static String EMAIL_ALERT_INVALID = "Email not valid";
    // URL.
    public static String defaultEnvironment = "test"; // test or production
    public static String protocol = "https://";
    public static String domain = "paulcosma.com/";
    public static String URL = protocol + BrowserFactory.getTestingEnvironment(defaultEnvironment) + domain;
}
