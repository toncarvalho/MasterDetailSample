package masterdetailsample.components;

import javafx.scene.control.Button;
import javafx.scene.control.ToolBar;
import masterdetailsample.eventos.masterdetail.DetailEventListener;
import masterdetailsample.eventos.masterdetail.MasterDetailEvent;
import masterdetailsample.eventos.masterdetail.MasterDetailEventSource;
import masterdetailsample.types.FormState;

/**
 * Created by ton on 9/26/14.
 */
public class ConfirmDetailEventslToolBar implements DetailEventListener {

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
    public void insertDetailListener(final MasterDetailEvent e) {
        this.formState = FormState.INSERINDO_DETALHE;

        this.salvar.disableProperty().set(false);
        this.cancelar.disableProperty().set(false);
    }

    @Override
    public void changeDetailListener(final MasterDetailEvent e) {
        this.formState = FormState.EDITANDO_DETALHE;

        this.salvar.disableProperty().set(false);
        this.cancelar.disableProperty().set(false);
    }

    @Override
    public void deleteDetailListener(final MasterDetailEvent e) {
        this.formState = FormState.EXCLUINDO_DETALHE;
        this.salvar.disableProperty().set(true);
        this.cancelar.disableProperty().set(false);
    }

    @Override
    public void searchDetailListener(final MasterDetailEvent e) {
        this.formState = FormState.PESQUISANDO_ITENS_DETALHE;

        this.salvar.disableProperty().setValue(true);
        this.cancelar.disableProperty().setValue(true);
    }

    @Override
    public void persistDetailListener(final MasterDetailEvent e) {
        this.formState = FormState.PROCESSANDO;
        this.salvar.disableProperty().setValue(true);
        this.cancelar.disableProperty().setValue(true);


    }

    @Override
    public void cancelDetailListener(final MasterDetailEvent e) {
        this.formState = FormState.PROCESSANDO;
        this.salvar.disableProperty().setValue(true);
        this.cancelar.disableProperty().setValue(true);
    }

    @Override
    public void selectDetailListener(final MasterDetailEvent event) {
        this.salvar.disableProperty().set(true);
        this.cancelar.disableProperty().set(true);
    }

    @Override
    public void restartSearchInDetails(final MasterDetailEvent event) {

    }

    @Override
    public void selectMasterItemListener(final MasterDetailEvent event) {
        this.salvar.disableProperty().set(true);
        this.cancelar.disableProperty().set(true);
    }

    @Override
    public void startNewDetailListener(final MasterDetailEvent event) {
        this.salvar.disableProperty().set(true);
        this.cancelar.disableProperty().set(true);
    }

    public ToolBar createBarraFinalizacao() {

        this.barra = new ToolBar(salvar, cancelar);

        return this.barra;
    }

    public ConfirmDetailEventslToolBar(final MasterDetailEventSource masterDetailSource) {
        this.masterDetailSource = masterDetailSource;
    }
}
