public class Customer
{
   
   private String name;
   private int phoneNo;
   private int licence;
   
   public Customer()
   {
      this.name = name;
      this.phoneNo = phoneNo;
      this.licence = licence;
   }
  
   /**
    * @return the name
    */
   public String getName()
   {
      return name;
   }
   /**
    * @param name the name to set
    */
   public void setName(String name)
   {
      this.name = name;
   }
   /**
    * @return the phoneNo
    */
   public int getPhoneNo()
   {
      return phoneNo;
   }
   /**
    * @param phoneNo the phoneNo to set
    */
   public void setPhoneNo(int phoneNo)
   {
      this.phoneNo = phoneNo;
   }
   /**
    * @return the licence
    */
   public int getLicence()
   {
      return licence;
   }
   /**
    * @param licence the licence to set
    */
   public void setLicence(int licence)
   {
      this.licence = licence;
   }
   /* (non-Javadoc)
    * @see java.lang.Object#toString()
    */
   @Override
   public String toString()
   {
      return "Customer [ name=" + name + ", phoneNo=" + phoneNo
            + ", licence=" + licence + "]";
   }
   
   
}

