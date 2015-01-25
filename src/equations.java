
public class equations {
	
	public String[] get_equations(double x[],double y[])
	{
		String res[]=new String[3];
		
	  
		double slope[]=new double[3];
	    double constant[]=new double[3];
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
	    constant[0]=(slope[0]*x[1])-y[1];
	    constant[1]=(slope[1]*x[3])-y[3];
	    constant[2]=(slope[2]*x[2])-y[2];
	    for(int i=0;i<3;i++)
	    {
	    	slope[i]=Math.ceil(slope[i]*100)*0.01;
	        constant[i]=Math.ceil(constant[i]*100)*0.01;
	    }
	    
	      res[0]="y + ("+slope[0]+")x + ("+constant[0]+") = 0";
	    res[1]="y + ("+slope[1]+")x + ("+constant[1]+") = 0";
	    res[2]="y + ("+slope[2]+")x + ("+constant[2]+") = 0";
	    
        if(x[1]==x[2])
        {
        	res[0]="x - "+x[1]+" = 0";
        }
        if(x[1]==x[3])
        {
        	res[1]="x - "+x[1]+" = 0";
        }
        if(x[3]==x[2])
        {
        	res[02]="x - "+x[3]+" = 0";
        }
        
	    return res;
	}

}
