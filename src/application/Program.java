package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class Program {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		List<Product> listOfProducts = new ArrayList<>();
		
		System.out.println("Enter the number of products: ");
		int N = sc.nextInt();
		
		for (int i = 0; i < N; i++) {
			System.out.printf("Product #%d data: %n", i + 1);
			System.out.println("Common, used or imported (c/u/i)? ");
			char opt = sc.next().charAt(0);
			System.out.print("Name: ");
			String name = sc.next();
			System.out.print("Price: ");
			Double price = sc.nextDouble();
			switch (opt) {
			case 'c': {
				listOfProducts.add(new Product(name, price));
				break;
			} 
			case 'u': {
				System.out.println("Manufacture date (DD/MM/YYYY): ");
				Date manufactureDate = sdf.parse(sc.next());
				listOfProducts.add(new UsedProduct(name, price, manufactureDate));
				break;
			}
			case 'i': {
				System.out.print("Customs fee: ");
				Double customsFee = sc.nextDouble();
				listOfProducts.add(new ImportedProduct(name, price, customsFee));
				break;
			}
			default: {
				System.out.println("Invalid");
				break;
			}
			}
		}
		System.out.println();
		System.out.println("PRICE TAGS:");
		for (Product product: listOfProducts) {
			System.out.println(product.priceTag());
		}
		sc.close();

	}

}
