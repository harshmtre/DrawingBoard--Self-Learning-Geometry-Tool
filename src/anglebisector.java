
public class anglebisector {

	public double[] getbisectors(double x[],double y[])
	{
		double bis[]=new double[6];
		double slope[]=new double[3];
		double bslope[]=new double[3];
		double constant[]=new double[3];
		double bconstant[]=new double[3]; 
		if(x[1]!=x[2])
	    { 	
	    slope[0]=(y[2]-y[1])/(x[2]-x[1]);
	    }
	    if(x[1]!=x[3])
	    {
	    slope[1]=(y[3]-y[1])/(x[3]-x[1]);
	    }
	    if(x[3]!=x[2])
	    {
	    slope[2]=(y[2]-y[3])/(x[2]-x[3]);
	    }
	
		
	    
	    
	    double ang1=Math.atan((slope[0]-slope[1])/(1+(slope[0]*slope[1])));
		double ang2=Math.atan((slope[0]-slope[2])/(1+(slope[0]*slope[2])));
		double ang3=Math.atan((slope[2]-slope[1])/(1+(slope[2]*slope[1])));
		ang1=ang1/2;
		ang2=ang2/2;
		ang3=ang3/2;
		
		bslope[0]=((slope[0]-Math.tan(ang1))/(1+(slope[0]*Math.tan(ang1))));
		bslope[1]=((slope[0]-Math.tan(ang2))/(1+(slope[0]*Math.tan(ang2))));
		bslope[2]=((slope[2]-Math.tan(ang3))/(1+(slope[2]*Math.tan(ang3))));
	    constant[0]=(slope[0]*x[1])-y[1];
	    constant[1]=(slope[1]*x[3])-y[3];
	    constant[2]=(slope[2]*x[2])-y[2];
	    bconstant[0]=(bslope[0]*x[1])-y[1];
	    bconstant[1]=(bslope[1]*x[2])-y[2];
	    bconstant[2]=(bslope[2]*x[3])-y[3];
	    bis[0]=(bconstant[0]-constant[2])/(slope[2]-bslope[0]);
        bis[2]=(bconstant[1]-constant[1])/(slope[1]-bslope[1]);
        bis[4]=(bconstant[2]-constant[0])/(slope[0]-bslope[2]);
        bis[1]=(slope[2]*bis[0])+constant[2];
        bis[3]=(slope[1]*bis[2])+constant[1];
        bis[5]=(slope[0]*bis[4])+constant[0];
        for(int i=0;i<6;i++)
		   {
               if(bis[i]<0)	   
			   bis[i]=bis[i]*-1;
		   }
	
		
		
		
		return bis;
	}
}
