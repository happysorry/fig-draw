package cal_cost;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class cal_threshold_cost {
    public static ArrayList<Double> mn1_res = new ArrayList<>();
    public static ArrayList<Double> mn1_con = new ArrayList<>();

    public static void main(String[] args) {
        read_res();
        read_con();
        double sum = 0;
        double cost = 0;
        for (int i = 0; i < mn1_res.size(); i++) {
            cost = cal_cost(mn1_res.get(i), mn1_con.get(i));
            sum += cost;
        }
        sum /= mn1_res.size();
        sum *= -1;
        System.out.println(sum);
    }

    public static void read_res() {
        String filename = "D:\\test result\\final\\threshold(20)\\1\\resp\\app_mn1_response_time.txt";
        try {
            FileReader fr = new FileReader(filename);
            BufferedReader r = new BufferedReader(fr);
            String line = "";
            double val = 0;
            try {
                while ((line = r.readLine()) != null) {
                    val = Double.parseDouble(line);
                    mn1_res.add(val);
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

    public static void read_con() {
        String filename = "D:\\test result\\final\\threshold(20)\\1\\resp\\app_mn1_con1.txt";
        try {
            FileReader fr = new FileReader(filename);
            BufferedReader r = new BufferedReader(fr);
            String line = "";
            double val = 0;
            try {
                while ((line = r.readLine()) != null) {
                    val = Double.parseDouble(line);
                    mn1_con.add(val);
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

    public static double cal_cost(double res, double con) {
        double cperf = 1;
        if (res > 25) {
            if (res > 50)
                res = 50;
            double tmp = res / 25;
            double pow = Math.pow(1.4, tmp);
            ////////////////////////////
            double m = 50 / 25;
            double max_pow = Math.pow(1.4, m);
            pow /= max_pow;
            cperf *= pow;
        } else
            cperf = 0;
        double cres = con / 4;
        // System.out.println(cperf + " " + cres);
        double sum = (cperf + cres) / 2;
        // System.out.println(sum);
        return sum;
    }
}
