import java.math.*;
public class diag {
	
	


	public double[] get_equations(double x[],double y[])
	{
		double xi[]=new double[2];
	  
		double slope[]=new double[4];
	    double constant[]=new double[4];
	    if(x[1]!=x[3])
	    { 	
	    slope[0]=(y[3]-y[1])/(x[3]-x[1]);
	    }
	    if(x[2]!=x[4])
	    {
	    slope[1]=(y[4]-y[2])/(x[4]-x[2]);
	    }

	    constant[0]=(slope[0]*x[1])-y[1];
	    constant[1]=(slope[1]*x[4])-y[4];
	    
	    for(int i=0;i<4;i++)
	    {
	    	slope[i]=Math.ceil(slope[i]*100)*0.01;
	        constant[i]=Math.ceil(constant[i]*100)*0.01;
	    }
	    xi[0] = (constant[1] - constant[0]) / (slope[0] - slope[1]);
       xi[1] = slope[0] * xi[0] + constant[0];
       xi[0]=Math.abs(xi[0]);
       xi[1]=Math.abs(xi[1]);
        
	    return xi;
	   /*   res[0]="y + ("+slope[0]+")x + ("+constant[0]+") = 0";
	    res[1]="y + ("+slope[1]+")x + ("+constant[1]+") = 0";
	    
        if(x[1]==x[3])
        {
        	res[0]="x - "+x[1]+" = 0";
        }
        if(x[2]==x[4])
        {
        	res[1]="x - "+x[2]+" = 0";
        }
        return res;
	*/
	}
}
