// TextBlocks.java
package com.jdojo.textblock;

public class TextBlocks {
    public static void main(String[] args) {
        String html1 = """
                       <html>
                           <body>
                               <h1>Hello, HTML</h1>
                           </body>
                       </html>
                       """;

        System.out.println("html1:\n" + html1);
        
        String html2 = """
                       <html>
                           <body>
                               <h1>Hello, HTML</h1>
                           </body>
                       </html>
                     """;

        System.out.println("html2:\n" + html2);
        
        // An empty String. Same as ""
        String empty1 = """
                        """;
        System.out.println("empty1: " + empty1);
        System.out.println("empty1.length(): " + empty1.length());

        // An empty String. Same as ""        
        String empty2 = """       
           """;
        System.out.println("empty2: " + empty2);
        System.out.println("empty2.length(): " + empty2.length());
        
        // Looks like an empty string, but it is not. Same as "\n"
        String empty3 = """
        
                        """;
        System.out.println("empty3: " + empty3);
        System.out.println("empty3.length(): " + empty3.length());        
    }
}
