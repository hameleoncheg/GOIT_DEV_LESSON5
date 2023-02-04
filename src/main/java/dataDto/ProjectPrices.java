package dataDto;

public class ProjectPrices {
    private String name;
    private long price;

    public ProjectPrices(String name, long price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "dataDto.ProjectPrices{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
