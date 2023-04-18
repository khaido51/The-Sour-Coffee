package cm4oopHw3;

public class MainDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Brand
		Brand kingCoffee = new Brand();
		kingCoffee.name = "King Coffee";
		
		Brand trungNguyen = new Brand();
		trungNguyen.name = "Trung Nguyen";
		
		Brand[] brands = { kingCoffee, trungNguyen };
		
		//Location
		Location location1 = new Location();
		location1.locationId = "Q1";
		
		Location location2 = new Location();
		location2.locationId = "Q9";
		
		Location[] locations = { location1, location2 };
		
		//Customer
		Customer customer1 = new Customer();
		customer1.name = "Anh Dung";
		
		Customer customer2 = new Customer();
		customer2.name = "Anh Thang";
		
		Customer customer3 = new Customer();
		customer3.name = "Anh Kiet";
		
		Customer[] customers = { customer1, customer2, customer3 };
		
		
		//Account
		Account account1 = new Account();
		account1.accountId = "A001";
		account1.loginId = "dung@gmail.com";
		account1.password = "123456";
		account1.isActive = true;
		account1.customer = customer1;
		
		Account account2 = new Account();
		account2.accountId = "A002";
		account2.loginId = "thang@gmail.com";
		account2.password = "123456";
		account2.isActive = true;
		account2.customer = customer2;
		
		Account account3 = new Account();
		account3.accountId = "A001";
		account3.loginId = "hung@gmail.com";
		account3.password = "123456";
		account3.isActive = true;
		account3.customer = customer3;
		
		Account[] accounts = { account1, account2, account3 };
		
		Order order1 = new Order();
		order1.orderId = "0001";
		order1.orderDate = "15/05/2024";
		order1.totalPrice = 0;
		order1.customer = customer1;
		
		Order order3 = new Order();
		order3.orderId = "0001";
		order3.orderDate = "15/05/2024";
		order3.totalPrice = 0;
		order3.customer = customer1;
		
		Order order2 = new Order();
		order2.orderId = "0002";
		order2.orderDate = "16/05/2024";
		order2.totalPrice = 0;
		order2.customer = customer2;
		
		
		Order[] orders = { order1, order2, order3};
		
		//Product
		Product blackCoffee = new Product();
		blackCoffee.productId = "P001";
		blackCoffee.name = "Black Coffee";
		blackCoffee.totalQuantity = 1000;
		blackCoffee.brand = kingCoffee;
		
		Product brownGrindCoffee = new Product();
		brownGrindCoffee.productId = "P002";
		brownGrindCoffee.name = "Brown Grind Coffee";
		brownGrindCoffee.totalQuantity = 1200;
		brownGrindCoffee.brand = trungNguyen;
		
		Product whiteCoffee = new Product();
		whiteCoffee.productId = "P002";
		whiteCoffee.name = "White Coffee";
		//whiteCoffee.totalQuantity = 450;
		
		Product[] products = { blackCoffee, brownGrindCoffee, whiteCoffee };
		
		//ProductInStock
		ProductInStock brownGrindCoffeeStock1 = new ProductInStock();
		brownGrindCoffeeStock1.product = brownGrindCoffee;
		brownGrindCoffeeStock1.location = location1;
		brownGrindCoffeeStock1.quantity = 1000;
		
		ProductInStock brownGrindCoffeeStock2 = new ProductInStock();
		brownGrindCoffeeStock2.product = brownGrindCoffee;
		brownGrindCoffeeStock2.location = location1;
		brownGrindCoffeeStock2.quantity = 20;
		
		ProductInStock[] stocks = { brownGrindCoffeeStock1, brownGrindCoffeeStock2 };
		
		//ProductInOrder
		ProductInOrder orderItem1 = new ProductInOrder();
		orderItem1.order = order1;
		orderItem1.product = blackCoffee;
		orderItem1.quantity = 3;
		orderItem1.productPrice = 5;
		
		
		ProductInOrder orderItem2 = new ProductInOrder();
		orderItem2.order = order2;
		orderItem2.product = brownGrindCoffee;
		orderItem2.quantity = 3;
		orderItem2.productPrice = 9.5;
		
		ProductInOrder orderItem3 = new ProductInOrder();
		orderItem3.order = order3;
		orderItem3.product = whiteCoffee;
		orderItem3.quantity = 2;
		orderItem3.productPrice = 6.5;
		
		ProductInOrder[] orderItems = {orderItem1, orderItem2, orderItem3};
		
		for (Order order : orders) {
			double subTotal = 0;
			System.out.println("Order code: " + order.orderId);
			System.out.println("Date: " + order.orderDate);
			System.out.println("Customer " + order.customer.name);
			System.out.println("Products of the order: ");
			
			for (ProductInOrder orderItem : orderItems) {
				if (order.orderId.equals(orderItem.order.orderId)) {
					subTotal = orderItem.productPrice * orderItem.quantity;
					System.out.println(orderItem.product.name + 
							" - Quantity: " + orderItem.quantity
							+ " - Price = $" + orderItem.productPrice + 
							" - Sub total = $"+ subTotal);
					order.totalPrice += subTotal;
				}
			}
			System.out.println("Total: $" + order.totalPrice);
			System.out.println("-----------------------");
		}
	}
	
}


