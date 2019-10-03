// VersionTest.java
package com.jdojo.version.scheme;

import java.lang.Runtime.Version;
import java.util.stream.Collectors;
import static java.lang.System.out;

public class VersionTest {
    public static void main(String[] args) {
        // Print the version string details of the current JRE
        Version jreVersion = Runtime.version();
        out.println("Current JRE Version: " + jreVersion);
        printVersionDetails(jreVersion.toString());

        // Have some version strings
        String[] versionStrings = {
            "10", "10.1", "10.0.1.2", "10.0.2.3.4", "10.0.0",
            "10.1.2-ea+153", "10+132", "10-ea+24-2018-01-23", "10+-123",
            "10.0.1-ea+132-2018-01-28.10.56.45am"};

        // Parse each version string and display their components
        for (String vstr : versionStrings) {
            printVersionDetails(vstr);
        }
    }

    public static void printVersionDetails(String vstr) {
        try {
            Version version = Version.parse(vstr);

            // Get the additional version number elements which starts
            // at the 5th element in the version number part
            String vnumAdditionalInfo = version.version()
                    .stream()
                    .skip(4)
                    .map(n -> n.toString())
                    .collect(Collectors.joining("."));

            out.printf("Version String=%s%n", vstr);
            out.printf("feature=%d, interim=%d, update=%d, patch=%d,"
                    + " additional info=%s,"
                    + " pre=%s, build=%s, optional=%s %n%n",
                    version.feature(),
                    version.interim(),
                    version.update(),
                    version.patch(),
                    vnumAdditionalInfo,
                    version.pre().orElse(""),
                    version.build().isPresent()
                    ? version.build().get().toString()
                    : "",
                    version.optional().orElse(""));
        } catch (Exception e) {
            out.printf("%s%n%n", e.getMessage());
        }
    }
}
