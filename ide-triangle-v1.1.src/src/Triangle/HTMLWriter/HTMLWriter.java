package Triangle.HTMLWriter;


import java.io.FileWriter;
import java.io.IOException;

public class HTMLWriter {
    private String fileName;

    public HTMLWriter(String fileName) {
        this.fileName = fileName;
    }

    /**
     * output HTML file of the code
     * @param html 
     */
    public void write(String html) {
        
        try {
            FileWriter fileWriter = new FileWriter(fileName + ".html");

            fileWriter.write("<!DOCTYPE html>\n" +
"<html>\n" +
"<head>\n" +
"<title>Page Title</title>\n" +
"</head>\n" +
"<style>\n" +
"  p {\n" +
"    font-size: 1em;\n" +
"    font-family: \"Courier New\", monospaced;\n" +
"  }\n" +
"  .literal {\n" +
"    color : #004080;\n" +
"  }\n" +
"  .comment {\n" +
"    color: #009933;\n" +
"  }\n" + ".reservedword {font-weight:bold;}" +
"</style>\n" +
"<body>");
            fileWriter.write("<p>");
            fileWriter.write(html);
            fileWriter.write("</p>");

            fileWriter.write("</body>\n" +
"</html>");

            fileWriter.close();

        } catch (IOException e) {
            System.err.println("Error while creating file for print the AST");
            e.printStackTrace();
        }
    }
}
