package uk.ac.westminster.products_api;

public class DigitalProduct extends Product implements Discountable {
    private double discountRate;
    private String downloadUrl;
    private double fileSize;
    private double discountPrice;

    public DigitalProduct(Long id, String name, double price, String downloadUrl, double fileSize) {
        super(id,name,price);
        this.downloadUrl=downloadUrl;
        this.fileSize=fileSize;
    }

    public DigitalProduct() {}


    public String getDownloadUrl() {
        return downloadUrl;
    }

    public double getFileSize() {
        return fileSize;
    }

    @Override
    public String getSummary(){
        return getName() + "->" + getDownloadUrl();
    }

    @Override
    public void applyDiscount(double rate) {
        discountPrice = getPrice()*(1-rate);

    }

    @Override
    public double getDiscountPrice() {
        return discountPrice;
    }
}
