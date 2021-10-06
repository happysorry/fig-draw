package threshold;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class global_resource {
    public static ArrayList<Double> mn1 = new ArrayList<>();
    public static ArrayList<Double> mn2 = new ArrayList<>();
    public static ArrayList<Double> mnae1 = new ArrayList<>();
    public static ArrayList<Double> mnae2 = new ArrayList<>();
    public static ArrayList<Double> total = new ArrayList<>();

    public static void main(String[] args) {
        read("app_mn1");
        read("app_mn2");
        read("app_mnae1");
        read("app_mnae2");

        System.out.println(mn2.size());
        double total_avg = 0;
        for (int i = 0; i < mn1.size(); i++) {
            double avg = 0;
            avg = mn1.get(i) + mn2.get(i) + mnae1.get(i) + mnae2.get(i);
            total_avg += avg;
            total.add(avg);
            // System.out.println(avg);
            write(avg);
        }
        total_avg /= total.size();
        System.out.println(total_avg);

    }

    public static void read(String con_name) {
        String filename = "D:\\test result\\final\\7200~10800\\threshold(20)\\2\\con1\\" + con_name + "_con1.txt";
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

    public static void write(double avg) {
        try {
            String filename = "D:\\test result\\final\\7200~10800\\threshold(20)\\2\\globe_resource.txt";
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
