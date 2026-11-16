package uk.ac.westminster.products_api;

public class DigitalProduct extends Product {
    private String downloadUrl;
    private double fileSize;

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
}
