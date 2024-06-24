package org.icet.demo.controller.admin.report;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;
import org.icet.demo.bo.BoFactory;
import org.icet.demo.bo.custom.OrderDetailsBo;
import org.icet.demo.bo.custom.ProductBo;
import org.icet.demo.bo.custom.SupplierBo;
import org.icet.demo.bo.custom.UserBo;
import org.icet.demo.dto.ViewOrdersSection;
import org.icet.demo.dto.ViewProduct;
import org.icet.demo.dto.ViewSupplier;
import org.icet.demo.entity.UserEntity;
import org.icet.demo.util.BoType;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.*;

public class reportController {
    public AnchorPane AdminReportAnchor;

    private UserBo userBo = BoFactory.getInstance().getBo(BoType.USER);
    private SupplierBo supplierBo = BoFactory.getInstance().getBo(BoType.SUPPLIER);
    private OrderDetailsBo orderDetailsBo = BoFactory.getInstance().getBo(BoType.ORDERDETAIL);
    private ProductBo productBo = BoFactory.getInstance().getBo(BoType.PRODUCT);


    public void registerBtn(ActionEvent actionEvent) throws IOException {
        Parent load = new FXMLLoader(getClass().getResource("/view/adminView/userRegistrationForm.fxml")).load();
        AdminReportAnchor.getChildren().clear();
        AdminReportAnchor.getChildren().add(load);
    }

    public void viewBtn(ActionEvent actionEvent) throws IOException {
        Parent load = new FXMLLoader(getClass().getResource("/view/adminView/viewSectionForm.fxml")).load();
        AdminReportAnchor.getChildren().clear();
        AdminReportAnchor.getChildren().add(load);
    }

    public void updateBtn(ActionEvent actionEvent) throws IOException {
        Parent load = new FXMLLoader(getClass().getResource("/view/adminView/updateSectionForm.fxml")).load();
        AdminReportAnchor.getChildren().clear();
        AdminReportAnchor.getChildren().add(load);
    }

    public void removeBtn(ActionEvent actionEvent) throws IOException {
        Parent load = new FXMLLoader(getClass().getResource("/view/adminView/removeSectionForm.fxml")).load();
        AdminReportAnchor.getChildren().clear();
        AdminReportAnchor.getChildren().add(load);
    }

    public void securityBtn(ActionEvent actionEvent) throws IOException {
        Parent load = new FXMLLoader(getClass().getResource("/view/adminView/securityForm.fxml")).load();
        AdminReportAnchor.getChildren().clear();
        AdminReportAnchor.getChildren().add(load);
    }

    public void reportBtn(ActionEvent actionEvent) throws IOException {
        Parent load = new FXMLLoader(getClass().getResource("/view/adminView/reportForm.fxml")).load();
        AdminReportAnchor.getChildren().clear();
        AdminReportAnchor.getChildren().add(load);
    }

    public void loginBtn(ActionEvent actionEvent) throws IOException {
        Parent load = new FXMLLoader(getClass().getResource("/view/loginForm.fxml")).load();
        AdminReportAnchor.getChildren().clear();
        AdminReportAnchor.getChildren().add(load);
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

    public void printSalesBtn(ActionEvent actionEvent) throws JRException {

        List<ViewOrdersSection> orders = orderDetailsBo.gellAllOrdersForView();

        // Load file and compile it
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("reports/salesRoport.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(inputStream);

        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(orders);
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
