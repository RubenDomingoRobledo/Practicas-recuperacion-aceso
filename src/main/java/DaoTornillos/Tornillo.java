package DaoTornillos;

enum TipoDeRosca {
	Métrica, Whitworth, Trapecial, Redonda, Eléctrica;
}

enum TipoDeCabeza {
	Estrella, Phillips, Bristol, Pala, Torx;
}

enum TipoAcero {
	ASTMA307, ASTMA563, ASTMA449, ASTMA193, ASTMA354;
}

class Tornillo {

	private int referencia;
	private int diametro;
	private int longitud;
	private String TipoDeRosca;
	private String material;
	private String tipoCabeza;
	private boolean enStock;
	private int stock;


	public Tornillo() {
		super();
	}

	public int getReferencia() {
		return referencia;
	}

	public void setReferencia(int referencia) {
		this.referencia = referencia;
	}

	public int getDiametro() {
		return diametro;
	}

	public void setDiametro(int diametro) {
		this.diametro = diametro;
	}

	public int getLongitud() {
		return longitud;
	}

	public void setLongitud(int longitud) {
		this.longitud = longitud;
	}

	public String getTipoDeRosca() {
		return TipoDeRosca;
	}

	public void setTipoDeRosca(String tipoDeRosca) {
		TipoDeRosca = tipoDeRosca;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public String getTipoCabeza() {
		return tipoCabeza;
	}

	public void setTipoCabeza(String tipoCabeza) {
		this.tipoCabeza = tipoCabeza;
	}

	public boolean isEnStock() {
		return enStock;
	}

	public void setEnStock(boolean enStock) {
		this.enStock = enStock;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	@Override
	public String toString() {
		return "Tornillo [referencia=" + referencia + ", diametro=" + diametro + ", longitud=" + longitud
				+ ", TipoDeRosca=" + TipoDeRosca + ", material=" + material + ", tipoCabeza=" + tipoCabeza
				+ ", enStock=" + enStock + ", stock=" + stock + "]";
	}


}

