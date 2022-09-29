public class Product {

    private String modelName;
    private String brand;
    private String type;
    private double price;

    public Product(String modelName, String brand, String type, double price) {
        this.modelName = modelName;
        this.brand = brand;
        this.type = type;
        this.price = price;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "modelName='" + modelName + '\'' +
                ", brand='" + brand + '\'' +
                ", type='" + type + '\'' +
                ", price=" + price +
                '}';
    }
}
