package net.tibrasil.service;

import java.util.ArrayList;
import java.util.List;

import net.tibrasil.model.Cliente;

public class ClienteService {
	private static List<Cliente> lista = new ArrayList<>();
	
	public void cadastrar(Cliente cliente) {
		lista.add(cliente);
		System.out.println("Adicionado");
	}

	public static List<Cliente> getTodosClientes() {
		return lista;
	}

	public void excluir(int indice) {
		lista.remove(indice);
		System.out.println("Excluído");
	}
}
