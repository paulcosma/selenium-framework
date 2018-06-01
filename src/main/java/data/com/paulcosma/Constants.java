package data.com.paulcosma;

import base.BrowserFactory;

public class Constants {
    // URL.
    public static String defaultEnvironment = "test"; // test or production
    public static String protocol = "https://";
    public static String domain = "paulcosma.com/";
    public static final String URL = protocol + BrowserFactory.getTestingEnvironment(defaultEnvironment) + domain;
    // Application.
    public static final String HOMEPAGE_TITLE = "Paul Cosma";
    public static final String HELLO_MESSAGE = "Hello! We'll be ready soon ...";
    public static final String FOOTER_MESSAGE = "Powered by Bootstrap";
    public static final String EXTERNAL_LINK_FACEBOOK = "https://www.facebook.com/paulcosma";
    public static final String EXTERNAL_LINK_TWITTER = "https://twitter.com/PaulPCosma";
    public static final String EXTERNAL_LINK_GITHUB = "https://github.com/paulcosma";
    public static final String EXTERNAL_LINK_LINKEDIN = "https://www.linkedin.com/";
    public static final String EXTERNAL_LINK_BOOTSTRAP = "http://getbootstrap.com/";
    public static final String EMAIL_ALERT_VALID = "Valid email. Thank you!";
    public static final String EMAIL_ALERT_INVALID = "Email not valid";
}
