
public class altitude {

	public double[] getaltitude(double x[],double y[])
	{
		double slope[]=new double[3];
		double nslope[]=new double[3];
		double constant[]=new double[3];
		double nconstant[]=new double[3];
		double alt[]=new double[6];
		 
		 
	 
	     if(x[1]!=x[2])
	     {
	    	 slope[0]=(y[2]-y[1])/(x[2]-x[1]);   
	    	 nslope[0]=-1/slope[0];
	     }
	     
	     if(x[1]!=x[3])
	     {
	    	 slope[1]=(y[3]-y[1])/(x[3]-x[1]);	 
	    	 nslope[1]=-1/slope[1];
	     }
	     if(x[2]!=x[3])
	     {
	    	 slope[2]=(y[2]-y[3])/(x[2]-x[3]);
	    	 nslope[2]=-1/slope[2];
	     }
	     
	      
	        
	       constant[0]=(slope[0]*x[1])-y[1];
		    constant[1]=(slope[1]*x[3])-y[3];
		    constant[2]=(slope[2]*x[2])-y[2];
		    nconstant[0]=(nslope[0]*x[3])-y[3];
		    nconstant[1]=(nslope[1]*x[2])-y[2];
		    nconstant[2]=(nslope[2]*x[1])-y[1];
            alt[0]=(nconstant[0]-constant[0])/(slope[0]-nslope[0]);
            alt[2]=(nconstant[1]-constant[1])/(slope[1]-nslope[1]);
            alt[4]=(nconstant[2]-constant[2])/(slope[2]-nslope[2]);
            alt[1]=(slope[0]*alt[0])+constant[0];
            alt[3]=(slope[1]*alt[2])+constant[1];
            alt[5]=(slope[2]*alt[4])+constant[2];
		
		   for(int i=0;i<6;i++)
		   {
			   alt[i]=alt[i]*-1;
		   }
		   if(x[1]==x[2])
		     {
		    	 alt[1]=y[3];
		    	 alt[0]=x[1];
		    	 
		     }
		     if(x[1]==x[3])
		     {
		    	 alt[2]=x[1];
		    	 alt[3]=y[2];
		    	 
		     }
		     if(x[3]==x[2])
		     {
		    	alt[4]=x[3];
		    	alt[5]=y[1];
		     }
		     if(y[1]==y[2])
		     {
		    	alt[0]=x[3];
		    	alt[1]=y[1];
		     }
		     if(y[1]==y[3])
		     {
		    	alt[2]=x[2];
		    	alt[3]=y[1];
		     }
		     if(y[3]==y[2])
		     {
		    	alt[4]=x[1];
		    	alt[5]=y[3];
		     }
		     
		   
	     return alt;
	}
	
}
