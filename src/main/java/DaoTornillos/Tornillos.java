package DaoTornillos;

import java.util.List;

public interface Tornillos {

	public Tornillo read(Integer referencia);

	public void insert(Tornillo t);

	public boolean update(Tornillo t);

	public boolean deleteByRef(Integer referencia);

	public List<Tornillo> findAll();

	public List<Tornillo> findByAttributes(String TipoDeRosca, String TipoCabeza);

	public boolean addStockByRef(Integer referencia, int stock);

}
