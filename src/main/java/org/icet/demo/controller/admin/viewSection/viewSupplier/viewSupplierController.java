package org.icet.demo.controller.admin.viewSection.viewSupplier;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import org.icet.demo.bo.BoFactory;
import org.icet.demo.bo.custom.SupplierBo;
import org.icet.demo.dto.ViewSupplier;
import org.icet.demo.util.BoType;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class viewSupplierController implements Initializable {
    public AnchorPane AdminViewSupplierAnchor;
    public TableView supplierDetailTable;
    public TableColumn supplierIdColomn;
    public TableColumn supplierNameColomn;
    public TableColumn companyColomn;
    public TableColumn productNameColomn;
    public TableColumn supplierEmailColomn;

    private SupplierBo supplierBo = BoFactory.getInstance().getBo(BoType.SUPPLIER);

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        supplierIdColomn.setCellValueFactory(new PropertyValueFactory<>("supId"));
        supplierNameColomn.setCellValueFactory(new PropertyValueFactory<>("name"));
        companyColomn.setCellValueFactory(new PropertyValueFactory<>("company"));
        productNameColomn.setCellValueFactory(new PropertyValueFactory<>("productName"));
        supplierEmailColomn.setCellValueFactory(new PropertyValueFactory<>("email"));


        ObservableList<ViewSupplier> allSuppliers = FXCollections.observableArrayList();

        List<ViewSupplier> suppliers = supplierBo.viewSuppliers();

        for (ViewSupplier supplier : suppliers){
            allSuppliers.add(supplier);
        }

        supplierDetailTable.setItems(allSuppliers);
    }

    public void registerBtn(ActionEvent actionEvent) throws IOException {
        Parent load = new FXMLLoader(getClass().getResource("/view/adminView/userRegistrationForm.fxml")).load();
        AdminViewSupplierAnchor.getChildren().clear();
        AdminViewSupplierAnchor.getChildren().add(load);
    }

    public void viewBtn(ActionEvent actionEvent) throws IOException {
        Parent load = new FXMLLoader(getClass().getResource("/view/adminView/viewSectionForm.fxml")).load();
        AdminViewSupplierAnchor.getChildren().clear();
        AdminViewSupplierAnchor.getChildren().add(load);
    }

    public void updateBtn(ActionEvent actionEvent) throws IOException {
        Parent load = new FXMLLoader(getClass().getResource("/view/adminView/updateSectionForm.fxml")).load();
        AdminViewSupplierAnchor.getChildren().clear();
        AdminViewSupplierAnchor.getChildren().add(load);
    }

    public void removeBtn(ActionEvent actionEvent) throws IOException {
        Parent load = new FXMLLoader(getClass().getResource("/view/adminView/removeSectionForm.fxml")).load();
        AdminViewSupplierAnchor.getChildren().clear();
        AdminViewSupplierAnchor.getChildren().add(load);
    }

    public void securityBtn(ActionEvent actionEvent) throws IOException {
        Parent load = new FXMLLoader(getClass().getResource("/view/adminView/securityForm.fxml")).load();
        AdminViewSupplierAnchor.getChildren().clear();
        AdminViewSupplierAnchor.getChildren().add(load);
    }

    public void reportBtn(ActionEvent actionEvent) throws IOException {
        Parent load = new FXMLLoader(getClass().getResource("/view/adminView/reportForm.fxml")).load();
        AdminViewSupplierAnchor.getChildren().clear();
        AdminViewSupplierAnchor.getChildren().add(load);
    }

    public void loginBtn(ActionEvent actionEvent) throws IOException {
        Parent load = new FXMLLoader(getClass().getResource("/view/loginForm.fxml")).load();
        AdminViewSupplierAnchor.getChildren().clear();
        AdminViewSupplierAnchor.getChildren().add(load);
    }
}
