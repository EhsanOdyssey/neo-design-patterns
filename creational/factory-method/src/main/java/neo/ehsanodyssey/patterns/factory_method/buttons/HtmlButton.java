package neo.ehsanodyssey.patterns.factory_method.buttons;

import javax.swing.*;
import javax.swing.text.html.HTMLEditorKit;
import java.awt.*;
import java.io.*;

/**
 * @author <a href="mailto:ehsan.odyssey@gmail.com">EhsanOdyssey</a>
 * @project neo-design-patterns
 * @date Mon 22 Nov 2021
 */
public class HtmlButton implements Button {

    JFrame frame = new JFrame("NEO HTML");

    @Override
    public void render() {
//        System.out.println("<button>Test Button</button>");
//        onClick();

//        Desktop desk = Desktop.getDesktop();
//        desk.browse(new URI("http://xyz.com"));

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JEditorPane editorPane = new JEditorPane();
        editorPane.setEditorKit(new HTMLEditorKit());
        String filename = "test.html";
        try (InputStream is = getClass().getClassLoader().getResourceAsStream(filename)) {
            editorPane.read(is, filename);
        } catch (IOException e) {
            e.printStackTrace();
        }
        JScrollPane scrollPane = new JScrollPane(editorPane);
        frame.add(scrollPane, BorderLayout.CENTER);

        frame.setSize(320, 200);
        frame.setVisible(true);
        onClick();
    }

    @Override
    public void onClick() {
        System.out.println("Close button clicked!");
    }
}
