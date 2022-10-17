package br.com.alura.loja.modelo;

import static java.util.Collections.unmodifiableList;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "pedidos")
public class Pedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private LocalDate data = LocalDate.now();

	/**
	 * Colocamos o FetchType como Lazy, para que a JPA não carregue a entidade cliente sem necessidade
	 * Lazy é necessário no caso de relacionamento OneToOne ou ManyToOne
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	private Cliente cliente;

	@Column(name = "valor_total")
	private BigDecimal valorTotal = BigDecimal.ZERO;

	@OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)
	private List<ItemPedido> itens = new ArrayList<>();
	
	public Pedido() {

	}

	public void adicionarItem(ItemPedido item) {
		item.setPedido(this);
		this.itens.add(item);
		this.valorTotal = this.valorTotal.add(item.getValor());
		
	}
	
	public List<ItemPedido> getItens() {
		return unmodifiableList(itens);
	}

	@SuppressWarnings("unused")
	@Deprecated
	private BigDecimal calcularValorTotal(ItemPedido item) {
		
		BigDecimal quantidade = new BigDecimal(item.getQuantidade());
		BigDecimal precoUnitario = item.getPrecoUnitario();
		return this.valorTotal = valorTotal.add((precoUnitario.multiply(quantidade)));
		
	}

	public Pedido(Cliente cliente) {
		this.cliente = cliente;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}

}
