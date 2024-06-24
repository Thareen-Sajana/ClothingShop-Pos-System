package org.icet.demo.controller.user.report;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;
import org.icet.demo.bo.BoFactory;
import org.icet.demo.bo.custom.ProductBo;
import org.icet.demo.bo.custom.SupplierBo;
import org.icet.demo.bo.custom.UserBo;
import org.icet.demo.dto.ViewProduct;
import org.icet.demo.dto.ViewSupplier;
import org.icet.demo.entity.UserEntity;
import org.icet.demo.util.BoType;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class reportController {
    public AnchorPane userReportAnchor;
    private UserBo userBo = BoFactory.getInstance().getBo(BoType.USER);
    private SupplierBo supplierBo = BoFactory.getInstance().getBo(BoType.SUPPLIER);
    private ProductBo productBo = BoFactory.getInstance().getBo(BoType.PRODUCT);

    public void placeOrderBtn(ActionEvent actionEvent) throws IOException {
        Parent load = new FXMLLoader(getClass().getResource("/view/userView/placeOrderForm.fxml")).load();
        userReportAnchor.getChildren().clear();
        userReportAnchor.getChildren().add(load);
    }

    public void addBtn(ActionEvent actionEvent) throws IOException {
        Parent load = new FXMLLoader(getClass().getResource("/view/userView/addSectionForm.fxml")).load();
        userReportAnchor.getChildren().clear();
        userReportAnchor.getChildren().add(load);
    }

    public void viewBtn(ActionEvent actionEvent) throws IOException {
        Parent load = new FXMLLoader(getClass().getResource("/view/userView/viewSectionForm.fxml")).load();
        userReportAnchor.getChildren().clear();
        userReportAnchor.getChildren().add(load);
    }

    public void updateBtn(ActionEvent actionEvent) throws IOException {
        Parent load = new FXMLLoader(getClass().getResource("/view/userView/updateSectionForm.fxml")).load();
        userReportAnchor.getChildren().clear();
        userReportAnchor.getChildren().add(load);
    }

    public void removeBtn(ActionEvent actionEvent) throws IOException {
        Parent load = new FXMLLoader(getClass().getResource("/view/userView/removeSectionForm.fxml")).load();
        userReportAnchor.getChildren().clear();
        userReportAnchor.getChildren().add(load);
    }

    public void securityBtn(ActionEvent actionEvent) throws IOException {
        Parent load = new FXMLLoader(getClass().getResource("/view/userView/securityForm.fxml")).load();
        userReportAnchor.getChildren().clear();
        userReportAnchor.getChildren().add(load);
    }

    public void reportBtn(ActionEvent actionEvent) throws IOException {
        Parent load = new FXMLLoader(getClass().getResource("/view/userView/reportForm.fxml")).load();
        userReportAnchor.getChildren().clear();
        userReportAnchor.getChildren().add(load);
    }

    public void loginBtn(ActionEvent actionEvent) throws IOException {
        Parent load = new FXMLLoader(getClass().getResource("/view/loginForm.fxml")).load();
        userReportAnchor.getChildren().clear();
        userReportAnchor.getChildren().add(load);
    }

    public void printEmployyeBtn(ActionEvent actionEvent) throws JRException {

        List<UserEntity> employees = userBo.getAllUsers();

        // Load file and compile it
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("reports/employeeRoport.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(inputStream);

        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(employees);
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("createdBy", "Clothify");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);

        JasperViewer viewer = new JasperViewer(jasperPrint, false);
        viewer.setVisible(true);

    }
    public void printSupplierBtn(ActionEvent actionEvent) throws JRException {

        List<ViewSupplier> suppliers = supplierBo.viewSuppliers();

        // Load file and compile it
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("reports/supplierRoport.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(inputStream);

        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(suppliers);
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("createdBy", "Clothify");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);

        JasperViewer viewer = new JasperViewer(jasperPrint, false);
        viewer.setVisible(true);
    }

    public void inventoryPrintBtn(ActionEvent actionEvent) throws JRException {

        List<ViewProduct> products = productBo.getDataForViewProduct();

        // Load file and compile it
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("reports/inventroyRoport.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(inputStream);

        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(products);
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("createdBy", "Clothify");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);

        JasperViewer viewer = new JasperViewer(jasperPrint, false);
        viewer.setVisible(true);
    }
}
