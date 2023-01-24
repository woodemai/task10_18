package ru.smirnov.tasks.task10_18;

import ru.smirnov.utils.JTableUtils;
import ru.smirnov.utils.SwingUtils;
import ru.smirnov.utils.Utils;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.io.File;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;


public class Window extends JFrame {
    private JTable table;
    private JPanel panel;
    private JButton buttonInput;
    private JButton buttonOutput;
    private JButton buttonExecute;
    Font mainFont = new Font("Roboto", Font.PLAIN, 16);
    ImageIcon logo = new ImageIcon("logo.png");


    public Window() {
        setTitle("Triangle");
        setContentPane(panel);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setIconImage(logo.getImage());
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        int width = 800;
        int height = 500;
        setBounds(dimension.width / 2 - width / 2, dimension.height / 2 - height / 2, width, height);
        Utils.setDefaultFont(mainFont);

        String[] identifiers = {"Точка 1 X", "Точка 1 Y", "Точка 2 X", "Точка 2 Y", "Точка 3 X", "Точка 3 Y"};
        Utils.setTable(table, identifiers);

        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File("."));
        FileFilter filter = new FileNameExtensionFilter("Text files", "txt");
        fileChooser.addChoosableFileFilter(filter);

        buttonInput.addActionListener(e -> {
            try {
                if (fileChooser.showOpenDialog(panel) == JFileChooser.APPROVE_OPTION) {
                    String path = fileChooser.getSelectedFile().getPath();
                    Object[][] arr = Utils.convertStringMatrixListToArr(Utils.readStringMatrixFromFile(path));

                    Utils.writeArrayToTable(table, arr);
                }
            } catch (Exception e1) {
                SwingUtils.showInfoMessageBox("Неверный файл", "Ошибка");
                throw new RuntimeException(e1);
            }
        });


        buttonOutput.addActionListener(e -> {
            try {
                if (fileChooser.showSaveDialog(panel) == JFileChooser.APPROVE_OPTION) {
                    String file = fileChooser.getSelectedFile().getPath();
                    PrintWriter writer = new PrintWriter(file, StandardCharsets.UTF_8);
                    writer.println();
                    writer.close();
                }
            } catch (Exception e1) {
                SwingUtils.showInfoMessageBox("Вы ввели неверные значения", "Ошибка");
            }
        });

        buttonExecute.addActionListener(e -> {
            try {
                double[][] matrix = JTableUtils.readDoubleMatrixFromJTable(table);
                assert matrix != null;
                ArrayList<Triangle> triangles = Logic.createTriangles(matrix);
                triangles.removeIf(triangle -> !triangle.oneQuarter(triangle));
                matrix = Logic.createMatrix(triangles);
                Utils.writeArrayToTable(table, matrix);


            } catch (Exception e1){
                SwingUtils.showErrorMessageBox(e1);
            }
        });
    }
}
