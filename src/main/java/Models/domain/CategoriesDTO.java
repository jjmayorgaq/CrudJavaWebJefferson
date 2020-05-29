package Models.domain;

public class CategoriesDTO {

    private int idCategory;
    private String name;

    public CategoriesDTO() {
    }

    public CategoriesDTO(int idCategory, String name) {
        this.idCategory = idCategory;
        this.name = name;
    }

    public CategoriesDTO(String name) {
        this.name = name;
    }

    public int getIdCategory() {
        return idCategory;
    }

    public String getName() {
        return name;
    }

    public void setIdCategory(int idCategory) {
        this.idCategory = idCategory;
    }

    public void setName(String name) {
        this.name = name;
    }
}
