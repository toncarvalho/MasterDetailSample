package masterdetailsample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import masterdetailsample.eventos.MasterDetailSource;
import masterdetailsample.screens.FormMaster;
import masterdetailsample.screens.InterfacePesquisa;

/**
 * Created by ton on 9/26/14.
 */
public class MasterDetatilStart extends Application {
    @Override
    public void start(final Stage primaryStage) throws Exception {

        AnchorPane anchorPane = new AnchorPane();

        VBox vBox = new VBox();
        vBox.setVgrow(anchorPane, Priority.ALWAYS);
        vBox.setFillWidth(true);

        MasterDetailSource masterDetailSource = new MasterDetailSource();

        vBox.getChildren().add(new InterfacePesquisa(masterDetailSource).getScreen());

        vBox.getChildren().add(new FormMaster(masterDetailSource).getScreen());

        anchorPane.getChildren().add(vBox);
        Scene scene = new Scene(anchorPane);

        primaryStage.setScene(scene);
        primaryStage.setMaximized(true);
        primaryStage.setTitle("Exemplo Mestre Detalhes");
        primaryStage.show();
    }
}
