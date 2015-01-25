
public class qequations {


		
		public String[] get_equations(double x[],double y[])
		{
			String res[]=new String[4];
			
		  
			double slope[]=new double[4];
		    double constant[]=new double[4];
		    if(x[1]!=x[2])
		    { 	
		    slope[0]=(y[2]-y[1])/(x[2]-x[1]);
		    }
		    if(x[2]!=x[3])
		    {
		    slope[1]=(y[3]-y[2])/(x[3]-x[2]);
		    }
		    if(x[3]!=x[4])
		    {
		    slope[2]=(y[4]-y[3])/(x[4]-x[3]);
		    }
		    if(x[1]!=x[4])
		    {
		    slope[3]=(y[4]-y[1])/(x[4]-x[1]);
		    }

		    constant[0]=(slope[0]*x[1])-y[1];
		    constant[1]=(slope[1]*x[3])-y[3];
		    constant[2]=(slope[2]*x[4])-y[4];
		    constant[3]=(slope[3]*x[4])-y[4];
		    
		    for(int i=0;i<4;i++)
		    {
		    	slope[i]=Math.ceil(slope[i]*100)*0.01;
		        constant[i]=Math.ceil(constant[i]*100)*0.01;
		    }
		    
		      res[0]="y + ("+slope[0]+")x + ("+constant[0]+") = 0";
		    res[1]="y + ("+slope[1]+")x + ("+constant[1]+") = 0";
		    res[2]="y + ("+slope[2]+")x + ("+constant[2]+") = 0";
		    res[3]="y + ("+slope[3]+")x + ("+constant[3]+") = 0";
		    
	        if(x[1]==x[2])
	        {
	        	res[0]="x - "+x[1]+" = 0";
	        }
	        if(x[2]==x[3])
	        {
	        	res[1]="x - "+x[2]+" = 0";
	        }
	        if(x[3]==x[4])
	        {
	        	res[2]="x - "+x[3]+" = 0";
	        }
	        if(x[4]==x[1])
	        {
	        	res[3]="x - "+x[4]+" = 0";
	        }
		    return res;
		}

	}


