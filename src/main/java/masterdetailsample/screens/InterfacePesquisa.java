package masterdetailsample.screens;

import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import masterdetailsample.components.BarraDeFerramentasInicial;
import masterdetailsample.eventos.MasterDetailSource;

/**
 * Created by ton on 9/29/14.
 */
public class InterfacePesquisa {

    private MasterDetailSource masterDetailSource;
    private VBox vBox = new VBox();

    public InterfacePesquisa(final MasterDetailSource masterDetailSource) {
        this.masterDetailSource = masterDetailSource;

        BarraDeFerramentasInicial ferramentasJanelaPesquisa = new BarraDeFerramentasInicial();

        masterDetailSource.addMasterDetailListener(ferramentasJanelaPesquisa);
        VBox interfacePesquisa = new VBox();
        interfacePesquisa.getChildren().add(new Label("Pesquisa"));
        interfacePesquisa.getChildren().add(ferramentasJanelaPesquisa.createBarraInicializacao());
        Label statusBar = new Label("Status:");

        ferramentasJanelaPesquisa.novo.setOnAction(event -> {
            masterDetailSource.insercaoRegistro(this);
        });

        ferramentasJanelaPesquisa.alterar.setOnAction(event -> {
            masterDetailSource.alteracaoRegistro(this);
        });

        ferramentasJanelaPesquisa.excluir.setOnAction(event -> {
            masterDetailSource.exclusaoRegistro(this);
        });

        vBox.getChildren().add(interfacePesquisa);
    }

    public VBox getScreen() {
        return this.vBox;
    }
}
