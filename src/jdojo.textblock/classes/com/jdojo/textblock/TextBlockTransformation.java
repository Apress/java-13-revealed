// TextBlockTransformation.java
package com.jdojo.textblock;

public class TextBlockTransformation {
    public static void main(String[] args) {
        String html = """
                      <html>\040
               
                          <body>   
                              <h1>Hello, HTML</h1>\t

                          </body>
                               
                      </html>
                      """;

              // let us print each line by enclosing it in single quotes
              html.lines()
                  .map(s -> "'" + s + "'")
                  .forEach(System.out::println);
    }
}
