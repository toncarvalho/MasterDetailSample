package masterdetailsample.components;

import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.layout.HBox;
import masterdetailsample.eventos.masterdetail.MasterDetailEvent;
import masterdetailsample.eventos.masterdetail.MasterEventListener;
import masterdetailsample.types.FormState;

/**
 * Created by ton on 9/29/14.
 */
public class MasterStatusBar extends HBox implements MasterEventListener {

    private Label label = new Label();
    private FormState formState;

    public MasterStatusBar() {
        this.getChildren().add(new Separator());
        this.getChildren().add(label);
        this.getChildren().add(new Separator());
    }

    @Override
    public void startFormListener(final MasterDetailEvent e) {
        this.formState = FormState.INICIAL;
        this.label.textProperty().setValue(" Status: " + FormState.INICIAL.name());
    }

    @Override
    public void persistListener(final MasterDetailEvent e) {
        this.formState = FormState.PROCESSANDO;
        this.label.textProperty().setValue(" Status: " + FormState.PROCESSANDO.name());
    }

    @Override
    public void cancelListener(final MasterDetailEvent e) {
        this.formState = FormState.CANCELANDO;
        this.label.textProperty().setValue(" Status: " + FormState.CANCELANDO.name());
    }

    @Override
    public void insertListener(final MasterDetailEvent e) {
        this.formState = FormState.INSERINDO;
        this.label.textProperty().setValue(" Status: " + FormState.INSERINDO.name());
    }

    @Override
    public void changeItemListener(final MasterDetailEvent e) {
        this.formState = FormState.EDITANDO;
        this.label.textProperty().setValue(" Status: " + FormState.EDITANDO.name());
    }

    @Override
    public void deleteListener(final MasterDetailEvent e) {
        this.formState = FormState.EXCLUINDO;
        this.label.textProperty().setValue(" Status: " + FormState.EXCLUINDO.name());
    }

    @Override
    public void searchListener(final MasterDetailEvent e) {
        this.formState = FormState.PESQUISANDO;
        this.label.textProperty().setValue(" Status: " + FormState.PESQUISANDO.name());
    }

    @Override
    public void selectListener(final MasterDetailEvent event) {
        this.formState = FormState.EXIBINDO_REGISTRO_SELECIONADO;
        this.label.textProperty().setValue(" Status: " + FormState.EXIBINDO_REGISTRO_SELECIONADO.name());
    }

    @Override
    public void restartSearchListener(final MasterDetailEvent event) {
        this.formState = FormState.INICIAL;
        this.label.textProperty().setValue(" Status: " + FormState.INICIAL.name());
    }

    public FormState getFormState() {
        return formState;
    }

    public void setFormState(final FormState formState) {
        this.formState = formState;
    }
}
