
public class Car
{
   
   private String model;
   private String brand;
   private int year;
   private int loadSize;
   private int kmDrived;
   private int litersHold;
   private String fuelType;
   private String vehicleType;
   private boolean availability;
   private String licencePlate;
   private int price;
   
   public Car()
   {
      this.model = model;
      this.brand = brand;
      this.year = year;
      this.loadSize = loadSize;
      this.kmDrived = kmDrived;
      this.litersHold = litersHold;
      this.fuelType = fuelType;
      this.vehicleType = vehicleType;
      this.availability = availability;
      this.licencePlate = licencePlate;
      this.price = price;
   }
  
   /**
    * @return the model
    */
   public String getModel()
   {
      return model;
   }
   /**
    * @param model the model to set
    */
   public void setModel(String model)
   {
      this.model = model;
   }
   /**
    * @return the brand
    */
   public String getBrand()
   {
      return brand;
   }
   /**
    * @param brand the brand to set
    */
   public void setBrand(String brand)
   {
      this.brand = brand;
   }
   /**
    * @return the year
    */
   public int getYear()
   {
      return year;
   }
   /**
    * @param year the year to set
    */
   public void setYear(int year)
   {
      this.year = year;
   }
   /**
    * @return the loadSize
    */
   public int getLoadSize()
   {
      return loadSize;
   }
   /**
    * @param loadSize the loadSize to set
    */
   public void setLoadSize(int loadSize)
   {
      this.loadSize = loadSize;
   }
   /**
    * @return the kmDrived
    */
   public int getKmDrived()
   {
      return kmDrived;
   }
   /**
    * @param kmDrived the kmDrived to set
    */
   public void setKmDrived(int kmDrived)
   {
      this.kmDrived = kmDrived;
   }
   /**
    * @return the litersHold
    */
   public int getLitersHold()
   {
      return litersHold;
   }
   /**
    * @param litersHold the litersHold to set
    */
   public void setLitersHold(int litersHold)
   {
      this.litersHold = litersHold;
   }
   /**
    * @return the fuelType
    */
   public String getFuelType()
   {
      return fuelType;
   }
   /**
    * @param fuelType the fuelType to set
    */
   public void setFuelType(String fuelType)
   {
      this.fuelType = fuelType;
   }
   /**
    * @return the vehicleType
    */
   public String getVehicleType()
   {
      return vehicleType;
   }
   /**
    * @param vehicleType the vehicleType to set
    */
   public void setVehicleType(String vehicleType)
   {
      this.vehicleType = vehicleType;
   }
   /**
    * @return the availability
    */
   public boolean getAvailability()
   {
      return availability;
   }
   /**
    * @param availability the availability to set
    */
   public void setAvailability(boolean availability)
   {
      this.availability = availability;
   }
   /**
    * @return the licencePlate
    */
   public String getLicencePlate()
   {
      return licencePlate;
   }
   /**
    * @param licencePlate the licencePlate to set
    */
   public void setLicencePlate(String licencePlate)
   {
      this.licencePlate = licencePlate;
   }
   /**
    * @return the price
    */
   public int getPrice()
   {
      return price;
   }
   /**
    * @param price the price to set
    */
   public void setPrice(int price)
   {
      this.price = price;
   }
   /* (non-Javadoc)
    * @see java.lang.Object#toString()
    */
   @Override
   public String toString()
   {
      return "Car [model=" + model + ", brand=" + brand
            + ", year=" + year + ", loadSize=" + loadSize + ", kmDrived="
            + kmDrived + ", litersHold=" + litersHold + ", fuelType="
            + fuelType + ", vehicleType=" + vehicleType + ", availability="
            + availability + ", licencePlate=" + licencePlate + ", price="
            + price + "]";
   }
   
   
}
