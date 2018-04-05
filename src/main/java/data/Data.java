package data;

import org.testng.annotations.DataProvider;

public class Data {

    @DataProvider(name = "validEmails")
    public static Object[][] validEmails() {
        return new Object[][]{
                {"contact@paulcosma.com", "1"},
                {"paul.cosma@paulcosma.com", "2"},
                {"contact@jenkins.paulcosma.com", "3"},
                {"paul+cosma@paulcosma.com", "4"},
                {"contact@123.123.123.123", "1"},
                {"contact@[123.123.123.123]", "1"},
                {"“contact”@paulcosma.com", "1"},
                {"1234567890@paulcosma.com", "1"},
                {"contact@paul-cosma.com", "1"},
                {"_______@paulcosma.com", "1"},
                {"contact@paulcosma.family", "1"},
                {"contact@paulcosma.co.uk", "1"},
                {"paul-cosma@paulcosma.com", "1"},
        };
    }
}
