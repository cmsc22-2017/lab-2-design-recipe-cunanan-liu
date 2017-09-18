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
interface IPet {
  boolean sameNamePet(String given);
}

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
  
  //--> Person
  //Checks if this persons pet is NoPet then returns the person 
  Person perish() {
    return new Person(this.name,new NoPet(),this.age);
  }
  
}
//to represent dead or no pet
class NoPet implements IPet{
  NoPet(){}
  
  /*TEMPLATE
   * FIELDS:
   *
   *METHODS:
   *...this.sameNamePet(String)...--boolean
   */
  
  public boolean sameNamePet(String given) {
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
 
  /*TEMPLATE
   * FIELDS:
   *...this.name...--string
   *...this.kind...--string
   *...this.longhaired...-boolean
   *METHODS:
   *...this.sameNamePet(String)...--boolean
  */
 
  public boolean sameNamePet(String given) {
    if(this.name == given){
      return true;
    }
    return false;
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
 
  /*TEMPLATE
   * FIELDS:
   *...this.name...--string
   *...this.kind...--string
   *...this.male...-boolean
   *METHODS:
   *...this.sameNamePet(String)...--boolean
   */
 
  public boolean sameNamePet(String given) {
    if(this.name == given){
      return true;
    }
    return false;
  }
}

class ExamplesPets{
  ExamplesPets(){}
	
	  IPet ab = new NoPet();
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
		
		boolean testSameNamePet(Tester t) {
		  return
		    t.checkExpect(this.d.sameNamePet("Yeol"),true) &&
		    t.checkExpect(this.a.sameNamePet("Harry"),false);
    }
		
		boolean testPerish(Tester t) {
		 Person p = this.one.perish();
		 Person z = this.two.perish();
		 
		  return
		    t.checkExpect(p.name, "Suho") &&
		    t.checkExpect(p.pet, this.ab) &&
		    t.checkExpect(p.age, 18) &&
		    t.checkExpect(z.name, "Kai") &&
		    t.checkExpect(z.pet, this.ab) &&
		    t.checkExpect(z.age, 20);
		}
}