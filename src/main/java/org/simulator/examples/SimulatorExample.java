import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Cylinder;
import javafx.scene.shape.Sphere;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.animation.RotateTransition;
import javafx.util.Duration;

public class Interactive3DApp extends Application {

    @Override
    public void start(Stage primaryStage) {
        // إعداد عناصر واجهة المستخدم
        StackPane root = new StackPane();
        
        // شكل كروي كجزء من واجهة الأطفال
        Sphere sphere = new Sphere(50);
        sphere.setMaterial(new javafx.scene.paint.PhongMaterial(Color.ORANGE));  // لون كرتوني جذاب
        
        // شكل اسطواني لإضافة بعد ثلاثي
        Cylinder cylinder = new Cylinder(30, 100);
        cylinder.setMaterial(new javafx.scene.paint.PhongMaterial(Color.CYAN));

        // نص ترحيبي
        Text welcomeText = new Text("مرحبًا بك في التطبيق!");
        welcomeText.setStyle("-fx-font-size: 20px; -fx-font-weight: bold; -fx-fill: #4CAF50;");
        
        // إضافة العناصر إلى الشاشة
        root.getChildren().addAll(sphere, cylinder, welcomeText);

        // إعداد حركة تفاعلية للأشكال
        RotateTransition rotateSphere = new RotateTransition(Duration.seconds(5), sphere);
        rotateSphere.setByAngle(360);
        rotateSphere.setCycleCount(RotateTransition.INDEFINITE);
        rotateSphere.play();

        RotateTransition rotateCylinder = new RotateTransition(Duration.seconds(5), cylinder);
        rotateCylinder.setByAngle(-360);
        rotateCylinder.setCycleCount(RotateTransition.INDEFINITE);
        rotateCylinder.play();

        // إعداد المشهد والنافذة
        Scene scene = new Scene(root, 600, 400, true);
        scene.setFill(Color.LIGHTBLUE);  // خلفية سماء زرقاء

        primaryStage.setTitle("تطبيق تفاعلي للأطفال");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
