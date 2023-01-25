package ru.smirnov.tasks.task10_18;

import ru.smirnov.utils.ArrayUtils;
import ru.smirnov.utils.Utils;

import javax.swing.*;
import java.io.PrintStream;
import java.util.ArrayList;


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
            if (args[   0].equals("--window")) {
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
            double[][] matrix = ArrayUtils.readDoubleArray2FromFile(params.inputFile);
            if (matrix == null) {
                System.err.printf("Can't read matrix from \"%s\"%n", params.inputFile);
                System.exit(2);
            };
            ArrayList<Triangle> triangles = Logic.createTriangles(matrix);
            triangles = Logic.filter(triangles);
            matrix = Logic.createMatrix(triangles);
            Utils.writeDoubleMatrixToFile(params.outputFile, matrix);

            PrintStream out = (params.outputFile != null) ? new PrintStream(params.outputFile) : System.out;
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    out.printf("%.2f ",matrix[i][j]);
                }
                out.print("\n");
            }
            out.close();
        }
    }
}