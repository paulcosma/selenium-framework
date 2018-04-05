package data.com.paulcosma;

import org.testng.annotations.DataProvider;

public class HomepageData {

    @DataProvider(name = "validEmails")
    public static Object[][] validEmails() {
        return new Object[][]{
                {"contact@paulcosma.com", "1"},
                {"paul.cosma@paulcosma.com", "2"},
                {"contact@jenkins.paulcosma.com", "3"},
                {"paul+cosma@paulcosma.com", "4"},
                {"contact@123.123.123.42", "5"},
                {"contact@[123.123.123.42]", "6"},
                {"“contact”@paulcosma.com", "7"},
                {"1234567890@paulcosma.com", "8"},
                {"contact@paul-cosma.com", "9"},
                {"_______@paulcosma.com", "10"},
                {"contact@paulcosma.family", "11"},
                {"contact@paulcosma.co.uk", "12"},
                {"paul-cosma@paulcosma.com", "13"},
        };
    }
}
