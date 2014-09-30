package masterdetailsample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Separator;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import masterdetailsample.eventos.masterdetail.MasterDetailEventSource;
import masterdetailsample.model.DataBase;
import masterdetailsample.screens.FormMaster;
import masterdetailsample.screens.InterfacePesquisa;

/**
 * Created by ton on 9/26/14.
 */
public class MasterDetatilStart extends Application {

    private DataBase base = DataBase.getInstance();

    @Override
    public void start(final Stage primaryStage) throws Exception {

        AnchorPane anchorPane = new AnchorPane();

        VBox vBox = new VBox();
        vBox.setVgrow(anchorPane, Priority.ALWAYS);
        vBox.setFillWidth(true);

        MasterDetailEventSource masterDetailSource = new MasterDetailEventSource();

        vBox.getChildren().add(new InterfacePesquisa(masterDetailSource).getScreen());

        FormMaster formMaster = new FormMaster(masterDetailSource);
        masterDetailSource.addMasterDetailListener(formMaster);

        Separator separator = new Separator();
        separator.setPrefSize(20, 20);
        vBox.getChildren().add(separator);
        vBox.getChildren().add(formMaster.getScreen());

        anchorPane.getChildren().add(vBox);
        Scene scene = new Scene(anchorPane);

        primaryStage.setScene(scene);
        primaryStage.setMaximized(true);
        primaryStage.setTitle("Exemplo Mestre Detalhes");
        primaryStage.show();
    }
}
