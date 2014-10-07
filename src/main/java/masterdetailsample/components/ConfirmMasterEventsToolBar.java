package masterdetailsample.components;

import javafx.scene.control.Button;
import javafx.scene.control.ToolBar;
import masterdetailsample.eventos.masterdetail.MasterDetailEvent;
import masterdetailsample.eventos.masterdetail.MasterDetailEventSource;
import masterdetailsample.eventos.masterdetail.MasterEventListener;
import masterdetailsample.types.FormState;

/**
 * Created by ton on 9/26/14.
 */
public class ConfirmMasterEventsToolBar implements MasterEventListener {

    private final MasterDetailEventSource masterDetailSource;
    private FormState formState;

    public Button salvar = new Button("Salvar");
    public Button cancelar = new Button("Cancelar");
    private ToolBar barra;

    public FormState getFormState() {
        return formState;
    }

    public void setFormState(final FormState formState) {
        this.formState = formState;
    }

    @Override
    public void startFormListener(final MasterDetailEvent e) {
        this.formState = FormState.INICIAL;
        this.salvar.disableProperty().setValue(true);
        this.cancelar.disableProperty().setValue(true);
    }

    @Override
    public void persistListener(final MasterDetailEvent e) {
        this.formState = FormState.PROCESSANDO;
        this.salvar.disableProperty().setValue(true);
        this.cancelar.disableProperty().setValue(true);
    }

    @Override
    public void insertListener(final MasterDetailEvent e) {
        this.formState = FormState.INSERINDO;
        this.salvar.disableProperty().set(false);
        this.cancelar.disableProperty().set(false);
    }

    @Override
    public void changeItemListener(final MasterDetailEvent e) {
        this.formState = FormState.EDITANDO;
        this.salvar.disableProperty().set(false);
        this.cancelar.disableProperty().set(false);
    }

    @Override
    public void deleteListener(final MasterDetailEvent e) {
        this.formState = FormState.EXCLUINDO;
        this.salvar.disableProperty().set(true);
        this.cancelar.disableProperty().set(false);
    }

    @Override
    public void searchListener(final MasterDetailEvent e) {
        this.formState = FormState.PESQUISANDO;

        this.salvar.disableProperty().set(true);
        this.cancelar.disableProperty().set(true);
    }

    @Override
    public void cancelListener(final MasterDetailEvent e) {
        this.formState = FormState.PROCESSANDO;
        this.salvar.disableProperty().setValue(true);
        this.cancelar.disableProperty().setValue(true);
    }

    @Override
    public void selectListener(final MasterDetailEvent event) {
        this.salvar.disableProperty().set(true);
        this.cancelar.disableProperty().set(true);
    }

    @Override
    public void restartSearchListener(final MasterDetailEvent event) {

    }

    public ToolBar createBarraFinalizacao() {

        this.barra = new ToolBar(salvar, cancelar);

        return this.barra;
    }

    public ConfirmMasterEventsToolBar(final MasterDetailEventSource masterDetailSource) {
        this.masterDetailSource = masterDetailSource;
    }
}
