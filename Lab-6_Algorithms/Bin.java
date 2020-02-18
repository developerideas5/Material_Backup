import java.util.ArrayList;

public class Bin
{
	ArrayList<Integer> integers;
	 int counter;
	public Bin()
	{
		integers = new ArrayList<Integer>();
		for (int i = 0; i < 10; i++)
		{
			integers.add(i);
		}
		int a=binary(0, 40, 41);
		System.out.println(a);
	}

	public int binary(int start,int end,int key)
	{
		counter++;
		int mid=(start+end)/2;
		if(key==mid)
		{
			return counter;
		}
		else if(key<mid)
		{
			binary(start, mid-1, key);
		}
		else 
		{
			binary(mid+1, end, key);
		}
		
		return counter;
	}
	public static void main(String... s)
	{
		new Bin();
	}
}
