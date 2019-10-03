// IndentTest.java
package com.jdojo.textblock;

public class IndentTest {
    public static void main(String[] args) {
        String html = " <html>\n"
                + "     <body>\n"
                + "         <h1>Hello, HTML</h1>\n"
                + "     </body>\n"
                + " </html>";

        System.out.println("Original:\n" + html);

        // Remove incidental whitespaces
        String html2 = html.stripIndent();
        System.out.println("\nAfter stringIndent():\n" + html2);

        // Indent the string with one space, which will add an LF
        // to the last line in the content
        String html3 = html2.indent(1);
        System.out.println("\nAfter indent():\n" + html3);

        // Print the details
        System.out.println("html.length(): " + html.length());
        System.out.println("html3.length(): " + html3.length());
        System.out.println("html.equals(html3): " + html.equals(html3));
        System.out.println("html.endsWith(\"\\n\"): " 
                + html.endsWith("\n"));
        System.out.println("html3.endsWith(\"\\n\"): " 
                + html3.endsWith("\n"));
    }
}
