package stockofproducts;

public class Stock {

    private String productID;

    @Override
    public String toString() {
        return productID + "(" + productName + ")" + "QOH :" + qoh + " Buying Price : $" + buyPrice + "000";
    }

    private String productName;
    private int qoh;
    private int rsp;
    private double buyPrice;
    private double sellPrice;

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getQoh() {
        return qoh;
    }

    public void setQoh(int qoh) {
        this.qoh = qoh;
    }

    public int getRsp() {
        return rsp;
    }

    public void setRsp(int rsp) {
        this.rsp = rsp;
    }

    public double getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(double sellPrice) {
        this.sellPrice = sellPrice;
    }

    public double getBuyPrice() {
        return buyPrice;
    }

    public void setBuyPrice(double buyPrice) {
        this.buyPrice = buyPrice;
    }

    public Stock(String productID, String productName, int qoh, double buyPrice) {
        super();
        this.productID = productID;
        this.productName = productName;
        this.qoh = qoh;
        this.buyPrice = buyPrice;
    }

}
