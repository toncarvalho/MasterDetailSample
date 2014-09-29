package masterdetailsample.screens;

import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import masterdetailsample.components.BarraDeFerramentasFinal;
import masterdetailsample.eventos.MasterDetailSource;

/**
 * Created by ton on 9/29/14.
 */
public class FormMaster {
    private VBox formMaster = new VBox();
    private MasterDetailSource masterDetailSource;

    public FormMaster(final MasterDetailSource masterDetailSource) {
        this.masterDetailSource = masterDetailSource;

        BarraDeFerramentasFinal ferramentasFormularioMaster = new BarraDeFerramentasFinal();
        this.masterDetailSource.addMasterDetailListener(ferramentasFormularioMaster);
        formMaster.getChildren().add(new Label("FORMULÁRIO MASTER"));
        formMaster.getChildren().add(ferramentasFormularioMaster.createBarraFinalizacao());

        ferramentasFormularioMaster.salvar.setOnAction(event -> {
            masterDetailSource.gravacaoRegistro(this);
        });
        ferramentasFormularioMaster.cancelar.setOnAction(event -> {
            masterDetailSource.cancelamentoRegistro(this);
        });
    }

    public VBox getScreen() {

        return this.formMaster;
    }
}
