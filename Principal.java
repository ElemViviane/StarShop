package br.com.starshop.modelos;

import java.util.Collections;
import java.util.Scanner;

public class Principal {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Informe o limite do cartão: ");
		double limite = sc.nextDouble();
		
		CartaoDeCredito cartao = new CartaoDeCredito(limite);
		
		int sair = 1;
		while(sair != 0) {
			System.out.println("Informe a descrição da compra: ");
			String descricao = sc.next();
			
			System.out.println("Informe o valor da compra: ");
			double valor = sc.nextDouble();
			
			Compra compra = new Compra(descricao, valor);
			boolean compraRealizada = cartao.lancaCompra(compra);
			
			if(compraRealizada) {
				System.out.println("Compra realizada!");
				System.out.println("\nDigite 0 para sair ou 1 para continuar.");
				sair = sc.nextInt();
			} else {
				System.out.println("Saldo insuficiente!\n");
				sair = 0;
			}
		}
		System.out.println("***********************");
		System.out.println("COMPRAS REALIZADAS:\n");
		
		Collections.sort(cartao.getCompras());
	    cartao.getCompras().forEach(System.out::println);
		
		System.out.println("\n***********************");
		
		System.out.println("\nSaldo do cartão: " + cartao.getSaldo());
	}
}
