package Models.domain;

public class ProductsDTO {

    private int idProduct;
    private String name;
    private String price;
    private String stock;
    private String idCategory;
    private String categoryName;

    public ProductsDTO() {
    }

    public ProductsDTO(String name, String price, String stock, String idCategory) {
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.idCategory = idCategory;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    public String getStock() {
        return stock;
    }

    public String getIdCategory() {
        return idCategory;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }

    public void setIdCategory(String idCategory) {
        this.idCategory = idCategory;
    }
    
    public String getCategoryName() {
        return categoryName;
    }
    
     public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

}
