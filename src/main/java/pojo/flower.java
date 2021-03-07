package pojo;

/**
 * @创建人 PigAndCatWithWind
 * @创建时间 2021/2/25下午1:31
 * @描述
 */
public class flower {
    private Integer id;
    private String name;
    private float price;
    private String production;

    @Override
    public String toString() {
        return "flower{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", production='" + production + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getProduction() {
        return production;
    }

    public void setProduction(String production) {
        this.production = production;
    }
}
