public class Item{
    private String description;
    private double weigth;

    public Item(String description, double weigth){
        this.description = description;
        this.weigth = weigth;
    }

    public String getItemDescription(){
        return (description + " " + weigth + "g");
    }
}
