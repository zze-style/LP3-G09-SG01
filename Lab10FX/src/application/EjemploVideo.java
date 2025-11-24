package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import java.io.File;

public class EjemploVideo extends Application {
    
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;

	@Override
	public void start(Stage primaryStage) {
		try {
            String videoFilePath = "URL DEL VIDEO";
            String videoUrl = new File(videoFilePath).toURI().toString();

            Media media = new Media(videoUrl);
            
            MediaPlayer mediaPlayer = new MediaPlayer(media);
            
            MediaView mediaView = new MediaView(mediaPlayer);

            mediaView.setFitWidth(WIDTH);
            mediaView.setFitHeight(HEIGHT);
            mediaView.setPreserveRatio(true);
            
			BorderPane root = new BorderPane();
            
            root.setCenter(mediaView);

			Scene scene = new Scene(root, WIDTH, HEIGHT);
            
			primaryStage.setScene(scene);
            primaryStage.setTitle("Reproductor de Video JavaFX");
			primaryStage.show();
            
            mediaPlayer.play();
            
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}