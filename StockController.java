/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stockofproducts;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author DELL
 */
public class StockController implements Initializable {

    @FXML
    private ListView<Stock> stockLV;

    @FXML
    private TextField txtProdId;

    @FXML
    private TextField txtProdName;

    @FXML
    private TextField txtProdQty;

    @FXML
    private TextField txtProdPoint;

    @FXML
    private TextField txtProdSprice;

    @FXML
    private TextField txtProdBPrice;

    @FXML
    private Label lblList;

    @FXML
    private Label lblProduct;

    @FXML
    private TextField txtItemToBuy;

    @FXML
    private Label lblItemToBuy;

    @FXML
    private Label lblProrductDisplay;

    @FXML
    private Label lblItemPrice;

    @FXML
    private Label lblError;

    private ObservableList<Stock> observableList = FXCollections.observableArrayList();
    Stock ss;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        lblList.setText("Select an item from list");
        lblProduct.setText("Add Products");
        lblItemToBuy.setText("How many item to Buy :");

        txtProdId.setPromptText("Prod. id, ex:123_ABC");
        txtProdName.setPromptText("Prod. Name");
        txtProdQty.setPromptText("Quantity on Hand(Number)");
        txtProdPoint.setPromptText("Restk Point(Number)");
        txtProdSprice.setPromptText("Sale Price(Number)");
        txtProdBPrice.setPromptText("Buy Price(Number)");

        Stock s1 = new Stock("111_AAA ", "Unknown Product", 0, 0.0000);
        Stock s2 = new Stock("234_XYZ ", " Item X ", 20, 3.0000);
        Stock s3 = new Stock("567_DDD ", " Item Y ", 10, 4.0000);
        Stock s4 = new Stock("999_AAA ", " Item Z ", 15, 2.0000);

        observableList.add(0, s1);
        observableList.add(1, s2);
        observableList.add(2, s3);
        observableList.add(3, s4);

        stockLV.setItems(observableList);
        stockLV.getSelectionModel().selectFirst();
        lblItemPrice.setText("ReStock Fee");

        stockLV.getSelectionModel().selectedItemProperty().addListener(new InvalidationListener() {

            @Override
            public void invalidated(Observable observable) {
                int index = stockLV.getSelectionModel().getSelectedIndex();
                // System.out.println("Index Value:::"+index);
                lblError.setText("");
                lblProrductDisplay.setText(observableList.get(index).toString());
                ss = observableList.get(index);
            }
        });
    }

    @FXML
    private void buy(ActionEvent event) {
        if (ss != null) {
            if (ss.getQoh() <= 0) {
                lblItemPrice.setText("ReStock Fee");

            } else {
                lblItemPrice.setText("");
                int quantity = Integer.parseInt(txtItemToBuy.getText());
                double price = quantity * ss.getBuyPrice();
                lblItemPrice.setText("$" + String.valueOf(price));
            }

        }
    }

    @FXML
    private void addProduct(ActionEvent event) {

        String productId = txtProdId.getText();
        String productName = txtProdName.getText();
        String productQty = txtProdQty.getText();
        String productQOH = txtProdPoint.getText();
        String productBuyPrice = txtProdBPrice.getText();
        String productSalePrice = txtProdSprice.getText();
        if (validateFields(productId, productName, productQty, productQOH, productBuyPrice, productSalePrice)) {

            Stock sAdd = new Stock(productId, productName, Integer.parseInt(productQty), Double.parseDouble(productBuyPrice));
            observableList.add(sAdd);
        } else {
            lblProrductDisplay.setText("");
            lblError.setText("Error!!!!!");
        }

    }

    public boolean validateFields(String productId, String productName, String productQty,
            String productQOH, String productBuyPrice, String productSalePrice) {
        boolean isValid = false;

        if (productIdValidation(productId) && productNameValidation(productName) && isNumberValidation(productQty) && isNumberValidation(productQOH)
                && isNumberValidation(productBuyPrice) && isNumberValidation(productSalePrice)) {
            isValid = true;
            return isValid;
        }
        return isValid;
    }

    private boolean productIdValidation(String productId) {
        boolean isValid = false;
        if (productId != null) {
            if (Character.isDigit(productId.charAt(0)) && Character.isDigit(productId.charAt(1))
                    && Character.isDigit(productId.charAt(2)) && productId.charAt(3) == '_' && Character.isLetter(productId.charAt(4))
                    && Character.isLetter(productId.charAt(5)) && Character.isLetter(productId.charAt(6))) {
                isValid = true;

            } else {
                isValid = false;

            }
        }
        return isValid;
    }

    public boolean isNumberValidation(String fieldName) {
        boolean isValid = false;

        int count = 0;
        if (fieldName != null && fieldName.length() > 0) {
            for (int i = 0; i < fieldName.length(); i++) {
                if (Character.isDigit(fieldName.charAt(i))) {
                    count++;
                }
            }
            if (count == fieldName.length()) {
                isValid = true;
            }
        }

        return isValid;
    }

    public boolean productNameValidation(String fieldName) {
        boolean isValid = false;

        int count = 0;
        if (fieldName != null && fieldName.length() > 0) {
            for (int i = 0; i < fieldName.length(); i++) {
                if (Character.isLetter(fieldName.charAt(i))) {
                    count++;
                }
            }
            if (count == fieldName.length()) {
                isValid = true;
            }
        }

        return isValid;
    }

}
