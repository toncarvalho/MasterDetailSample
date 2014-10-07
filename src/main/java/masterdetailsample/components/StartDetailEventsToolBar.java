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
public class StartDetailEventsToolBar implements DetailEventListener {

    private final MasterDetailEventSource masterDetailSource;
    private FormState formState;

    public Button novo = new Button("Novo");
    public Button alterar = new Button("Alterar");
    public Button excluir = new Button("Excluir");

    private ToolBar barra;

    public StartDetailEventsToolBar(final MasterDetailEventSource masterDetailSource) {
        this.masterDetailSource = masterDetailSource;
    }

    public FormState getFormState() {
        return formState;
    }

    public void setFormState(final FormState formState) {
        this.formState = formState;
    }

    @Override
    public void insertDetailListener(final MasterDetailEvent e) {
        this.formState = FormState.INSERINDO_DETALHE;
        this.novo.disableProperty().set(true);
        this.alterar.disableProperty().set(true);
        this.excluir.disableProperty().set(true);
    }

    @Override
    public void changeDetailListener(final MasterDetailEvent e) {
        this.formState = FormState.EDITANDO_DETALHE;
        this.novo.disableProperty().set(true);
        this.alterar.disableProperty().set(true);
        this.excluir.disableProperty().set(true);
    }

    @Override
    public void deleteDetailListener(final MasterDetailEvent e) {
        this.formState = FormState.EXCLUINDO_DETALHE;
        this.novo.disableProperty().set(true);
        this.alterar.disableProperty().set(true);
        this.excluir.disableProperty().set(true);
    }

    @Override
    public void searchDetailListener(final MasterDetailEvent e) {
        this.formState = FormState.PESQUISANDO_ITENS_DETALHE;
        this.novo.disableProperty().set(true);
        this.alterar.disableProperty().set(true);
        this.excluir.disableProperty().set(true);
    }

    @Override
    public void persistDetailListener(final MasterDetailEvent e) {
        this.formState = FormState.PROCESSANDO;
        this.novo.disableProperty().set(true);
        this.alterar.disableProperty().set(true);
        this.excluir.disableProperty().set(true);
    }

    @Override
    public void cancelDetailListener(final MasterDetailEvent e) {
        this.formState = FormState.PROCESSANDO;
        this.novo.disableProperty().set(true);
        this.alterar.disableProperty().set(true);
        this.excluir.disableProperty().set(true);
    }

    @Override
    public void selectDetailListener(final MasterDetailEvent event) {
        this.formState = FormState.EXIBINDO_REGISTRO_SELECIONADO;
        this.novo.disableProperty().set(false);
        this.alterar.disableProperty().set(false);
        this.excluir.disableProperty().set(false);
    }

    @Override
    public void restartSearchInDetails(final MasterDetailEvent event) {
        this.formState = FormState.DETALHE_SELECIONADO;
        this.novo.disableProperty().set(true);
        this.alterar.disableProperty().set(true);
        this.excluir.disableProperty().set(true);
    }

    @Override
    public void selectMasterItemListener(final MasterDetailEvent event) {
        this.formState = FormState.DETALHE_SELECIONADO;
        //depois sincronizar com o alterar do master, pois só deve ser possível trabalhar em um item do detalhe quando o master estiver em edição.
        this.novo.disableProperty().set(false);
        this.alterar.disableProperty().set(false);
        this.excluir.disableProperty().set(false);
    }

    @Override
    public void startNewDetailListener(final MasterDetailEvent event) {
        this.formState = FormState.INICIO_CADASTRO_DETALHE;
        this.novo.disableProperty().set(false);
        this.alterar.disableProperty().set(true);
        this.excluir.disableProperty().set(true);
    }

    public ToolBar createBarraInicializacao() {
        this.barra = new ToolBar(novo, alterar, excluir);

        return this.barra;
    }
}
