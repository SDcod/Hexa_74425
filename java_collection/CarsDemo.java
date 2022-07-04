package java_28_6;
import java.util.*;



	abstract class Car
	{
		String model;
		String brand;
		float carAge;
		int price;
		
		Car()
		{
			Scanner sc=new Scanner(System.in);
			System.out.print("\n Enter car model name :");
			model=sc.nextLine();
			System.out.print("\n Enter car age(years) :");
			carAge=sc.nextInt();
			System.out.print("\n Enter car price :");
			price=sc.nextInt();
			
			
		}
		public void display()
		{
			
			System.out.println("\nCAR NAME : "+ model+ "\nCAR AGE :"+carAge+ "\nCAR PRICE : "+price+"\nCAR BRAND : "+brand);	
		}
		public abstract void raisePrice();	
		
		
	}

	final class Ford extends Car {
		public Ford(){
			
			brand="Ford";
		}
		public void raisePrice(){
			price=price+5000;
			
		}
	}

	 final class Toyota extends Car{
		public Toyota(){
		
			brand="Toyota";
		}
		public void raisePrice(){
			price=price+10000;
			
		}
	}
	final class Mercedes extends Car{
		public Mercedes(){
		
			brand="Mercedes";
		}
		public void raisePrice(){
			price=price+20000;
			
		}
	}

	public class CarsDemo {
		
		public static void main(String args[])
		{
			int ch1=0,ch2=0;
			
		//	ArrayList<Car> list=new ArrayList<Car>();
			LinkedList<Car> list = new LinkedList<Car>();
			do{ 
			System.out.println("----------------Car Manager-------------------");
			System.out.println("1.Insert Car");
			System.out.println("2.Display Cars");
			System.out.println("3.Raise Price");
			System.out.println("4.Exit");
			System.out.println("--------------------------------");
			System.out.println("Enter your Choice: ");
			Scanner sc1=new Scanner(System.in);
			ch1=sc1.nextInt();

				if(ch1==1){
				do{
					System.out.println("-------------Select Car Make-------------------");
					System.out.println("1.Ford");
					System.out.println("2.Toyota");
					System.out.println("3.Mercedes");
					System.out.println("4.Exit");
					System.out.println("--------------------------------");
					System.out.println("Enter your Choice: ");
					Scanner sc2=new Scanner(System.in);
					ch2=sc2.nextInt();
					switch(ch2){
						case 1:	
						
							list.add(new Ford());	
							break;							
						case 2:
							list.add(new Toyota());
							break;						
						case 3:
							list.add(new Mercedes());
							break;
						}
				}while(ch2!=4);
			}
			if(ch1==2)
			{
				Iterator i=list.iterator();
				
				if(i.hasNext())
				{
					Car x=(Car) i.next();
					x.display();
				}else {
					System.out.println("No CARS FOUND !!! please select insert option to add cars.");
				}
				
			}
			if(ch1==3)
			{
				Iterator i=list.iterator();
				while(i.hasNext())
				{
					Car x=(Car) i.next();
					x.raisePrice();
				}
			}
			}while(ch1!=4);
			System.out.println("Total no. of Cars Added: "+list.size());
		}
	}


