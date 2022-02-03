package DaoTornillos;

import java.security.SecureRandom;
import java.util.Random;

public class TornilloBuilder {

	enum TipoDeRosca {
		Métrica, Whitworth, Trapecial, Redonda, Eléctrica;
	}

	enum TipoDeCabeza {
		Estrella, Phillips, Bristol, Pala, Torx;
	}

	enum TipoAcero {
		ASTMA307, ASTMA563, ASTMA449, ASTMA193, ASTMA354;
	}

	private static final int[] medidaslongitud = { 10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 110, 120, 130, 140, 150,
			160, 170, 180, 190, 200 };

	private static final int[] medidasDiametro = { 10, 15, 20, 25, 30, 35, 40, 45, 50, 55, 60 };

	public TornilloBuilder() {
	}

	public Tornillo tornilloRandomBuilder() {

		Tornillo tornillo = new Tornillo();

		tornillo.setReferencia(getRandomInt(1, 2000));
		tornillo.setDiametro(getRandomInt(medidasDiametro));
		tornillo.setLongitud(getRandomInt(medidaslongitud));

		tornillo.setTipoDeRosca(randomEnum(TipoDeRosca.class).toString());
		tornillo.setMaterial(randomEnum(TipoAcero.class).toString());
		tornillo.setTipoCabeza(randomEnum(TipoDeCabeza.class).toString());

		boolean auxBoolean = getRandomBoolean();
		if (auxBoolean) {
			tornillo.setEnStock(getRandomBoolean());
			tornillo.setStock(getRandomInt(1, 10000));
		} else {
			tornillo.setEnStock(auxBoolean);
		}

		return tornillo;
	}

	private <T extends Enum<?>> T randomEnum(Class<T> clazz) {

		SecureRandom Random = new SecureRandom();
		int x = Random.nextInt(clazz.getEnumConstants().length);
		return clazz.getEnumConstants()[x];
	}

	private int getRandomInt(int[] array) {

		Random r = new Random();
		int random = r.nextInt(array.length);

		return array[random];

	}

	private boolean getRandomBoolean() {

		Random random = new Random();
		return random.nextBoolean();
	}

	private int getRandomInt(int min, int max) {

		if (min >= max) {
			throw new IllegalArgumentException("el máximo debe ser mayor que mininimo");
		}

		Random r = new Random();
		return r.nextInt((max - min) + 1) + min;

	}

}
