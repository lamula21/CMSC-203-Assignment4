

public class ManagementCompany extends Object  {

	
		
	private final int MAX_PROPERTY = 5, MGMT_WIDTH = 10, MGMT_DEPTH = 10;
	private double mgmFeePer;
	private String name, taxID;
	private Property[] properties;
	private Plot plot;

	public ManagementCompany(){
		 
		 name = "";
		 taxID = "";
		 mgmFeePer = 0;
		 plot = new Plot();
		 properties = new Property[MAX_PROPERTY];
	 }
	 
	public ManagementCompany(String name, String taxID, double mgmFee){
		 
		 this.name = name;
		 this.taxID= taxID;
		 mgmFeePer = mgmFee;
		 plot = new Plot (0, 0, MGMT_WIDTH, MGMT_DEPTH);
		 properties = new Property[MAX_PROPERTY];
		 
	 }
	 
	public ManagementCompany(String name, String taxID, double mgmFee, int x, int y, int width, int depth){
		 
		 this.name = name;
		 this.taxID= taxID;
		 mgmFeePer = mgmFee;
		 plot = new Plot (x, y, width, depth);
		 properties = new Property[MAX_PROPERTY];
		 
		 
	 }
	 
	public ManagementCompany(ManagementCompany otherCompany){ 
		 
		 
		 name = otherCompany.name;
		 taxID = otherCompany.taxID;
		 mgmFeePer = otherCompany.mgmFeePer;
		 plot = new Plot(otherCompany.plot);
		 properties = new Property[MAX_PROPERTY];
		 
	 }
		
	// addproperty 1 
	public int addProperty(Property property) {
		
		
		if (property == null)
			return -2;
		
		if (!(plot.encompasses(property.getPlot())))
			return -3;
		
		for (int i = 0; i < MAX_PROPERTY; i++) {
			if ( properties[i] != null && (property.getPlot()).overlaps(properties[i].getPlot()))
				return -4;
		}
			
        int position = -1;
        boolean found = false;

        for (int i = 0; i < MAX_PROPERTY && !found; i++)
            if (properties[i] == null) {
                found = true;
                position = i;
                properties[i] = property;
            }

        return position;
		}

	
	
	// addproperty 2
	public int addProperty(String name,String city,double rent,String owner) {
		
		
		Property property = new Property(name, city, rent, owner);
		return addProperty(property);}
	 
	 
	// addproperty 3
	public int addProperty(String name, String city, double rent, String owner, int x, int y, int width, int depth) 
	{
		Property property = new Property(name, city, rent, owner, x, y, width, depth);
		return addProperty(property);
	}
	 
	
	
	
	
	
	
	
	String displayPropertyAtIndex(int i) {
		
		return properties[i].toString();
	}
	 
	
	
	
	
	
	public int getMAX_PROPERTY() {
		return MAX_PROPERTY;}
	 
	
	
	
	
	public String maxRentProp() {

		return displayPropertyAtIndex(maxRentPropertyIndex()) ;
	}
	
	
	
	
	
	// check this one
	int maxRentPropertyIndex() {
		
		
		int index = 0;	// Store the index with max rent
		double max = properties[0].getRentAmount() ; // Store the number with max rent
		
		for(int i = 0; properties[i] != null && i < properties.length; i++) 
		{
			if (  properties[i].getRentAmount() > max  )
			{
				max = properties[i].getRentAmount();
				index = i;
			}
		}
		
		return index;
	}
	
	
	
	
	
	 //check 
	 public String toString() {
		
		String a = "List of the properties for " + name + ", taxID: " + taxID
				+ "\n------------------------------------------------\n" 
				+ 	properties[0].toString() + "\n" 
				+ 	properties[1].toString() + "\n" 
				+ 	properties[2].toString() + "\n" 
				+ 	properties[3].toString() + "\n" 
				+ 	properties[4].toString() + "\n";

		return a ;}
	 
	 
	 
	 
	 
	
	 public double	totalRent() {
		 
		double totalRent = 0.0;
		for ( int i = 0; properties[i] != null && i<properties.length; i++)
		{
			totalRent += properties[i].getRentAmount(); 
		}
			
		return totalRent;
		}

}
