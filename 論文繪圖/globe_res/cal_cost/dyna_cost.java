import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class dyna_cost {

    public static ArrayList<Double> mn1_con = new ArrayList<>();
    public static ArrayList<Double> mn2_con = new ArrayList<>();
    public static ArrayList<Double> mnae1_con = new ArrayList<>();
    public static ArrayList<Double> mnae2_con = new ArrayList<>();
    public static ArrayList<Double> mn1_res = new ArrayList<>();
    public static ArrayList<Double> mn2_res = new ArrayList<>();
    public static ArrayList<Double> mnae1_res = new ArrayList<>();
    public static ArrayList<Double> mnae2_res = new ArrayList<>();

    public static ArrayList<Double> mn1_cost = new ArrayList<>();
    public static ArrayList<Double> total_cost = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        read_con("app_mn1");
        read_con("app_mn2");
        read_con("app_mnae1");
        read_con("app_mnae2");
        read_res("app_mn1");
        read_res("app_mn2");
        read_res("app_mnae1");
        read_res("app_mnae2");

        for (int i = 0; i < mn1_res.size(); i++) {
            mn1_cost(mn1_res.get(i), mn1_con.get(i));
        }
        double mn1_sum = 0;
        for (int i = 0; i < mn1_res.size(); i++) {
            mn1_sum += mn1_cost.get(i);
        }
        mn1_sum /= mn1_res.size();
        mn1_sum *= -1;
        System.out.println("mn1 cost= " + mn1_sum);

        double total_sum = 0;
        total_cost();
        for (int i = 0; i < mn1_res.size(); i++) {
            total_sum += total_cost.get(i);
        }
        total_sum /= mn1_res.size();
        total_sum *= -1;
        System.out.println("total cost = " + total_sum);
    }

    public static void read_con(String con_name) {
        String filename = "D:\\test result\\final\\dyna threshold(50)\\5\\con1\\" + con_name + "_con1.txt";
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
                            mn1_con.add(val);
                            break;
                        case "app_mn2":
                            mn2_con.add(val);
                            break;
                        case "app_mnae1":
                            mnae1_con.add(val);
                            break;
                        case "app_mnae2":
                            mnae2_con.add(val);
                            break;
                    }
                }
                while (count < 120) {// less than 120
                    switch (con_name) {
                        case "app_mn1":
                            mn1_con.add(val);
                            break;
                        case "app_mn2":
                            mn2_con.add(val);
                            break;
                        case "app_mnae1":
                            mnae1_con.add(val);
                            break;
                        case "app_mnae2":
                            mnae2_con.add(val);
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

    public static void read_res(String con_name) {
        String filename = "D:\\test result\\final\\dyna threshold(50)\\5\\resp\\" + con_name + "_response_time.txt";
        try {
            FileReader fr = new FileReader(filename);
            BufferedReader r = new BufferedReader(fr);
            String line = "";
            double val = 0;
            try {
                while ((line = r.readLine()) != null) {
                    val = Double.parseDouble(line);
                    switch (con_name) {
                        case "app_mn1":
                            mn1_res.add(val);
                            break;
                        case "app_mn2":
                            mn2_res.add(val);
                            break;
                        case "app_mnae1":
                            mnae1_res.add(val);
                            break;
                        case "app_mnae2":
                            mnae2_res.add(val);
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

    public static double mn1_cost(double resp_time, double cons) {
        double sum = 0;
        // weight of cost
        double wres = 0.5;
        double wadp = 0.0;
        double wperf = 0.5;
        // cost

        double cperf_ = 1;

        double tmax = 25;

        if (resp_time > 50)
            resp_time = 50;
        if (resp_time < tmax)
            cperf_ = 0;

        double tmp = resp_time / tmax;
        double pow = Math.pow(1.4, tmp);
        ////////////////////////////
        double m = 50 / tmax;
        double max_pow = Math.pow(1.4, m);
        pow /= max_pow;
        ////////////////////////////
        cperf_ *= pow;
        // print_perf_cost(-wperf * cperf_);

        double total_use = Double.valueOf(cons);
        //////////////////////////
        total_use /= 4; // max container numbers
        ////////////////////////
        sum = wres * total_use + wperf * (cperf_);
        mn1_cost.add(sum);
        return sum;
    }

    public static void total_cost() {
        double tmpp = 0;
        for (int i = 0; i < mn1_res.size(); i++) {
            double sum = 0;
            // weight of cost
            double wres = 0.5;
            double wadp = 0.0;
            double wperf = 0.5;
            // cost

            double cperf_ = 1;

            double tmax = 75;
            double resp_time = mn1_res.get(i) + mn1_res.get(i) + mn2_res.get(i) + mnae1_res.get(i) + mnae2_res.get(i);
            if (resp_time > 100)
                resp_time = 100;
            if (resp_time < tmax)
                cperf_ = 0;

            double tmp = resp_time / tmax;
            double pow = Math.pow(1.4, tmp);
            ////////////////////////////
            double m = 100 / tmax;
            double max_pow = Math.pow(1.4, m);
            pow /= max_pow;
            ////////////////////////////
            cperf_ *= pow;

            // print_perf_cost(-wperf * cperf_);
            double cons = mn1_con.get(i) + mn2_con.get(i) + mnae1_con.get(i) + mnae2_con.get(i);
            double total_use = Double.valueOf(cons);
            //////////////////////////
            total_use /= 16; // max container numbers
            ////////////////////////
            sum = wres * total_use + wperf * (cperf_);

            total_cost.add(sum);
            tmpp = total_use;
            // System.out.println("total_use" + sum);
        }

    }
}
