/**
 * 
 */
package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

/**
 * @author Matos
 *
 */
public class ProductProgram {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		List<Product> products = new ArrayList<>();

		System.out.println("Enter the number of products: ");
		int n = sc.nextInt();
		
		for(int i = 1; i <= n; i++) {
			System.out.println("Product #" + i + " data: ");
			
			System.out.print("Common, used or imported (c/u/i)?");
			char opcao = sc.next().charAt(0);
			
			System.out.print("Name: ");
			sc.nextLine();
			String nameProduct = sc.nextLine();
			
			System.out.print("Price: ");
			double price = sc.nextDouble();
			
			if(opcao == 'i' || opcao == 'I') {
				System.out.print("Customs fee: ");
				double customsFee = sc.nextDouble();
				products.add(new ImportedProduct(nameProduct, price, customsFee));
				
			} else if (opcao == 'u' || opcao == 'U') {
				System.out.print("Manufacture date (DD/MM/YYYY): ");
				LocalDate date = LocalDate.parse(sc.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
				products.add(new UsedProduct(nameProduct, price, date));
				
			} else {
				products.add(new Product(nameProduct, price));
			}
		}
		
		System.out.println();
		
		System.out.println("PRICE TAGS: ");
		for(Product p: products) {
			System.out.println(p.priceTag());
		}

		sc.close();

	}

}
