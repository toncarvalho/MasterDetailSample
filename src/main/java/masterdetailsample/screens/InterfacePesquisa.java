package masterdetailsample.screens;

import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import masterdetailsample.components.BarraDeFerramentasInicial;
import masterdetailsample.components.BarraDeStatus;
import masterdetailsample.eventos.MasterDetailSource;
import masterdetailsample.types.FormState;

/**
 * Created by ton on 9/29/14.
 */
public class InterfacePesquisa {

    private MasterDetailSource masterDetailSource;
    private VBox vBox = new VBox();
    private FormState estado;

    public InterfacePesquisa(final MasterDetailSource masterDetailSource) {
        this.estado = FormState.INICIAL;
        this.masterDetailSource = masterDetailSource;

        BarraDeFerramentasInicial ferramentasJanelaPesquisa = new BarraDeFerramentasInicial(masterDetailSource);

        this.masterDetailSource.addMasterDetailListener(ferramentasJanelaPesquisa);
        VBox interfacePesquisa = new VBox();
        interfacePesquisa.getChildren().add(new Label("Pesquisa"));
        interfacePesquisa.getChildren().add(ferramentasJanelaPesquisa.createBarraInicializacao());

        BarraDeStatus status = new BarraDeStatus();
        interfacePesquisa.getChildren().add(status);
        this.masterDetailSource.addMasterDetailListener(status);
        interfacePesquisa.setPrefSize(200, 200);
        vBox.getChildren().add(interfacePesquisa);
    }

    public VBox getScreen() {
        return this.vBox;
    }
}
