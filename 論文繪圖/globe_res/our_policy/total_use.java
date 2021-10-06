package our_policy;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class total_use {
    public static ArrayList<Double> mn1 = new ArrayList<>();
    public static ArrayList<Double> mn2 = new ArrayList<>();
    public static ArrayList<Double> mnae1 = new ArrayList<>();
    public static ArrayList<Double> mnae2 = new ArrayList<>();

    public static ArrayList<Double> mn11 = new ArrayList<>();
    public static ArrayList<Double> mn22 = new ArrayList<>();
    public static ArrayList<Double> mnae11 = new ArrayList<>();
    public static ArrayList<Double> mnae22 = new ArrayList<>();

    public static ArrayList<Double> total = new ArrayList<>();

    public static void main(String[] args) {
        read("app_mn1");
        read("app_mn2");
        read("app_mnae1");
        read("app_mnae2");
        read2("app_mn1");
        read2("app_mn2");
        read2("app_mnae1");
        read2("app_mnae2");
        double total_avg = 0;
        for (int i = 0; i < mn2.size(); i++) {
            double avg = 0;
            avg = mn1.get(i) + mn2.get(i) + mnae1.get(i) + mnae2.get(i);
            // avg *= 0.1;
            avg /= 4;
            total_avg += avg;
            total.add(avg);
            write(avg);
        }
        total_avg /= total.size();
        System.out.println(total_avg);
    }

    public static void read(String con_name) {
        String filename = "D:\\test result\\final\\tmax=25(20-1)\\7200~10800\\2\\" + con_name + "\\" + con_name
                + "_use.txt";
        try {
            FileReader fr = new FileReader(filename);
            BufferedReader r = new BufferedReader(fr);
            String line = "";
            double val = 0;
            int count = 0;
            try {
                while ((line = r.readLine()) != null) {
                    count++;
                    val = Double.parseDouble(line);
                    switch (con_name) {
                        case "app_mn1":
                            mn1.add(val);
                            break;
                        case "app_mn2":
                            mn2.add(val);
                            break;
                        case "app_mnae1":
                            mnae1.add(val);
                            break;
                        case "app_mnae2":
                            mnae2.add(val);
                            break;
                    }
                }
                while (count < 120) {// less than 120
                    switch (con_name) {
                        case "app_mn1":
                            mn1.add(val);
                            break;
                        case "app_mn2":
                            mn2.add(val);
                            break;
                        case "app_mnae1":
                            mnae1.add(val);
                            break;
                        case "app_mnae2":
                            mnae2.add(val);
                            break;
                    }
                    count++;
                }
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void read2(String con_name) {
        String filename = "D:\\test result\\final\\tmax=25(20-1)\\7200~10800\\2\\" + con_name + "\\" + con_name
                + "_use.txt";
        try {
            FileReader fr = new FileReader(filename);
            BufferedReader r = new BufferedReader(fr);
            String line = "";
            double val = 0;
            try {
                while ((line = r.readLine()) != null) {
                    if (line == "nan") {
                        if (con_name == "app_mn1")
                            val = 40;
                        else
                            val = 5;
                    }
                    val = Double.parseDouble(line);
                    val++;
                    switch (con_name) {
                        case "app_mn1":
                            mn11.add(val);
                            break;
                        case "app_mn2":
                            mn22.add(val);
                            break;
                        case "app_mnae1":
                            mnae11.add(val);
                            break;
                        case "app_mnae2":
                            mnae22.add(val);
                            break;
                    }
                }
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void write(double avg) {
        try {
            String filename = "D:\\test result\\final\\tmax=25(20-1)\\7200~10800\\2\\total_use.txt";
            FileWriter fw1 = new FileWriter(filename, true);
            fw1.write(avg + "\n");
            fw1.flush();
            fw1.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}