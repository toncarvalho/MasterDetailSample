package masterdetailsample.screens;

import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import masterdetailsample.components.MasterStatusBar;
import masterdetailsample.components.ConfirmMasterEventsToolBar;
import masterdetailsample.eventos.masterdetail.MasterDetailEvent;
import masterdetailsample.eventos.masterdetail.MasterDetailEventSource;
import masterdetailsample.eventos.masterdetail.MasterEventListener;
import masterdetailsample.model.Pessoa;
import masterdetailsample.types.FormState;

/**
 * Created by ton on 9/29/14.
 */
public class FormMaster implements MasterEventListener {

    private FormState estadoInternoDoForm = FormState.INICIAL;
    private VBox formMaster = new VBox();
    private MasterDetailEventSource masterDetailSource;
    private Label lblNome = new Label("None:");
    private TextField edtNome = new TextField();
    private Label lblFone = new Label("Fone:");
    private TextField edtFone = new TextField();
    private Label lblEmail = new Label("Email:");
    private TextField edtEmail = new TextField();
    private MasterStatusBar status = new MasterStatusBar();

    private Pessoa entidade;

    public FormMaster(final MasterDetailEventSource masterDetailSource) {
        this.masterDetailSource = masterDetailSource;

        ConfirmMasterEventsToolBar ferramentasFormularioMaster = new ConfirmMasterEventsToolBar(masterDetailSource);

        ferramentasFormularioMaster.salvar.setOnAction(event -> {
            entidade.setNome(edtNome.textProperty().getValue());
            entidade.setFone(edtFone.textProperty().getValue());
            entidade.setEmail(edtEmail.textProperty().getValue());
            this.masterDetailSource.gravacaoRegistro(entidade);
        });
        ferramentasFormularioMaster.cancelar.setOnAction(event -> {
            this.masterDetailSource.cancelamentoRegistro(entidade);
        });

        this.masterDetailSource.addMasterListener(ferramentasFormularioMaster);
        formMaster.getChildren().add(new Label("FORMULÁRIO MASTER"));

        formMaster.getChildren().add(new VBox(lblNome, edtNome));

        formMaster.getChildren().add(new VBox(lblFone, edtFone));

        formMaster.getChildren().add(new VBox(lblEmail, edtEmail));

        formMaster.getChildren().add(ferramentasFormularioMaster.createBarraFinalizacao());

        MasterStatusBar status = new MasterStatusBar();
        formMaster.getChildren().add(status);
        this.masterDetailSource.addMasterListener(status);

        ////////////////inserção do subormulario de detalhe
        FormDetail subFormulario = new FormDetail(masterDetailSource);

        formMaster.getChildren().add(new Separator());

        formMaster.getChildren().add(subFormulario.getScreen());

        formMaster.setPrefSize(600, 550);
    }

    public VBox getScreen() {

        return this.formMaster;
    }

    @Override
    public void startFormListener(final MasterDetailEvent e) {
        edtNome.disableProperty().set(true);
        edtFone.disableProperty().set(true);
        edtEmail.disableProperty().set(true);
        edtNome.textProperty().set("");
        edtNome.setPromptText("nome");
        edtFone.textProperty().set("");
        edtFone.setPromptText("telefone");
        edtEmail.textProperty().set("");
        edtEmail.setPromptText("email");
    }

    @Override
    public void persistListener(final MasterDetailEvent e) {

    }

    @Override
    public void cancelListener(final MasterDetailEvent e) {

        switch (this.estadoInternoDoForm) {
        case EDITANDO: {
            edtNome.disableProperty().set(true);
            edtFone.disableProperty().set(true);
            edtEmail.disableProperty().set(true);
            break;
        }
        case INSERINDO: {
            edtNome.disableProperty().set(true);
            edtFone.disableProperty().set(true);
            edtEmail.disableProperty().set(true);
            break;
        }
        }
    }

    @Override
    public void insertListener(final MasterDetailEvent e) {
        this.estadoInternoDoForm = FormState.INSERINDO;
        entidade = new Pessoa();
        edtNome.disableProperty().set(false);
        edtFone.disableProperty().set(false);
        edtEmail.disableProperty().set(false);
        edtNome.textProperty().set("");
        edtNome.setPromptText("nome");
        edtFone.textProperty().set("");
        edtFone.setPromptText("telefone");
        edtEmail.textProperty().set("");
        edtEmail.setPromptText("email");
    }

    @Override
    public void changeItemListener(final MasterDetailEvent e) {
        edtNome.disableProperty().set(false);
        edtFone.disableProperty().set(false);
        edtEmail.disableProperty().set(false);
    }

    @Override
    public void deleteListener(final MasterDetailEvent e) {

    }

    @Override
    public void searchListener(final MasterDetailEvent e) {
        edtNome.textProperty().set("");
        edtNome.setPromptText("nome");
        edtFone.textProperty().set("");
        edtFone.setPromptText("telefone");
        edtEmail.textProperty().set("");
        edtEmail.setPromptText("email");
    }

    @Override
    public void selectListener(final MasterDetailEvent event) {
        System.out.println(this.getClass().getName() + " selecionando item");
        if (event.getSource() != null && event.getSource() instanceof TableView) {
            TableView<Pessoa> table = (TableView<Pessoa>) event.getSource();
            if (table.getSelectionModel().getSelectedItem() != null) {
                entidade = table.getSelectionModel().getSelectedItems().get(0);
                edtNome.textProperty().setValue(entidade.getNome());
                edtFone.textProperty().setValue(entidade.getFone());
                edtEmail.textProperty().setValue(entidade.getEmail());

                edtNome.disableProperty().set(true);
                edtFone.disableProperty().set(true);
                edtEmail.disableProperty().set(true);
            }
        } else if (event.getSource() != null && event.getSource() instanceof Pessoa) {
            entidade = (Pessoa) event.getSource();
            edtNome.textProperty().setValue(entidade.getNome());
            edtFone.textProperty().setValue(entidade.getFone());
            edtEmail.textProperty().setValue(entidade.getEmail());

            edtNome.disableProperty().set(true);
            edtFone.disableProperty().set(true);
            edtEmail.disableProperty().set(true);
        } else {
            edtNome.disableProperty().set(true);
            edtFone.disableProperty().set(true);
            edtEmail.disableProperty().set(true);
        }
    }

    @Override
    public void restartSearchListener(final MasterDetailEvent event) {

    }

    public FormState getEstadoInternoDoForm() {
        return estadoInternoDoForm;
    }

    public void setEstadoInternoDoForm(final FormState estadoInternoDoForm) {
        this.estadoInternoDoForm = estadoInternoDoForm;
    }
}
