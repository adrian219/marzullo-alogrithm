package pl.edu.wat.wcy.isi.orr.wieczorek.adrian.start;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import pl.edu.wat.wcy.isi.orr.wieczorek.adrian.algorithm.IntersectionAlgorithm;
import pl.edu.wat.wcy.isi.orr.wieczorek.adrian.algorithm.MarzulloAlgorithm;
import pl.edu.wat.wcy.isi.orr.wieczorek.adrian.element.Interval;
import pl.edu.wat.wcy.isi.orr.wieczorek.adrian.exception.InvalidIntervalException;
import pl.edu.wat.wcy.isi.orr.wieczorek.adrian.util.AlgorithmType;

import java.util.ArrayList;
import java.util.List;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();

        getBestInterval();
    }


    public static void main(String[] args) {
        launch(args);
    }

    private static void getBestInterval(){
        List<Interval> intervalList = new ArrayList<>();

        intervalList.add(new Interval(3.0, 10.0));
        intervalList.add(new Interval(1.0, 6.0));
        intervalList.add(new Interval(4.0, 8.0));
        intervalList.add(new Interval(6.0, 13.0));
        intervalList.add(new Interval(9.0, 12.0));

        MarzulloAlgorithm marzulloAlgorithm = new MarzulloAlgorithm();
        IntersectionAlgorithm intersectionAlgorithm = new IntersectionAlgorithm();

        try {
            Interval marzulloInterval = marzulloAlgorithm.getBestInterval(intervalList);
            System.out.println("MARZULLO: [" + marzulloInterval.getStart() + ", " + marzulloInterval.getEnd() + "]");
        } catch (InvalidIntervalException e) {
            System.out.println("Bledny przedzial algorytm: " + AlgorithmType.MARZULLO);
        }

        try {
            Interval intersectionInterval = intersectionAlgorithm.getBestInterval(intervalList);
            System.out.println("INTERSECTION: [" + intersectionInterval.getStart() + ", " + intersectionInterval.getEnd() + "]");
        } catch (InvalidIntervalException e) {
            System.out.println("Bledny przedzial algorytm: " + AlgorithmType.INTERSECTION);
        }
    }
}
