
public class centroid {

	public double[] calc_centroid(double x1,double y1,double x2,double y2,double x3,double y3)
	{
		double cnt[]=new double[2];
		cnt[0]=(x1+x2+x3)/3;
		cnt[0]=Math.ceil(cnt[0]*100)*0.01;
		cnt[1]=(y1+y2+y3)/3;
		cnt[1]=Math.ceil(cnt[1]*100)*0.01;
		return cnt;
	}

}
