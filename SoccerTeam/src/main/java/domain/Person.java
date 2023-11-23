package domain;
/**
* Класс для данных игроков футбольной команды
*/
public class Person {
// Идентификатор игрока
	private Long id;
 // Имя
	private String firstName;
 // Фамилия
	private String lastName;
 // Дата рождения
	private String  birthday;
 // Рост
	private String  height;
 //Вес
	private String  weight;
  // Внешний ключ -ссылка на сущность Role
	private Long idRole;
 // Навигационное свойства - ссылка на позицию
	private Role role;
	public Person() {
	
	}
	public Person(Long idRole,String firstName, String lastName, String birthday, String  height, String  weight) {
		this.idRole = idRole;
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthday = birthday;
		this.height = height;
		this.weight = weight;
		
	}
	public Person(Long idRole,String firstName, String lastName, String  birthday, String  height, String  weight,  Role role) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthday = birthday;
		this.height = height;
		this.weight = weight;
		this.role = role;
		this.idRole = idRole;
	}
	public Person(Long id, String firstName, String lastName, String  birthday, String  height, String  weight, Long idRole, Role role) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthday = birthday;
		this.height = height;
		this.weight = weight;
		this.role = role;
		this.idRole = idRole;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String  getHeight() {
		return height;
	}
	public void setHeight(String  height) {
		this.height = height;
	}
	public String  getWeight() {
		return weight;
	}
	public void setWeight(String  weight) {
		this.weight = weight;
	}
	public Role role () {
		return role;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
		}
	public String  getBirthday() {
		return birthday;
	}
	public void setBirthday(String  birthday) {
		this.birthday = birthday;
		}
	

	public String getRole() {
		return role.getNamerole();
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public Long getIdRole() {
		return idRole;
	}
	public void setIdRole(Long idRole) {
		this.idRole = idRole;
	}
	@Override
	public String toString() {
		return "Role {" + "Id = " + id + 
				", firstName = " + firstName + 
				", lastName = " + lastName + 
				", heigth = " + height + 
				", weight = " + weight + 
				", birthday = " + birthday +
				", namerole = " + getRole() + 
				"}";
	}
}
