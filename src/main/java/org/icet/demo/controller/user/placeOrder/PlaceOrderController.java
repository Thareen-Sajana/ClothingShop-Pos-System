package org.icet.demo.controller.user.placeOrder;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.util.Duration;
import org.icet.demo.bo.BoFactory;
import org.icet.demo.bo.custom.*;
import org.icet.demo.dto.*;
import org.icet.demo.entity.MeasurmentEntity;
import org.icet.demo.entity.ProductEntity;
import org.icet.demo.util.BoType;

import javax.naming.InsufficientResourcesException;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

public class PlaceOrderController implements Initializable {
    public AnchorPane userPlaceOrderAnchor;
    public Text dateTxt;
    public Text timeTxt;
    public JFXComboBox productComboBoxId;
    public TextField customerNameTxt;
    public JFXComboBox employeeComboBoxId;
    public TextField qtyTxt;
    public JFXComboBox paymentTypeComboBoxId;
    public TextField discountPercentageTxt;
    public JFXComboBox sizeComboBoxId;
    public Text orderIdTxt;
    public TableView customerOrderTable;
    public TableColumn productNameColumn;
    public TableColumn sizeColumn;
    public TableColumn qtyColumn;
    public TableColumn discountColumn;
    public TableColumn totalColumn;
    public Text netTotalTxt;
    public JFXButton addOrderBtn;

    UserBo userBo = BoFactory.getInstance().getBo(BoType.USER);
    ProductBo productBo = BoFactory.getInstance().getBo(BoType.PRODUCT);
    OrderBo orderBo = BoFactory.getInstance().getBo(BoType.ORDER);
    OrderDetailsBo orderDetailsBo = BoFactory.getInstance().getBo(BoType.ORDERDETAIL);
    MeasurmentBo measurmentBo = BoFactory.getInstance().getBo(BoType.MEASURMENT);

    private ObservableList<AllOrderDetails> allOrders;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        allOrders = FXCollections.observableArrayList();

        orderIdTxt.setText(generateOrderId());

        loadDateAndTime();
        loadEmployees();
        loadProducts();

