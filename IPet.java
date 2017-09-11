// person --> boolean
//determine whether this person is older than this given person
/* boolean isOlder(Person other){
 *   return false;
 * }
`*/
//TEMPLATE 
/* Fields:
 * FOR PERSON
 * ...this.name...-string
 * ...this.pet...-inference
 * ...this.age...-int
 * FOR CAT
 * ...this.name...-string
 * ...this.kind...-string
 * ...this.longhaired...-boolean
 * FOR DOG
 * ...this.name...-string
 * ...this.kind...-string
 * ...this.male...-boolean
 * Methods:
 * ...isOlder...-->boolean
 */
import tester.Tester;

//to represent a pet
interface IPet {}

//to represent a pet owner
class Person {
 String name;
 IPet pet;
 int age;

 Person(String name, IPet pet, int age) {
     this.name = name;
     this.pet = pet;
     this.age = age;
 }
 
 boolean isOlder(Person other){
		if(this.age > other.age){
			return true;
		}
		else
			return false;
	}
}

//to represent a pet cat
class Cat implements IPet {
 String name;
 String kind;
 boolean longhaired;

 Cat(String name, String kind, boolean longhaired) {
     this.name = name;
     this.kind = kind;
     this.longhaired = longhaired;
 }
}

//to represent a pet dog
class Dog implements IPet {
 String name;
 String kind;
 boolean male;

 Dog(String name, String kind, boolean male) {
     this.name = name;
     this.kind = kind;
     this.male = male;
 }
}

class ExamplesPets{
	ExamplesPets(){}
	
		IPet a = new Cat("Xiumin","persian",false);
		IPet b = new Cat("Chen","chesire",true);
		IPet c = new Dog("Baekhyun","beagle",true);
		IPet d = new Dog("Yeol","pug",false);
		
		Person one = new Person("Suho",this.a,18);
		Person two = new Person("Kai",this.b,20);
		Person three = new Person("Sehun",this.c,5);
		Person four = new Person("Kyungsoo",this.d,20);
		
		boolean testIsOlder(Tester t) {
			return
					t.checkExpect(this.one.isOlder(this.two),false) &&
					t.checkExpect(this.one.isOlder(this.three),true) &&
					t.checkExpect(this.two.isOlder(this.four),false);
		}
}
