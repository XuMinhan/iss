package sg.iss.nus.spring.mvc.shoppingcartapplication;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import sg.iss.nus.spring.mvc.shoppingcartapplication.model.Product;
import sg.iss.nus.spring.mvc.shoppingcartapplication.repository.CustomerRepository;
import sg.iss.nus.spring.mvc.shoppingcartapplication.repository.ProductRepository;
import sg.iss.nus.spring.mvc.shoppingcartapplication.repository.ShoppingCartDetailsRepository;
import sg.iss.nus.spring.mvc.shoppingcartapplication.repository.ShoppingCartRepository;
/**
 *
 * @author Ding Zihe
 *
 */
@SpringBootApplication
public class ShoppingCartApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShoppingCartApplication.class, args);
	}
	@Bean
	CommandLineRunner commandLineRun(ShoppingCartDetailsRepository shoppingCartDetailsRepository, ShoppingCartRepository shoppingCartRepository, ProductRepository productRepository, CustomerRepository customerRepository) {
		return args -> {
//			Product product_1 = new Product();
//			product_1.setDescription("This is the new product");
//			product_1.setProductName("XiaoMi");
//			product_1.setUnitPrice(10000);
//
//			Product product_2 = new Product();
//			product_2.setDescription("Second product");
//			product_2.setProductName("Apple");
//			product_2.setUnitPrice(123.434);
//
//			productRepository.save(product_1);
//			productRepository.save(product_2);
//			List<ShoppingCard> shoppingCards = shoppingCardRepository.findAll();
//			List<ShoppingCardDetails> shoppingCardDetails = shoppingCardDetailsRepository.findAll();
//			shoppingCards.get(0).setShoppingCardDetailsList(shoppingCardDetails);
//			shoppingCardRepository.save(shoppingCards.get(0));
//			System.out.println(shoppingCards.get(0).getShoppingCardDetailsList()+"1231231321313");
//
//			List<Product> products = productRepository.findAll();
//			List<Customer> customers = customerRepository.findAll();
//
//			ShoppingCard shoppingCard = new ShoppingCard();
//			shoppingCard.setCustomer(customers.get(0));
//
//			ShoppingCardDetails cardDetails = new ShoppingCardDetails();
//			cardDetails.setProduct(products.get(0));
//			cardDetails.setShoppingCard(shoppingCard);
//
//			shoppingCardRepository.save(shoppingCard);
//			shoppingCardDetailsRepository.save(cardDetails);
//
//			Product product1 = new Product("Adidas Originals Hoodie", 299, "3.1.1Adidas Originals Hoodie.jpg", "Men’s Clothing");
//			productRepository.save(product1);
//
//			Product product2 = new Product("Nike Air Max T-shirt", 199, "3.1.2Nike Air Max T-shirt.jpg", "Men’s Clothing");
//			productRepository.save(product2);
//
//			Product product3 = new Product("Nike Sportswear Jacket", 399, "3.1.3Nike Sportswear Jacket.jpg", "Men’s Clothing");
//			productRepository.save(product3);
//
//			Product product4 = new Product("Zara Casual Blazer", 499, "3.2.1Zara Casual Blazer.jpg", "Women’s Clothing");
//			productRepository.save(product4);
//
//			Product product5 = new Product("Zara Summer Dress", 299, "3.2.2Zara Summer Dress.jpg", "Women’s Clothing");
//			productRepository.save(product5);
//
//			Product product6 = new Product("Puma Essentials Hoodie", 279, "3.3.1Puma Essentials Hoodie.jpg", "Sportswear");
//			productRepository.save(product6);
//
//			Product product7 = new Product("Puma Ignite Running Shoes", 599, "3.3.2Puma Ignite Running Shoes.jpg", "Sportswear");
//			productRepository.save(product7);
//
//			Product product8 = new Product("Swarovski Crystal Necklace", 799, "3.4.1Swarovski Crystal Necklace.jpg", "Jewelry");
//			productRepository.save(product8);
//
//			Product product9 = new Product("Swarovski Tennis Bracelet", 999, "3.4.2Swarovski Tennis Bracelet.jpg", "Jewelry");
//			productRepository.save(product9);
//
//			Product product10 = new Product("Nike Air Force 1", 899, "3.5.1Nike Air Force 1.jpg", "Footwear");
//			productRepository.save(product10);
//
//			Product product11 = new Product("Nike Air Zoom Pegasus", 799, "3.5.2Nike Air Zoom Pegasus.jpg", "Footwear");
//			productRepository.save(product11);
//
//			Product product12 = new Product("Converse One Star Platform", 499, "3.5.3Converse One Star Platform.jpg", "Footwear");
//			productRepository.save(product12);
//
//			Product product13 = new Product("Coach Tabby Shoulder Bag", 2899, "3.6.1Coach Tabby Shoulder Bag.jpg", "Handbags");
//			productRepository.save(product13);
//
//			Product product14 = new Product("Coach Rogue Bag", 5999, "3.6.2Coach Rogue Bag.jpg", "Handbags");
//			productRepository.save(product14);
//
//			Product product15 = new Product("Michael Kors Jet Set Travel Tote", 1599, "3.6.3Michael Kors Jet Set Travel Tote.jpg", "Handbags");
//			productRepository.save(product15);
//
//			Product product16 = new Product("Casio G-Shock DW-5600", 799, "3.7.1Casio G-Shock DW-5600.jpg", "Watches");
//			productRepository.save(product16);
//
//			Product product17 = new Product("Casio Edifice EFV-570", 899, "3.7.2Casio Edifice EFV-570.jpg", "Watches");
//			productRepository.save(product17);

//			Product product1 = new Product("Apple iPhone 14", 5999, "1.1.1Apple iPhone 14.jpg", "Mobile Phones");
//			productRepository.save(product1);
//
//			Product product2 = new Product("Apple iPhone 14 Pro", 7999, "1.1.2Apple iPhone 14 Pro.jpg", "Mobile Phones");
//			productRepository.save(product2);
//
//			Product product3 = new Product("Samsung Galaxy S23", 5499, "1.1.3Samsung Galaxy S23.jpg", "Mobile Phones");
//			productRepository.save(product3);
//
//			Product product4 = new Product("Apple MacBook Air M2", 7999, "1.2.1Apple MacBook Air M2.jpg", "Laptops");
//			productRepository.save(product4);
//
//			Product product5 = new Product("Dell XPS 13", 8499, "1.2.2Dell XPS 13.jpg", "Laptops");
//			productRepository.save(product5);
//			Product product6 = new Product("Oreo Original Flavor", 12, "2.1.1Oreo Original Flavor.jpg", "Biscuits");
//			productRepository.save(product6);
//
//			Product product7 = new Product("Oreo Chocolate Flavor", 14, "2.1.2Oreo Chocolate Flavor.jpg", "Biscuits");
//			productRepository.save(product7);
//
//			Product product8 = new Product("Lindt Dark Chocolate", 30, "2.2.1Lindt Dark Chocolate.jpg", "Chocolates");
//			productRepository.save(product8);
//
//			Product product9 = new Product("Lindt Milk Chocolate", 35, "2.2.2Lindt Milk Chocolate.jpg", "Chocolates");
//			productRepository.save(product9);
//
//			Product product10 = new Product("Lay’s Original Flavor", 8, "2.3.1Lay’s Original Flavor.jpg", "Chips");
//			productRepository.save(product10);
//
//			Product product11 = new Product("Lay’s Tomato Flavor", 8, "2.3.2Lay’s Tomato Flavor.jpg", "Chips");
//			productRepository.save(product11);
//
//			Product product12 = new Product("Pringles BBQ Flavor", 10, "2.3.3Pringles BBQ Flavor.jpg", "Chips");
//			productRepository.save(product12);
//
//			Product product13 = new Product("Three Squirrels Almonds", 25, "2.4.1Three Squirrels Almonds.jpg", "Nuts");
//			productRepository.save(product13);
//
//			Product product14 = new Product("Three Squirrels Daily Nuts", 30, "2.4.2Three Squirrels Daily Nuts.jpg", "Nuts");
//			productRepository.save(product14);
//
//			Product product15 = new Product("Haribo Fruit Gummies", 18, "2.5.1Haribo Fruit Gummies.jpg", "Candies");
//			productRepository.save(product15);
//
//			Product product16 = new Product("Skittles Fruit Candy", 10, "2.5.2Skittles Fruit Candy.jpg", "Candies");
//			productRepository.save(product16);
//
//			Product product17 = new Product("Skittles Sugar-Free Mints", 12, "2.5.3Skittles Sugar-Free Mints.jpg", "Candies");
//			productRepository.save(product17);
//
//			Product product18 = new Product("Planters Salted Cashews", 28, "2.6.1Planters Salted Cashews.jpg", "Dried Fruits");
//			productRepository.save(product18);
//
//			Product product19 = new Product("Planters Dry Roasted Peanuts", 30, "2.6.2Planters Dry Roasted Peanuts.jpg", "Dried Fruits");
//			productRepository.save(product19);
//
//			Product product20 = new Product("Calbee Shrimp Chips", 10, "2.7.1Calbee Shrimp Chips.jpg", "Ready-to-Eat Snacks");
//			productRepository.save(product20);
//
//			Product product21 = new Product("Jack Link’s Beef Jerky", 45, "2.7.2Jack Link’s Beef Jerky.jpg", "Ready-to-Eat Snacks");
//			productRepository.save(product21);
//
//			Product product22 = new Product("Jack Link’s Smoked Beef Sticks", 50, "2.7.3Jack Link’s Smoked Beef Sticks.jpg", "Ready-to-Eat Snacks");
//			productRepository.save(product22);









		};

		}
	}
