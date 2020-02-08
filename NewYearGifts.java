import java.util.*;

interface Item
{
	public void assign(int weight,int price);
}

class Sweets implements Item
{
	int weight;
	int price_of_sweets;
	public void assign(int weight,int price_of_sweets)
	{
		this.weight=weight;
		this.price_of_sweets=price_of_sweets;
	}
}

class Chocolates implements Item
{
	int weight;
	int price_of_choco;
	public void assign(int weight,int price_of_choco)
	{
		this.weight=weight;
		this.price_of_choco=price_of_choco;
		
	}
}

class ChildrensNewYearGifts
{
	int noOfSweets;
	int noOfChoco;
	Sweets sweet[];
	Chocolates choco[];
	
	ChildrensNewYearGifts(int noOfSweets,int noOfChoco,int weightOfSweets[],int price_of_sweets[],int weightOfChoco[],int price_of_choco[])
	{
		this.noOfSweets=noOfSweets;
		this.noOfChoco=noOfChoco;
		sweet=new Sweets[noOfSweets];
		choco=new Chocolates[noOfChoco];
		int i;	
		
		for(i=0;i<noOfSweets;i++)
		{
			sweet[i]=new Sweets();
			sweet[i].assign(weightOfSweets[i],price_of_sweets[i]);
		}
		
		
		for(i=0;i<noOfChoco;i++)
		{
			choco[i]=new Chocolates();
			choco[i].assign(weightOfChoco[i],price_of_choco[i]);
		}
		
	}
	
}

public class NewYearGifts 
{
	static int noOfChoco;
	static int noOfSweets;
	static int i;
	static int weightOfSweets[];
	static int price_of_sweets[];
		
	static int weightOfChoco[];
	static int price_of_choco[];
	static Scanner sc=new Scanner(System.in);
	
	static ChildrensNewYearGifts gifts;
	
	static void inputSweet()
	{
		System.out.println("Enter number of sweets:");
		noOfSweets=sc.nextInt();
		weightOfSweets=new int[noOfSweets];
		price_of_sweets=new int[noOfSweets];
		
		System.out.println("Enter the weight and price of each sweet");
		
		for(i=0;i<noOfSweets;i++)
		{
			System.out.println("Enter the weight and price of Sweet "+(i+1)+" :");
			weightOfSweets[i]=sc.nextInt();
			price_of_sweets[i]=sc.nextInt();
		}
	}
	
	static void inputChocolate()
	{
		System.out.println("Enter number of chocolates:");
		noOfChoco=sc.nextInt();
		
		weightOfChoco=new int[noOfChoco];
		price_of_choco=new int[noOfChoco];
		System.out.println("Enter the weight and price of each Chocolate");
		
		for(i=0;i<noOfChoco;i++)
		{
			System.out.println("Enter the weight and price of Chocolate "+(i+1)+" :");
			weightOfChoco[i]=sc.nextInt();
			price_of_choco[i]=sc.nextInt();
		}
		
	}
	
	static int totalWeight(int type)
	{
		int total_Weight=0;
		if(type == 1)
		{
			for(i=0;i<noOfSweets;i++)
			{
				total_Weight=total_Weight+gifts.sweet[i].weight;
			}
		}
		else
		{
			for(i=0;i<noOfChoco;i++)
			{
				total_Weight=total_Weight+gifts.choco[i].weight;
			}			
		}
		return total_Weight;
	}
	
	static int totalPrice(int type)
	{
		int total_Price=0;
		if(type == 1)
		{
			for(i=0;i<noOfSweets;i++)
			{
				total_Price=total_Price+gifts.sweet[i].price_of_sweets;
			}
		}
		else
		{
			for(i=0;i<noOfChoco;i++)
			{
				total_Price=total_Price+gifts.choco[i].price_of_choco;
			}			
		}
		return total_Price;
	}
	
	public static void main(String args[])
	{
		inputSweet();
		inputChocolate();			
	
		gifts=new ChildrensNewYearGifts(noOfSweets,noOfChoco,weightOfSweets,price_of_sweets,weightOfChoco,price_of_choco);
		
		int choice;
		System.out.println("Do you want to sort the items in the gift. If so\nPress 1 -to sort the items in the gift according to the sorted order of price");
		System.out.println("Press 2 - to sort the items in the gift according to the order of the weight:");
		System.out.println("Press 0 if you don't wish to sort ");
		choice=sc.nextInt();
		
		Sweets temp1;
		Chocolates temp2;
		int j;
		if(choice == 1)
		{
			
			for(i=0;i<noOfSweets;i++)
			{
				for(j=0;j<noOfSweets;j++)
				{
					if(gifts.sweet[i].price_of_sweets < gifts.sweet[j].price_of_sweets)
					{
						temp1=gifts.sweet[i];	
						gifts.sweet[i]=gifts.sweet[j];
						gifts.sweet[j]=temp1;
					}
				}
			}
			
			for(i=0;i<noOfChoco;i++)
			{
				for(j=0;j<noOfChoco;j++)
				{
					if(gifts.choco[i].price_of_choco < gifts.choco[j].price_of_choco)
					{
						temp2=gifts.choco[i];	
						gifts.choco[i]=gifts.choco[j];
						gifts.choco[j]=temp2;
						
					}
				}
			}
		}
		else if(choice == 2)
		{
			for(i=0;i<noOfSweets;i++)
			{
				for(j=0;j<noOfSweets;j++)
				{
					if(gifts.sweet[i].weight < gifts.sweet[j].weight)
					{
						temp1=gifts.sweet[i];	
						gifts.sweet[i]=gifts.sweet[j];
						gifts.sweet[j]=temp1;
					}
				}
			}
			
			for(i=0;i<noOfChoco;i++)
			{
				for(j=0;j<noOfChoco;j++)
				{
					if(gifts.choco[i].weight < gifts.choco[j].weight)
					{
						temp2=gifts.choco[i];	
						gifts.choco[i]=gifts.choco[j];
						gifts.choco[j]=temp2;
						
					}
				}
			}
		
		}
		
		if(choice != 0)
		{
			System.out.println("The Sorted List is: ");
		}
		else
			System.out.println("The Unchanged list is: ");
		
		
		System.out.println("The List of Sweets: ");
		System.out.println("Weight -------- Price");
		
		
		for(i=0;i<noOfSweets;i++)
		{
			System.out.println(gifts.sweet[i].weight+"\t|\t"+gifts.sweet[i].price_of_sweets);			
		}
		
		int total_Weight=totalWeight(1);
		int total_Price=totalPrice(1);
		
		System.out.println("Total Weight of the Sweets is: "+total_Weight+" Total Price of the Sweets is: "+total_Price);
		
		System.out.println("The List of Chocolates: ");
		System.out.println("Weight -------- Price");
		
		for(i=0;i<noOfChoco;i++)
		{
			System.out.println(gifts.choco[i].weight+"\t|\t"+gifts.choco[i].price_of_choco);			
		}
		
		int total_Weight1=totalWeight(2);
		int total_Price1=totalPrice(2);
		
		System.out.println("Total Weight of the Chocolates is: "+total_Weight1+" Total Price of the Chocolates is: "+total_Price1);
		
		System.out.println("Total Price: "+(total_Price+total_Price1));
		System.out.println("Total Weight: "+(total_Weight+total_Weight1));
		
		sc.close();
		
	}
}
