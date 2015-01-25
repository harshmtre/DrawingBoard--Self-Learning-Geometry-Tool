
public class length {
	
	public double[] calc_length(double x1,double x2,double y1,double y2,double z1,double z2)
	{
		double d[]=new double[3];
		double dab=Math.pow((x1-y1),2)+Math.pow((x2-y2),2);
		d[0]=(double)Math.sqrt(dab);
		dab=Math.pow((x1-z1),2)+Math.pow((x2-z2),2);
		d[1]=(double)Math.sqrt(dab);
		dab=Math.pow((y1-z1),2)+Math.pow((y2-z2),2);
		d[2]=(double)Math.sqrt(dab);
		d[0]=Math.ceil(d[0]*100)*0.01;
   	    d[1]=Math.ceil(d[1]*100)*0.01;
   	    d[2]=Math.ceil(d[2]*100)*0.01;
		return d;
		
	}

}
