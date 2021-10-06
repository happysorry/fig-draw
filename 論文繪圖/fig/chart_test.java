
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

import org.jfree.chart.ChartFactory;

import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;

import org.jfree.chart.plot.PlotOrientation;

import org.jfree.data.category.DefaultCategoryDataset;

public class chart_test {
    public static void main(String[] args) {
        JFreeChart lineChart = ChartFactory.createLineChart(
            "Title",
            "X axis",
            "Y axis",
            create_dataset(),
            PlotOrientation.VERTICAL,
            true,true,false
        );
        // CategoryPlot plot = (CategoryPlot) lineChart.getPlot();
        // // Create an NumberAxis
        // NumberAxis xAxis = new NumberAxis();
        // xAxis.setTickUnit(new NumberTickUnit(20));

        saveAsFile(lineChart, "C:\\Users\\USER\\Desktop\\thread-master\\Fig\\share.jpg", 600,400);
    }

    public static void saveAsFile(JFreeChart chart, String outputPath,
			int weight, int height) {
		FileOutputStream out = null;
		try {
			File outFile = new File(outputPath);
			if (!outFile.getParentFile().exists()) {
				outFile.getParentFile().mkdirs();
			}
			out = new FileOutputStream(outputPath);
			
			ChartUtilities.writeChartAsJPEG(out, chart, weight, height);
			out.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (out != null) {
				try {
					out.close();
				} catch (IOException e) {
					// do nothing
				}
			}
		}
	}

    public static DefaultCategoryDataset create_dataset(){
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        int con = 0;
        try {
            FileReader fr = new FileReader("C:\\Users\\USER\\Desktop\\Fig\\share.txt");
            BufferedReader br = new BufferedReader(fr);
            try {
                while (br.ready()) {
                    // int tmp = Integer.parseInt(br.readLine());
                    double tmp = Double.parseDouble(br.readLine());
                    dataset.addValue(tmp, "use", String.valueOf(con));
                    con ++;
                }
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        return dataset;
    }
    // public static XYDataset create_dataset(){
    //     XYSeriesCollection dataset = new XYSeriesCollection();
    //     XYSeries series1 = new XYSeries("Object 1");
    //     int con = 0;
    //     try {
    //         FileReader fr = new FileReader("share.txt");
    //         BufferedReader br = new BufferedReader(fr);
    //         try {
    //             while (br.ready()) {
    //                 // int tmp = Integer.parseInt(br.readLine());
    //                 double tmp = Double.parseDouble(br.readLine());
    //                 series1.add(tmp, con);
    //                 con ++;
    //             }
                
    //             dataset.addSeries(series1);
    //         } catch (IOException e) {
    //             // TODO Auto-generated catch block
    //             e.printStackTrace();
    //         }

    //     } catch (FileNotFoundException e) {
    //         // TODO Auto-generated catch block
    //         e.printStackTrace();
    //     }
        
    //     return dataset;
    // }
}