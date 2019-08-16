package com.twu.biblioteca;

import java.util.Scanner;

public class ScannerWrapper {

    public String nextLine() {
        return new Scanner(System.in).nextLine();
    }
}
