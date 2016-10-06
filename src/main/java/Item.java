public class Item{
  private String name;
  private double price;
  private String description;
  private String imageSrc;
  public Item(String name, double price, String description, String imageSrc){
    this.name = name;
    this.price = price;
    this.description = description;
    this.imageSrc = imageSrc;
  }
  public String getName(){
    return name;
  }
  public double getPrice(){
    return price;
  }
  public String getDescription(){
    return description;
  }
  public String getImageSrc(){
    return imageSrc;
  }
}
