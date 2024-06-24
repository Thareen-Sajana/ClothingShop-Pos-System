package org.icet.demo.controller.admin.viewSection.viewOrder;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import org.icet.demo.bo.BoFactory;
import org.icet.demo.bo.custom.OrderDetailsBo;
import org.icet.demo.util.BoType;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class viewOrderController implements Initializable {
    public AnchorPane AdminViewOrderAnchor;
    public TableView viewOrdersTable;
    public TableColumn orderIdColumn;
    public TableColumn productNameColumn;
    public TableColumn customerNameColumn;
    public TableColumn timeColumn;
    public TableColumn dateColumn;
    public TableColumn discountColumn;
    public TableColumn qtyColumn;
    public TableColumn totalColumn;
    private OrderDetailsBo orderDetailsBo = BoFactory.getInstance().getBo(BoType.ORDERDETAIL);

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        orderIdColumn.setCellValueFactory(new PropertyValueFactory<>("orId"));
        productNameColumn.setCellValueFactory(new PropertyValueFactory<>("productName"));
        customerNameColumn.setCellValueFactory(new PropertyValueFactory<>("customerName"));
        timeColumn.setCellValueFactory(new PropertyValueFactory<>("time"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
        discountColumn.setCellValueFactory(new PropertyValueFactory<>("discount"));
        qtyColumn.setCellValueFactory(new PropertyValueFactory<>("qty"));
        totalColumn.setCellValueFactory(new PropertyValueFactory<>("total"));

        viewOrdersTable.setItems(orderDetailsBo.gellAllOrdersForView());

    }

    public void registerBtn(ActionEvent actionEvent) throws IOException {
        Parent load = new FXMLLoader(getClass().getResource("/view/adminView/userRegistrationForm.fxml")).load();
        AdminViewOrderAnchor.getChildren().clear();
        AdminViewOrderAnchor.getChildren().add(load);
    }

    public void viewBtn(ActionEvent actionEvent) throws IOException {
        Parent load = new FXMLLoader(getClass().getResource("/view/adminView/viewSectionForm.fxml")).load();
        AdminViewOrderAnchor.getChildren().clear();
        AdminViewOrderAnchor.getChildren().add(load);
    }

    public void updateBtn(ActionEvent actionEvent) throws IOException {
        Parent load = new FXMLLoader(getClass().getResource("/view/adminView/updateSectionForm.fxml")).load();
        AdminViewOrderAnchor.getChildren().clear();
        AdminViewOrderAnchor.getChildren().add(load);
    }

    public void removeBtn(ActionEvent actionEvent) throws IOException {
        Parent load = new FXMLLoader(getClass().getResource("/view/adminView/removeSectionForm.fxml")).load();
        AdminViewOrderAnchor.getChildren().clear();
        AdminViewOrderAnchor.getChildren().add(load);
    }

    public void securityBtn(ActionEvent actionEvent) throws IOException {
        Parent load = new FXMLLoader(getClass().getResource("/view/adminView/securityForm.fxml")).load();
        AdminViewOrderAnchor.getChildren().clear();
        AdminViewOrderAnchor.getChildren().add(load);
    }

    public void reportBtn(ActionEvent actionEvent) throws IOException {
        Parent load = new FXMLLoader(getClass().getResource("/view/adminView/reportForm.fxml")).load();
        AdminViewOrderAnchor.getChildren().clear();
        AdminViewOrderAnchor.getChildren().add(load);
    }

    public void loginBtn(ActionEvent actionEvent) throws IOException {
        Parent load = new FXMLLoader(getClass().getResource("/view/loginForm.fxml")).load();
        AdminViewOrderAnchor.getChildren().clear();
        AdminViewOrderAnchor.getChildren().add(load);
    }
}
