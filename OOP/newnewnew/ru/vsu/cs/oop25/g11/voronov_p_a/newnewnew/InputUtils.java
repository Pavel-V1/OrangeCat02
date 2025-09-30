package ru.vsu.cs.oop25.g11.voronov_p_a.newnewnew;

import java.util.Scanner;

public class InputUtils {
    static double readDoubleValueFromConsole(String varName) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.printf("Введите %s: ", varName);
            String str = scanner.nextLine();
            try {
                return Double.valueOf(str);
            } catch (Exception e) {
                System.out.printf(" -> неверное значение (%s)%n", str);
            }
        }
    }
}