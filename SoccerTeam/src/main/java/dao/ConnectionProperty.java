package dao;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.io.FileInputStream;
/**
* Класс формирования свойств соединения с БД по конфигурационному
файлу
*/
public class ConnectionProperty {
	// Имя конфигурационного файла
	public static final String CONFIG_NAME = "config.properties";
	// Свойства конфигурации
	public static final Properties PROPERTY_COFIG = new Properties();
	public ConnectionProperty() throws FileNotFoundException, IOException {
		InputStream inputStream = null;
		String filePath = "C:\\Users\\lizap\\git\\JavaEE1\\SoccerTeam\\src\\main\\java\\config\\config.properties";
		inputStream = new FileInputStream(filePath);
		PROPERTY_COFIG.load(inputStream);
	//ClassLoader classLoader = getClass().getClassLoader();
	//PROPERTY_COFIG.load(classLoader.getResourceAsStream("config/" + CONFIG_NAME));
	}
	// Получить значение параметра из конфигурации по имени свойства
	public static String getProperty(String property) {
	return PROPERTY_COFIG.getProperty(property);
	}
}