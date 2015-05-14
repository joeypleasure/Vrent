import java.util.Date;

public class Reservation
{
   
   private Date pickUpTime;
   private Date returnTime;
   private String locationPickUp;
   private String locationReturn;
   private int kmWantToDrive;
   private int carId;
   private int customerId;
   
   public Reservation()
   {
      this.pickUpTime = pickUpTime;
      this.returnTime = returnTime;
      this.locationPickUp = locationPickUp;
      this.locationReturn = locationReturn;
      this.kmWantToDrive = kmWantToDrive;
      this.carId = carId;
      this.customerId = customerId;
   }
   
   /**
    * @return the pickUpTime
    */
   public Date getPickUpTime()
   {
      return pickUpTime;
   }
   /**
    * @param pickUpTime the pickUpTime to set
    */
   public void setPickUpTime(Date pickUpTime)
   {
      this.pickUpTime = pickUpTime;
   }
   /**
    * @return the returnTime
    */
   public Date getReturnTime()
   {
      return returnTime;
   }
   /**
    * @param returnTime the returnTime to set
    */
   public void setReturnTime(Date returnTime)
   {
      this.returnTime = returnTime;
   }
   /**
    * @return the locationPickUp
    */
   public String getLocationPickUp()
   {
      return locationPickUp;
   }
   /**
    * @param locationPickUp the locationPickUp to set
    */
   public void setLocationPickUp(String locationPickUp)
   {
      this.locationPickUp = locationPickUp;
   }
   /**
    * @return the locationReturn
    */
   public String getLocationReturn()
   {
      return locationReturn;
   }
   /**
    * @param locationReturn the locationReturn to set
    */
   public void setLocationReturn(String locationReturn)
   {
      this.locationReturn = locationReturn;
   }
   /**
    * @return the kmWantToDrive
    */
   public int getKmWantToDrive()
   {
      return kmWantToDrive;
   }
   /**
    * @param kmWantToDrive the kmWantToDrive to set
    */
   public void setKmWantToDrive(int kmWantToDrive)
   {
      this.kmWantToDrive = kmWantToDrive;
   }
   /**
    * @return the car
    */
   public int getCarId()
   {
      return carId;
   }
   /**
    * @param car the car to set
    */
   public void setCarId(int carId)
   {
      this.carId = carId;
   }
   /**
    * @return the customer
    */
   public int getCustomerId()
   {
      return customerId;
   }
   /**
    * @param customer the customer to set
    */
   public void setCustomerId(int customerId)
   {
      this.customerId = customerId;
   }
   /* (non-Javadoc)
    * @see java.lang.Object#toString()
    */
   @Override
   public String toString()
   {
      return "Reservation [, pickUpTime=" + pickUpTime
            + ", returnTime=" + returnTime + ", locationPickUp="
            + locationPickUp + ", locationReturn=" + locationReturn
            + ", kmWantToDrive=" + kmWantToDrive + ", car=" + carId
            + ", customer=" + customerId + "]";
   }
   
   
}
