package ru.smirnov.tasks.task10_18;

import ru.smirnov.utils.ArrayUtils;

import javax.swing.*;
import java.io.PrintStream;
import java.util.Objects;


public class Main {

    public static class CmdParams {
        public String inputFile;
        public String outputFile;
        public boolean error;
        public boolean help;
        public boolean window;
    }

    public static CmdParams parseArgs(String[] args) {
        CmdParams params = new CmdParams();
        if (args.length > 0) {
            if (args[0].equals("--help")) {
                params.help = true;
                return params;
            }
            if (args[0].equals("--window")) {
                params.window = true;
                return params;
            }
            params.inputFile = args[0];
            if (args.length > 1) {
                params.outputFile = args[1];
            }
            if (args.length > 2) {
                params.help = true;
                params.error = true;
            }
        } else {
            params.help = true;
            params.error = true;
        }
        return params;
    }


    public static void main(String[] args) throws Exception {
        CmdParams params = parseArgs(args);
        if (params.help) {
            PrintStream out = params.error ? System.err : System.out;
            out.println("Usage:");
            out.println("  <cmd> args <input-file> (<output-file>)");
            out.println("  <cmd> --help");
            System.exit(params.error ? 1 : 0);
        }
        if (params.window) {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName()  );
            new Window().setVisible(true);
        } else {
            int[][] matrix = ArrayUtils.readIntArray2FromFile(params.inputFile);
            if (matrix == null) {
                System.err.printf("Can't read matrix from \"%s\"%n", params.inputFile);
                System.exit(2);
            }
            Triangle[] triangles = new Triangle[matrix.length];
            for (int row = 0; row < Objects.requireNonNull(matrix).length; row++) {
                String[] arr = new String[matrix[row].length];
                for (int column = 0; column < matrix[row].length; column++) {
                    arr[column] = String.valueOf(matrix[row][column]);
                }
                triangles[row] = new Triangle( Integer.parseInt(arr[0]),  Integer.parseInt(arr[1]),  Integer.parseInt(arr[2]),  Integer.parseInt(arr[3]),  Integer.parseInt(arr[4]),  Integer.parseInt(arr[5]));
            }
            boolean[] inOneQuarter = Logic.oneQuarter(triangles);

            PrintStream out = (params.outputFile != null) ? new PrintStream(params.outputFile) : System.out;
            for (int i = 0; i < inOneQuarter.length; i++) {
                out.printf("[" + triangles[i].getPoint1X() + " " + triangles[i].getPoint1Y() + " " + triangles[i].getPoint2X() + " " + triangles[i].getPoint2Y() + " " + triangles[i].getPoint3X() + " "  + triangles[i].getPoint3Y() + " "  +  "] - " + inOneQuarter[i] +"\n");
            }
            out.close();
        }
    }
}