package ru.smirnov.utils;


import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Scanner;


public class Utils {

    /**
     * чтение из файла
     */

    public static String readLineFromFile(String fileName) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            return br.readLine();
        }

    }

    /**
     * запись в файл
     */

    public static void writeLineToFile(String filePath, String text) throws IOException {
        List<String> list = List.of(text);
        Path file = Paths.get(filePath);
        Files.write(file, list, StandardCharsets.UTF_8);
    }
    public static void  writeDoubleMatrixToFile(String file, double[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                
            }
        }
    }

    public static String[] readStringArrayFromFile(String path) {
        String[] params;
        try {
            File file = new File(path);
            BufferedReader br = new BufferedReader(new FileReader(file));
            params = br.readLine().split(" ");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return params;
    }


    public static String[][] readStringMatrixFromFile(String path) throws FileNotFoundException {
        List<List<String>> list = new ArrayList<>();
        Scanner rowScan = new Scanner(new File(path));
        while (rowScan.hasNextLine()) {
            List<String> line = List.of(rowScan.nextLine().split(" "));
            list.add(line);
        }
        return convertStringMatrixListToArr(list);
    }


    public static String[][] convertStringMatrixListToArr(List<List<String>> list) {
        String[][] arr = new String[list.size()][list.get(0).size()];
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.get(i).size(); j++) {
                arr[i][j] = list.get(i).get(j);
            }
        }
        return arr;
    }

    public static void setTable(JTable table, String[] identifiers, int cellSize) {
        Font font = new Font("Roboto", Font.PLAIN, 18);
        table.setFont(font);
        table.setRowHeight(cellSize);
        table.createDefaultColumnsFromModel();
        DefaultTableModel model = new DefaultTableModel();
        for (int i = 0; i < table.getColumnModel().getColumnCount(); i++) {
            table.getColumnModel().getColumn(i).setPreferredWidth(cellSize/2);
        }
        model.setColumnCount(identifiers.length);
        model.setColumnIdentifiers(identifiers);
        table.setModel(model);
    }
    public static void writeArrayToTable(JTable table, Object[][] arr) {
        if (!arr.getClass().isArray()) {
            return;
        }
        if (!(table.getModel() instanceof DefaultTableModel tableModel)) {
            return;
        }
        tableModel.setRowCount(0);
        for (Object[] objects : arr) {
            tableModel.addRow(objects);
        }
    }


    public static void setDefaultFont(Font font) {
        Enumeration<Object> keys = UIManager.getDefaults().keys();
        while (keys.hasMoreElements()) {
            Object key = keys.nextElement();
            Object value = UIManager.get(key);
            if (value instanceof javax.swing.plaf.FontUIResource) {
                UIManager.put(key, font);
            }
        }
    }

    public static List<String> textToWords(String line) {
        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < line.length(); i++) {
            if (line.charAt(i) != ' ' && line.charAt(i) != ',' && line.charAt(i) != ';') {
                sb.append(line.charAt(i));
            } else {
                list.add(sb.toString());
                sb = new StringBuilder();
            }
        }
        list.add(sb.toString());
        return list;
    }

    public static void writeArrayToTable(JTable table, double[][] matrix) {
        if (!matrix.getClass().isArray()) {
            return;
        }
        if (!(table.getModel() instanceof DefaultTableModel tableModel)) {
            return;
        }
        tableModel.setRowCount(matrix.length);
        for (int i = 0; i < matrix.length - 1; i++) {
            for (int j = 0; j < 6; j++) {
                table.setValueAt(matrix[i][j], i, j);
            }
        }
    }
}