package com.example.day12.IO;

import java.io.*;

public class Test8 {
    public static void main(String[] args) {
//        try (BufferedReader br = new BufferedReader(new FileReader("src//com//example//day12//txt//Test.txt"));
//             BufferedWriter bw = new BufferedWriter(new FileWriter("src//com//example//day12//txt//Test8Write.txt"))) {
//            String str;
//            while ((str = br.readLine()) != null) {
//                bw.write(str + "hi\n");
//            }
//        } catch (FileNotFoundException e) {
//            throw new RuntimeException(e);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }

        try (BufferedReader br = new BufferedReader(new FileReader("src//com//example//day12//txt//Test.txt"));
             PrintWriter pw = new PrintWriter("src//com//example//day12//txt//Test8Write.txt")) {
            String str;
            while ((str = br.readLine()) != null) {
                pw.println(str + "hi");
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
