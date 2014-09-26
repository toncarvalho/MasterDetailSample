package masterdetailsample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import masterdetailsample.eventos.MasterDetailSource;

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

        BarraDeFerramentas ferramentasJanelaPesquisa = new BarraDeFerramentas();
        masterDetailSource.addMasterDetailListener(ferramentasJanelaPesquisa);
        VBox interfacePesquisa = new VBox();
        interfacePesquisa.getChildren().add(new Label("Pesquisa"));
        interfacePesquisa.getChildren().add(ferramentasJanelaPesquisa.getBarraInicializacao());
        vBox.getChildren().add(interfacePesquisa);

        VBox formMaster = new VBox();
        BarraDeFerramentas ferramentasFormularioMaster = new BarraDeFerramentas();
        masterDetailSource.addMasterDetailListener(ferramentasFormularioMaster);
        formMaster.getChildren().add(new Label("FORMULÁRIO MASTER"));
        formMaster.getChildren().add(ferramentasFormularioMaster.getBarraFinalizacao());
        vBox.getChildren().add(formMaster);

        VBox formDetalhe = new VBox();
        BarraDeFerramentas ferramentasFormularioDetalhe = new BarraDeFerramentas();
        masterDetailSource.addMasterDetailListener(ferramentasFormularioDetalhe);
        formDetalhe.getChildren().add(new Label("FORMULÁRIO DETALHE"));
        formDetalhe.getChildren().add(ferramentasFormularioDetalhe.getBarraInicializacao());
        vBox.getChildren().add(formDetalhe);

        VBox painelDadosDetalhe = new VBox();
        BarraDeFerramentas ferramentasPainelDadosDetalhe = new BarraDeFerramentas();
        masterDetailSource.addMasterDetailListener(ferramentasPainelDadosDetalhe);
        painelDadosDetalhe.getChildren().add(new Label("Painel de dados do DETALHE"));
        painelDadosDetalhe.getChildren().add(ferramentasPainelDadosDetalhe.getBarraFinalizacao());
        vBox.getChildren().add(painelDadosDetalhe);

        anchorPane.getChildren().add(vBox);
        Scene scene = new Scene(anchorPane);

        primaryStage.setScene(scene);
        primaryStage.setMaximized(true);
        primaryStage.setTitle("Exemplo Mestre Detalhes");
        primaryStage.show();

        masterDetailSource.inicioCadastro();
        masterDetailSource.insercaoRegistroDetalhe();
    }
}
