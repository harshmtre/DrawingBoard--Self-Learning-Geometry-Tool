
public class qdiag {
	
	public double cal_length(double x1,double y1,double x2,double y2)
	{
		double d;
		double dab=Math.pow((x1-x2),2)+Math.pow((y1-y2),2);
		d=(double)Math.sqrt(dab);
		return d;
	}

}
