package org.icet.demo.controller.admin.viewSection.viewProduct;

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
import org.icet.demo.bo.custom.ProductBo;
import org.icet.demo.dto.ViewProduct;
import org.icet.demo.util.BoType;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class viewProductController implements Initializable {
    public AnchorPane AdminViewProductAnchor;
    public TableView viewProductsTable;
    public TableColumn productIdColumn;
    public TableColumn productNameColumn;
    public TableColumn supplierNameColumn;
    public TableColumn sizeColumn;
    public TableColumn qtyColumn;
    public TableColumn categoryColumn;
    public TableColumn priceColumn;
    private ProductBo productBo = BoFactory.getInstance().getBo(BoType.PRODUCT);

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        productIdColumn.setCellValueFactory(new PropertyValueFactory<>("proId"));
        productNameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        supplierNameColumn.setCellValueFactory(new PropertyValueFactory<>("supName"));
        sizeColumn.setCellValueFactory(new PropertyValueFactory<>("size"));
        qtyColumn.setCellValueFactory(new PropertyValueFactory<>("qty"));
        categoryColumn.setCellValueFactory(new PropertyValueFactory<>("category"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));


        ObservableList<ViewProduct> viewProducts = FXCollections.observableArrayList();

        List<ViewProduct> products = productBo.getDataForViewProduct();

        for (ViewProduct product : products){
            viewProducts.add(product);
        }

        viewProductsTable.setItems(viewProducts);
    }

    public void registerBtn(ActionEvent actionEvent) throws IOException {
        Parent load = new FXMLLoader(getClass().getResource("/view/adminView/userRegistrationForm.fxml")).load();
        AdminViewProductAnchor.getChildren().clear();
        AdminViewProductAnchor.getChildren().add(load);
    }

    public void viewBtn(ActionEvent actionEvent) throws IOException {
        Parent load = new FXMLLoader(getClass().getResource("/view/adminView/viewSectionForm.fxml")).load();
        AdminViewProductAnchor.getChildren().clear();
        AdminViewProductAnchor.getChildren().add(load);
    }

    public void updateBtn(ActionEvent actionEvent) throws IOException {
        Parent load = new FXMLLoader(getClass().getResource("/view/adminView/updateSectionForm.fxml")).load();
        AdminViewProductAnchor.getChildren().clear();
        AdminViewProductAnchor.getChildren().add(load);
    }

    public void removeBtn(ActionEvent actionEvent) throws IOException {
        Parent load = new FXMLLoader(getClass().getResource("/view/adminView/removeSectionForm.fxml")).load();
        AdminViewProductAnchor.getChildren().clear();
        AdminViewProductAnchor.getChildren().add(load);
    }

    public void securityBtn(ActionEvent actionEvent) throws IOException {
        Parent load = new FXMLLoader(getClass().getResource("/view/adminView/securityForm.fxml")).load();
        AdminViewProductAnchor.getChildren().clear();
        AdminViewProductAnchor.getChildren().add(load);
    }

    public void reportBtn(ActionEvent actionEvent) throws IOException {
        Parent load = new FXMLLoader(getClass().getResource("/view/adminView/reportForm.fxml")).load();
        AdminViewProductAnchor.getChildren().clear();
        AdminViewProductAnchor.getChildren().add(load);
    }

    public void loginBtn(ActionEvent actionEvent) throws IOException {
        Parent load = new FXMLLoader(getClass().getResource("/view/loginForm.fxml")).load();
        AdminViewProductAnchor.getChildren().clear();
        AdminViewProductAnchor.getChildren().add(load);
    }
}
