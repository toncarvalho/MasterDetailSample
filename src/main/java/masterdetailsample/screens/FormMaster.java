package masterdetailsample.screens;

import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import masterdetailsample.components.BarraDeFerramentasFinal;
import masterdetailsample.components.BarraDeStatus;
import masterdetailsample.eventos.MasterDetailSource;

/**
 * Created by ton on 9/29/14.
 */
public class FormMaster {
    private VBox formMaster = new VBox();
    private MasterDetailSource masterDetailSource;

    public FormMaster(final MasterDetailSource masterDetailSource) {
        this.masterDetailSource = masterDetailSource;

        BarraDeFerramentasFinal ferramentasFormularioMaster = new BarraDeFerramentasFinal(masterDetailSource);
        this.masterDetailSource.addMasterDetailListener(ferramentasFormularioMaster);
        formMaster.getChildren().add(new Label("FORMULÁRIO MASTER"));
        formMaster.getChildren().add(ferramentasFormularioMaster.createBarraFinalizacao());

        BarraDeStatus status = new BarraDeStatus();
        formMaster.getChildren().add(status);
        this.masterDetailSource.addMasterDetailListener(status);

        formMaster.setPrefSize(200,200);
    }

    public VBox getScreen() {

        return this.formMaster;
    }
}