        paymentTypeComboBoxId.setItems(FXCollections.observableArrayList("Cash","Check","Credit Card","Debit Card"));
        sizeComboBoxId.setItems(FXCollections.observableArrayList("select product"));
    }

    private void loadProducts(){

        List<String> productNames = new ArrayList<>();

        boolean isExist = false;

        for (ProductEntity product : productBo.getAllProducts()){
            for (String name : productNames){

                if(product.getName().equals(name)){
                    isExist = true;
                }
            }
            if(!isExist){
                productNames.add(product.getName());
            }
            isExist = false;
        }

        ObservableList<String> names = FXCollections.observableArrayList();
        for (String name : productNames){
            names.add(name);
        }
        productComboBoxId.setItems(names);
    }

    private void loadEmployees(){

        ObservableList<String> employeeID = FXCollections.observableArrayList();

        for (String id : userBo.getAllUserId()){
            employeeID.add(id);
        }

        employeeComboBoxId.setItems(employeeID);

    }

    private void loadDateAndTime() {
        //Date
        Date date = new Date();
        SimpleDateFormat f =new SimpleDateFormat("yyyy-MM-dd");
        dateTxt.setText(f.format(date));


        //Time
        Timeline timeline = new Timeline(new KeyFrame(Duration.ZERO, e->{
            LocalTime time = LocalTime.now();
            timeTxt.setText(
                    time.getHour()+" : "+time.getMinute()+" : "+time.getSecond()
            );
        }),
                new KeyFrame(Duration.seconds(1))
        );
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }

    private void loadSizes(){
        String productName = (String) productComboBoxId.getValue();
        ObservableList<String> sizes = FXCollections.observableArrayList();

        for(ProductDetails product : productBo.getAllProductDetails()){
            if(productName.equals(product.getName())){
                sizes.add(product.getSize());
            }
        }
        sizeComboBoxId.setItems(sizes);
    }


    public void placeOrderBtn(ActionEvent actionEvent) throws IOException {
        Parent load = new FXMLLoader(getClass().getResource("/view/userView/placeOrderForm.fxml")).load();
        userPlaceOrderAnchor.getChildren().clear();
        userPlaceOrderAnchor.getChildren().add(load);
    }

    public void addBtn(ActionEvent actionEvent) throws IOException {
        Parent load = new FXMLLoader(getClass().getResource("/view/userView/addSectionForm.fxml")).load();
        userPlaceOrderAnchor.getChildren().clear();
        userPlaceOrderAnchor.getChildren().add(load);
    }

    public void viewBtn(ActionEvent actionEvent) throws IOException {
        Parent load = new FXMLLoader(getClass().getResource("/view/userView/viewSectionForm.fxml")).load();
        userPlaceOrderAnchor.getChildren().clear();
        userPlaceOrderAnchor.getChildren().add(load);
    }

    public void updateBtn(ActionEvent actionEvent) throws IOException {
        Parent load = new FXMLLoader(getClass().getResource("/view/userView/updateSectionForm.fxml")).load();
        userPlaceOrderAnchor.getChildren().clear();
        userPlaceOrderAnchor.getChildren().add(load);
    }

    public void removeBtn(ActionEvent actionEvent) throws IOException {
        Parent load = new FXMLLoader(getClass().getResource("/view/userView/removeSectionForm.fxml")).load();
        userPlaceOrderAnchor.getChildren().clear();
        userPlaceOrderAnchor.getChildren().add(load);
    }

    public void securityBtn(ActionEvent actionEvent) throws IOException {
        Parent load = new FXMLLoader(getClass().getResource("/view/userView/securityForm.fxml")).load();
        userPlaceOrderAnchor.getChildren().clear();
        userPlaceOrderAnchor.getChildren().add(load);
    }

    public void reportBtn(ActionEvent actionEvent) throws IOException {
        Parent load = new FXMLLoader(getClass().getResource("/view/userView/reportForm.fxml")).load();
        userPlaceOrderAnchor.getChildren().clear();
        userPlaceOrderAnchor.getChildren().add(load);
    }

    public void loginBtn(ActionEvent actionEvent) throws IOException {
        Parent load = new FXMLLoader(getClass().getResource("/view/loginForm.fxml")).load();
        userPlaceOrderAnchor.getChildren().clear();
        userPlaceOrderAnchor.getChildren().add(load);
    }

    public void addOrderBtn(ActionEvent actionEvent) {

        if(!isEmpty() && isQtyEnough()){

            String productId = getProductId(productComboBoxId.getValue().toString(),
                    sizeComboBoxId.getValue().toString());

            Double price = getPrice(productComboBoxId.getValue().toString(),
                    sizeComboBoxId.getValue().toString());

            AllOrderDetails allOrderDetails = new AllOrderDetails();
            allOrderDetails.setQty(Integer.valueOf(qtyTxt.getText()));
            allOrderDetails.setOrdId(orderIdTxt.getText());
            allOrderDetails.setUserId(employeeComboBoxId.getValue().toString());
            allOrderDetails.setProId(productId);
            allOrderDetails.setCustomerName(customerNameTxt.getText());
            allOrderDetails.setTime(timeTxt.getText());
            allOrderDetails.setDate(dateTxt.getText());
            allOrderDetails.setPaymentType(paymentTypeComboBoxId.getValue().toString());
            allOrderDetails.setProductName(productComboBoxId.getValue().toString());

            Double discount = (price * Double.valueOf(discountPercentageTxt.getText()) / 100.0) * Double.valueOf(qtyTxt.getText());
            allOrderDetails.setDiscount(discount);

            Double total = price * Double.valueOf(qtyTxt.getText()) - discount;
            allOrderDetails.setTotal(total);
            allOrderDetails.setSize(sizeComboBoxId.getValue().toString());

            allOrders.add(allOrderDetails);
            loadOrderTable();
            setNetTotal();
            employeeComboBoxId.setDisable(true);
            customerNameTxt.setDisable(true);
            clear();

        }else {

            Alert alert = new Alert(Alert.AlertType.WARNING);

            if(isEmpty()){
                alert.setTitle("Empty");
                alert.setContentText("Please Fill all details");
            }else if (!isQtyEnough()){
                alert.setTitle("Too much");
                alert.setContentText("Not enough qty in the store");
            }

            alert.show();
        }
    }

    private void setNetTotal(){
        Double total = 0.0;

        for (AllOrderDetails allOrderDetails : allOrders){
            total += allOrderDetails.getTotal();
        }
        netTotalTxt.setText(String.valueOf(total) +" /=");
    }


    private void loadOrderTable(){
        productNameColumn.setCellValueFactory(new PropertyValueFactory<>("productName"));
        sizeColumn.setCellValueFactory(new PropertyValueFactory<>("size"));
        qtyColumn.setCellValueFactory(new PropertyValueFactory<>("qty"));
        discountColumn.setCellValueFactory(new PropertyValueFactory<>("discount"));
        totalColumn.setCellValueFactory(new PropertyValueFactory<>("total"));

        customerOrderTable.setItems(allOrders);
    }

    public void selectProductBox(ActionEvent actionEvent) {
        loadSizes();
    }


    public void placeOrderDetailsBtn(ActionEvent actionEvent) {

        Alert alertWarning = new Alert(Alert.AlertType.WARNING);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);

        boolean isOrderSaved = false;
        boolean isOrderDetailsSaved = false;
        boolean isMeasurmentUpdated = false;

        boolean isAllowed = true;

        for (AllOrderDetails allOrderDetails : allOrders){

            if(isAllowed){
                Order order = new Order();
                order.setOrId(allOrderDetails.getOrdId());
                order.setUserId(allOrderDetails.getUserId());
                isOrderSaved = orderBo.saveOrder(order);
                isAllowed = false;
            }

            OrderDetail orderDetail = new OrderDetail();
            orderDetail.setCustomerName(allOrderDetails.getCustomerName());
            orderDetail.setTime(allOrderDetails.getTime());
            orderDetail.setDate(allOrderDetails.getDate());
            orderDetail.setPaymentType(allOrderDetails.getPaymentType());
            orderDetail.setDiscount(allOrderDetails.getDiscount());
            orderDetail.setTotal(allOrderDetails.getTotal());
            orderDetail.setOrId(allOrderDetails.getOrdId());
            orderDetail.setSize(allOrderDetails.getSize());
            orderDetail.setQty(allOrderDetails.getQty());
            orderDetail.setProId(allOrderDetails.getProId());

            isOrderDetailsSaved = orderDetailsBo.saveOrderDetail(orderDetail);

            MeasurmentEntity measurmentEntity = measurmentBo.getMeasurmentByProductId(allOrderDetails.getProId());
            Integer measurmentID = measurmentEntity.getMeasurmentId();
            Integer qty = measurmentEntity.getQty();

            MeasurmentEntity measurment = new MeasurmentEntity();
            measurment.setMeasurmentId(measurmentID);
            Integer newQty = qty - allOrderDetails.getQty();
            measurment.setQty(newQty);
            measurment.setSize(allOrderDetails.getSize());
            measurment.setProId(allOrderDetails.getProId());
            isMeasurmentUpdated = measurmentBo.updateMeasurment(measurment);
        }

        if(isOrderSaved && isOrderDetailsSaved && isMeasurmentUpdated){
            alert.setTitle("Done");
            alert.setContentText("Successfully order placed");
            alert.show();
            generateOrderId();
            clear();
            customerNameTxt.clear();
            employeeComboBoxId.setDisable(false);
            customerNameTxt.setDisable(false);
            allOrders = FXCollections.observableArrayList();
            loadOrderTable();
            netTotalTxt.setText("0.00 /=");
        }else {
            alertWarning.setTitle("Error");
            alertWarning.setContentText("Something went wrong please try again");
            alertWarning.show();
        }

    }

    private boolean isQtyEnough(){

        String productId = getProductId(productComboBoxId.getValue().toString(),
                sizeComboBoxId.getValue().toString());

        Integer userEnterdQty = Integer.valueOf(qtyTxt.getText());
        Integer realQty = measurmentBo.getMeasurmentByProductId(productId).getQty();

        if ((realQty - userEnterdQty) >= 0){
            return true;
        }
        return false;
    }

    private boolean isEmpty(){

        if(productComboBoxId.getSelectionModel().isEmpty() ||
        employeeComboBoxId.getSelectionModel().isEmpty() ||
        customerNameTxt.getText().strip().equals("") ||
        qtyTxt.getText().strip().equals("") ||
        paymentTypeComboBoxId.getSelectionModel().isEmpty() ||
        discountPercentageTxt.getText().strip().equals("") ||
        sizeComboBoxId.getSelectionModel().isEmpty()){
            return true;
        }
        return false;
    }

    private String getProductId(String productName, String size){

        for (ProductDetails productDetails : productBo.getAllProductDetails()){
            if(productName.equals(productDetails.getName()) && size.equals(productDetails.getSize())){
                return productDetails.getProId();
            }
        }

        return null;
    }

    private Double getPrice(String productName, String size){
        for (ProductDetails productDetails : productBo.getAllProductDetails()){
            if(productName.equals(productDetails.getName()) && size.equals(productDetails.getSize())){
                return productDetails.getPrice();
            }
        }
        return null;
    }

    private String generateOrderId(){
        return orderBo.generateOrderId();
    }

    private void clear(){
        qtyTxt.clear();
        discountPercentageTxt.clear();
    }


}
