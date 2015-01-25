
public class qlength {
	public double[] calc_length(double x1,double y1,double x2,double y2,double x3,double y3,double x4,double y4)
	{
		double d[]=new double[4];
		double dab=Math.pow((x1-x2),2)+Math.pow((y1-y2),2);
		d[0]=(double)Math.sqrt(dab);
		dab=Math.pow((x3-x2),2)+Math.pow((y3-y2),2);
		d[1]=(double)Math.sqrt(dab);
		dab=Math.pow((x4-x3),2)+Math.pow((y4-y3),2);
		d[2]=(double)Math.sqrt(dab);
		dab=Math.pow((x4-x1),2)+Math.pow((y4-y1),2);
		d[3]=(double)Math.sqrt(dab);
		
		d[0]=Math.ceil(d[0]*100)*0.01;
   	    d[1]=Math.ceil(d[1]*100)*0.01;
   	    d[2]=Math.ceil(d[2]*100)*0.01;
   	 d[3]=Math.ceil(d[3]*100)*0.01;
		
   	    return d;
		
	}

}
