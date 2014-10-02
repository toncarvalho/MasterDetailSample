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
public class ToolBarFinalMaster implements MasterEventListener {

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
    public void inicioCadastro(final MasterDetailEvent e) {
        this.formState = FormState.INICIAL;
        this.salvar.disableProperty().setValue(true);
        this.cancelar.disableProperty().setValue(true);
    }

    @Override
    public void gravacaoRegistro(final MasterDetailEvent e) {
        this.formState = FormState.PROCESSANDO;
        this.salvar.disableProperty().setValue(true);
        this.cancelar.disableProperty().setValue(true);
    }

    @Override
    public void insercaoRegistro(final MasterDetailEvent e) {
        this.formState = FormState.INSERINDO;
        this.salvar.disableProperty().set(false);
        this.cancelar.disableProperty().set(false);
    }

    @Override
    public void alteracaoRegistro(final MasterDetailEvent e) {
        this.formState = FormState.EDITANDO;
        this.salvar.disableProperty().set(false);
        this.cancelar.disableProperty().set(false);
    }

    @Override
    public void exclusaoRegistro(final MasterDetailEvent e) {
        this.formState = FormState.EXCLUINDO;
        this.salvar.disableProperty().set(true);
        this.cancelar.disableProperty().set(false);
    }

    @Override
    public void pesquisaRegistro(final MasterDetailEvent e) {
        this.formState = FormState.PESQUISANDO;

        this.salvar.disableProperty().set(true);
        this.cancelar.disableProperty().set(true);
    }

    @Override
    public void cancelamentoRegistro(final MasterDetailEvent e) {
        this.formState = FormState.PROCESSANDO;
        this.salvar.disableProperty().setValue(true);
        this.cancelar.disableProperty().setValue(true);
    }

    @Override
    public void selecaoDeIten(final MasterDetailEvent event) {
        this.salvar.disableProperty().set(true);
        this.cancelar.disableProperty().set(true);
    }

    @Override
    public void reiniciaPesquisa(final MasterDetailEvent event) {

    }

    public ToolBar createBarraFinalizacao() {

        this.barra = new ToolBar(salvar, cancelar);

        return this.barra;
    }

    public ToolBarFinalMaster(final MasterDetailEventSource masterDetailSource) {
        this.masterDetailSource = masterDetailSource;
    }
}
